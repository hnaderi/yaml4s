/*
 * Copyright 2023 Hossein Naderi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.hnaderi.libyaml

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import dev.hnaderi.libyaml.aliases.yaml_node_type_t

import scala.scalanative.runtime.libc

import all.*

object Main {
  def main(args: Array[String]): Unit = Zone { implicit zone =>
    val input =
      scala.io.Source.fromFile("test.yaml").getLines().mkString("\n")
    val input_c = toCString(input).asInstanceOf[Ptr[CUnsignedChar]]

    val parser = yaml_parser_t()

    if (yaml_parser_initialize(parser) == 0)
      println("Failed to init parser!")

    yaml_parser_set_input_string(parser, input_c, input.size.toULong)

    val document = yaml_document_t()
    if (yaml_parser_load(parser, document) == 0)
      println("Failed to load document!")

    val ytg = YamlTreeGenerator()
    val doc = LibYamlDocument(document)
    doc.visit(ytg)

    println("Tree:")
    println(ytg.build)

    doc.clean
    yaml_parser_delete(parser)
  }
}

trait YAMLParser {
  def parse(input: String): YAMLDocument

  def clean: Unit
}

trait YAMLDocument {
  def visit(visitor: YamlNodeVisitor): Unit

  def clean: Unit
}

trait YAMLDocumentMutable extends YAMLDocument {
  def addMapping(): Unit
}

final class LibYamlDocument(private val document: Ptr[yaml_document_t])
    extends YAMLDocument {

  override def clean: Unit =
    yaml_document_delete(document)

  override def visit(visitor: YamlNodeVisitor): Unit = Zone { implicit zone =>
    val root = yaml_document_get_root_node(document)
    visitNode(document, root, visitor)
  }

  private def visitNode(
      document: Ptr[yaml_document_t],
      root: Ptr[yaml_node_t],
      visitor: YamlNodeVisitor
  )(using Zone): Unit = {
    val node = !root
    val nodeType = yaml_node_type_t(node.`type`)

    nodeType match {
      case yaml_node_type_e.YAML_MAPPING_NODE =>
        visitMapping(document, node.data.mapping, visitor.mapping())
      case yaml_node_type_e.YAML_SEQUENCE_NODE =>
        visitSeq(document, node.data.sequence, visitor.seq())
      case yaml_node_type_e.YAML_SCALAR_NODE =>
        visitScalar(node.data.scalar, visitor.scalar())
      case yaml_node_type_e.YAML_NO_NODE =>
        println("No node!!!")
    }

    val nodes = (!root).data
  }

  private def scalarValue(node: yaml_node_t.Union0.Struct0): String = {
    val bytes = new Array[Byte](node.length.toInt)
    val value = node.value.asInstanceOf[CString]
    libc.memcpy(bytes.at(0), value, node.length)

    new String(bytes)
  }

  private def visitScalar(
      node: yaml_node_t.Union0.Struct0,
      visitor: YamlScalarVisitor
  ): Unit =
    visitor.write(scalarValue(node))

  private def visitSeq(
      document: Ptr[yaml_document_t],
      node: yaml_node_t.Union0.Struct1,
      visitor: YamlSequenceVisitor
  )(using Zone): Unit = {
    val items = node.items
    var cur = items.start
    while (cur.toLong < items.top.toLong) {
      val idx = (!cur).value
      val node = yaml_document_get_node(document, idx)
      visitNode(document, node, visitor.next())
      cur = cur + 1
    }

    visitor.`end`()
  }

  private def visitMapping(
      document: Ptr[yaml_document_t],
      node: yaml_node_t.Union0.Struct2,
      visitor: YamlMappingVisitor
  )(using
      Zone
  ): Unit = {
    val items = node.pairs
    var cur = items.start
    while (cur.toLong < items.top.toLong) {
      val keyIdx = (!cur).key
      val key = yaml_document_get_node(document, keyIdx)
      assert((!key).`type` == yaml_node_type_e.YAML_SCALAR_NODE)

      val current = visitor.at(scalarValue((!key).data.scalar))

      val idx = (!cur).value
      val node = yaml_document_get_node(document, idx)
      visitNode(document, node, current)
      cur = cur + 1
    }

    visitor.`end`()
  }
}

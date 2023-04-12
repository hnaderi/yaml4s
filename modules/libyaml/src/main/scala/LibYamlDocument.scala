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

import scala.collection.mutable
import scala.scalanative.runtime.libc
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import extern_functions._
import aliases._
import enumerations._
import structs._

final class LibYamlDocument(private val document: Ptr[yaml_document_t])
    extends AnyVal {

  def clean: Unit =
    yaml_document_delete(document)

  def visit[T](using w: Writer[T]): Option[T] = Zone { implicit zone =>
    val root = yaml_document_get_root_node(document)

    if root == null then None
    else Some(visitNode(document, root))
  }

  private def visitNode[T](
      document: Ptr[yaml_document_t],
      root: Ptr[yaml_node_t]
  )(using Zone)(using w: Writer[T]): T = {
    val node = !root
    val nodeType = yaml_node_type_t(node.`type`)

    println(fromCString(node.tag.asInstanceOf[CString]))
    nodeType match {
      case yaml_node_type_e.YAML_MAPPING_NODE =>
        w.yobject(visitMapping(document, node.data.mapping))
      case yaml_node_type_e.YAML_SEQUENCE_NODE =>
        w.yarray(visitSeq(document, node.data.sequence))
      case yaml_node_type_e.YAML_SCALAR_NODE =>
        visitScalar(node.data.scalar)
    }
  }

  private def stringValue(node: yaml_node_t.Union0.Struct0): String = {
    val bytes = new Array[Byte](node.length.toInt)
    val value = node.value.asInstanceOf[CString]
    libc.memcpy(bytes.at(0), value, node.length)

    new String(bytes)
  }

  private def visitScalar[T](
      node: yaml_node_t.Union0.Struct0
  )(using w: Writer[T]): T = {
    import yaml_scalar_style_e.*
    val style = node.style
    val mustBeString = style match {
      case YAML_SINGLE_QUOTED_SCALAR_STYLE | YAML_DOUBLE_QUOTED_SCALAR_STYLE |
          YAML_FOLDED_SCALAR_STYLE =>
        true
      case _ => false
    }

    val str = stringValue(node)
    if (mustBeString) w.ystring(str)
    else
      str match {
        case "true" | "Yes" => w.ytrue
        case "false" | "NO" => w.yfalse
        // TODO numbers!
        case other => w.ystring(str)
      }
  }

  private def visitSeq[T](
      document: Ptr[yaml_document_t],
      node: yaml_node_t.Union0.Struct1
  )(using Zone)(using w: Writer[T]): List[T] = {
    val items = node.items
    var cur = items.start
    val result = mutable.ListBuffer.empty[T]
    while (cur.toLong < items.top.toLong) {
      val idx = (!cur).value
      val node = yaml_document_get_node(document, idx)
      result.addOne(visitNode(document, node))
      cur = cur + 1
    }

    result.toList
  }

  private def visitMapping[T](
      document: Ptr[yaml_document_t],
      node: yaml_node_t.Union0.Struct2
  )(using Zone)(using w: Writer[T]): Map[String, T] = {
    val items = node.pairs
    var cur = items.start
    val result = mutable.Map.empty[String, T]
    while (cur.toLong < items.top.toLong) {
      val keyIdx = (!cur).key
      val nodeKey = yaml_document_get_node(document, keyIdx)
      assert((!nodeKey).`type` == yaml_node_type_e.YAML_SCALAR_NODE)

      val key = stringValue((!nodeKey).data.scalar)

      val idx = (!cur).value
      val node = yaml_document_get_node(document, idx)

      result.addOne((key, visitNode(document, node)))
      cur = cur + 1
    }

    result.toMap
  }
}

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

package dev.hnaderi.yaml4s
package binding

import scala.collection.mutable
import scala.scalanative.runtime.libc
import scala.scalanative.unsafe._
import scala.scalanative.unsigned._

import binding.libyaml._
import binding.others.implicits._
import binding.definitions._

private final class LibYamlDocument(private val document: Ptr[yaml_document_t])
    extends AnyVal {

  def clean(): Unit =
    yaml_document_delete(document)

  def visit[T](implicit w: Writer[T]): Option[T] = Zone { implicit zone =>
    val root = yaml_document_get_root_node(document)

    if (root == null) None
    else Some(visitNode(document, root))
  }

  private def visitNode[T](
      document: Ptr[yaml_document_t],
      root: Ptr[yaml_node_t]
  )(implicit z: Zone, w: Writer[T]): T = {
    val nodeType = root.`type`

    nodeType match {
      case enum_yaml_node_type_e.YAML_MAPPING_NODE =>
        w.yobject(visitMapping(document, root.data.mapping))
      case enum_yaml_node_type_e.YAML_SEQUENCE_NODE =>
        w.yarray(visitSeq(document, root.data.sequence))
      case enum_yaml_node_type_e.YAML_SCALAR_NODE =>
        visitScalar(root.data.scalar)
    }
  }

  private def stringValue(node: Ptr[struct_scalar_node]): String = {
    val bytes = new Array[Byte](node.length.toInt)
    val value = node.value.asInstanceOf[CString]
    libc.memcpy(bytes.at(0), value, node.length.toULong)

    new String(bytes)
  }

  private def visitScalar[T](
      node: Ptr[struct_scalar_node]
  )(implicit w: Writer[T]): T = {
    import enum_yaml_scalar_style_e._
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
        case "true"         => w.ytrue
        case "false"        => w.yfalse
        case Numeric(value) => w.ybigdecimal(value)
        case other          => w.ystring(other)
      }

  }

  private def visitSeq[T](
      document: Ptr[yaml_document_t],
      node: Ptr[struct_sequence_node]
  )(implicit z: Zone, w: Writer[T]): List[T] = {
    val items = node.items
    var cur = items.start
    val result = mutable.ListBuffer.empty[T]
    while (cur.toLong < items.top.toLong) {
      val idx = !cur
      val node = yaml_document_get_node(document, idx)
      result.append(visitNode(document, node))
      cur = cur + 1
    }

    result.toList
  }

  private def visitMapping[T](
      document: Ptr[yaml_document_t],
      node: Ptr[struct_mapping_node]
  )(implicit z: Zone, w: Writer[T]): Map[String, T] = {
    val items = node.pairs
    var cur = items.start
    val result = mutable.Map.empty[String, T]
    while (cur.toLong < items.top.toLong) {
      val keyIdx = cur.key
      val nodeKey = yaml_document_get_node(document, keyIdx)
      assert(nodeKey.`type` == enum_yaml_node_type_e.YAML_SCALAR_NODE)

      val key = stringValue(nodeKey.data.scalar)

      val idx = cur.value
      val node = yaml_document_get_node(document, idx)

      result.+=((key, visitNode(document, node)))
      cur = cur + 1
    }

    result.toMap
  }
}

private object Numeric {
  def unapply(s: String): Option[BigDecimal] = try {
    Some(BigDecimal(s))
  } catch {
    case _: NumberFormatException => None
  }
}

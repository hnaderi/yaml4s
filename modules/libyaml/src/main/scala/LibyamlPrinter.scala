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

import scala.scalanative.runtime
import scala.scalanative.unsafe._
import scala.scalanative.unsigned._

import libyaml._
import others._
import definitions._

private[yaml4s] trait LibyamlPrinter extends Printer {

  override def print[T: Visitable](t: T): String = Zone { implicit z =>
    val emitter = struct_yaml_emitter_s()

    yaml_emitter_initialize(emitter)

    val stringBuilder = new java.lang.StringBuilder()
    yaml_emitter_set_output(emitter, handler(_, _, _), toPtr(stringBuilder))

    val doc = struct_yaml_document_s()
    yaml_document_initialize(doc, null, null, null, 0, 0)
    build(doc, t)

    yaml_emitter_dump(emitter, doc)

    yaml_emitter_flush(emitter)
    yaml_emitter_close(emitter)
    yaml_emitter_delete(emitter)

    stringBuilder.toString()
  }

  private[this] def toPtr(a: AnyRef): Ptr[Byte] =
    runtime.fromRawPtr(runtime.Intrinsics.castObjectToRawPtr(a))

  private[this] def fromPtr[A](ptr: Ptr[Byte]): A =
    runtime.Intrinsics
      .castRawPtrToObject(runtime.toRawPtr(ptr))
      .asInstanceOf[A]

  private def handler(
      userdata: Ptr[Byte],
      buf: Ptr[CUnsignedChar],
      size: CInt
  ): CInt = {
    val builder = fromPtr[java.lang.StringBuilder](userdata)

    val bytes = new Array[Byte](size.toInt)
    val value = buf.asInstanceOf[CString]
    runtime.libc.memcpy(bytes.at(0), value, size.toULong)

    builder.append(new String(bytes))

    1 // TODO check docs!
  }

  private type NodeId = CInt
  import enum_yaml_scalar_style_e._

  private def build[T](document: Ptr[yaml_document_t], yaml: T)(implicit
      z: Zone,
      vis: Visitable[T]
  ): NodeId = vis.visit(
    yaml,
    new Visitor[T, NodeId] {
      override def onNull: NodeId = yaml_document_add_scalar(
        document,
        null,
        null,
        0,
        YAML_PLAIN_SCALAR_STYLE
      )
      override def onBoolean(value: Boolean): NodeId = {
        val str = value.toString()
        val v = asYamlChar(str)
        yaml_document_add_scalar(
          document,
          null,
          v,
          str.length(),
          YAML_PLAIN_SCALAR_STYLE
        )
      }
      override def onNumber(value: YamlNumber): NodeId = {
        val str = value.toString()
        val v = asYamlChar(str)
        yaml_document_add_scalar(
          document,
          null,
          v,
          str.length(),
          YAML_PLAIN_SCALAR_STYLE
        )
      }
      override def onString(value: String): NodeId = {
        val v = asYamlChar(value)
        yaml_document_add_scalar(
          document,
          null,
          v,
          value.length(),
          stringStyle(value)
        )
      }
      override def onArray(value: Iterable[T]): NodeId = {
        val sequence = yaml_document_add_sequence(
          document,
          null,
          enum_yaml_sequence_style_e.YAML_ANY_SEQUENCE_STYLE
        )
        value.foreach { y =>
          val item = vis.visit(y, this)
          yaml_document_append_sequence_item(document, sequence, item)
        }
        sequence
      }
      override def onObject(value: Iterable[(String, T)]): NodeId = {
        val mapping = yaml_document_add_mapping(
          document,
          null,
          enum_yaml_mapping_style_e.YAML_ANY_MAPPING_STYLE
        )
        value.foreach { case (k, v) =>
          val keyId: NodeId = yaml_document_add_scalar(
            document,
            null,
            asYamlChar(k),
            k.length(),
            enum_yaml_scalar_style_e.YAML_PLAIN_SCALAR_STYLE
          )
          val valueId = vis.visit(v, this)
          yaml_document_append_mapping_pair(document, mapping, keyId, valueId)
        }
        mapping
      }
    }
  )

  private def asYamlChar(str: String)(implicit z: Zone): Ptr[yaml_char_t] =
    toCString(str).asInstanceOf[Ptr[yaml_char_t]]

  private def isBad(s: String): Boolean =
    s.indexOf('\u0085') >= 0 || s.indexOf('\ufeff') >= 0
  private def hasNewline(s: String): Boolean = s.indexOf('\n') >= 0

  private def stringStyle(value: String) =
    if (isBad(value)) YAML_DOUBLE_QUOTED_SCALAR_STYLE
    else if (hasNewline(value)) YAML_LITERAL_SCALAR_STYLE
    else YAML_PLAIN_SCALAR_STYLE
}

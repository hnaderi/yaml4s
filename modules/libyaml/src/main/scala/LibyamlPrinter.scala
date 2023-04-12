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

import dev.hnaderi.libyaml.YAML.*

import scala.annotation.tailrec
import scala.collection.mutable
import scala.scalanative.runtime
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import all.*

object LibyamlPrinter extends Printer {

  override def print(t: YAML): String = Zone { implicit z =>
    val emitter = yaml_emitter_t()

    yaml_emitter_initialize(emitter)

    val stringBuilder = java.lang.StringBuilder()
    yaml_emitter_set_output(emitter, handler, toPtr(stringBuilder))

    val doc = yaml_document_t()
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
      size: size_t
  ): CInt = {
    val builder = fromPtr[java.lang.StringBuilder](userdata)

    val bytes = new Array[Byte](size.toInt)
    val value = buf.asInstanceOf[CString]
    runtime.libc.memcpy(bytes.at(0), value, size)

    builder.append(new String(bytes))

    1 // TODO check docs!
  }

  private type NodeId = CInt
  private def build(document: Ptr[yaml_document_t], yaml: YAML)(implicit
      z: Zone
  ): NodeId =
    yaml match {
      case s: YAML.Scalar =>
        buildScalar(document, s)
      case YArr(value) =>
        val sequence = yaml_document_add_sequence(
          document,
          null,
          yaml_sequence_style_e.YAML_ANY_SEQUENCE_STYLE
        )
        value.foreach { y =>
          val item = build(document, y)
          yaml_document_append_sequence_item(document, sequence, item)
        }
        sequence
      case YObj(value) =>
        val mapping = yaml_document_add_mapping(
          document,
          null,
          yaml_mapping_style_e.YAML_ANY_MAPPING_STYLE
        )
        value.foreach { case (k, v) =>
          val keyId: NodeId = yaml_document_add_scalar(
            document,
            null,
            asYamlChar(k),
            k.length(),
            yaml_scalar_style_e.YAML_PLAIN_SCALAR_STYLE
          )

          val valueId = build(document, v)

          yaml_document_append_mapping_pair(document, mapping, keyId, valueId)
        }
        mapping
    }

  private def buildScalar(
      document: Ptr[yaml_document_t],
      yaml: YAML.Scalar
  )(implicit z: Zone): NodeId =
    yaml match {
      case YString(value) =>
        val v = asYamlChar(value)
        yaml_document_add_scalar(
          document,
          null,
          v,
          value.length(),
          stringStyle(value)
        )
      case YInt(value) =>
        val str = value.toString()
        val v = asYamlChar(str)
        yaml_document_add_scalar(
          document,
          null,
          v,
          str.length(),
          yaml_scalar_style_e.YAML_PLAIN_SCALAR_STYLE
        )
      case YLong(value) =>
        val str = value.toString()
        val v = asYamlChar(str)
        yaml_document_add_scalar(
          document,
          null,
          v,
          str.length(),
          yaml_scalar_style_e.YAML_PLAIN_SCALAR_STYLE
        )
      case YDouble(value) =>
        val str = value.toString()
        val v = asYamlChar(str)
        yaml_document_add_scalar(
          document,
          null,
          v,
          str.length(),
          yaml_scalar_style_e.YAML_PLAIN_SCALAR_STYLE
        )
      case YBool(value) =>
        val str = value.toString()
        val v = asYamlChar(str)
        yaml_document_add_scalar(
          document,
          null,
          v,
          str.length(),
          yaml_scalar_style_e.YAML_PLAIN_SCALAR_STYLE
        )
      case YNull =>
        yaml_document_add_scalar(
          document,
          null,
          null,
          0,
          yaml_scalar_style_e.YAML_PLAIN_SCALAR_STYLE
        )
    }

  private def asYamlChar(str: String)(implicit z: Zone): Ptr[yaml_char_t] =
    toCString(str).asInstanceOf[Ptr[yaml_char_t]]

  private def isBad(s: String): Boolean =
    s.indexOf('\u0085') >= 0 || s.indexOf('\ufeff') >= 0
  private def hasNewline(s: String): Boolean = s.indexOf('\n') >= 0

  private def stringStyle(value: String) =
    if (isBad(value)) yaml_scalar_style_e.YAML_DOUBLE_QUOTED_SCALAR_STYLE
    else if (hasNewline(value)) yaml_scalar_style_e.YAML_LITERAL_SCALAR_STYLE
    else yaml_scalar_style_e.YAML_PLAIN_SCALAR_STYLE
}

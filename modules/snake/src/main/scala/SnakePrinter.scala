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

import dev.hnaderi.libyaml.YAML._
import org.snakeyaml.engine.v2.api.DumpSettings
import org.snakeyaml.engine.v2.api.StreamDataWriter
import org.snakeyaml.engine.v2.common
import org.snakeyaml.engine.v2.emitter.Emitter
import org.snakeyaml.engine.v2.nodes._
import org.snakeyaml.engine.v2.serializer.Serializer

import java.io.StringWriter
import Conversions._

object SnakePrinter extends Printer {

  override def print(t: YAML): String = {
    val writer = new StreamToStringWriter
    val options = DumpSettings.builder().build()
    val serializer = new Serializer(options, new Emitter(options, writer))
    serializer.emitStreamStart()
    serializer.serializeDocument(jsonToYaml(t))
    serializer.emitStreamEnd()
    writer.toString
  }

  private[this] class StreamToStringWriter
      extends StringWriter
      with StreamDataWriter {
    override def flush(): Unit = super.flush() // to fix "conflicting members"
  }

  private def isBad(s: String): Boolean =
    s.indexOf('\u0085') >= 0 || s.indexOf('\ufeff') >= 0
  private def hasNewline(s: String): Boolean = s.indexOf('\n') >= 0

  private def scalarStyle(value: String): common.ScalarStyle =
    if (isBad(value)) common.ScalarStyle.DOUBLE_QUOTED
    else common.ScalarStyle.PLAIN

  private def stringScalarStyle(
      value: String
  ): common.ScalarStyle = // TODO config
    if (isBad(value)) common.ScalarStyle.DOUBLE_QUOTED
    else if (hasNewline(value)) common.ScalarStyle.LITERAL
    else common.ScalarStyle.PLAIN

  private def scalarNode(tag: Tag, value: String) =
    new ScalarNode(tag, value, scalarStyle(value))
  private def stringNode(value: String) =
    new ScalarNode(Tag.STR, value, stringScalarStyle(value))
  private def keyNode(value: String) =
    new ScalarNode(Tag.STR, value, scalarStyle(value))

  private def convertObject(obj: YAML.YObj) = {
    val fields = obj.value.map(_._1)
    val m = obj.value.toMap
    val childNodes = fields.flatMap { key =>
      val value = m(key)
      Some(new NodeTuple(keyNode(key), jsonToYaml(value)))
    }
    new MappingNode(
      Tag.MAP,
      childNodes.toList.asJava,
      common.FlowStyle.AUTO
    )
  }
  private def jsonToYaml(json: YAML): Node = json match {
    case YString(str) => stringNode(str)
    case YNumber(value) =>
      scalarNode(if (value.isWhole) Tag.INT else Tag.FLOAT, value.toString)
    case YBool(value) => scalarNode(Tag.BOOL, value.toString)
    case YArr(arr) =>
      new SequenceNode(
        Tag.SEQ,
        arr.map(jsonToYaml).asJava,
        common.FlowStyle.FLOW // TODO config
      )
    case obj @ YObj(_) => convertObject(obj)
    case YNull         => scalarNode(Tag.NULL, "null")
  }

}

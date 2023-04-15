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

import scala.util.Try

import scalajs.js
import scalajs.js.annotation.JSImport
import js.JSConverters._

object JSYaml extends Parser with Printer {

  override def print(t: YAML): String = JS.dump(convertYAMLToJSUnsafe(t))

  override def parse[T: Writer](input: String): Either[Throwable, T] =
    Try(JS.load(input)).toEither.map(convertAnyToJsonUnsafe[T](_))

  override def parseDocuments[T: Writer](
      yaml: String
  ): Either[Throwable, Iterable[T]] =
    Try(JS.loadAll(yaml)).toEither.map(_.map(convertAnyToJsonUnsafe[T](_)))

  private[this] def convertAnyToJsonUnsafe[T](
      input: Any
  )(implicit w: Writer[T]): T = input match {
    case s: String => w.ystring(s)
    case n: Double => w.ydouble(n)
    case true      => w.ytrue
    case false     => w.yfalse
    case null      => w.ynull
    case a: js.Array[?] =>
      w.yarray(a.map(convertAnyToJsonUnsafe[T](_)).toList)
    case o: js.Object =>
      w.yobject(
        o.asInstanceOf[js.Dictionary[Any]]
          .map { case (k, v) => (k, convertAnyToJsonUnsafe[T](v)) }
      )
    case other if js.isUndefined(other) => w.ynull
  }

  private[this] def convertYAMLToJSUnsafe[T](input: YAML): js.Any =
    input match {
      case YString(value) => value
      case YNumber(value) => value.toDouble
      case YBool(value)   => value
      case YArr(value)    => value.map(convertYAMLToJSUnsafe).toJSArray
      case YObj(value) =>
        value
          .map { case (k, v) => (k, convertYAMLToJSUnsafe(v)) }
          .toMap
          .toJSDictionary
      case YNull => null
    }

  @JSImport("js-yaml", JSImport.Namespace)
  @js.native
  private object JS extends js.Object {
    final def load(str: String): Any = js.native
    final def loadAll(str: String): js.Array[Any] = js.native
    final def dump(obj: js.Any): String = js.native
  }
}

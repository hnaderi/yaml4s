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

import scala.util.Try

import scalajs.js
import scalajs.js.annotation.JSImport

object JSYamlParser extends Parser {

  override def parse[T: Writer](input: String): Either[Throwable, T] =
    Try(JS.load(input)).toEither.map(convertAnyToJsonUnsafe)

  override def parseDocuments[T: Writer](
      yaml: String
  ): LazyList[Either[Throwable, T]] = ???

  private[this] def convertAnyToJsonUnsafe[T](
      input: Any
  )(using w: Writer[T]): T = input match {
    case s: String => w.ystring(s)
    case n: Double => w.ydouble(n)
    case true      => w.ytrue
    case false     => w.yfalse
    case null      => w.ynull
    case a: js.Array[?] =>
      w.yarray(a.map(convertAnyToJsonUnsafe(_: Any)).toList)
    case o: js.Object =>
      w.yobject(
        o.asInstanceOf[js.Dictionary[Any]]
          .view
          .mapValues(convertAnyToJsonUnsafe)
          .toMap
      )
    case other if js.isUndefined(other) => w.ynull
  }

  @JSImport("js-yaml", JSImport.Namespace)
  @js.native
  private object JS extends js.Object {
    final def load(str: String): Any = js.native
  }
}

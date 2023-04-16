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
import js.JSConverters._

object JSYaml extends Parser with Printer {

  override def print[T: Visitable](t: T): String =
    JS.dump(convertYAMLToJSUnsafe(t))

  override def parse[T: Writer](input: String): Either[Throwable, T] =
    if (input.isEmpty || input.forall(_.isWhitespace)) Left(NoDocument)
    else Try(JS.load(input)).toEither.map(convertAnyToJsonUnsafe[T](_))

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

  private[this] def convertYAMLToJSUnsafe[T](input: T)(implicit
      vis: Visitable[T]
  ): js.Any =
    vis.visit(
      input,
      new Visitor[T, js.Any] {
        override def onNull: js.Any = null
        override def onBoolean(value: Boolean): js.Any = value
        override def onNumber(value: YamlNumber): js.Any = value.toDouble
        override def onString(value: String): js.Any = value
        override def onArray(value: Vector[T]): js.Any =
          value.map(vis.visit(_, this)).toJSArray
        override def onObject(value: Map[String, T]): js.Any = value.map {
          case (k, v) => (k, vis.visit(v, this))
        }.toJSDictionary
      }
    )

  @JSImport("js-yaml", JSImport.Namespace)
  @js.native
  private object JS extends js.Object {
    final def load(str: String): Any = js.native
    final def loadAll(str: String): js.Array[Any] = js.native
    final def dump(obj: js.Any): String = js.native
  }

  case object NoDocument
      extends Exception("Expected at least one document, but found none!")
}

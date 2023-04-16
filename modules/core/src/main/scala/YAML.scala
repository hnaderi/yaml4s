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

import scala.collection.mutable.LinkedHashMap

sealed trait YAML extends Any {
  import dev.hnaderi.yaml4s.YAML._

  final def transform[T](implicit w: Writer[T]): T = this match {
    case YArr(value) => w.yarray(value.map(_.transform[T]))
    case YObj(value) =>
      w.yobject(value.map { case (k, v) => (k, v.transform[T]) })
    case YNumber(value) => w.ybigdecimal(value.toBigDecimal)
    case YString(value) => w.ystring(value)
    case YBool(value)   => w.ybool(value)
    case YNull          => w.ynull
  }

  final def fold[T](folder: Visitor[YAML, T]): T = this match {
    case YArr(value)    => folder.onArray(value)
    case YObj(value)    => folder.onObject(value)
    case YNumber(value) => folder.onNumber(value)
    case YString(value) => folder.onString(value)
    case YBool(value)   => folder.onBoolean(value)
    case YNull          => folder.onNull
  }

  def isNull: Boolean = false
  def isBoolean: Boolean = false
  def isNumber: Boolean = false
  def isString: Boolean = false
  def isArray: Boolean = false
  def isObject: Boolean = false

  def asNull: Option[Unit] = None
  def asBoolean: Option[Boolean] = None
  def asNumber: Option[YamlNumber] = None
  def asString: Option[String] = None
  def asArray: Option[Vector[YAML]] = None
  def asObject: Option[Map[String, YAML]] = None

}
object YAML {
  sealed trait Scalar extends Any with YAML

  private final case class YString(value: String) extends AnyVal with Scalar {
    override def isString: Boolean = true
    override def asString: Option[String] = Some(value)
  }

  private final case class YNumber(value: YamlNumber)
      extends AnyVal
      with Scalar {
    override def isNumber: Boolean = true
    override def asNumber: Option[YamlNumber] = Some(value)
  }

  private final case class YBool(value: Boolean) extends AnyVal with Scalar {
    override def isBoolean: Boolean = true
    override def asBoolean: Option[Boolean] = Some(value)
  }

  private final case class YArr(value: Vector[YAML]) extends AnyVal with YAML {
    override def isArray: Boolean = true
    override def asArray: Option[Vector[YAML]] = Some(value)
  }

  private final case class YObj(value: LinkedHashMap[String, YAML])
      extends AnyVal
      with YAML {
    override def isObject: Boolean = true
    override def asObject: Option[Map[String, YAML]] = Some(value.toMap)
  }

  case object YNull extends Scalar {
    override def isNull: Boolean = true
    override def asNull: Option[Unit] = Some(())
  }

  val False: YAML = YBool(false)
  val True: YAML = YBool(true)

  def obj(vs: (String, YAML)*): YAML = YObj(LinkedHashMap(vs: _*))
  def arr(vs: YAML*): YAML = YArr(vs.toVector)
  def number(n: Int): YAML = YNumber(YamlNumber(n.toLong))
  def number(n: Long): YAML = YNumber(YamlNumber(n))
  def number(n: Double): YAML = YNumber(YamlNumber(n))
  def number(n: BigDecimal): YAML = YNumber(YamlNumber(n))
  def bool(b: Boolean): YAML = if (b) True else False
  def str(s: String): YAML = YString(s)

  implicit val writerInstance: Writer[YAML] = new Writer[YAML] {

    override def yfalse: YAML = False

    override def ytrue: YAML = True

    override def ydouble(d: Double): YAML = number(d)

    override def ylong(l: Long): YAML = number(l)

    override def yint(i: Int): YAML = number(i)

    override def ybigdecimal(i: BigDecimal): YAML = number(i)

    override def ystring(s: String): YAML = YString(s)

    override def yobject(vs: Iterable[(String, YAML)]): YAML = YObj(
      LinkedHashMap.newBuilder.++=(vs).result()
    )

    override def ynull: YAML = YNull

    override def yarray(vs: Iterable[YAML]): YAML = YArr(vs.toVector)

    override def ybool(b: Boolean): YAML = YBool(b)

  }

  implicit val visitableInstance: Visitable[YAML] = new Visitable[YAML] {
    override def visit[O](t: YAML, visitor: Visitor[YAML, O]): O =
      t.fold(visitor)
  }
}

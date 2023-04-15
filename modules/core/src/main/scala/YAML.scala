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

import scala.collection.mutable.LinkedHashMap

sealed trait YAML extends Any {
  def transform[T: Writer]: T

  import dev.hnaderi.libyaml.YAML._
  final def fold[T](folder: YAML.Folder[T]): T = this match {
    case YArr(value)    => folder.onArray(value)
    case YObj(value)    => folder.onObject(value.toMap)
    case YNumber(value) => folder.onNumber(value)
    case YString(value) => folder.onString(value)
    case YBool(value)   => folder.onBoolean(value)
    case YNull          => folder.onNull
  }
}
object YAML {
  sealed trait Scalar extends Any with YAML
  private[libyaml] final case class YString(value: String)
      extends AnyVal
      with Scalar {
    def transform[T](implicit b: Writer[T]): T = b.ystring(value)
  }
  private[libyaml] final case class YNumber(value: YamlNumber)
      extends AnyVal
      with Scalar {
    def transform[T](implicit b: Writer[T]): T = b.ynull
  }
  private[libyaml] final case class YBool(value: Boolean)
      extends AnyVal
      with Scalar {
    def transform[T](implicit b: Writer[T]): T = b.ybool(value)
  }
  private[libyaml] final case class YArr(value: Vector[YAML])
      extends AnyVal
      with YAML {
    def transform[T](implicit b: Writer[T]): T =
      b.yarray(value.map(_.transform[T]))
  }
  private[libyaml] final case class YObj(value: LinkedHashMap[String, YAML])
      extends AnyVal
      with YAML {
    def transform[T](implicit b: Writer[T]): T =
      b.yobject(value.map { case (k, v) => (k, v.transform[T]) })
  }
  private object YObj {
    val empty = YObj(LinkedHashMap.empty)
  }
  case object YNull extends Scalar {
    def transform[T](implicit b: Writer[T]): T = b.ynull
  }
  val False = YBool(false)
  val True = YBool(true)

  def obj(vs: (String, YAML)*): YObj = YObj(LinkedHashMap(vs: _*))
  def arr(vs: YAML*): YArr = YArr(vs.toVector)
  def number(n: Int): YNumber = YNumber(YamlNumber(n.toLong))
  def number(n: Long): YNumber = YNumber(YamlNumber(n))
  def number(n: Double): YNumber = YNumber(YamlNumber(n))
  def number(n: BigDecimal): YNumber = YNumber(YamlNumber(n))
  def bool(b: Boolean): YBool = if (b) True else False
  def str(s: String): YString = YString(s)

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

  implicit val readerInstance: Reader[YAML] = new Reader[YAML] {

    override def string(t: YAML): Either[String, String] = t match {
      case YString(v) => Right(v)
      case _          => Left("Not a string!")
    }

    override def int(t: YAML): Either[String, Int] = t match {
      case YNumber(i) => i.toInt.toRight("Not valid integer!")
      case _          => Left("Not a valid integer!")
    }

    override def long(t: YAML): Either[String, Long] = t match {
      case YNumber(l) => l.toLong.toRight("Not a valid long!")
      case _          => Left("Not a valid long!")
    }

    override def double(t: YAML): Either[String, Double] = t match {
      case YNumber(l) => Right(l.toDouble)
      case _          => Left("Not a valid double!")
    }

    override def bool(t: YAML): Either[String, Boolean] = t match {
      case YBool(b) => Right(b)
      case _        => Left("Not a boolean value!")
    }

    override def array(t: YAML): Either[String, Iterable[YAML]] = t match {
      case YArr(vs) => Right(vs)
      case _        => Left("Not an array!")
    }

    override def obj(t: YAML): Either[String, Iterable[(String, YAML)]] =
      t match {
        case YObj(fs) => Right(fs)
        case _        => Left("Not an object!")
      }
  }

  trait Folder[T] {
    def onNull: T
    def onBoolean(value: Boolean): T
    def onNumber(value: YamlNumber): T
    def onString(value: String): T
    def onArray(value: Vector[YAML]): T
    def onObject(value: Map[String, YAML]): T
  }
}

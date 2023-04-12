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

sealed trait YAML extends Any {
  def foldTo[T: Writer]: T
}
object YAML {
  sealed trait Scalar extends Any with YAML
  final case class YString(value: String) extends AnyVal with Scalar {
    def foldTo[T](implicit b: Writer[T]): T = b.ystring(value)
  }
  final case class YInt(value: Int) extends AnyVal with Scalar {
    def foldTo[T](implicit b: Writer[T]): T = b.yint(value)
  }
  final case class YLong(value: Long) extends AnyVal with Scalar {
    def foldTo[T](implicit b: Writer[T]): T = b.ylong(value)
  }
  final case class YDouble(value: Double) extends AnyVal with Scalar {
    def foldTo[T](implicit b: Writer[T]): T = b.ydouble(value)
  }
  final case class YBool(value: Boolean) extends AnyVal with Scalar {
    def foldTo[T](implicit b: Writer[T]): T = b.ybool(value)
  }
  final case class YArr(value: Seq[YAML]) extends AnyVal with YAML {
    def foldTo[T](implicit b: Writer[T]): T = b.yarray(value.map(_.foldTo[T]))
  }
  final case class YObj(value: Seq[(String, YAML)]) extends AnyVal with YAML {
    def foldTo[T](implicit b: Writer[T]): T =
      b.yobject(value.map { case (k, v) => (k, v.foldTo[T]) })
    def add(k: String, v: YAML): YObj = YObj((k, v) +: value)
  }
  object YObj {
    val empty = YObj(Nil)
  }
  case object YNull extends Scalar {
    def foldTo[T](implicit b: Writer[T]): T = b.ynull
  }
  val False = YBool(false)
  val True = YBool(true)

  given Writer[YAML] = new {

    override def ystring(s: String): YAML = YString(s)

    override def ydouble(d: Double): YAML = YDouble(d)

    override def yobject(vs: Iterable[(String, YAML)]): YAML = YObj(vs.toSeq)

    override def ynull: YAML = YNull

    override def ynum(s: String, decIndex: Int, expIndex: Int): YAML = YString(
      s
    ) // TODO

    override def yarray(vs: Iterable[YAML]): YAML = YArr(vs.toSeq)

    override def yint(i: Int): YAML = YInt(i)

    override def ybool(b: Boolean): YAML = YBool(b)

    override def ylong(l: Long): YAML = YLong(l)

    override def yfalse: YAML = YBool(false)

    override def ytrue: YAML = YBool(true)

  }

  implicit val readerInstance: Reader[YAML] = new Reader[YAML] {

    override def string(t: YAML): Either[String, String] = t match {
      case YString(v) => Right(v)
      case _          => Left("Not a string!")
    }

    override def int(t: YAML): Either[String, Int] = t match {
      case YInt(i)                    => Right(i)
      case YLong(l) if l.isValidInt   => Right(l.toInt)
      case YDouble(l) if l.isValidInt => Right(l.toInt)
      case _                          => Left("Not a valid integer!")
    }

    override def long(t: YAML): Either[String, Long] = t match {
      case YLong(l)                => Right(l)
      case YInt(i)                 => Right(i.toLong)
      case YDouble(l) if l.isWhole => Right(l.toLong)
      case _                       => Left("Not a valid long!")
    }

    override def double(t: YAML): Either[String, Double] = t match {
      case YDouble(l) => Right(l)
      case YLong(l)   => Right(l.toDouble)
      case YInt(i)    => Right(i.toDouble)
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
}

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

sealed abstract class YamlNumber extends Serializable {

  /** Return this number as a [[scala.math.BigDecimal]].
    */
  def toBigDecimal: BigDecimal

  /** Return this number as a [[scala.math.BigInt]] if it's a sufficiently small
    * whole number.
    */
  def toBigInt: Option[BigInt]

  /** Convert this number to its best [[scala.Double]] approximation.
    *
    * Anything over `Double.MaxValue` will be rounded to
    * `Double.PositiveInfinity` and anything below `Double.MinValue` is rounded
    * to `Double.NegativeInfinity`.
    */
  def toDouble: Double

  /** Convert this number to its best [[scala.Float]] approximation.
    *
    * Anything over `Float.MaxValue` will be rounded to `Float.PositiveInfinity`
    * and anything below `Float.MinValue` is rounded to
    * `Float.NegativeInfinity`.
    */
  def toFloat: Float

  /** Return this number as a [[scala.Byte]] if it's a valid [[scala.Byte]].
    */
  final def toByte: Option[Byte] = toLong match {
    case Some(n) =>
      val asByte: Byte = n.toByte
      if (n == asByte) Some(asByte) else None
    case None => None
  }

  /** Return this number as a [[scala.Short]] if it's a valid [[scala.Short]].
    */
  final def toShort: Option[Short] = toLong match {
    case Some(n) =>
      val asShort: Short = n.toShort
      if (n == asShort) Some(asShort) else None
    case None => None
  }

  /** Return this number as an [[scala.Int]] if it's a valid [[scala.Int]].
    */
  final def toInt: Option[Int] = toLong match {
    case Some(n) =>
      val asInt: Int = n.toInt
      if (n == asInt) Some(asInt) else None
    case None => None
  }

  /** Return this number as a [[scala.Long]] if it's a valid [[scala.Long]].
    */
  def toLong: Option[Long]

  def isWhole: Boolean
}

object YamlNumber {
  private final case class YLong(value: Long) extends YamlNumber {
    override def toBigDecimal: BigDecimal = BigDecimal(value)
    override def toBigInt: Option[BigInt] = Some(BigInt(value))
    override def toDouble: Double = value.toDouble
    override def toFloat: Float = value.toFloat
    override def toLong: Option[Long] = Some(value)
    override def isWhole: Boolean = true
    override def toString: String = value.toString()

    override def equals(that: Any): Boolean = that match {
      case YLong(v)       => v == value
      case YDouble(v)     => v == value
      case YBigDecimal(v) => v == value
      case YFloat(v)      => v == value
      case _              => false
    }
  }

  private final case class YDouble(value: Double) extends YamlNumber {
    override def toBigDecimal: BigDecimal = BigDecimal(value)
    override def toBigInt: Option[BigInt] = toLong.map(BigInt(_))
    override def toDouble: Double = value
    override def toFloat: Float = value.toFloat
    override def toLong: Option[Long] =
      if (value.isWhole) Some(value.toLong) else None
    override def isWhole: Boolean = value.isWhole
    override def toString: String = value.toString()

    override def equals(that: Any): Boolean = that match {
      case YLong(v)       => v == value
      case YDouble(v)     => v == value
      case YBigDecimal(v) => v == value
      case YFloat(v)      => v == value
      case _              => false
    }
  }

  private final case class YFloat(value: Float) extends YamlNumber {
    override def toBigDecimal: BigDecimal = BigDecimal(value.toDouble)
    override def toBigInt: Option[BigInt] = toLong.map(BigInt(_))
    override def toDouble: Double = value.toDouble
    override def toFloat: Float = value
    override def toLong: Option[Long] =
      if (value.isValidInt) Some(value.toLong) else None
    override def isWhole: Boolean = value.isWhole
    override def toString: String = value.toString()

    override def equals(that: Any): Boolean = that match {
      case YLong(v)       => v == value
      case YDouble(v)     => v == value
      case YBigDecimal(v) => v == value
      case YFloat(v)      => v == value
      case _              => false
    }
  }

  private final case class YBigDecimal(value: BigDecimal) extends YamlNumber {
    override def toBigDecimal: BigDecimal = value
    override def toBigInt: Option[BigInt] = value.toBigIntExact
    override def toDouble: Double = value.toDouble
    override def toFloat: Float = value.toFloat
    override def toLong: Option[Long] =
      if (value.isValidLong) Some(value.toLongExact) else None
    override def isWhole: Boolean = value.isWhole
    override def toString: String = value.toString()

    override def equals(that: Any): Boolean = that match {
      case YLong(v)       => v == value
      case YDouble(v)     => v == value
      case YBigDecimal(v) => v == value
      case YFloat(v)      => v == value
      case _              => false
    }
  }

  def apply(n: Long): YamlNumber = YLong(n)
  def apply(n: Float): YamlNumber = YFloat(n)
  def apply(n: Double): YamlNumber = YDouble(n)
  def apply(n: BigDecimal): YamlNumber = YBigDecimal(n)
}

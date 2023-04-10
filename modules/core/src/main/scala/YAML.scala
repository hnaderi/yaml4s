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

import scala.collection.mutable

sealed trait YAML extends Any
object YAML {
  case object Null extends YAML
  final class Scalar private[YAML] (val value: String)
      extends AnyVal
      with YAML {
    override def toString(): String = value
  }
  final class Mapping private[YAML] (
      private val value: mutable.Map[String, YAML]
  ) extends AnyVal
      with YAML {
    private[libyaml] def add(key: String, elem: YAML): Mapping = {
      value.addOne((key, elem))
      this
    }

    def items: Map[String, YAML] = value.toMap

    override def toString(): String = value.toString()
  }
  final class Sequence private[YAML] (
      private val value: mutable.ListBuffer[YAML]
  ) extends AnyVal
      with YAML {
    private[libyaml] def add(elem: YAML): Sequence = {
      value.append(elem)
      this
    }
    private[libyaml] def addAll(elems: IterableOnce[YAML]): Sequence = {
      value.appendAll(elems)
      this
    }

    def items: List[YAML] = value.toList

    override def toString(): String = value.toString()
  }

  def apply(value: String): Scalar = new Scalar(value)
  def sequence(values: YAML*): Sequence = new Sequence(
    mutable.ListBuffer.from(values)
  )
  def sequence(values: IterableOnce[YAML]): Sequence = new Sequence(
    mutable.ListBuffer.from(values)
  )
  def mapping(values: (String, YAML)*): Mapping = new Mapping(
    mutable.Map.from(values)
  )
  def mapping(values: IterableOnce[(String, YAML)]): Mapping = new Mapping(
    mutable.Map.from(values)
  )

  given Writer[YAML] = new {

    override def yint(i: Int): YAML = apply(i.toString())

    override def ydouble(d: Double): YAML = apply(d.toString())

    override def ylong(l: Long): YAML = apply(l.toString())

    def ynull: YAML = Null
    def yfalse: YAML = apply("false")
    def ytrue: YAML = apply("true")
    def ynum(s: CharSequence, decIndex: Int, expIndex: Int): YAML = apply(
      s.toString()
    )
    def ystring(s: CharSequence): YAML = apply(s.toString())
    def yarray(vs: Iterable[YAML]): YAML = sequence(vs)
    def yobject(vs: Iterable[(String, YAML)]): YAML = mapping(vs)
  }
}

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

import org.json4s.JArray
import org.json4s.JBool
import org.json4s.JDecimal
import org.json4s.JDouble
import org.json4s.JField
import org.json4s.JInt
import org.json4s.JLong
import org.json4s.JNothing
import org.json4s.JNull
import org.json4s.JObject
import org.json4s.JSet
import org.json4s.JString
import org.json4s.JValue

package object json4s {
  implicit object Json4sWriter extends Writer[JValue] {
    override def ynull: JValue = JNull
    override def yfalse: JValue = JBool.False
    override def ytrue: JValue = JBool.True
    override def ybool(b: Boolean): JValue = JBool(b)
    override def ydouble(d: Double): JValue = JDouble(d)
    override def ylong(l: Long): JValue = JLong(l)
    override def yint(i: Int): JValue = JInt(i)
    override def ybigdecimal(i: BigDecimal): JValue = JDecimal(i)
    override def ystring(s: String): JValue = JString(s)
    override def yarray(vs: Iterable[JValue]): JValue = JArray(vs.toList)
    override def yobject(vs: Iterable[(String, JValue)]): JValue = JObject(
      vs.map { case (k, v) => JField(k, v) }.toList
    )
  }

  implicit object Json4sVisitable extends Visitable[JValue] {
    override def visit[O](t: JValue, visitor: Visitor[JValue, O]): O = t match {
      case JObject(obj)  => visitor.onObject(obj.toMap)
      case JSet(set)     => visitor.onArray(set.toVector)
      case JString(s)    => visitor.onString(s)
      case JBool(value)  => visitor.onBoolean(value)
      case JDecimal(num) => visitor.onNumber(YamlNumber(num))
      case JArray(arr)   => visitor.onArray(arr.toVector)
      case JInt(num)     => visitor.onNumber(YamlNumber(num.toLong))
      case JNothing      => visitor.onNull
      case JNull         => visitor.onNull
      case JDouble(num)  => visitor.onNumber(YamlNumber(num))
      case JLong(num)    => visitor.onNumber(YamlNumber(num))
    }
  }
}

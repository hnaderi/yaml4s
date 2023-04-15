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

import zio.json.ast.Json

package object ziojson {
  implicit object ZioJsonWriter extends Writer[Json] {

    override def ynull: Json = Json.Null

    override def yfalse: Json = Json.Bool.False

    override def ytrue: Json = Json.Bool.True

    override def ybool(b: Boolean): Json = Json.Bool(b)

    override def ydouble(d: Double): Json = Json.Num(d)

    override def ylong(l: Long): Json = Json.Num(l)

    override def yint(i: Int): Json = Json.Num(i)

    override def ybigdecimal(i: BigDecimal): Json = Json.Num(i)

    override def ystring(s: String): Json = Json.Str(s)

    override def yarray(vs: Iterable[Json]): Json = Json.Arr(vs.toSeq: _*)

    override def yobject(vs: Iterable[(String, Json)]): Json =
      Json.Obj(vs.toSeq: _*)

  }
}

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

import scala.annotation.implicitNotFound

@implicitNotFound(
  "Cannot find a way to construct ${T}, you might have missed an import"
)
trait Writer[T] {
  def ynull: T

  def yfalse: T
  def ytrue: T
  def ybool(b: Boolean): T

  def ydouble(d: Double): T
  def ylong(l: Long): T
  def yint(i: Int): T
  def ybigdecimal(i: BigDecimal): T

  def ystring(s: String): T

  def yarray(vs: Iterable[T]): T
  def yobject(vs: Iterable[(String, T)]): T
}

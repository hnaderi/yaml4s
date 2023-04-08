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

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import dev.hnaderi.libyaml.aliases.yaml_node_type_t
import scala.scalanative.runtime.libc
import all.*

trait YamlVisitor {
  def onScalar(value: String): Unit

  def startSeq(): Unit
  def endSeq(): Unit

  def startMapping(): Unit
  def goto(key: String): Unit
  def endMapping(): Unit

}

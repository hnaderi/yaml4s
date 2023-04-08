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

object Printer extends YamlVisitor {

  override def endMapping(): Unit = println("end mapping")

  override def onScalar(value: String): Unit = println(s"scalar: $value")

  override def endSeq(): Unit = println("end seq")

  override def goto(key: String): Unit = println(s"go to: $key")

  override def startMapping(): Unit = println("start mapping")

  override def startSeq(): Unit = println("start seq")

}

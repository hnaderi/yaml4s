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

object Main {
  def main(args: Array[String]): Unit = {
    val input =
      scala.io.Source
        .fromFile("data/test5.yaml")
        .getLines()
        .mkString("\n")

    // val yaml = Right(
    //   YAML.YObj(
    //     Seq(
    //       "a" -> YAML.False,
    //       "b" -> YAML.YArr(Seq(YAML.YInt(1), YAML.YDouble(20.34)))
    //     )
    //   )
    // )
    val yaml = LibyamlParser.parse[YAML](input)
    println(yaml)

    yaml.map(LibyamlPrinter.print).foreach(println)

  }
}
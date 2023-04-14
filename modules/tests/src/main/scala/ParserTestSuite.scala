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

package tests

import dev.hnaderi.libyaml._
import munit.FunSuite

abstract class ParserTestSuite(parser: Parser, printer: Printer)
    extends FunSuite {
  test("Empty") {
    parser.parse[YAML]("")
  }

  test("sanity") {
    val input = """
data:
  double-quoted: "data"
  single-quoted: 'data'
  not quoted: data
  folded: |
    line 1
    line 2
  quoted: >
    data 1
    data 2
    data 3
  boolean 1: true
  boolean 2: Yes
  boolean 3: false
  boolean 4: NO
  not boolean 1: "Yes"
  not boolean 2: "true"
  number: 123
"""

    val yaml = parser.parse[YAML](input)
    println(yaml)

    yaml.map(printer.print).foreach(println)
  }
}

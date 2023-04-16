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

import dev.hnaderi.yaml4s._
import munit.FunSuite

abstract class BackendTestSuite(backend: YamlBackend) extends FunSuite {

  test("fails to parse empty string") {
    assertFails("")
  }

  test("fails to parse blank string") {
    assertFails("  ")
  }

  test("json") {
    assertParses("""{ "a" : 1, "b": ["c", "d"] }""")(
      YAML.obj(
        "a" -> YAML.number(1),
        "b" -> YAML.arr(YAML.str("c"), YAML.str("d"))
      )
    )
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

    val yaml = backend.parse[YAML](input)
    println(yaml)

    yaml.map(backend.print(_)).foreach(println)
  }

  test("boolean") {
    assertParses("true")(YAML.True)
    assertParses("false")(YAML.False)
  }

  test("not booleans") {
    // because it is stupid!
    assertParses("Yes")(YAML.str("Yes"))
    assertParses("yes")(YAML.str("yes"))
    assertParses("no")(YAML.str("no"))
    assertParses("NO")(YAML.str("NO"))
  }

  test("numerics") {
    assertParses("123")(YAML.number(123))
    assertParses("123.456")(YAML.number(123.456))
    assertParses("1234.5678")(YAML.number(BigDecimal("1234.5678")))
  }

  test("sequences") {
    assertParses("[1, 2, 3]")(
      YAML.arr(YAML.number(1), YAML.number(2), YAML.number(3))
    )
    assertParses("- 1\n- 2\n- 3")(
      YAML.arr(YAML.number(1), YAML.number(2), YAML.number(3))
    )
  }

  test("mappings") {
    assertParses("""
a: 1
b: 2
""")(YAML.obj("a" -> YAML.number(1), "b" -> YAML.number(2)))
  }

  test("aliases") {
    val alias = YAML.obj("foo" -> YAML.str("bar"))
    assertParses(
      """
          | aliases:
          |   - &alias1
          |     foo:
          |       bar
          | baz:
          |  - *alias1
          |  - *alias1
          |""".stripMargin
    )(
      YAML.obj(
        "aliases" -> YAML.arr(alias),
        "baz" -> YAML.arr(alias, alias)
      )
    )
  }

  // TODO libyaml does not respect this
  test("fails on invalid tag".ignore) {
    assertFails("!!int 12foo")
  }

  protected def assertParses(
      s: String
  )(yaml: YAML)(implicit l: munit.Location): Unit = {
    val res = backend.parse[YAML](s)
    assertEquals(res, Right(yaml))
    res.map(backend.print(_)).foreach(println(_))
  }
  protected def assertFails(s: String)(implicit l: munit.Location): Unit = {
    val result = backend.parse[YAML](s)
    assert(result.isLeft, result.toString)
  }
}

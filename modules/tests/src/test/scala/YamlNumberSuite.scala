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

import dev.hnaderi.yaml4s.YamlNumber
import munit.FunSuite
import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAll
import dev.hnaderi.yaml4s.YAML

class YamlNumberSuite extends FunSuite with ScalaCheckSuite {
  property("long equals") {
    forAll { (l: Long) =>
      assertEquals(YamlNumber(l), YamlNumber(l.toDouble))
      assertEquals(YamlNumber(l.toDouble), YamlNumber(l))
      assertEquals(YamlNumber(l), YamlNumber(BigDecimal(l)))
      assertEquals(YamlNumber(BigDecimal(l)), YamlNumber(l))
    }
  }

  property("double equals") {
    forAll { (l: Double) =>
      assertEquals(YamlNumber(l), YamlNumber(BigDecimal(l)))
      assertEquals(YAML.number(l), YAML.number(BigDecimal(l)))
      assertEquals(YamlNumber(BigDecimal(l)), YamlNumber(l))
      assertEquals(YAML.number(BigDecimal(l)), YAML.number(l))
    }
  }

  property("long equals") {
    forAll { (l: Long) =>
      assertEquals(YAML.number(l), YAML.number(l.toDouble))
      assertEquals(YAML.number(l.toDouble), YAML.number(l))
      assertEquals(YAML.number(l), YAML.number(BigDecimal(l)))
      assertEquals(YAML.number(BigDecimal(l)), YAML.number(l))
    }
  }
}

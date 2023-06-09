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

package dev.hnaderi.yaml4s

import binding._

object LibYaml extends YamlBackend with LibyamlParser with LibyamlPrinter {
  // def parse[T: Writer](input: String): Either[Throwable, T] =
  //   LibyamlParser.parse(input)
  // def parseDocuments[T: Writer](yaml: String): Either[Throwable, Iterable[T]] =
  //   LibyamlParser.parseDocuments(yaml)
  // def print[T: Visitable](t: T): String = LibyamlPrinter.print(t)
}

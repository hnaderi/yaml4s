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

import scala.collection.mutable

trait YamlTreeGenerator extends YamlNodeVisitor {
  def build: YAML
}

object YamlTreeGenerator {
  def apply(): YamlTreeGenerator = Root()

  private final class Root(var data: YAML = YAML.Null)
      extends YamlTreeGenerator {

    override def scalar(): YamlScalarVisitor = Scalar(this)

    override def seq(): YamlSequenceVisitor = Sequence(this)

    override def mapping(): YamlMappingVisitor = Mapping(this)

    def build: YAML = data
  }

  private final class Scalar(node: Root) extends YamlScalarVisitor {
    override def write(value: String): Unit = {
      node.data = YAML(value)
    }
  }

  private final class Sequence(
      node: Root,
      items: mutable.ListBuffer[Root] = mutable.ListBuffer.empty
  ) extends YamlSequenceVisitor {

    override def next(): YamlNodeVisitor = {
      val node = Root()
      items.addOne(node)
      node
    }

    override def end(): Unit = {
      node.data = YAML.sequence(items.map(_.data))
    }

  }

  private final class Mapping(
      node: Root,
      items: mutable.Map[String, Root] = mutable.Map.empty
  ) extends YamlMappingVisitor {

    override def at(key: String): YamlNodeVisitor = {
      val node = Root()
      items.addOne((key, node))
      node
    }

    override def end(): Unit = {
      node.data = YAML.mapping(items.view.mapValues(_.data))
    }

  }
}

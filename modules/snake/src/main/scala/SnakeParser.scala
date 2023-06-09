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
package snakeyaml

import org.snakeyaml.engine.v2.api.LoadSettings
import org.snakeyaml.engine.v2.composer.Composer
import org.snakeyaml.engine.v2.constructor.StandardConstructor
import org.snakeyaml.engine.v2.nodes._
import org.snakeyaml.engine.v2.scanner.StreamReader

import java.io.StringReader
import java.io.{Reader => JReader}
import java.util.Optional

import Conversions._

private[yaml4s] trait SnakeParser extends Parser {
  private val settings = LoadSettings.builder.build

  override def parse[T: Writer](input: String): Either[Throwable, T] =
    parseNode(input).flatMap(yamlToJson[T](_))

  override def parseDocuments[T: Writer](
      yaml: String
  ): Either[Throwable, Iterable[T]] = {
    import collection.mutable.ListBuffer
    parseStream(new StringReader(yaml)).flatMap(nodes =>
      nodes.foldLeft[Either[Throwable, ListBuffer[T]]](
        Right(ListBuffer.empty[T])
      ) { case (l, n) =>
        for {
          list <- l
          y <- yamlToJson(n)
          _ = list.append(y)
        } yield list
      }
    )
  }

  private def catchNonFatal[A](f: => A): Either[Throwable, A] =
    try {
      Right(f)
    } catch {
      case t if scala.util.control.NonFatal(t) => Left(t)
    }

  private[this] def parseNode(yaml: String): Either[ParsingFailure, Node] =
    parseSingle(new StringReader(yaml))

  private[this] def asScala[T](ot: Optional[T]): Option[T] =
    if (ot.isPresent) Some(ot.get()) else None

  private[this] def createComposer(reader: JReader) =
    new Composer(
      settings,
      new org.snakeyaml.engine.v2.parser.ParserImpl(
        settings,
        new StreamReader(settings, reader)
      )
    )

  private[this] def parseSingle(reader: JReader): Either[ParsingFailure, Node] =
    catchNonFatal {
      val composer = createComposer(reader)
      asScala(composer.getSingleNode)
    } match {
      case Left(err) => Left(ParsingFailure(err.getMessage, err))
      case Right(None) =>
        Left(
          ParsingFailure(
            "no document found",
            new RuntimeException("no document found")
          )
        )
      case Right(Some(value)) => Right(value)
    }

  private[this] def parseStream(
      reader: JReader
  ): Either[ParsingFailure, List[Node]] =
    catchNonFatal(createComposer(reader).asScala.toList).leftMap(err =>
      ParsingFailure(err.getMessage, err)
    )

  private[this] object CustomTag {
    def unapply(tag: Tag): Option[String] = if (
      !tag.getValue.startsWith(Tag.PREFIX)
    )
      Some(tag.getValue)
    else
      None
  }

  private[this] class FlatteningConstructor(settings: LoadSettings)
      extends StandardConstructor(settings) {
    def flatten(node: MappingNode): MappingNode = {
      flattenMapping(node)
      node
    }

    def construct(node: ScalarNode): Object =
      super.construct(node) // to make the method public
  }

  private[this] def yamlToJson[T](
      node: Node
  )(implicit w: Writer[T]): Either[ParsingFailure, T] = {
    // Isn't thread-safe internally, may hence not be shared
    val flattener: FlatteningConstructor = new FlatteningConstructor(settings)

    def convertScalarNode(node: ScalarNode) =
      catchNonFatal(node.getTag match {
        case Tag.INT
            if node.getValue.startsWith("0x") || node.getValue.contains("_") =>
          flattener.construct(node) match {
            case int: Integer         => w.yint(int)
            case long: java.lang.Long => w.ylong(long)
            case bigint: java.math.BigInteger =>
              w.ybigdecimal(BigDecimal(bigint))
            case other =>
              throw new NumberFormatException(
                s"Unexpected number type: ${other.getClass}"
              )
          }
        case Tag.INT | Tag.FLOAT =>
          val bd = BigDecimal(node.getValue())
          if (bd.isValidInt) w.yint(bd.toIntExact)
          else if (bd.isValidLong) w.ylong(bd.toLongExact)
          else w.ydouble(bd.toDouble)
        case Tag.BOOL =>
          flattener.construct(node) match {
            case b: java.lang.Boolean => w.ybool(b)
            case _ =>
              throw new IllegalArgumentException(
                s"Invalid boolean string ${node.getValue}"
              )
          }
        case Tag.NULL => w.ynull
        case CustomTag(other) =>
          w.yobject(Seq(other.stripPrefix("!") -> w.ystring(node.getValue)))
        case _ => w.ystring(node.getValue)
      })
        .leftMap { err =>
          ParsingFailure(err.getMessage, err)
        }

    def convertKeyNode(node: Node) = node match {
      case scalar: ScalarNode => Right(scalar.getValue)
      case _ =>
        Left(
          ParsingFailure("Only string keys can be represented in JSON", null)
        )
    }

    if (node == null) {
      Right(w.yfalse)
    } else {
      node match {
        case mapping: MappingNode =>
          flattener
            .flatten(mapping)
            .getValue
            .asScala
            .foldLeft[Either[ParsingFailure, Map[String, T]]](
              Right(Map.empty)
            ) { case (objEither, tup) =>
              for {
                obj <- objEither
                key <- convertKeyNode(tup.getKeyNode)
                value <- yamlToJson[T](tup.getValueNode)
              } yield obj.updated(key, value)
            }
            .map(w.yobject)
        case sequence: SequenceNode =>
          sequence.getValue.asScala
            .foldLeft[Either[ParsingFailure, Vector[T]]](
              Right(Vector.empty)
            ) { case (arrEither, node) =>
              for {
                arr <- arrEither
                value <- yamlToJson[T](node)
              } yield arr :+ value
            }
            .map(w.yarray(_))
        case scalar: ScalarNode => convertScalarNode(scalar)
      }
    }
  }
}

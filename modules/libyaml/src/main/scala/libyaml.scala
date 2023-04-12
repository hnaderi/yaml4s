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
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object predef:
  private[libyaml] trait CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
    extension (inline t: T)
      inline def int: CInt = eq.apply(t).toInt
      inline def uint: CUnsignedInt = eq.apply(t)
      inline def value: CUnsignedInt = eq.apply(t)

object enumerations:
  import predef.*

  /** Line break types.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_break_e = CUnsignedInt
  object yaml_break_e extends CEnumU[yaml_break_e]:
    given _tag: Tag[yaml_break_e] = Tag.UInt
    inline def define(inline a: Long): yaml_break_e = a.toUInt
    val YAML_ANY_BREAK = define(0)
    val YAML_CR_BREAK = define(1)
    val YAML_LN_BREAK = define(2)
    val YAML_CRLN_BREAK = define(3)
    inline def getName(inline value: yaml_break_e): Option[String] =
      inline value match
        case YAML_ANY_BREAK  => Some("YAML_ANY_BREAK")
        case YAML_CR_BREAK   => Some("YAML_CR_BREAK")
        case YAML_LN_BREAK   => Some("YAML_LN_BREAK")
        case YAML_CRLN_BREAK => Some("YAML_CRLN_BREAK")
        case _               => None
    extension (a: yaml_break_e)
      inline def &(b: yaml_break_e): yaml_break_e = a & b
      inline def |(b: yaml_break_e): yaml_break_e = a | b
      inline def is(b: yaml_break_e): Boolean = (a & b) == b

  /** The emitter states.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_emitter_state_e = CUnsignedInt
  object yaml_emitter_state_e extends CEnumU[yaml_emitter_state_e]:
    given _tag: Tag[yaml_emitter_state_e] = Tag.UInt
    inline def define(inline a: Long): yaml_emitter_state_e = a.toUInt
    val YAML_EMIT_STREAM_START_STATE = define(0)
    val YAML_EMIT_FIRST_DOCUMENT_START_STATE = define(1)
    val YAML_EMIT_DOCUMENT_START_STATE = define(2)
    val YAML_EMIT_DOCUMENT_CONTENT_STATE = define(3)
    val YAML_EMIT_DOCUMENT_END_STATE = define(4)
    val YAML_EMIT_FLOW_SEQUENCE_FIRST_ITEM_STATE = define(5)
    val YAML_EMIT_FLOW_SEQUENCE_ITEM_STATE = define(6)
    val YAML_EMIT_FLOW_MAPPING_FIRST_KEY_STATE = define(7)
    val YAML_EMIT_FLOW_MAPPING_KEY_STATE = define(8)
    val YAML_EMIT_FLOW_MAPPING_SIMPLE_VALUE_STATE = define(9)
    val YAML_EMIT_FLOW_MAPPING_VALUE_STATE = define(10)
    val YAML_EMIT_BLOCK_SEQUENCE_FIRST_ITEM_STATE = define(11)
    val YAML_EMIT_BLOCK_SEQUENCE_ITEM_STATE = define(12)
    val YAML_EMIT_BLOCK_MAPPING_FIRST_KEY_STATE = define(13)
    val YAML_EMIT_BLOCK_MAPPING_KEY_STATE = define(14)
    val YAML_EMIT_BLOCK_MAPPING_SIMPLE_VALUE_STATE = define(15)
    val YAML_EMIT_BLOCK_MAPPING_VALUE_STATE = define(16)
    val YAML_EMIT_END_STATE = define(17)
    inline def getName(inline value: yaml_emitter_state_e): Option[String] =
      inline value match
        case YAML_EMIT_STREAM_START_STATE =>
          Some("YAML_EMIT_STREAM_START_STATE")
        case YAML_EMIT_FIRST_DOCUMENT_START_STATE =>
          Some("YAML_EMIT_FIRST_DOCUMENT_START_STATE")
        case YAML_EMIT_DOCUMENT_START_STATE =>
          Some("YAML_EMIT_DOCUMENT_START_STATE")
        case YAML_EMIT_DOCUMENT_CONTENT_STATE =>
          Some("YAML_EMIT_DOCUMENT_CONTENT_STATE")
        case YAML_EMIT_DOCUMENT_END_STATE =>
          Some("YAML_EMIT_DOCUMENT_END_STATE")
        case YAML_EMIT_FLOW_SEQUENCE_FIRST_ITEM_STATE =>
          Some("YAML_EMIT_FLOW_SEQUENCE_FIRST_ITEM_STATE")
        case YAML_EMIT_FLOW_SEQUENCE_ITEM_STATE =>
          Some("YAML_EMIT_FLOW_SEQUENCE_ITEM_STATE")
        case YAML_EMIT_FLOW_MAPPING_FIRST_KEY_STATE =>
          Some("YAML_EMIT_FLOW_MAPPING_FIRST_KEY_STATE")
        case YAML_EMIT_FLOW_MAPPING_KEY_STATE =>
          Some("YAML_EMIT_FLOW_MAPPING_KEY_STATE")
        case YAML_EMIT_FLOW_MAPPING_SIMPLE_VALUE_STATE =>
          Some("YAML_EMIT_FLOW_MAPPING_SIMPLE_VALUE_STATE")
        case YAML_EMIT_FLOW_MAPPING_VALUE_STATE =>
          Some("YAML_EMIT_FLOW_MAPPING_VALUE_STATE")
        case YAML_EMIT_BLOCK_SEQUENCE_FIRST_ITEM_STATE =>
          Some("YAML_EMIT_BLOCK_SEQUENCE_FIRST_ITEM_STATE")
        case YAML_EMIT_BLOCK_SEQUENCE_ITEM_STATE =>
          Some("YAML_EMIT_BLOCK_SEQUENCE_ITEM_STATE")
        case YAML_EMIT_BLOCK_MAPPING_FIRST_KEY_STATE =>
          Some("YAML_EMIT_BLOCK_MAPPING_FIRST_KEY_STATE")
        case YAML_EMIT_BLOCK_MAPPING_KEY_STATE =>
          Some("YAML_EMIT_BLOCK_MAPPING_KEY_STATE")
        case YAML_EMIT_BLOCK_MAPPING_SIMPLE_VALUE_STATE =>
          Some("YAML_EMIT_BLOCK_MAPPING_SIMPLE_VALUE_STATE")
        case YAML_EMIT_BLOCK_MAPPING_VALUE_STATE =>
          Some("YAML_EMIT_BLOCK_MAPPING_VALUE_STATE")
        case YAML_EMIT_END_STATE => Some("YAML_EMIT_END_STATE")
        case _                   => None
    extension (a: yaml_emitter_state_e)
      inline def &(b: yaml_emitter_state_e): yaml_emitter_state_e = a & b
      inline def |(b: yaml_emitter_state_e): yaml_emitter_state_e = a | b
      inline def is(b: yaml_emitter_state_e): Boolean = (a & b) == b

  /** The stream encoding.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_encoding_e = CUnsignedInt
  object yaml_encoding_e extends CEnumU[yaml_encoding_e]:
    given _tag: Tag[yaml_encoding_e] = Tag.UInt
    inline def define(inline a: Long): yaml_encoding_e = a.toUInt
    val YAML_ANY_ENCODING = define(0)
    val YAML_UTF8_ENCODING = define(1)
    val YAML_UTF16LE_ENCODING = define(2)
    val YAML_UTF16BE_ENCODING = define(3)
    inline def getName(inline value: yaml_encoding_e): Option[String] =
      inline value match
        case YAML_ANY_ENCODING     => Some("YAML_ANY_ENCODING")
        case YAML_UTF8_ENCODING    => Some("YAML_UTF8_ENCODING")
        case YAML_UTF16LE_ENCODING => Some("YAML_UTF16LE_ENCODING")
        case YAML_UTF16BE_ENCODING => Some("YAML_UTF16BE_ENCODING")
        case _                     => None
    extension (a: yaml_encoding_e)
      inline def &(b: yaml_encoding_e): yaml_encoding_e = a & b
      inline def |(b: yaml_encoding_e): yaml_encoding_e = a | b
      inline def is(b: yaml_encoding_e): Boolean = (a & b) == b

  /** Many bad things could happen with the parser and emitter.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_error_type_e = CUnsignedInt
  object yaml_error_type_e extends CEnumU[yaml_error_type_e]:
    given _tag: Tag[yaml_error_type_e] = Tag.UInt
    inline def define(inline a: Long): yaml_error_type_e = a.toUInt
    val YAML_NO_ERROR = define(0)
    val YAML_MEMORY_ERROR = define(1)
    val YAML_READER_ERROR = define(2)
    val YAML_SCANNER_ERROR = define(3)
    val YAML_PARSER_ERROR = define(4)
    val YAML_COMPOSER_ERROR = define(5)
    val YAML_WRITER_ERROR = define(6)
    val YAML_EMITTER_ERROR = define(7)
    inline def getName(inline value: yaml_error_type_e): Option[String] =
      inline value match
        case YAML_NO_ERROR       => Some("YAML_NO_ERROR")
        case YAML_MEMORY_ERROR   => Some("YAML_MEMORY_ERROR")
        case YAML_READER_ERROR   => Some("YAML_READER_ERROR")
        case YAML_SCANNER_ERROR  => Some("YAML_SCANNER_ERROR")
        case YAML_PARSER_ERROR   => Some("YAML_PARSER_ERROR")
        case YAML_COMPOSER_ERROR => Some("YAML_COMPOSER_ERROR")
        case YAML_WRITER_ERROR   => Some("YAML_WRITER_ERROR")
        case YAML_EMITTER_ERROR  => Some("YAML_EMITTER_ERROR")
        case _                   => None
    extension (a: yaml_error_type_e)
      inline def &(b: yaml_error_type_e): yaml_error_type_e = a & b
      inline def |(b: yaml_error_type_e): yaml_error_type_e = a | b
      inline def is(b: yaml_error_type_e): Boolean = (a & b) == b

  /** Event types.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_event_type_e = CUnsignedInt
  object yaml_event_type_e extends CEnumU[yaml_event_type_e]:
    given _tag: Tag[yaml_event_type_e] = Tag.UInt
    inline def define(inline a: Long): yaml_event_type_e = a.toUInt
    val YAML_NO_EVENT = define(0)
    val YAML_STREAM_START_EVENT = define(1)
    val YAML_STREAM_END_EVENT = define(2)
    val YAML_DOCUMENT_START_EVENT = define(3)
    val YAML_DOCUMENT_END_EVENT = define(4)
    val YAML_ALIAS_EVENT = define(5)
    val YAML_SCALAR_EVENT = define(6)
    val YAML_SEQUENCE_START_EVENT = define(7)
    val YAML_SEQUENCE_END_EVENT = define(8)
    val YAML_MAPPING_START_EVENT = define(9)
    val YAML_MAPPING_END_EVENT = define(10)
    inline def getName(inline value: yaml_event_type_e): Option[String] =
      inline value match
        case YAML_NO_EVENT             => Some("YAML_NO_EVENT")
        case YAML_STREAM_START_EVENT   => Some("YAML_STREAM_START_EVENT")
        case YAML_STREAM_END_EVENT     => Some("YAML_STREAM_END_EVENT")
        case YAML_DOCUMENT_START_EVENT => Some("YAML_DOCUMENT_START_EVENT")
        case YAML_DOCUMENT_END_EVENT   => Some("YAML_DOCUMENT_END_EVENT")
        case YAML_ALIAS_EVENT          => Some("YAML_ALIAS_EVENT")
        case YAML_SCALAR_EVENT         => Some("YAML_SCALAR_EVENT")
        case YAML_SEQUENCE_START_EVENT => Some("YAML_SEQUENCE_START_EVENT")
        case YAML_SEQUENCE_END_EVENT   => Some("YAML_SEQUENCE_END_EVENT")
        case YAML_MAPPING_START_EVENT  => Some("YAML_MAPPING_START_EVENT")
        case YAML_MAPPING_END_EVENT    => Some("YAML_MAPPING_END_EVENT")
        case _                         => None
    extension (a: yaml_event_type_e)
      inline def &(b: yaml_event_type_e): yaml_event_type_e = a & b
      inline def |(b: yaml_event_type_e): yaml_event_type_e = a | b
      inline def is(b: yaml_event_type_e): Boolean = (a & b) == b

  /** Mapping styles.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_mapping_style_e = CUnsignedInt
  object yaml_mapping_style_e extends CEnumU[yaml_mapping_style_e]:
    given _tag: Tag[yaml_mapping_style_e] = Tag.UInt
    inline def define(inline a: Long): yaml_mapping_style_e = a.toUInt
    val YAML_ANY_MAPPING_STYLE = define(0)
    val YAML_BLOCK_MAPPING_STYLE = define(1)
    val YAML_FLOW_MAPPING_STYLE = define(2)
    inline def getName(inline value: yaml_mapping_style_e): Option[String] =
      inline value match
        case YAML_ANY_MAPPING_STYLE   => Some("YAML_ANY_MAPPING_STYLE")
        case YAML_BLOCK_MAPPING_STYLE => Some("YAML_BLOCK_MAPPING_STYLE")
        case YAML_FLOW_MAPPING_STYLE  => Some("YAML_FLOW_MAPPING_STYLE")
        case _                        => None
    extension (a: yaml_mapping_style_e)
      inline def &(b: yaml_mapping_style_e): yaml_mapping_style_e = a & b
      inline def |(b: yaml_mapping_style_e): yaml_mapping_style_e = a | b
      inline def is(b: yaml_mapping_style_e): Boolean = (a & b) == b

  /** Node types.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_node_type_e = CUnsignedInt
  object yaml_node_type_e extends CEnumU[yaml_node_type_e]:
    given _tag: Tag[yaml_node_type_e] = Tag.UInt
    inline def define(inline a: Long): yaml_node_type_e = a.toUInt
    val YAML_NO_NODE = define(0)
    val YAML_SCALAR_NODE = define(1)
    val YAML_SEQUENCE_NODE = define(2)
    val YAML_MAPPING_NODE = define(3)
    inline def getName(inline value: yaml_node_type_e): Option[String] =
      inline value match
        case YAML_NO_NODE       => Some("YAML_NO_NODE")
        case YAML_SCALAR_NODE   => Some("YAML_SCALAR_NODE")
        case YAML_SEQUENCE_NODE => Some("YAML_SEQUENCE_NODE")
        case YAML_MAPPING_NODE  => Some("YAML_MAPPING_NODE")
        case _                  => None
    extension (a: yaml_node_type_e)
      inline def &(b: yaml_node_type_e): yaml_node_type_e = a & b
      inline def |(b: yaml_node_type_e): yaml_node_type_e = a | b
      inline def is(b: yaml_node_type_e): Boolean = (a & b) == b

  /** The states of the parser.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_parser_state_e = CUnsignedInt
  object yaml_parser_state_e extends CEnumU[yaml_parser_state_e]:
    given _tag: Tag[yaml_parser_state_e] = Tag.UInt
    inline def define(inline a: Long): yaml_parser_state_e = a.toUInt
    val YAML_PARSE_STREAM_START_STATE = define(0)
    val YAML_PARSE_IMPLICIT_DOCUMENT_START_STATE = define(1)
    val YAML_PARSE_DOCUMENT_START_STATE = define(2)
    val YAML_PARSE_DOCUMENT_CONTENT_STATE = define(3)
    val YAML_PARSE_DOCUMENT_END_STATE = define(4)
    val YAML_PARSE_BLOCK_NODE_STATE = define(5)
    val YAML_PARSE_BLOCK_NODE_OR_INDENTLESS_SEQUENCE_STATE = define(6)
    val YAML_PARSE_FLOW_NODE_STATE = define(7)
    val YAML_PARSE_BLOCK_SEQUENCE_FIRST_ENTRY_STATE = define(8)
    val YAML_PARSE_BLOCK_SEQUENCE_ENTRY_STATE = define(9)
    val YAML_PARSE_INDENTLESS_SEQUENCE_ENTRY_STATE = define(10)
    val YAML_PARSE_BLOCK_MAPPING_FIRST_KEY_STATE = define(11)
    val YAML_PARSE_BLOCK_MAPPING_KEY_STATE = define(12)
    val YAML_PARSE_BLOCK_MAPPING_VALUE_STATE = define(13)
    val YAML_PARSE_FLOW_SEQUENCE_FIRST_ENTRY_STATE = define(14)
    val YAML_PARSE_FLOW_SEQUENCE_ENTRY_STATE = define(15)
    val YAML_PARSE_FLOW_SEQUENCE_ENTRY_MAPPING_KEY_STATE = define(16)
    val YAML_PARSE_FLOW_SEQUENCE_ENTRY_MAPPING_VALUE_STATE = define(17)
    val YAML_PARSE_FLOW_SEQUENCE_ENTRY_MAPPING_END_STATE = define(18)
    val YAML_PARSE_FLOW_MAPPING_FIRST_KEY_STATE = define(19)
    val YAML_PARSE_FLOW_MAPPING_KEY_STATE = define(20)
    val YAML_PARSE_FLOW_MAPPING_VALUE_STATE = define(21)
    val YAML_PARSE_FLOW_MAPPING_EMPTY_VALUE_STATE = define(22)
    val YAML_PARSE_END_STATE = define(23)
    inline def getName(inline value: yaml_parser_state_e): Option[String] =
      inline value match
        case YAML_PARSE_STREAM_START_STATE =>
          Some("YAML_PARSE_STREAM_START_STATE")
        case YAML_PARSE_IMPLICIT_DOCUMENT_START_STATE =>
          Some("YAML_PARSE_IMPLICIT_DOCUMENT_START_STATE")
        case YAML_PARSE_DOCUMENT_START_STATE =>
          Some("YAML_PARSE_DOCUMENT_START_STATE")
        case YAML_PARSE_DOCUMENT_CONTENT_STATE =>
          Some("YAML_PARSE_DOCUMENT_CONTENT_STATE")
        case YAML_PARSE_DOCUMENT_END_STATE =>
          Some("YAML_PARSE_DOCUMENT_END_STATE")
        case YAML_PARSE_BLOCK_NODE_STATE => Some("YAML_PARSE_BLOCK_NODE_STATE")
        case YAML_PARSE_BLOCK_NODE_OR_INDENTLESS_SEQUENCE_STATE =>
          Some("YAML_PARSE_BLOCK_NODE_OR_INDENTLESS_SEQUENCE_STATE")
        case YAML_PARSE_FLOW_NODE_STATE => Some("YAML_PARSE_FLOW_NODE_STATE")
        case YAML_PARSE_BLOCK_SEQUENCE_FIRST_ENTRY_STATE =>
          Some("YAML_PARSE_BLOCK_SEQUENCE_FIRST_ENTRY_STATE")
        case YAML_PARSE_BLOCK_SEQUENCE_ENTRY_STATE =>
          Some("YAML_PARSE_BLOCK_SEQUENCE_ENTRY_STATE")
        case YAML_PARSE_INDENTLESS_SEQUENCE_ENTRY_STATE =>
          Some("YAML_PARSE_INDENTLESS_SEQUENCE_ENTRY_STATE")
        case YAML_PARSE_BLOCK_MAPPING_FIRST_KEY_STATE =>
          Some("YAML_PARSE_BLOCK_MAPPING_FIRST_KEY_STATE")
        case YAML_PARSE_BLOCK_MAPPING_KEY_STATE =>
          Some("YAML_PARSE_BLOCK_MAPPING_KEY_STATE")
        case YAML_PARSE_BLOCK_MAPPING_VALUE_STATE =>
          Some("YAML_PARSE_BLOCK_MAPPING_VALUE_STATE")
        case YAML_PARSE_FLOW_SEQUENCE_FIRST_ENTRY_STATE =>
          Some("YAML_PARSE_FLOW_SEQUENCE_FIRST_ENTRY_STATE")
        case YAML_PARSE_FLOW_SEQUENCE_ENTRY_STATE =>
          Some("YAML_PARSE_FLOW_SEQUENCE_ENTRY_STATE")
        case YAML_PARSE_FLOW_SEQUENCE_ENTRY_MAPPING_KEY_STATE =>
          Some("YAML_PARSE_FLOW_SEQUENCE_ENTRY_MAPPING_KEY_STATE")
        case YAML_PARSE_FLOW_SEQUENCE_ENTRY_MAPPING_VALUE_STATE =>
          Some("YAML_PARSE_FLOW_SEQUENCE_ENTRY_MAPPING_VALUE_STATE")
        case YAML_PARSE_FLOW_SEQUENCE_ENTRY_MAPPING_END_STATE =>
          Some("YAML_PARSE_FLOW_SEQUENCE_ENTRY_MAPPING_END_STATE")
        case YAML_PARSE_FLOW_MAPPING_FIRST_KEY_STATE =>
          Some("YAML_PARSE_FLOW_MAPPING_FIRST_KEY_STATE")
        case YAML_PARSE_FLOW_MAPPING_KEY_STATE =>
          Some("YAML_PARSE_FLOW_MAPPING_KEY_STATE")
        case YAML_PARSE_FLOW_MAPPING_VALUE_STATE =>
          Some("YAML_PARSE_FLOW_MAPPING_VALUE_STATE")
        case YAML_PARSE_FLOW_MAPPING_EMPTY_VALUE_STATE =>
          Some("YAML_PARSE_FLOW_MAPPING_EMPTY_VALUE_STATE")
        case YAML_PARSE_END_STATE => Some("YAML_PARSE_END_STATE")
        case _                    => None
    extension (a: yaml_parser_state_e)
      inline def &(b: yaml_parser_state_e): yaml_parser_state_e = a & b
      inline def |(b: yaml_parser_state_e): yaml_parser_state_e = a | b
      inline def is(b: yaml_parser_state_e): Boolean = (a & b) == b

  /** Scalar styles.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_scalar_style_e = CUnsignedInt
  object yaml_scalar_style_e extends CEnumU[yaml_scalar_style_e]:
    given _tag: Tag[yaml_scalar_style_e] = Tag.UInt
    inline def define(inline a: Long): yaml_scalar_style_e = a.toUInt
    val YAML_ANY_SCALAR_STYLE = define(0)
    val YAML_PLAIN_SCALAR_STYLE = define(1)
    val YAML_SINGLE_QUOTED_SCALAR_STYLE = define(2)
    val YAML_DOUBLE_QUOTED_SCALAR_STYLE = define(3)
    val YAML_LITERAL_SCALAR_STYLE = define(4)
    val YAML_FOLDED_SCALAR_STYLE = define(5)
    inline def getName(inline value: yaml_scalar_style_e): Option[String] =
      inline value match
        case YAML_ANY_SCALAR_STYLE   => Some("YAML_ANY_SCALAR_STYLE")
        case YAML_PLAIN_SCALAR_STYLE => Some("YAML_PLAIN_SCALAR_STYLE")
        case YAML_SINGLE_QUOTED_SCALAR_STYLE =>
          Some("YAML_SINGLE_QUOTED_SCALAR_STYLE")
        case YAML_DOUBLE_QUOTED_SCALAR_STYLE =>
          Some("YAML_DOUBLE_QUOTED_SCALAR_STYLE")
        case YAML_LITERAL_SCALAR_STYLE => Some("YAML_LITERAL_SCALAR_STYLE")
        case YAML_FOLDED_SCALAR_STYLE  => Some("YAML_FOLDED_SCALAR_STYLE")
        case _                         => None
    extension (a: yaml_scalar_style_e)
      inline def &(b: yaml_scalar_style_e): yaml_scalar_style_e = a & b
      inline def |(b: yaml_scalar_style_e): yaml_scalar_style_e = a | b
      inline def is(b: yaml_scalar_style_e): Boolean = (a & b) == b

  /** Sequence styles.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_sequence_style_e = CUnsignedInt
  object yaml_sequence_style_e extends CEnumU[yaml_sequence_style_e]:
    given _tag: Tag[yaml_sequence_style_e] = Tag.UInt
    inline def define(inline a: Long): yaml_sequence_style_e = a.toUInt
    val YAML_ANY_SEQUENCE_STYLE = define(0)
    val YAML_BLOCK_SEQUENCE_STYLE = define(1)
    val YAML_FLOW_SEQUENCE_STYLE = define(2)
    inline def getName(inline value: yaml_sequence_style_e): Option[String] =
      inline value match
        case YAML_ANY_SEQUENCE_STYLE   => Some("YAML_ANY_SEQUENCE_STYLE")
        case YAML_BLOCK_SEQUENCE_STYLE => Some("YAML_BLOCK_SEQUENCE_STYLE")
        case YAML_FLOW_SEQUENCE_STYLE  => Some("YAML_FLOW_SEQUENCE_STYLE")
        case _                         => None
    extension (a: yaml_sequence_style_e)
      inline def &(b: yaml_sequence_style_e): yaml_sequence_style_e = a & b
      inline def |(b: yaml_sequence_style_e): yaml_sequence_style_e = a | b
      inline def is(b: yaml_sequence_style_e): Boolean = (a & b) == b

  /** Token types.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_token_type_e = CUnsignedInt
  object yaml_token_type_e extends CEnumU[yaml_token_type_e]:
    given _tag: Tag[yaml_token_type_e] = Tag.UInt
    inline def define(inline a: Long): yaml_token_type_e = a.toUInt
    val YAML_NO_TOKEN = define(0)
    val YAML_STREAM_START_TOKEN = define(1)
    val YAML_STREAM_END_TOKEN = define(2)
    val YAML_VERSION_DIRECTIVE_TOKEN = define(3)
    val YAML_TAG_DIRECTIVE_TOKEN = define(4)
    val YAML_DOCUMENT_START_TOKEN = define(5)
    val YAML_DOCUMENT_END_TOKEN = define(6)
    val YAML_BLOCK_SEQUENCE_START_TOKEN = define(7)
    val YAML_BLOCK_MAPPING_START_TOKEN = define(8)
    val YAML_BLOCK_END_TOKEN = define(9)
    val YAML_FLOW_SEQUENCE_START_TOKEN = define(10)
    val YAML_FLOW_SEQUENCE_END_TOKEN = define(11)
    val YAML_FLOW_MAPPING_START_TOKEN = define(12)
    val YAML_FLOW_MAPPING_END_TOKEN = define(13)
    val YAML_BLOCK_ENTRY_TOKEN = define(14)
    val YAML_FLOW_ENTRY_TOKEN = define(15)
    val YAML_KEY_TOKEN = define(16)
    val YAML_VALUE_TOKEN = define(17)
    val YAML_ALIAS_TOKEN = define(18)
    val YAML_ANCHOR_TOKEN = define(19)
    val YAML_TAG_TOKEN = define(20)
    val YAML_SCALAR_TOKEN = define(21)
    inline def getName(inline value: yaml_token_type_e): Option[String] =
      inline value match
        case YAML_NO_TOKEN           => Some("YAML_NO_TOKEN")
        case YAML_STREAM_START_TOKEN => Some("YAML_STREAM_START_TOKEN")
        case YAML_STREAM_END_TOKEN   => Some("YAML_STREAM_END_TOKEN")
        case YAML_VERSION_DIRECTIVE_TOKEN =>
          Some("YAML_VERSION_DIRECTIVE_TOKEN")
        case YAML_TAG_DIRECTIVE_TOKEN  => Some("YAML_TAG_DIRECTIVE_TOKEN")
        case YAML_DOCUMENT_START_TOKEN => Some("YAML_DOCUMENT_START_TOKEN")
        case YAML_DOCUMENT_END_TOKEN   => Some("YAML_DOCUMENT_END_TOKEN")
        case YAML_BLOCK_SEQUENCE_START_TOKEN =>
          Some("YAML_BLOCK_SEQUENCE_START_TOKEN")
        case YAML_BLOCK_MAPPING_START_TOKEN =>
          Some("YAML_BLOCK_MAPPING_START_TOKEN")
        case YAML_BLOCK_END_TOKEN => Some("YAML_BLOCK_END_TOKEN")
        case YAML_FLOW_SEQUENCE_START_TOKEN =>
          Some("YAML_FLOW_SEQUENCE_START_TOKEN")
        case YAML_FLOW_SEQUENCE_END_TOKEN =>
          Some("YAML_FLOW_SEQUENCE_END_TOKEN")
        case YAML_FLOW_MAPPING_START_TOKEN =>
          Some("YAML_FLOW_MAPPING_START_TOKEN")
        case YAML_FLOW_MAPPING_END_TOKEN => Some("YAML_FLOW_MAPPING_END_TOKEN")
        case YAML_BLOCK_ENTRY_TOKEN      => Some("YAML_BLOCK_ENTRY_TOKEN")
        case YAML_FLOW_ENTRY_TOKEN       => Some("YAML_FLOW_ENTRY_TOKEN")
        case YAML_KEY_TOKEN              => Some("YAML_KEY_TOKEN")
        case YAML_VALUE_TOKEN            => Some("YAML_VALUE_TOKEN")
        case YAML_ALIAS_TOKEN            => Some("YAML_ALIAS_TOKEN")
        case YAML_ANCHOR_TOKEN           => Some("YAML_ANCHOR_TOKEN")
        case YAML_TAG_TOKEN              => Some("YAML_TAG_TOKEN")
        case YAML_SCALAR_TOKEN           => Some("YAML_SCALAR_TOKEN")
        case _                           => None
    extension (a: yaml_token_type_e)
      inline def &(b: yaml_token_type_e): yaml_token_type_e = a & b
      inline def |(b: yaml_token_type_e): yaml_token_type_e = a | b
      inline def is(b: yaml_token_type_e): Boolean = (a & b) == b

object aliases:
  import _root_.dev.hnaderi.libyaml.enumerations.*
  import _root_.dev.hnaderi.libyaml.aliases.*
  import _root_.dev.hnaderi.libyaml.structs.*

  type FILE = libc.stdio.FILE
  object FILE:
    val _tag: Tag[FILE] = summon[Tag[libc.stdio.FILE]]
    inline def apply(inline o: libc.stdio.FILE): FILE = o
    extension (v: FILE) inline def value: libc.stdio.FILE = v

  type size_t = libc.stddef.size_t
  object size_t:
    val _tag: Tag[size_t] = summon[Tag[libc.stddef.size_t]]
    inline def apply(inline o: libc.stddef.size_t): size_t = o
    extension (v: size_t) inline def value: libc.stddef.size_t = v

  /** Line break types.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  type yaml_break_t = yaml_break_e
  object yaml_break_t:
    given _tag: Tag[yaml_break_t] = yaml_break_e._tag
    inline def apply(inline o: yaml_break_e): yaml_break_t = o
    extension (v: yaml_break_t) inline def value: yaml_break_e = v

  /** The character type (UTF-8 octet).
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_char_t = CUnsignedChar
  object yaml_char_t:
    given _tag: Tag[yaml_char_t] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): yaml_char_t = o
    extension (v: yaml_char_t) inline def value: CUnsignedChar = v

  /** The emitter states.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  type yaml_emitter_state_t = yaml_emitter_state_e
  object yaml_emitter_state_t:
    given _tag: Tag[yaml_emitter_state_t] = yaml_emitter_state_e._tag
    inline def apply(inline o: yaml_emitter_state_e): yaml_emitter_state_t = o
    extension (v: yaml_emitter_state_t)
      inline def value: yaml_emitter_state_e = v

  /** The stream encoding.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  type yaml_encoding_t = yaml_encoding_e
  object yaml_encoding_t:
    given _tag: Tag[yaml_encoding_t] = yaml_encoding_e._tag
    inline def apply(inline o: yaml_encoding_e): yaml_encoding_t = o
    extension (v: yaml_encoding_t) inline def value: yaml_encoding_e = v

  /** Many bad things could happen with the parser and emitter.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  type yaml_error_type_t = yaml_error_type_e
  object yaml_error_type_t:
    given _tag: Tag[yaml_error_type_t] = yaml_error_type_e._tag
    inline def apply(inline o: yaml_error_type_e): yaml_error_type_t = o
    extension (v: yaml_error_type_t) inline def value: yaml_error_type_e = v

  /** Event types.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  type yaml_event_type_t = yaml_event_type_e
  object yaml_event_type_t:
    given _tag: Tag[yaml_event_type_t] = yaml_event_type_e._tag
    inline def apply(inline o: yaml_event_type_e): yaml_event_type_t = o
    extension (v: yaml_event_type_t) inline def value: yaml_event_type_e = v

  /** Mapping styles.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  type yaml_mapping_style_t = yaml_mapping_style_e
  object yaml_mapping_style_t:
    given _tag: Tag[yaml_mapping_style_t] = yaml_mapping_style_e._tag
    inline def apply(inline o: yaml_mapping_style_e): yaml_mapping_style_t = o
    extension (v: yaml_mapping_style_t)
      inline def value: yaml_mapping_style_e = v

  /** An element of a sequence node.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_node_item_t = CInt
  object yaml_node_item_t:
    given _tag: Tag[yaml_node_item_t] = Tag.Int
    inline def apply(inline o: CInt): yaml_node_item_t = o
    extension (v: yaml_node_item_t) inline def value: CInt = v

  /** Node types.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  type yaml_node_type_t = yaml_node_type_e
  object yaml_node_type_t:
    given _tag: Tag[yaml_node_type_t] = yaml_node_type_e._tag
    inline def apply(inline o: yaml_node_type_e): yaml_node_type_t = o
    extension (v: yaml_node_type_t) inline def value: yaml_node_type_e = v

  /** The states of the parser.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  type yaml_parser_state_t = yaml_parser_state_e
  object yaml_parser_state_t:
    given _tag: Tag[yaml_parser_state_t] = yaml_parser_state_e._tag
    inline def apply(inline o: yaml_parser_state_e): yaml_parser_state_t = o
    extension (v: yaml_parser_state_t) inline def value: yaml_parser_state_e = v

  /** The prototype of a read handler.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  type yaml_read_handler_t =
    CFuncPtr4[Ptr[Byte], Ptr[CUnsignedChar], size_t, Ptr[size_t], CInt]
  object yaml_read_handler_t:
    given _tag: Tag[yaml_read_handler_t] = Tag.materializeCFuncPtr4[Ptr[
      Byte
    ], Ptr[CUnsignedChar], size_t, Ptr[size_t], CInt]
    inline def apply(
        inline o: CFuncPtr4[Ptr[Byte], Ptr[CUnsignedChar], size_t, Ptr[
          size_t
        ], CInt]
    ): yaml_read_handler_t = o
    extension (v: yaml_read_handler_t)
      inline def value: CFuncPtr4[Ptr[Byte], Ptr[CUnsignedChar], size_t, Ptr[
        size_t
      ], CInt] = v

  /** Scalar styles.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  type yaml_scalar_style_t = yaml_scalar_style_e
  object yaml_scalar_style_t:
    given _tag: Tag[yaml_scalar_style_t] = yaml_scalar_style_e._tag
    inline def apply(inline o: yaml_scalar_style_e): yaml_scalar_style_t = o
    extension (v: yaml_scalar_style_t) inline def value: yaml_scalar_style_e = v

  /** Sequence styles.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  type yaml_sequence_style_t = yaml_sequence_style_e
  object yaml_sequence_style_t:
    given _tag: Tag[yaml_sequence_style_t] = yaml_sequence_style_e._tag
    inline def apply(inline o: yaml_sequence_style_e): yaml_sequence_style_t = o
    extension (v: yaml_sequence_style_t)
      inline def value: yaml_sequence_style_e = v

  /** Token types.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  type yaml_token_type_t = yaml_token_type_e
  object yaml_token_type_t:
    given _tag: Tag[yaml_token_type_t] = yaml_token_type_e._tag
    inline def apply(inline o: yaml_token_type_e): yaml_token_type_t = o
    extension (v: yaml_token_type_t) inline def value: yaml_token_type_e = v

  /** The prototype of a write handler.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  type yaml_write_handler_t =
    CFuncPtr3[Ptr[Byte], Ptr[CUnsignedChar], size_t, CInt]
  object yaml_write_handler_t:
    given _tag: Tag[yaml_write_handler_t] =
      Tag.materializeCFuncPtr3[Ptr[Byte], Ptr[CUnsignedChar], size_t, CInt]
    inline def apply(
        inline o: CFuncPtr3[Ptr[Byte], Ptr[CUnsignedChar], size_t, CInt]
    ): yaml_write_handler_t = o
    extension (v: yaml_write_handler_t)
      inline def value: CFuncPtr3[Ptr[Byte], Ptr[CUnsignedChar], size_t, CInt] =
        v

object structs:
  import _root_.dev.hnaderi.libyaml.enumerations.*
  import _root_.dev.hnaderi.libyaml.aliases.*
  import _root_.dev.hnaderi.libyaml.structs.*

  /** This structure holds aliases data.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_alias_data_s = CStruct3[Ptr[yaml_char_t], CInt, yaml_mark_t]
  object yaml_alias_data_s:
    given _tag: Tag[yaml_alias_data_s] =
      Tag.materializeCStruct3Tag[Ptr[yaml_char_t], CInt, yaml_mark_t]
    def apply()(using Zone): Ptr[yaml_alias_data_s] =
      scala.scalanative.unsafe.alloc[yaml_alias_data_s](1)
    def apply(anchor: Ptr[yaml_char_t], index: CInt, mark: yaml_mark_t)(using
        Zone
    ): Ptr[yaml_alias_data_s] =
      val ____ptr = apply()
      (!____ptr).anchor = anchor
      (!____ptr).index = index
      (!____ptr).mark = mark
      ____ptr
    extension (struct: yaml_alias_data_s)
      def anchor: Ptr[yaml_char_t] = struct._1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
      def index: CInt = struct._2
      def index_=(value: CInt): Unit = !struct.at2 = value
      def mark: yaml_mark_t = struct._3
      def mark_=(value: yaml_mark_t): Unit = !struct.at3 = value

  /** This structure holds aliases data.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_alias_data_t = CStruct3[Ptr[yaml_char_t], CInt, yaml_mark_t]
  object yaml_alias_data_t:
    given _tag: Tag[yaml_alias_data_t] =
      Tag.materializeCStruct3Tag[Ptr[yaml_char_t], CInt, yaml_mark_t]
    def apply()(using Zone): Ptr[yaml_alias_data_t] =
      scala.scalanative.unsafe.alloc[yaml_alias_data_t](1)
    def apply(anchor: Ptr[yaml_char_t], index: CInt, mark: yaml_mark_t)(using
        Zone
    ): Ptr[yaml_alias_data_t] =
      val ____ptr = apply()
      (!____ptr).anchor = anchor
      (!____ptr).index = index
      (!____ptr).mark = mark
      ____ptr
    extension (struct: yaml_alias_data_t)
      def anchor: Ptr[yaml_char_t] = struct._1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
      def index: CInt = struct._2
      def index_=(value: CInt): Unit = !struct.at2 = value
      def mark: yaml_mark_t = struct._3
      def mark_=(value: yaml_mark_t): Unit = !struct.at3 = value

  /** [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_anchors_s = CStruct3[CInt, CInt, CInt]
  object yaml_anchors_s:
    given _tag: Tag[yaml_anchors_s] =
      Tag.materializeCStruct3Tag[CInt, CInt, CInt]
    def apply()(using Zone): Ptr[yaml_anchors_s] =
      scala.scalanative.unsafe.alloc[yaml_anchors_s](1)
    def apply(references: CInt, anchor: CInt, serialized: CInt)(using
        Zone
    ): Ptr[yaml_anchors_s] =
      val ____ptr = apply()
      (!____ptr).references = references
      (!____ptr).anchor = anchor
      (!____ptr).serialized = serialized
      ____ptr
    extension (struct: yaml_anchors_s)
      def references: CInt = struct._1
      def references_=(value: CInt): Unit = !struct.at1 = value
      def anchor: CInt = struct._2
      def anchor_=(value: CInt): Unit = !struct.at2 = value
      def serialized: CInt = struct._3
      def serialized_=(value: CInt): Unit = !struct.at3 = value

  /** [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_anchors_t = CStruct3[CInt, CInt, CInt]
  object yaml_anchors_t:
    given _tag: Tag[yaml_anchors_t] =
      Tag.materializeCStruct3Tag[CInt, CInt, CInt]
    def apply()(using Zone): Ptr[yaml_anchors_t] =
      scala.scalanative.unsafe.alloc[yaml_anchors_t](1)
    def apply(references: CInt, anchor: CInt, serialized: CInt)(using
        Zone
    ): Ptr[yaml_anchors_t] =
      val ____ptr = apply()
      (!____ptr).references = references
      (!____ptr).anchor = anchor
      (!____ptr).serialized = serialized
      ____ptr
    extension (struct: yaml_anchors_t)
      def references: CInt = struct._1
      def references_=(value: CInt): Unit = !struct.at1 = value
      def anchor: CInt = struct._2
      def anchor_=(value: CInt): Unit = !struct.at2 = value
      def serialized: CInt = struct._3
      def serialized_=(value: CInt): Unit = !struct.at3 = value

  /** The document structure.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_document_s = CStruct7[yaml_document_s.Struct0, Ptr[
    yaml_version_directive_t
  ], yaml_document_s.Struct1, CInt, CInt, yaml_mark_t, yaml_mark_t]
  object yaml_document_s:
    /** The document nodes.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct0 =
      CStruct3[Ptr[yaml_node_t], Ptr[yaml_node_t], Ptr[yaml_node_t]]
    object Struct0:
      given _tag: Tag[Struct0] = Tag.materializeCStruct3Tag[Ptr[
        yaml_node_t
      ], Ptr[yaml_node_t], Ptr[yaml_node_t]]
      def apply()(using Zone): Ptr[Struct0] =
        scala.scalanative.unsafe.alloc[Struct0](1)
      def apply(
          start: Ptr[yaml_node_t],
          end: Ptr[yaml_node_t],
          top: Ptr[yaml_node_t]
      )(using Zone): Ptr[Struct0] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct0)
        def start: Ptr[yaml_node_t] = struct._1
        def start_=(value: Ptr[yaml_node_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_node_t] = struct._2
        def end_=(value: Ptr[yaml_node_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_node_t] = struct._3
        def top_=(value: Ptr[yaml_node_t]): Unit = !struct.at3 = value

    /** The list of tag directives.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct1 =
      CStruct2[Ptr[yaml_tag_directive_t], Ptr[yaml_tag_directive_t]]
    object Struct1:
      given _tag: Tag[Struct1] = Tag.materializeCStruct2Tag[Ptr[
        yaml_tag_directive_t
      ], Ptr[yaml_tag_directive_t]]
      def apply()(using Zone): Ptr[Struct1] =
        scala.scalanative.unsafe.alloc[Struct1](1)
      def apply(
          start: Ptr[yaml_tag_directive_t],
          end: Ptr[yaml_tag_directive_t]
      )(using Zone): Ptr[Struct1] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        ____ptr
      extension (struct: Struct1)
        def start: Ptr[yaml_tag_directive_t] = struct._1
        def start_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at1 =
          value
        def end: Ptr[yaml_tag_directive_t] = struct._2
        def end_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at2 = value
    given _tag: Tag[yaml_document_s] =
      Tag.materializeCStruct7Tag[yaml_document_s.Struct0, Ptr[
        yaml_version_directive_t
      ], yaml_document_s.Struct1, CInt, CInt, yaml_mark_t, yaml_mark_t]
    def apply()(using Zone): Ptr[yaml_document_s] =
      scala.scalanative.unsafe.alloc[yaml_document_s](1)
    def apply(
        nodes: yaml_document_s.Struct0,
        version_directive: Ptr[yaml_version_directive_t],
        tag_directives: yaml_document_s.Struct1,
        start_implicit: CInt,
        end_implicit: CInt,
        start_mark: yaml_mark_t,
        end_mark: yaml_mark_t
    )(using Zone): Ptr[yaml_document_s] =
      val ____ptr = apply()
      (!____ptr).nodes = nodes
      (!____ptr).version_directive = version_directive
      (!____ptr).tag_directives = tag_directives
      (!____ptr).start_implicit = start_implicit
      (!____ptr).end_implicit = end_implicit
      (!____ptr).start_mark = start_mark
      (!____ptr).end_mark = end_mark
      ____ptr
    extension (struct: yaml_document_s)
      def nodes: yaml_document_s.Struct0 = struct._1
      def nodes_=(value: yaml_document_s.Struct0): Unit = !struct.at1 = value
      def version_directive: Ptr[yaml_version_directive_t] = struct._2
      def version_directive_=(value: Ptr[yaml_version_directive_t]): Unit =
        !struct.at2 = value
      def tag_directives: yaml_document_s.Struct1 = struct._3
      def tag_directives_=(value: yaml_document_s.Struct1): Unit = !struct.at3 =
        value
      def start_implicit: CInt = struct._4
      def start_implicit_=(value: CInt): Unit = !struct.at4 = value
      def end_implicit: CInt = struct._5
      def end_implicit_=(value: CInt): Unit = !struct.at5 = value
      def start_mark: yaml_mark_t = struct._6
      def start_mark_=(value: yaml_mark_t): Unit = !struct.at6 = value
      def end_mark: yaml_mark_t = struct._7
      def end_mark_=(value: yaml_mark_t): Unit = !struct.at7 = value

  /** The document structure.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_document_t = CStruct7[yaml_document_t.Struct0, Ptr[
    yaml_version_directive_t
  ], yaml_document_t.Struct1, CInt, CInt, yaml_mark_t, yaml_mark_t]
  object yaml_document_t:
    /** The document nodes.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct0 =
      CStruct3[Ptr[yaml_node_t], Ptr[yaml_node_t], Ptr[yaml_node_t]]
    object Struct0:
      given _tag: Tag[Struct0] = Tag.materializeCStruct3Tag[Ptr[
        yaml_node_t
      ], Ptr[yaml_node_t], Ptr[yaml_node_t]]
      def apply()(using Zone): Ptr[Struct0] =
        scala.scalanative.unsafe.alloc[Struct0](1)
      def apply(
          start: Ptr[yaml_node_t],
          end: Ptr[yaml_node_t],
          top: Ptr[yaml_node_t]
      )(using Zone): Ptr[Struct0] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct0)
        def start: Ptr[yaml_node_t] = struct._1
        def start_=(value: Ptr[yaml_node_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_node_t] = struct._2
        def end_=(value: Ptr[yaml_node_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_node_t] = struct._3
        def top_=(value: Ptr[yaml_node_t]): Unit = !struct.at3 = value

    /** The list of tag directives.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct1 =
      CStruct2[Ptr[yaml_tag_directive_t], Ptr[yaml_tag_directive_t]]
    object Struct1:
      given _tag: Tag[Struct1] = Tag.materializeCStruct2Tag[Ptr[
        yaml_tag_directive_t
      ], Ptr[yaml_tag_directive_t]]
      def apply()(using Zone): Ptr[Struct1] =
        scala.scalanative.unsafe.alloc[Struct1](1)
      def apply(
          start: Ptr[yaml_tag_directive_t],
          end: Ptr[yaml_tag_directive_t]
      )(using Zone): Ptr[Struct1] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        ____ptr
      extension (struct: Struct1)
        def start: Ptr[yaml_tag_directive_t] = struct._1
        def start_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at1 =
          value
        def end: Ptr[yaml_tag_directive_t] = struct._2
        def end_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at2 = value
    given _tag: Tag[yaml_document_t] =
      Tag.materializeCStruct7Tag[yaml_document_t.Struct0, Ptr[
        yaml_version_directive_t
      ], yaml_document_t.Struct1, CInt, CInt, yaml_mark_t, yaml_mark_t]
    def apply()(using Zone): Ptr[yaml_document_t] =
      scala.scalanative.unsafe.alloc[yaml_document_t](1)
    def apply(
        nodes: yaml_document_t.Struct0,
        version_directive: Ptr[yaml_version_directive_t],
        tag_directives: yaml_document_t.Struct1,
        start_implicit: CInt,
        end_implicit: CInt,
        start_mark: yaml_mark_t,
        end_mark: yaml_mark_t
    )(using Zone): Ptr[yaml_document_t] =
      val ____ptr = apply()
      (!____ptr).nodes = nodes
      (!____ptr).version_directive = version_directive
      (!____ptr).tag_directives = tag_directives
      (!____ptr).start_implicit = start_implicit
      (!____ptr).end_implicit = end_implicit
      (!____ptr).start_mark = start_mark
      (!____ptr).end_mark = end_mark
      ____ptr
    extension (struct: yaml_document_t)
      def nodes: yaml_document_t.Struct0 = struct._1
      def nodes_=(value: yaml_document_t.Struct0): Unit = !struct.at1 = value
      def version_directive: Ptr[yaml_version_directive_t] = struct._2
      def version_directive_=(value: Ptr[yaml_version_directive_t]): Unit =
        !struct.at2 = value
      def tag_directives: yaml_document_t.Struct1 = struct._3
      def tag_directives_=(value: yaml_document_t.Struct1): Unit = !struct.at3 =
        value
      def start_implicit: CInt = struct._4
      def start_implicit_=(value: CInt): Unit = !struct.at4 = value
      def end_implicit: CInt = struct._5
      def end_implicit_=(value: CInt): Unit = !struct.at5 = value
      def start_mark: yaml_mark_t = struct._6
      def start_mark_=(value: yaml_mark_t): Unit = !struct.at6 = value
      def end_mark: yaml_mark_t = struct._7
      def end_mark_=(value: yaml_mark_t): Unit = !struct.at7 = value

  /** The emitter structure.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_emitter_s = CArray[CChar, Nat.Digit3[Nat._4, Nat._3, Nat._2]]
  object yaml_emitter_s:
    /** Standard (string or file) output data.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Union0 = CArray[Byte, Nat.Digit2[Nat._2, Nat._4]]
    object Union0:
      /** String output data.
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct0 = CStruct3[Ptr[CUnsignedChar], size_t, Ptr[size_t]]
      object Struct0:
        given _tag: Tag[Struct0] =
          Tag.materializeCStruct3Tag[Ptr[CUnsignedChar], size_t, Ptr[size_t]]
        def apply()(using Zone): Ptr[Struct0] =
          scala.scalanative.unsafe.alloc[Struct0](1)
        def apply(
            buffer: Ptr[CUnsignedChar],
            size: size_t,
            size_written: Ptr[size_t]
        )(using Zone): Ptr[Struct0] =
          val ____ptr = apply()
          (!____ptr).buffer = buffer
          (!____ptr).size = size
          (!____ptr).size_written = size_written
          ____ptr
        extension (struct: Struct0)
          def buffer: Ptr[CUnsignedChar] = struct._1
          def buffer_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
          def size: size_t = struct._2
          def size_=(value: size_t): Unit = !struct.at2 = value
          def size_written: Ptr[size_t] = struct._3
          def size_written_=(value: Ptr[size_t]): Unit = !struct.at3 = value
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat.Digit2[Nat._2, Nat._4]](
        Tag.Byte,
        Tag.Digit2[Nat._2, Nat._4](Tag.Nat2, Tag.Nat4)
      )
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_string")
      def apply(string: yaml_emitter_s.Union0.Struct0)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_emitter_s.Union0.Struct0]]
          .update(0, string)
        ___ptr
      @scala.annotation.targetName("apply_file")
      def apply(file: Ptr[FILE])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FILE]]].update(0, file)
        ___ptr
      extension (struct: Union0)
        def string: yaml_emitter_s.Union0.Struct0 =
          !struct.at(0).asInstanceOf[Ptr[yaml_emitter_s.Union0.Struct0]]
        def string_=(value: yaml_emitter_s.Union0.Struct0): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_emitter_s.Union0.Struct0]] = value
        def file: Ptr[FILE] = !struct.at(0).asInstanceOf[Ptr[Ptr[FILE]]]
        def file_=(value: Ptr[FILE]): Unit =
          !struct.at(0).asInstanceOf[Ptr[Ptr[FILE]]] = value

    /** The working buffer.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct1 = CStruct4[Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[
      yaml_char_t
    ], Ptr[yaml_char_t]]
    object Struct1:
      given _tag: Tag[Struct1] = Tag.materializeCStruct4Tag[Ptr[
        yaml_char_t
      ], Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[yaml_char_t]]
      def apply()(using Zone): Ptr[Struct1] =
        scala.scalanative.unsafe.alloc[Struct1](1)
      def apply(
          start: Ptr[yaml_char_t],
          end: Ptr[yaml_char_t],
          pointer: Ptr[yaml_char_t],
          last: Ptr[yaml_char_t]
      )(using Zone): Ptr[Struct1] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).pointer = pointer
        (!____ptr).last = last
        ____ptr
      extension (struct: Struct1)
        def start: Ptr[yaml_char_t] = struct._1
        def start_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_char_t] = struct._2
        def end_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
        def pointer: Ptr[yaml_char_t] = struct._3
        def pointer_=(value: Ptr[yaml_char_t]): Unit = !struct.at3 = value
        def last: Ptr[yaml_char_t] = struct._4
        def last_=(value: Ptr[yaml_char_t]): Unit = !struct.at4 = value

    /** The raw buffer.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct2 = CStruct4[Ptr[CUnsignedChar], Ptr[CUnsignedChar], Ptr[
      CUnsignedChar
    ], Ptr[CUnsignedChar]]
    object Struct2:
      given _tag: Tag[Struct2] = Tag.materializeCStruct4Tag[Ptr[
        CUnsignedChar
      ], Ptr[CUnsignedChar], Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
      def apply()(using Zone): Ptr[Struct2] =
        scala.scalanative.unsafe.alloc[Struct2](1)
      def apply(
          start: Ptr[CUnsignedChar],
          end: Ptr[CUnsignedChar],
          pointer: Ptr[CUnsignedChar],
          last: Ptr[CUnsignedChar]
      )(using Zone): Ptr[Struct2] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).pointer = pointer
        (!____ptr).last = last
        ____ptr
      extension (struct: Struct2)
        def start: Ptr[CUnsignedChar] = struct._1
        def start_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
        def end: Ptr[CUnsignedChar] = struct._2
        def end_=(value: Ptr[CUnsignedChar]): Unit = !struct.at2 = value
        def pointer: Ptr[CUnsignedChar] = struct._3
        def pointer_=(value: Ptr[CUnsignedChar]): Unit = !struct.at3 = value
        def last: Ptr[CUnsignedChar] = struct._4
        def last_=(value: Ptr[CUnsignedChar]): Unit = !struct.at4 = value

    /** The stack of states.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct3 = CStruct3[Ptr[yaml_emitter_state_t], Ptr[
      yaml_emitter_state_t
    ], Ptr[yaml_emitter_state_t]]
    object Struct3:
      given _tag: Tag[Struct3] = Tag.materializeCStruct3Tag[Ptr[
        yaml_emitter_state_t
      ], Ptr[yaml_emitter_state_t], Ptr[yaml_emitter_state_t]]
      def apply()(using Zone): Ptr[Struct3] =
        scala.scalanative.unsafe.alloc[Struct3](1)
      def apply(
          start: Ptr[yaml_emitter_state_t],
          end: Ptr[yaml_emitter_state_t],
          top: Ptr[yaml_emitter_state_t]
      )(using Zone): Ptr[Struct3] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct3)
        def start: Ptr[yaml_emitter_state_t] = struct._1
        def start_=(value: Ptr[yaml_emitter_state_t]): Unit = !struct.at1 =
          value
        def end: Ptr[yaml_emitter_state_t] = struct._2
        def end_=(value: Ptr[yaml_emitter_state_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_emitter_state_t] = struct._3
        def top_=(value: Ptr[yaml_emitter_state_t]): Unit = !struct.at3 = value

    /** The event queue.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct4 = CStruct4[Ptr[yaml_event_t], Ptr[yaml_event_t], Ptr[
      yaml_event_t
    ], Ptr[yaml_event_t]]
    object Struct4:
      given _tag: Tag[Struct4] = Tag.materializeCStruct4Tag[Ptr[
        yaml_event_t
      ], Ptr[yaml_event_t], Ptr[yaml_event_t], Ptr[yaml_event_t]]
      def apply()(using Zone): Ptr[Struct4] =
        scala.scalanative.unsafe.alloc[Struct4](1)
      def apply(
          start: Ptr[yaml_event_t],
          end: Ptr[yaml_event_t],
          head: Ptr[yaml_event_t],
          tail: Ptr[yaml_event_t]
      )(using Zone): Ptr[Struct4] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).head = head
        (!____ptr).tail = tail
        ____ptr
      extension (struct: Struct4)
        def start: Ptr[yaml_event_t] = struct._1
        def start_=(value: Ptr[yaml_event_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_event_t] = struct._2
        def end_=(value: Ptr[yaml_event_t]): Unit = !struct.at2 = value
        def head: Ptr[yaml_event_t] = struct._3
        def head_=(value: Ptr[yaml_event_t]): Unit = !struct.at3 = value
        def tail: Ptr[yaml_event_t] = struct._4
        def tail_=(value: Ptr[yaml_event_t]): Unit = !struct.at4 = value

    /** The stack of indentation levels.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct5 = CStruct3[Ptr[CInt], Ptr[CInt], Ptr[CInt]]
    object Struct5:
      given _tag: Tag[Struct5] =
        Tag.materializeCStruct3Tag[Ptr[CInt], Ptr[CInt], Ptr[CInt]]
      def apply()(using Zone): Ptr[Struct5] =
        scala.scalanative.unsafe.alloc[Struct5](1)
      def apply(start: Ptr[CInt], end: Ptr[CInt], top: Ptr[CInt])(using
          Zone
      ): Ptr[Struct5] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct5)
        def start: Ptr[CInt] = struct._1
        def start_=(value: Ptr[CInt]): Unit = !struct.at1 = value
        def end: Ptr[CInt] = struct._2
        def end_=(value: Ptr[CInt]): Unit = !struct.at2 = value
        def top: Ptr[CInt] = struct._3
        def top_=(value: Ptr[CInt]): Unit = !struct.at3 = value

    /** The list of tag directives.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct6 = CStruct3[Ptr[yaml_tag_directive_t], Ptr[
      yaml_tag_directive_t
    ], Ptr[yaml_tag_directive_t]]
    object Struct6:
      given _tag: Tag[Struct6] = Tag.materializeCStruct3Tag[Ptr[
        yaml_tag_directive_t
      ], Ptr[yaml_tag_directive_t], Ptr[yaml_tag_directive_t]]
      def apply()(using Zone): Ptr[Struct6] =
        scala.scalanative.unsafe.alloc[Struct6](1)
      def apply(
          start: Ptr[yaml_tag_directive_t],
          end: Ptr[yaml_tag_directive_t],
          top: Ptr[yaml_tag_directive_t]
      )(using Zone): Ptr[Struct6] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct6)
        def start: Ptr[yaml_tag_directive_t] = struct._1
        def start_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at1 =
          value
        def end: Ptr[yaml_tag_directive_t] = struct._2
        def end_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_tag_directive_t] = struct._3
        def top_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at3 = value

    /** Anchor analysis.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct7 = CStruct3[Ptr[yaml_char_t], size_t, CInt]
    object Struct7:
      given _tag: Tag[Struct7] =
        Tag.materializeCStruct3Tag[Ptr[yaml_char_t], size_t, CInt]
      def apply()(using Zone): Ptr[Struct7] =
        scala.scalanative.unsafe.alloc[Struct7](1)
      def apply(anchor: Ptr[yaml_char_t], anchor_length: size_t, alias: CInt)(
          using Zone
      ): Ptr[Struct7] =
        val ____ptr = apply()
        (!____ptr).anchor = anchor
        (!____ptr).anchor_length = anchor_length
        (!____ptr).alias = alias
        ____ptr
      extension (struct: Struct7)
        def anchor: Ptr[yaml_char_t] = struct._1
        def anchor_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
        def anchor_length: size_t = struct._2
        def anchor_length_=(value: size_t): Unit = !struct.at2 = value
        def alias: CInt = struct._3
        def alias_=(value: CInt): Unit = !struct.at3 = value

    /** Tag analysis.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct8 =
      CStruct4[Ptr[yaml_char_t], size_t, Ptr[yaml_char_t], size_t]
    object Struct8:
      given _tag: Tag[Struct8] = Tag.materializeCStruct4Tag[Ptr[
        yaml_char_t
      ], size_t, Ptr[yaml_char_t], size_t]
      def apply()(using Zone): Ptr[Struct8] =
        scala.scalanative.unsafe.alloc[Struct8](1)
      def apply(
          handle: Ptr[yaml_char_t],
          handle_length: size_t,
          suffix: Ptr[yaml_char_t],
          suffix_length: size_t
      )(using Zone): Ptr[Struct8] =
        val ____ptr = apply()
        (!____ptr).handle = handle
        (!____ptr).handle_length = handle_length
        (!____ptr).suffix = suffix
        (!____ptr).suffix_length = suffix_length
        ____ptr
      extension (struct: Struct8)
        def handle: Ptr[yaml_char_t] = struct._1
        def handle_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
        def handle_length: size_t = struct._2
        def handle_length_=(value: size_t): Unit = !struct.at2 = value
        def suffix: Ptr[yaml_char_t] = struct._3
        def suffix_=(value: Ptr[yaml_char_t]): Unit = !struct.at3 = value
        def suffix_length: size_t = struct._4
        def suffix_length_=(value: size_t): Unit = !struct.at4 = value

    /** Scalar analysis.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct9 = CStruct8[Ptr[
      yaml_char_t
    ], size_t, CInt, CInt, CInt, CInt, CInt, yaml_scalar_style_t]
    object Struct9:
      given _tag: Tag[Struct9] = Tag.materializeCStruct8Tag[Ptr[
        yaml_char_t
      ], size_t, CInt, CInt, CInt, CInt, CInt, yaml_scalar_style_t]
      def apply()(using Zone): Ptr[Struct9] =
        scala.scalanative.unsafe.alloc[Struct9](1)
      def apply(
          value: Ptr[yaml_char_t],
          length: size_t,
          multiline: CInt,
          flow_plain_allowed: CInt,
          block_plain_allowed: CInt,
          single_quoted_allowed: CInt,
          block_allowed: CInt,
          style: yaml_scalar_style_t
      )(using Zone): Ptr[Struct9] =
        val ____ptr = apply()
        (!____ptr).value = value
        (!____ptr).length = length
        (!____ptr).multiline = multiline
        (!____ptr).flow_plain_allowed = flow_plain_allowed
        (!____ptr).block_plain_allowed = block_plain_allowed
        (!____ptr).single_quoted_allowed = single_quoted_allowed
        (!____ptr).block_allowed = block_allowed
        (!____ptr).style = style
        ____ptr
      extension (struct: Struct9)
        def value: Ptr[yaml_char_t] = struct._1
        def value_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
        def length: size_t = struct._2
        def length_=(value: size_t): Unit = !struct.at2 = value
        def multiline: CInt = struct._3
        def multiline_=(value: CInt): Unit = !struct.at3 = value
        def flow_plain_allowed: CInt = struct._4
        def flow_plain_allowed_=(value: CInt): Unit = !struct.at4 = value
        def block_plain_allowed: CInt = struct._5
        def block_plain_allowed_=(value: CInt): Unit = !struct.at5 = value
        def single_quoted_allowed: CInt = struct._6
        def single_quoted_allowed_=(value: CInt): Unit = !struct.at6 = value
        def block_allowed: CInt = struct._7
        def block_allowed_=(value: CInt): Unit = !struct.at7 = value
        def style: yaml_scalar_style_t = struct._8
        def style_=(value: yaml_scalar_style_t): Unit = !struct.at8 = value
    given _tag: Tag[yaml_emitter_s] =
      Tag.CArray[CChar, Nat.Digit3[Nat._4, Nat._3, Nat._2]](
        Tag.Byte,
        Tag.Digit3[Nat._4, Nat._3, Nat._2](Tag.Nat4, Tag.Nat3, Tag.Nat2)
      )
    def apply()(using Zone): Ptr[yaml_emitter_s] =
      scala.scalanative.unsafe.alloc[yaml_emitter_s](1)
    def apply(
        error: yaml_error_type_t,
        problem: CString,
        write_handler: Ptr[yaml_write_handler_t],
        write_handler_data: Ptr[Byte],
        output: yaml_emitter_s.Union0,
        buffer: yaml_emitter_s.Struct1,
        raw_buffer: yaml_emitter_s.Struct2,
        encoding: yaml_encoding_t,
        canonical: CInt,
        best_indent: CInt,
        best_width: CInt,
        unicode: CInt,
        line_break: yaml_break_t,
        states: yaml_emitter_s.Struct3,
        state: yaml_emitter_state_t,
        events: yaml_emitter_s.Struct4,
        indents: yaml_emitter_s.Struct5,
        tag_directives: yaml_emitter_s.Struct6,
        indent: CInt,
        flow_level: CInt,
        root_context: CInt,
        sequence_context: CInt,
        mapping_context: CInt,
        simple_key_context: CInt,
        line: CInt,
        column: CInt,
        whitespace: CInt,
        indention: CInt,
        open_ended: CInt,
        anchor_data: yaml_emitter_s.Struct7,
        tag_data: yaml_emitter_s.Struct8,
        scalar_data: yaml_emitter_s.Struct9,
        opened: CInt,
        closed: CInt,
        anchors: Ptr[yaml_anchors_t],
        last_anchor_id: CInt,
        document: Ptr[yaml_document_t]
    )(using Zone): Ptr[yaml_emitter_s] =
      val ____ptr = apply()
      (!____ptr).error = error
      (!____ptr).problem = problem
      (!____ptr).write_handler = write_handler
      (!____ptr).write_handler_data = write_handler_data
      (!____ptr).output = output
      (!____ptr).buffer = buffer
      (!____ptr).raw_buffer = raw_buffer
      (!____ptr).encoding = encoding
      (!____ptr).canonical = canonical
      (!____ptr).best_indent = best_indent
      (!____ptr).best_width = best_width
      (!____ptr).unicode = unicode
      (!____ptr).line_break = line_break
      (!____ptr).states = states
      (!____ptr).state = state
      (!____ptr).events = events
      (!____ptr).indents = indents
      (!____ptr).tag_directives = tag_directives
      (!____ptr).indent = indent
      (!____ptr).flow_level = flow_level
      (!____ptr).root_context = root_context
      (!____ptr).sequence_context = sequence_context
      (!____ptr).mapping_context = mapping_context
      (!____ptr).simple_key_context = simple_key_context
      (!____ptr).line = line
      (!____ptr).column = column
      (!____ptr).whitespace = whitespace
      (!____ptr).indention = indention
      (!____ptr).open_ended = open_ended
      (!____ptr).anchor_data = anchor_data
      (!____ptr).tag_data = tag_data
      (!____ptr).scalar_data = scalar_data
      (!____ptr).opened = opened
      (!____ptr).closed = closed
      (!____ptr).anchors = anchors
      (!____ptr).last_anchor_id = last_anchor_id
      (!____ptr).document = document
      ____ptr
    extension (struct: yaml_emitter_s)
      def error: yaml_error_type_t =
        !struct.at(0).asInstanceOf[Ptr[yaml_error_type_t]]
      def error_=(value: yaml_error_type_t): Unit =
        !struct.at(0).asInstanceOf[Ptr[yaml_error_type_t]] = value
      def problem: CString = !struct.at(8).asInstanceOf[Ptr[CString]]
      def problem_=(value: CString): Unit =
        !struct.at(8).asInstanceOf[Ptr[CString]] = value
      def write_handler: Ptr[yaml_write_handler_t] =
        !struct.at(16).asInstanceOf[Ptr[Ptr[yaml_write_handler_t]]]
      def write_handler_=(value: Ptr[yaml_write_handler_t]): Unit =
        !struct.at(16).asInstanceOf[Ptr[Ptr[yaml_write_handler_t]]] = value
      def write_handler_data: Ptr[Byte] =
        !struct.at(24).asInstanceOf[Ptr[Ptr[Byte]]]
      def write_handler_data_=(value: Ptr[Byte]): Unit =
        !struct.at(24).asInstanceOf[Ptr[Ptr[Byte]]] = value
      def output: yaml_emitter_s.Union0 =
        !struct.at(32).asInstanceOf[Ptr[yaml_emitter_s.Union0]]
      def output_=(value: yaml_emitter_s.Union0): Unit =
        !struct.at(32).asInstanceOf[Ptr[yaml_emitter_s.Union0]] = value
      def buffer: yaml_emitter_s.Struct1 =
        !struct.at(56).asInstanceOf[Ptr[yaml_emitter_s.Struct1]]
      def buffer_=(value: yaml_emitter_s.Struct1): Unit =
        !struct.at(56).asInstanceOf[Ptr[yaml_emitter_s.Struct1]] = value
      def raw_buffer: yaml_emitter_s.Struct2 =
        !struct.at(88).asInstanceOf[Ptr[yaml_emitter_s.Struct2]]
      def raw_buffer_=(value: yaml_emitter_s.Struct2): Unit =
        !struct.at(88).asInstanceOf[Ptr[yaml_emitter_s.Struct2]] = value
      def encoding: yaml_encoding_t =
        !struct.at(120).asInstanceOf[Ptr[yaml_encoding_t]]
      def encoding_=(value: yaml_encoding_t): Unit =
        !struct.at(120).asInstanceOf[Ptr[yaml_encoding_t]] = value
      def canonical: CInt = !struct.at(124).asInstanceOf[Ptr[CInt]]
      def canonical_=(value: CInt): Unit =
        !struct.at(124).asInstanceOf[Ptr[CInt]] = value
      def best_indent: CInt = !struct.at(128).asInstanceOf[Ptr[CInt]]
      def best_indent_=(value: CInt): Unit =
        !struct.at(128).asInstanceOf[Ptr[CInt]] = value
      def best_width: CInt = !struct.at(132).asInstanceOf[Ptr[CInt]]
      def best_width_=(value: CInt): Unit =
        !struct.at(132).asInstanceOf[Ptr[CInt]] = value
      def unicode: CInt = !struct.at(136).asInstanceOf[Ptr[CInt]]
      def unicode_=(value: CInt): Unit =
        !struct.at(136).asInstanceOf[Ptr[CInt]] = value
      def line_break: yaml_break_t =
        !struct.at(140).asInstanceOf[Ptr[yaml_break_t]]
      def line_break_=(value: yaml_break_t): Unit =
        !struct.at(140).asInstanceOf[Ptr[yaml_break_t]] = value
      def states: yaml_emitter_s.Struct3 =
        !struct.at(144).asInstanceOf[Ptr[yaml_emitter_s.Struct3]]
      def states_=(value: yaml_emitter_s.Struct3): Unit =
        !struct.at(144).asInstanceOf[Ptr[yaml_emitter_s.Struct3]] = value
      def state: yaml_emitter_state_t =
        !struct.at(168).asInstanceOf[Ptr[yaml_emitter_state_t]]
      def state_=(value: yaml_emitter_state_t): Unit =
        !struct.at(168).asInstanceOf[Ptr[yaml_emitter_state_t]] = value
      def events: yaml_emitter_s.Struct4 =
        !struct.at(176).asInstanceOf[Ptr[yaml_emitter_s.Struct4]]
      def events_=(value: yaml_emitter_s.Struct4): Unit =
        !struct.at(176).asInstanceOf[Ptr[yaml_emitter_s.Struct4]] = value
      def indents: yaml_emitter_s.Struct5 =
        !struct.at(208).asInstanceOf[Ptr[yaml_emitter_s.Struct5]]
      def indents_=(value: yaml_emitter_s.Struct5): Unit =
        !struct.at(208).asInstanceOf[Ptr[yaml_emitter_s.Struct5]] = value
      def tag_directives: yaml_emitter_s.Struct6 =
        !struct.at(232).asInstanceOf[Ptr[yaml_emitter_s.Struct6]]
      def tag_directives_=(value: yaml_emitter_s.Struct6): Unit =
        !struct.at(232).asInstanceOf[Ptr[yaml_emitter_s.Struct6]] = value
      def indent: CInt = !struct.at(256).asInstanceOf[Ptr[CInt]]
      def indent_=(value: CInt): Unit =
        !struct.at(256).asInstanceOf[Ptr[CInt]] = value
      def flow_level: CInt = !struct.at(260).asInstanceOf[Ptr[CInt]]
      def flow_level_=(value: CInt): Unit =
        !struct.at(260).asInstanceOf[Ptr[CInt]] = value
      def root_context: CInt = !struct.at(264).asInstanceOf[Ptr[CInt]]
      def root_context_=(value: CInt): Unit =
        !struct.at(264).asInstanceOf[Ptr[CInt]] = value
      def sequence_context: CInt = !struct.at(268).asInstanceOf[Ptr[CInt]]
      def sequence_context_=(value: CInt): Unit =
        !struct.at(268).asInstanceOf[Ptr[CInt]] = value
      def mapping_context: CInt = !struct.at(272).asInstanceOf[Ptr[CInt]]
      def mapping_context_=(value: CInt): Unit =
        !struct.at(272).asInstanceOf[Ptr[CInt]] = value
      def simple_key_context: CInt = !struct.at(276).asInstanceOf[Ptr[CInt]]
      def simple_key_context_=(value: CInt): Unit =
        !struct.at(276).asInstanceOf[Ptr[CInt]] = value
      def line: CInt = !struct.at(280).asInstanceOf[Ptr[CInt]]
      def line_=(value: CInt): Unit = !struct.at(280).asInstanceOf[Ptr[CInt]] =
        value
      def column: CInt = !struct.at(284).asInstanceOf[Ptr[CInt]]
      def column_=(value: CInt): Unit =
        !struct.at(284).asInstanceOf[Ptr[CInt]] = value
      def whitespace: CInt = !struct.at(288).asInstanceOf[Ptr[CInt]]
      def whitespace_=(value: CInt): Unit =
        !struct.at(288).asInstanceOf[Ptr[CInt]] = value
      def indention: CInt = !struct.at(292).asInstanceOf[Ptr[CInt]]
      def indention_=(value: CInt): Unit =
        !struct.at(292).asInstanceOf[Ptr[CInt]] = value
      def open_ended: CInt = !struct.at(296).asInstanceOf[Ptr[CInt]]
      def open_ended_=(value: CInt): Unit =
        !struct.at(296).asInstanceOf[Ptr[CInt]] = value
      def anchor_data: yaml_emitter_s.Struct7 =
        !struct.at(304).asInstanceOf[Ptr[yaml_emitter_s.Struct7]]
      def anchor_data_=(value: yaml_emitter_s.Struct7): Unit =
        !struct.at(304).asInstanceOf[Ptr[yaml_emitter_s.Struct7]] = value
      def tag_data: yaml_emitter_s.Struct8 =
        !struct.at(328).asInstanceOf[Ptr[yaml_emitter_s.Struct8]]
      def tag_data_=(value: yaml_emitter_s.Struct8): Unit =
        !struct.at(328).asInstanceOf[Ptr[yaml_emitter_s.Struct8]] = value
      def scalar_data: yaml_emitter_s.Struct9 =
        !struct.at(360).asInstanceOf[Ptr[yaml_emitter_s.Struct9]]
      def scalar_data_=(value: yaml_emitter_s.Struct9): Unit =
        !struct.at(360).asInstanceOf[Ptr[yaml_emitter_s.Struct9]] = value
      def opened: CInt = !struct.at(400).asInstanceOf[Ptr[CInt]]
      def opened_=(value: CInt): Unit =
        !struct.at(400).asInstanceOf[Ptr[CInt]] = value
      def closed: CInt = !struct.at(404).asInstanceOf[Ptr[CInt]]
      def closed_=(value: CInt): Unit =
        !struct.at(404).asInstanceOf[Ptr[CInt]] = value
      def anchors: Ptr[yaml_anchors_t] =
        !struct.at(408).asInstanceOf[Ptr[Ptr[yaml_anchors_t]]]
      def anchors_=(value: Ptr[yaml_anchors_t]): Unit =
        !struct.at(408).asInstanceOf[Ptr[Ptr[yaml_anchors_t]]] = value
      def last_anchor_id: CInt = !struct.at(416).asInstanceOf[Ptr[CInt]]
      def last_anchor_id_=(value: CInt): Unit =
        !struct.at(416).asInstanceOf[Ptr[CInt]] = value
      def document: Ptr[yaml_document_t] =
        !struct.at(424).asInstanceOf[Ptr[Ptr[yaml_document_t]]]
      def document_=(value: Ptr[yaml_document_t]): Unit =
        !struct.at(424).asInstanceOf[Ptr[Ptr[yaml_document_t]]] = value

  /** The emitter structure.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_emitter_t = CArray[CChar, Nat.Digit3[Nat._4, Nat._3, Nat._2]]
  object yaml_emitter_t:
    /** Standard (string or file) output data.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Union0 = CArray[Byte, Nat.Digit2[Nat._2, Nat._4]]
    object Union0:
      /** String output data.
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct0 = CStruct3[Ptr[CUnsignedChar], size_t, Ptr[size_t]]
      object Struct0:
        given _tag: Tag[Struct0] =
          Tag.materializeCStruct3Tag[Ptr[CUnsignedChar], size_t, Ptr[size_t]]
        def apply()(using Zone): Ptr[Struct0] =
          scala.scalanative.unsafe.alloc[Struct0](1)
        def apply(
            buffer: Ptr[CUnsignedChar],
            size: size_t,
            size_written: Ptr[size_t]
        )(using Zone): Ptr[Struct0] =
          val ____ptr = apply()
          (!____ptr).buffer = buffer
          (!____ptr).size = size
          (!____ptr).size_written = size_written
          ____ptr
        extension (struct: Struct0)
          def buffer: Ptr[CUnsignedChar] = struct._1
          def buffer_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
          def size: size_t = struct._2
          def size_=(value: size_t): Unit = !struct.at2 = value
          def size_written: Ptr[size_t] = struct._3
          def size_written_=(value: Ptr[size_t]): Unit = !struct.at3 = value
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat.Digit2[Nat._2, Nat._4]](
        Tag.Byte,
        Tag.Digit2[Nat._2, Nat._4](Tag.Nat2, Tag.Nat4)
      )
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_string")
      def apply(string: yaml_emitter_t.Union0.Struct0)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_emitter_t.Union0.Struct0]]
          .update(0, string)
        ___ptr
      @scala.annotation.targetName("apply_file")
      def apply(file: Ptr[FILE])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FILE]]].update(0, file)
        ___ptr
      extension (struct: Union0)
        def string: yaml_emitter_t.Union0.Struct0 =
          !struct.at(0).asInstanceOf[Ptr[yaml_emitter_t.Union0.Struct0]]
        def string_=(value: yaml_emitter_t.Union0.Struct0): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_emitter_t.Union0.Struct0]] = value
        def file: Ptr[FILE] = !struct.at(0).asInstanceOf[Ptr[Ptr[FILE]]]
        def file_=(value: Ptr[FILE]): Unit =
          !struct.at(0).asInstanceOf[Ptr[Ptr[FILE]]] = value

    /** The working buffer.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct1 = CStruct4[Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[
      yaml_char_t
    ], Ptr[yaml_char_t]]
    object Struct1:
      given _tag: Tag[Struct1] = Tag.materializeCStruct4Tag[Ptr[
        yaml_char_t
      ], Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[yaml_char_t]]
      def apply()(using Zone): Ptr[Struct1] =
        scala.scalanative.unsafe.alloc[Struct1](1)
      def apply(
          start: Ptr[yaml_char_t],
          end: Ptr[yaml_char_t],
          pointer: Ptr[yaml_char_t],
          last: Ptr[yaml_char_t]
      )(using Zone): Ptr[Struct1] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).pointer = pointer
        (!____ptr).last = last
        ____ptr
      extension (struct: Struct1)
        def start: Ptr[yaml_char_t] = struct._1
        def start_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_char_t] = struct._2
        def end_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
        def pointer: Ptr[yaml_char_t] = struct._3
        def pointer_=(value: Ptr[yaml_char_t]): Unit = !struct.at3 = value
        def last: Ptr[yaml_char_t] = struct._4
        def last_=(value: Ptr[yaml_char_t]): Unit = !struct.at4 = value

    /** The raw buffer.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct2 = CStruct4[Ptr[CUnsignedChar], Ptr[CUnsignedChar], Ptr[
      CUnsignedChar
    ], Ptr[CUnsignedChar]]
    object Struct2:
      given _tag: Tag[Struct2] = Tag.materializeCStruct4Tag[Ptr[
        CUnsignedChar
      ], Ptr[CUnsignedChar], Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
      def apply()(using Zone): Ptr[Struct2] =
        scala.scalanative.unsafe.alloc[Struct2](1)
      def apply(
          start: Ptr[CUnsignedChar],
          end: Ptr[CUnsignedChar],
          pointer: Ptr[CUnsignedChar],
          last: Ptr[CUnsignedChar]
      )(using Zone): Ptr[Struct2] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).pointer = pointer
        (!____ptr).last = last
        ____ptr
      extension (struct: Struct2)
        def start: Ptr[CUnsignedChar] = struct._1
        def start_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
        def end: Ptr[CUnsignedChar] = struct._2
        def end_=(value: Ptr[CUnsignedChar]): Unit = !struct.at2 = value
        def pointer: Ptr[CUnsignedChar] = struct._3
        def pointer_=(value: Ptr[CUnsignedChar]): Unit = !struct.at3 = value
        def last: Ptr[CUnsignedChar] = struct._4
        def last_=(value: Ptr[CUnsignedChar]): Unit = !struct.at4 = value

    /** The stack of states.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct3 = CStruct3[Ptr[yaml_emitter_state_t], Ptr[
      yaml_emitter_state_t
    ], Ptr[yaml_emitter_state_t]]
    object Struct3:
      given _tag: Tag[Struct3] = Tag.materializeCStruct3Tag[Ptr[
        yaml_emitter_state_t
      ], Ptr[yaml_emitter_state_t], Ptr[yaml_emitter_state_t]]
      def apply()(using Zone): Ptr[Struct3] =
        scala.scalanative.unsafe.alloc[Struct3](1)
      def apply(
          start: Ptr[yaml_emitter_state_t],
          end: Ptr[yaml_emitter_state_t],
          top: Ptr[yaml_emitter_state_t]
      )(using Zone): Ptr[Struct3] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct3)
        def start: Ptr[yaml_emitter_state_t] = struct._1
        def start_=(value: Ptr[yaml_emitter_state_t]): Unit = !struct.at1 =
          value
        def end: Ptr[yaml_emitter_state_t] = struct._2
        def end_=(value: Ptr[yaml_emitter_state_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_emitter_state_t] = struct._3
        def top_=(value: Ptr[yaml_emitter_state_t]): Unit = !struct.at3 = value

    /** The event queue.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct4 = CStruct4[Ptr[yaml_event_t], Ptr[yaml_event_t], Ptr[
      yaml_event_t
    ], Ptr[yaml_event_t]]
    object Struct4:
      given _tag: Tag[Struct4] = Tag.materializeCStruct4Tag[Ptr[
        yaml_event_t
      ], Ptr[yaml_event_t], Ptr[yaml_event_t], Ptr[yaml_event_t]]
      def apply()(using Zone): Ptr[Struct4] =
        scala.scalanative.unsafe.alloc[Struct4](1)
      def apply(
          start: Ptr[yaml_event_t],
          end: Ptr[yaml_event_t],
          head: Ptr[yaml_event_t],
          tail: Ptr[yaml_event_t]
      )(using Zone): Ptr[Struct4] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).head = head
        (!____ptr).tail = tail
        ____ptr
      extension (struct: Struct4)
        def start: Ptr[yaml_event_t] = struct._1
        def start_=(value: Ptr[yaml_event_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_event_t] = struct._2
        def end_=(value: Ptr[yaml_event_t]): Unit = !struct.at2 = value
        def head: Ptr[yaml_event_t] = struct._3
        def head_=(value: Ptr[yaml_event_t]): Unit = !struct.at3 = value
        def tail: Ptr[yaml_event_t] = struct._4
        def tail_=(value: Ptr[yaml_event_t]): Unit = !struct.at4 = value

    /** The stack of indentation levels.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct5 = CStruct3[Ptr[CInt], Ptr[CInt], Ptr[CInt]]
    object Struct5:
      given _tag: Tag[Struct5] =
        Tag.materializeCStruct3Tag[Ptr[CInt], Ptr[CInt], Ptr[CInt]]
      def apply()(using Zone): Ptr[Struct5] =
        scala.scalanative.unsafe.alloc[Struct5](1)
      def apply(start: Ptr[CInt], end: Ptr[CInt], top: Ptr[CInt])(using
          Zone
      ): Ptr[Struct5] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct5)
        def start: Ptr[CInt] = struct._1
        def start_=(value: Ptr[CInt]): Unit = !struct.at1 = value
        def end: Ptr[CInt] = struct._2
        def end_=(value: Ptr[CInt]): Unit = !struct.at2 = value
        def top: Ptr[CInt] = struct._3
        def top_=(value: Ptr[CInt]): Unit = !struct.at3 = value

    /** The list of tag directives.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct6 = CStruct3[Ptr[yaml_tag_directive_t], Ptr[
      yaml_tag_directive_t
    ], Ptr[yaml_tag_directive_t]]
    object Struct6:
      given _tag: Tag[Struct6] = Tag.materializeCStruct3Tag[Ptr[
        yaml_tag_directive_t
      ], Ptr[yaml_tag_directive_t], Ptr[yaml_tag_directive_t]]
      def apply()(using Zone): Ptr[Struct6] =
        scala.scalanative.unsafe.alloc[Struct6](1)
      def apply(
          start: Ptr[yaml_tag_directive_t],
          end: Ptr[yaml_tag_directive_t],
          top: Ptr[yaml_tag_directive_t]
      )(using Zone): Ptr[Struct6] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct6)
        def start: Ptr[yaml_tag_directive_t] = struct._1
        def start_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at1 =
          value
        def end: Ptr[yaml_tag_directive_t] = struct._2
        def end_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_tag_directive_t] = struct._3
        def top_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at3 = value

    /** Anchor analysis.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct7 = CStruct3[Ptr[yaml_char_t], size_t, CInt]
    object Struct7:
      given _tag: Tag[Struct7] =
        Tag.materializeCStruct3Tag[Ptr[yaml_char_t], size_t, CInt]
      def apply()(using Zone): Ptr[Struct7] =
        scala.scalanative.unsafe.alloc[Struct7](1)
      def apply(anchor: Ptr[yaml_char_t], anchor_length: size_t, alias: CInt)(
          using Zone
      ): Ptr[Struct7] =
        val ____ptr = apply()
        (!____ptr).anchor = anchor
        (!____ptr).anchor_length = anchor_length
        (!____ptr).alias = alias
        ____ptr
      extension (struct: Struct7)
        def anchor: Ptr[yaml_char_t] = struct._1
        def anchor_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
        def anchor_length: size_t = struct._2
        def anchor_length_=(value: size_t): Unit = !struct.at2 = value
        def alias: CInt = struct._3
        def alias_=(value: CInt): Unit = !struct.at3 = value

    /** Tag analysis.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct8 =
      CStruct4[Ptr[yaml_char_t], size_t, Ptr[yaml_char_t], size_t]
    object Struct8:
      given _tag: Tag[Struct8] = Tag.materializeCStruct4Tag[Ptr[
        yaml_char_t
      ], size_t, Ptr[yaml_char_t], size_t]
      def apply()(using Zone): Ptr[Struct8] =
        scala.scalanative.unsafe.alloc[Struct8](1)
      def apply(
          handle: Ptr[yaml_char_t],
          handle_length: size_t,
          suffix: Ptr[yaml_char_t],
          suffix_length: size_t
      )(using Zone): Ptr[Struct8] =
        val ____ptr = apply()
        (!____ptr).handle = handle
        (!____ptr).handle_length = handle_length
        (!____ptr).suffix = suffix
        (!____ptr).suffix_length = suffix_length
        ____ptr
      extension (struct: Struct8)
        def handle: Ptr[yaml_char_t] = struct._1
        def handle_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
        def handle_length: size_t = struct._2
        def handle_length_=(value: size_t): Unit = !struct.at2 = value
        def suffix: Ptr[yaml_char_t] = struct._3
        def suffix_=(value: Ptr[yaml_char_t]): Unit = !struct.at3 = value
        def suffix_length: size_t = struct._4
        def suffix_length_=(value: size_t): Unit = !struct.at4 = value

    /** Scalar analysis.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct9 = CStruct8[Ptr[
      yaml_char_t
    ], size_t, CInt, CInt, CInt, CInt, CInt, yaml_scalar_style_t]
    object Struct9:
      given _tag: Tag[Struct9] = Tag.materializeCStruct8Tag[Ptr[
        yaml_char_t
      ], size_t, CInt, CInt, CInt, CInt, CInt, yaml_scalar_style_t]
      def apply()(using Zone): Ptr[Struct9] =
        scala.scalanative.unsafe.alloc[Struct9](1)
      def apply(
          value: Ptr[yaml_char_t],
          length: size_t,
          multiline: CInt,
          flow_plain_allowed: CInt,
          block_plain_allowed: CInt,
          single_quoted_allowed: CInt,
          block_allowed: CInt,
          style: yaml_scalar_style_t
      )(using Zone): Ptr[Struct9] =
        val ____ptr = apply()
        (!____ptr).value = value
        (!____ptr).length = length
        (!____ptr).multiline = multiline
        (!____ptr).flow_plain_allowed = flow_plain_allowed
        (!____ptr).block_plain_allowed = block_plain_allowed
        (!____ptr).single_quoted_allowed = single_quoted_allowed
        (!____ptr).block_allowed = block_allowed
        (!____ptr).style = style
        ____ptr
      extension (struct: Struct9)
        def value: Ptr[yaml_char_t] = struct._1
        def value_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
        def length: size_t = struct._2
        def length_=(value: size_t): Unit = !struct.at2 = value
        def multiline: CInt = struct._3
        def multiline_=(value: CInt): Unit = !struct.at3 = value
        def flow_plain_allowed: CInt = struct._4
        def flow_plain_allowed_=(value: CInt): Unit = !struct.at4 = value
        def block_plain_allowed: CInt = struct._5
        def block_plain_allowed_=(value: CInt): Unit = !struct.at5 = value
        def single_quoted_allowed: CInt = struct._6
        def single_quoted_allowed_=(value: CInt): Unit = !struct.at6 = value
        def block_allowed: CInt = struct._7
        def block_allowed_=(value: CInt): Unit = !struct.at7 = value
        def style: yaml_scalar_style_t = struct._8
        def style_=(value: yaml_scalar_style_t): Unit = !struct.at8 = value
    given _tag: Tag[yaml_emitter_t] =
      Tag.CArray[CChar, Nat.Digit3[Nat._4, Nat._3, Nat._2]](
        Tag.Byte,
        Tag.Digit3[Nat._4, Nat._3, Nat._2](Tag.Nat4, Tag.Nat3, Tag.Nat2)
      )
    def apply()(using Zone): Ptr[yaml_emitter_t] =
      scala.scalanative.unsafe.alloc[yaml_emitter_t](1)
    def apply(
        error: yaml_error_type_t,
        problem: CString,
        write_handler: Ptr[yaml_write_handler_t],
        write_handler_data: Ptr[Byte],
        output: yaml_emitter_t.Union0,
        buffer: yaml_emitter_t.Struct1,
        raw_buffer: yaml_emitter_t.Struct2,
        encoding: yaml_encoding_t,
        canonical: CInt,
        best_indent: CInt,
        best_width: CInt,
        unicode: CInt,
        line_break: yaml_break_t,
        states: yaml_emitter_t.Struct3,
        state: yaml_emitter_state_t,
        events: yaml_emitter_t.Struct4,
        indents: yaml_emitter_t.Struct5,
        tag_directives: yaml_emitter_t.Struct6,
        indent: CInt,
        flow_level: CInt,
        root_context: CInt,
        sequence_context: CInt,
        mapping_context: CInt,
        simple_key_context: CInt,
        line: CInt,
        column: CInt,
        whitespace: CInt,
        indention: CInt,
        open_ended: CInt,
        anchor_data: yaml_emitter_t.Struct7,
        tag_data: yaml_emitter_t.Struct8,
        scalar_data: yaml_emitter_t.Struct9,
        opened: CInt,
        closed: CInt,
        anchors: Ptr[yaml_anchors_t],
        last_anchor_id: CInt,
        document: Ptr[yaml_document_t]
    )(using Zone): Ptr[yaml_emitter_t] =
      val ____ptr = apply()
      (!____ptr).error = error
      (!____ptr).problem = problem
      (!____ptr).write_handler = write_handler
      (!____ptr).write_handler_data = write_handler_data
      (!____ptr).output = output
      (!____ptr).buffer = buffer
      (!____ptr).raw_buffer = raw_buffer
      (!____ptr).encoding = encoding
      (!____ptr).canonical = canonical
      (!____ptr).best_indent = best_indent
      (!____ptr).best_width = best_width
      (!____ptr).unicode = unicode
      (!____ptr).line_break = line_break
      (!____ptr).states = states
      (!____ptr).state = state
      (!____ptr).events = events
      (!____ptr).indents = indents
      (!____ptr).tag_directives = tag_directives
      (!____ptr).indent = indent
      (!____ptr).flow_level = flow_level
      (!____ptr).root_context = root_context
      (!____ptr).sequence_context = sequence_context
      (!____ptr).mapping_context = mapping_context
      (!____ptr).simple_key_context = simple_key_context
      (!____ptr).line = line
      (!____ptr).column = column
      (!____ptr).whitespace = whitespace
      (!____ptr).indention = indention
      (!____ptr).open_ended = open_ended
      (!____ptr).anchor_data = anchor_data
      (!____ptr).tag_data = tag_data
      (!____ptr).scalar_data = scalar_data
      (!____ptr).opened = opened
      (!____ptr).closed = closed
      (!____ptr).anchors = anchors
      (!____ptr).last_anchor_id = last_anchor_id
      (!____ptr).document = document
      ____ptr
    extension (struct: yaml_emitter_t)
      def error: yaml_error_type_t =
        !struct.at(0).asInstanceOf[Ptr[yaml_error_type_t]]
      def error_=(value: yaml_error_type_t): Unit =
        !struct.at(0).asInstanceOf[Ptr[yaml_error_type_t]] = value
      def problem: CString = !struct.at(8).asInstanceOf[Ptr[CString]]
      def problem_=(value: CString): Unit =
        !struct.at(8).asInstanceOf[Ptr[CString]] = value
      def write_handler: Ptr[yaml_write_handler_t] =
        !struct.at(16).asInstanceOf[Ptr[Ptr[yaml_write_handler_t]]]
      def write_handler_=(value: Ptr[yaml_write_handler_t]): Unit =
        !struct.at(16).asInstanceOf[Ptr[Ptr[yaml_write_handler_t]]] = value
      def write_handler_data: Ptr[Byte] =
        !struct.at(24).asInstanceOf[Ptr[Ptr[Byte]]]
      def write_handler_data_=(value: Ptr[Byte]): Unit =
        !struct.at(24).asInstanceOf[Ptr[Ptr[Byte]]] = value
      def output: yaml_emitter_t.Union0 =
        !struct.at(32).asInstanceOf[Ptr[yaml_emitter_t.Union0]]
      def output_=(value: yaml_emitter_t.Union0): Unit =
        !struct.at(32).asInstanceOf[Ptr[yaml_emitter_t.Union0]] = value
      def buffer: yaml_emitter_t.Struct1 =
        !struct.at(56).asInstanceOf[Ptr[yaml_emitter_t.Struct1]]
      def buffer_=(value: yaml_emitter_t.Struct1): Unit =
        !struct.at(56).asInstanceOf[Ptr[yaml_emitter_t.Struct1]] = value
      def raw_buffer: yaml_emitter_t.Struct2 =
        !struct.at(88).asInstanceOf[Ptr[yaml_emitter_t.Struct2]]
      def raw_buffer_=(value: yaml_emitter_t.Struct2): Unit =
        !struct.at(88).asInstanceOf[Ptr[yaml_emitter_t.Struct2]] = value
      def encoding: yaml_encoding_t =
        !struct.at(120).asInstanceOf[Ptr[yaml_encoding_t]]
      def encoding_=(value: yaml_encoding_t): Unit =
        !struct.at(120).asInstanceOf[Ptr[yaml_encoding_t]] = value
      def canonical: CInt = !struct.at(124).asInstanceOf[Ptr[CInt]]
      def canonical_=(value: CInt): Unit =
        !struct.at(124).asInstanceOf[Ptr[CInt]] = value
      def best_indent: CInt = !struct.at(128).asInstanceOf[Ptr[CInt]]
      def best_indent_=(value: CInt): Unit =
        !struct.at(128).asInstanceOf[Ptr[CInt]] = value
      def best_width: CInt = !struct.at(132).asInstanceOf[Ptr[CInt]]
      def best_width_=(value: CInt): Unit =
        !struct.at(132).asInstanceOf[Ptr[CInt]] = value
      def unicode: CInt = !struct.at(136).asInstanceOf[Ptr[CInt]]
      def unicode_=(value: CInt): Unit =
        !struct.at(136).asInstanceOf[Ptr[CInt]] = value
      def line_break: yaml_break_t =
        !struct.at(140).asInstanceOf[Ptr[yaml_break_t]]
      def line_break_=(value: yaml_break_t): Unit =
        !struct.at(140).asInstanceOf[Ptr[yaml_break_t]] = value
      def states: yaml_emitter_t.Struct3 =
        !struct.at(144).asInstanceOf[Ptr[yaml_emitter_t.Struct3]]
      def states_=(value: yaml_emitter_t.Struct3): Unit =
        !struct.at(144).asInstanceOf[Ptr[yaml_emitter_t.Struct3]] = value
      def state: yaml_emitter_state_t =
        !struct.at(168).asInstanceOf[Ptr[yaml_emitter_state_t]]
      def state_=(value: yaml_emitter_state_t): Unit =
        !struct.at(168).asInstanceOf[Ptr[yaml_emitter_state_t]] = value
      def events: yaml_emitter_t.Struct4 =
        !struct.at(176).asInstanceOf[Ptr[yaml_emitter_t.Struct4]]
      def events_=(value: yaml_emitter_t.Struct4): Unit =
        !struct.at(176).asInstanceOf[Ptr[yaml_emitter_t.Struct4]] = value
      def indents: yaml_emitter_t.Struct5 =
        !struct.at(208).asInstanceOf[Ptr[yaml_emitter_t.Struct5]]
      def indents_=(value: yaml_emitter_t.Struct5): Unit =
        !struct.at(208).asInstanceOf[Ptr[yaml_emitter_t.Struct5]] = value
      def tag_directives: yaml_emitter_t.Struct6 =
        !struct.at(232).asInstanceOf[Ptr[yaml_emitter_t.Struct6]]
      def tag_directives_=(value: yaml_emitter_t.Struct6): Unit =
        !struct.at(232).asInstanceOf[Ptr[yaml_emitter_t.Struct6]] = value
      def indent: CInt = !struct.at(256).asInstanceOf[Ptr[CInt]]
      def indent_=(value: CInt): Unit =
        !struct.at(256).asInstanceOf[Ptr[CInt]] = value
      def flow_level: CInt = !struct.at(260).asInstanceOf[Ptr[CInt]]
      def flow_level_=(value: CInt): Unit =
        !struct.at(260).asInstanceOf[Ptr[CInt]] = value
      def root_context: CInt = !struct.at(264).asInstanceOf[Ptr[CInt]]
      def root_context_=(value: CInt): Unit =
        !struct.at(264).asInstanceOf[Ptr[CInt]] = value
      def sequence_context: CInt = !struct.at(268).asInstanceOf[Ptr[CInt]]
      def sequence_context_=(value: CInt): Unit =
        !struct.at(268).asInstanceOf[Ptr[CInt]] = value
      def mapping_context: CInt = !struct.at(272).asInstanceOf[Ptr[CInt]]
      def mapping_context_=(value: CInt): Unit =
        !struct.at(272).asInstanceOf[Ptr[CInt]] = value
      def simple_key_context: CInt = !struct.at(276).asInstanceOf[Ptr[CInt]]
      def simple_key_context_=(value: CInt): Unit =
        !struct.at(276).asInstanceOf[Ptr[CInt]] = value
      def line: CInt = !struct.at(280).asInstanceOf[Ptr[CInt]]
      def line_=(value: CInt): Unit = !struct.at(280).asInstanceOf[Ptr[CInt]] =
        value
      def column: CInt = !struct.at(284).asInstanceOf[Ptr[CInt]]
      def column_=(value: CInt): Unit =
        !struct.at(284).asInstanceOf[Ptr[CInt]] = value
      def whitespace: CInt = !struct.at(288).asInstanceOf[Ptr[CInt]]
      def whitespace_=(value: CInt): Unit =
        !struct.at(288).asInstanceOf[Ptr[CInt]] = value
      def indention: CInt = !struct.at(292).asInstanceOf[Ptr[CInt]]
      def indention_=(value: CInt): Unit =
        !struct.at(292).asInstanceOf[Ptr[CInt]] = value
      def open_ended: CInt = !struct.at(296).asInstanceOf[Ptr[CInt]]
      def open_ended_=(value: CInt): Unit =
        !struct.at(296).asInstanceOf[Ptr[CInt]] = value
      def anchor_data: yaml_emitter_t.Struct7 =
        !struct.at(304).asInstanceOf[Ptr[yaml_emitter_t.Struct7]]
      def anchor_data_=(value: yaml_emitter_t.Struct7): Unit =
        !struct.at(304).asInstanceOf[Ptr[yaml_emitter_t.Struct7]] = value
      def tag_data: yaml_emitter_t.Struct8 =
        !struct.at(328).asInstanceOf[Ptr[yaml_emitter_t.Struct8]]
      def tag_data_=(value: yaml_emitter_t.Struct8): Unit =
        !struct.at(328).asInstanceOf[Ptr[yaml_emitter_t.Struct8]] = value
      def scalar_data: yaml_emitter_t.Struct9 =
        !struct.at(360).asInstanceOf[Ptr[yaml_emitter_t.Struct9]]
      def scalar_data_=(value: yaml_emitter_t.Struct9): Unit =
        !struct.at(360).asInstanceOf[Ptr[yaml_emitter_t.Struct9]] = value
      def opened: CInt = !struct.at(400).asInstanceOf[Ptr[CInt]]
      def opened_=(value: CInt): Unit =
        !struct.at(400).asInstanceOf[Ptr[CInt]] = value
      def closed: CInt = !struct.at(404).asInstanceOf[Ptr[CInt]]
      def closed_=(value: CInt): Unit =
        !struct.at(404).asInstanceOf[Ptr[CInt]] = value
      def anchors: Ptr[yaml_anchors_t] =
        !struct.at(408).asInstanceOf[Ptr[Ptr[yaml_anchors_t]]]
      def anchors_=(value: Ptr[yaml_anchors_t]): Unit =
        !struct.at(408).asInstanceOf[Ptr[Ptr[yaml_anchors_t]]] = value
      def last_anchor_id: CInt = !struct.at(416).asInstanceOf[Ptr[CInt]]
      def last_anchor_id_=(value: CInt): Unit =
        !struct.at(416).asInstanceOf[Ptr[CInt]] = value
      def document: Ptr[yaml_document_t] =
        !struct.at(424).asInstanceOf[Ptr[Ptr[yaml_document_t]]]
      def document_=(value: Ptr[yaml_document_t]): Unit =
        !struct.at(424).asInstanceOf[Ptr[Ptr[yaml_document_t]]] = value

  /** The event structure.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_event_s =
    CStruct4[yaml_event_type_t, yaml_event_s.Union0, yaml_mark_t, yaml_mark_t]
  object yaml_event_s:
    /** The event data.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Union0 = CArray[Byte, Nat.Digit2[Nat._4, Nat._8]]
    object Union0:
      /** The stream parameters (for YAML_STREAM_START_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct0 = CStruct1[yaml_encoding_t]
      object Struct0:
        given _tag: Tag[Struct0] = Tag.materializeCStruct1Tag[yaml_encoding_t]
        def apply()(using Zone): Ptr[Struct0] =
          scala.scalanative.unsafe.alloc[Struct0](1)
        def apply(encoding: yaml_encoding_t)(using Zone): Ptr[Struct0] =
          val ____ptr = apply()
          (!____ptr).encoding = encoding
          ____ptr
        extension (struct: Struct0)
          def encoding: yaml_encoding_t = struct._1
          def encoding_=(value: yaml_encoding_t): Unit = !struct.at1 = value

      /** The document parameters (for YAML_DOCUMENT_START_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct1 = CStruct3[Ptr[
        yaml_version_directive_t
      ], yaml_event_s.Union0.Struct1.Struct0, CInt]
      object Struct1:
        /** The list of tag directives.
          *
          * [bindgen] header: /usr/include/yaml.h
          */
        opaque type Struct0 =
          CStruct2[Ptr[yaml_tag_directive_t], Ptr[yaml_tag_directive_t]]
        object Struct0:
          given _tag: Tag[Struct0] = Tag.materializeCStruct2Tag[Ptr[
            yaml_tag_directive_t
          ], Ptr[yaml_tag_directive_t]]
          def apply()(using Zone): Ptr[Struct0] =
            scala.scalanative.unsafe.alloc[Struct0](1)
          def apply(
              start: Ptr[yaml_tag_directive_t],
              end: Ptr[yaml_tag_directive_t]
          )(using Zone): Ptr[Struct0] =
            val ____ptr = apply()
            (!____ptr).start = start
            (!____ptr).end = end
            ____ptr
          extension (struct: Struct0)
            def start: Ptr[yaml_tag_directive_t] = struct._1
            def start_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at1 =
              value
            def end: Ptr[yaml_tag_directive_t] = struct._2
            def end_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at2 =
              value
        given _tag: Tag[Struct1] = Tag.materializeCStruct3Tag[Ptr[
          yaml_version_directive_t
        ], yaml_event_s.Union0.Struct1.Struct0, CInt]
        def apply()(using Zone): Ptr[Struct1] =
          scala.scalanative.unsafe.alloc[Struct1](1)
        def apply(
            version_directive: Ptr[yaml_version_directive_t],
            tag_directives: yaml_event_s.Union0.Struct1.Struct0,
            `implicit`: CInt
        )(using Zone): Ptr[Struct1] =
          val ____ptr = apply()
          (!____ptr).version_directive = version_directive
          (!____ptr).tag_directives = tag_directives
          (!____ptr).`implicit` = `implicit`
          ____ptr
        extension (struct: Struct1)
          def version_directive: Ptr[yaml_version_directive_t] = struct._1
          def version_directive_=(value: Ptr[yaml_version_directive_t]): Unit =
            !struct.at1 = value
          def tag_directives: yaml_event_s.Union0.Struct1.Struct0 = struct._2
          def tag_directives_=(
              value: yaml_event_s.Union0.Struct1.Struct0
          ): Unit = !struct.at2 = value
          def `implicit`: CInt = struct._3
          def implicit_=(value: CInt): Unit = !struct.at3 = value

      /** The document end parameters (for YAML_DOCUMENT_END_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct2 = CStruct1[CInt]
      object Struct2:
        given _tag: Tag[Struct2] = Tag.materializeCStruct1Tag[CInt]
        def apply()(using Zone): Ptr[Struct2] =
          scala.scalanative.unsafe.alloc[Struct2](1)
        def apply(`implicit`: CInt)(using Zone): Ptr[Struct2] =
          val ____ptr = apply()
          (!____ptr).`implicit` = `implicit`
          ____ptr
        extension (struct: Struct2)
          def `implicit`: CInt = struct._1
          def implicit_=(value: CInt): Unit = !struct.at1 = value

      /** The alias parameters (for YAML_ALIAS_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct3 = CStruct1[Ptr[yaml_char_t]]
      object Struct3:
        given _tag: Tag[Struct3] = Tag.materializeCStruct1Tag[Ptr[yaml_char_t]]
        def apply()(using Zone): Ptr[Struct3] =
          scala.scalanative.unsafe.alloc[Struct3](1)
        def apply(anchor: Ptr[yaml_char_t])(using Zone): Ptr[Struct3] =
          val ____ptr = apply()
          (!____ptr).anchor = anchor
          ____ptr
        extension (struct: Struct3)
          def anchor: Ptr[yaml_char_t] = struct._1
          def anchor_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value

      /** The scalar parameters (for YAML_SCALAR_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct4 = CStruct7[Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[
        yaml_char_t
      ], size_t, CInt, CInt, yaml_scalar_style_t]
      object Struct4:
        given _tag: Tag[Struct4] =
          Tag.materializeCStruct7Tag[Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[
            yaml_char_t
          ], size_t, CInt, CInt, yaml_scalar_style_t]
        def apply()(using Zone): Ptr[Struct4] =
          scala.scalanative.unsafe.alloc[Struct4](1)
        def apply(
            anchor: Ptr[yaml_char_t],
            tag: Ptr[yaml_char_t],
            value: Ptr[yaml_char_t],
            length: size_t,
            plain_implicit: CInt,
            quoted_implicit: CInt,
            style: yaml_scalar_style_t
        )(using Zone): Ptr[Struct4] =
          val ____ptr = apply()
          (!____ptr).anchor = anchor
          (!____ptr).tag = tag
          (!____ptr).value = value
          (!____ptr).length = length
          (!____ptr).plain_implicit = plain_implicit
          (!____ptr).quoted_implicit = quoted_implicit
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct4)
          def anchor: Ptr[yaml_char_t] = struct._1
          def anchor_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def tag: Ptr[yaml_char_t] = struct._2
          def tag_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
          def value: Ptr[yaml_char_t] = struct._3
          def value_=(value: Ptr[yaml_char_t]): Unit = !struct.at3 = value
          def length: size_t = struct._4
          def length_=(value: size_t): Unit = !struct.at4 = value
          def plain_implicit: CInt = struct._5
          def plain_implicit_=(value: CInt): Unit = !struct.at5 = value
          def quoted_implicit: CInt = struct._6
          def quoted_implicit_=(value: CInt): Unit = !struct.at6 = value
          def style: yaml_scalar_style_t = struct._7
          def style_=(value: yaml_scalar_style_t): Unit = !struct.at7 = value

      /** The sequence parameters (for YAML_SEQUENCE_START_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct5 = CStruct4[Ptr[yaml_char_t], Ptr[
        yaml_char_t
      ], CInt, yaml_sequence_style_t]
      object Struct5:
        given _tag: Tag[Struct5] = Tag.materializeCStruct4Tag[Ptr[
          yaml_char_t
        ], Ptr[yaml_char_t], CInt, yaml_sequence_style_t]
        def apply()(using Zone): Ptr[Struct5] =
          scala.scalanative.unsafe.alloc[Struct5](1)
        def apply(
            anchor: Ptr[yaml_char_t],
            tag: Ptr[yaml_char_t],
            `implicit`: CInt,
            style: yaml_sequence_style_t
        )(using Zone): Ptr[Struct5] =
          val ____ptr = apply()
          (!____ptr).anchor = anchor
          (!____ptr).tag = tag
          (!____ptr).`implicit` = `implicit`
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct5)
          def anchor: Ptr[yaml_char_t] = struct._1
          def anchor_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def tag: Ptr[yaml_char_t] = struct._2
          def tag_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
          def `implicit`: CInt = struct._3
          def implicit_=(value: CInt): Unit = !struct.at3 = value
          def style: yaml_sequence_style_t = struct._4
          def style_=(value: yaml_sequence_style_t): Unit = !struct.at4 = value

      /** The mapping parameters (for YAML_MAPPING_START_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct6 =
        CStruct4[Ptr[yaml_char_t], Ptr[yaml_char_t], CInt, yaml_mapping_style_t]
      object Struct6:
        given _tag: Tag[Struct6] = Tag.materializeCStruct4Tag[Ptr[
          yaml_char_t
        ], Ptr[yaml_char_t], CInt, yaml_mapping_style_t]
        def apply()(using Zone): Ptr[Struct6] =
          scala.scalanative.unsafe.alloc[Struct6](1)
        def apply(
            anchor: Ptr[yaml_char_t],
            tag: Ptr[yaml_char_t],
            `implicit`: CInt,
            style: yaml_mapping_style_t
        )(using Zone): Ptr[Struct6] =
          val ____ptr = apply()
          (!____ptr).anchor = anchor
          (!____ptr).tag = tag
          (!____ptr).`implicit` = `implicit`
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct6)
          def anchor: Ptr[yaml_char_t] = struct._1
          def anchor_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def tag: Ptr[yaml_char_t] = struct._2
          def tag_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
          def `implicit`: CInt = struct._3
          def implicit_=(value: CInt): Unit = !struct.at3 = value
          def style: yaml_mapping_style_t = struct._4
          def style_=(value: yaml_mapping_style_t): Unit = !struct.at4 = value
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat.Digit2[Nat._4, Nat._8]](
        Tag.Byte,
        Tag.Digit2[Nat._4, Nat._8](Tag.Nat4, Tag.Nat8)
      )
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_stream_start")
      def apply(stream_start: yaml_event_s.Union0.Struct0)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_event_s.Union0.Struct0]]
          .update(0, stream_start)
        ___ptr
      @scala.annotation.targetName("apply_document_start")
      def apply(document_start: yaml_event_s.Union0.Struct1)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_event_s.Union0.Struct1]]
          .update(0, document_start)
        ___ptr
      @scala.annotation.targetName("apply_document_end")
      def apply(document_end: yaml_event_s.Union0.Struct2)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_event_s.Union0.Struct2]]
          .update(0, document_end)
        ___ptr
      @scala.annotation.targetName("apply_alias")
      def apply(alias: yaml_event_s.Union0.Struct3)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct3]].update(0, alias)
        ___ptr
      @scala.annotation.targetName("apply_scalar")
      def apply(scalar: yaml_event_s.Union0.Struct4)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_event_s.Union0.Struct4]]
          .update(0, scalar)
        ___ptr
      @scala.annotation.targetName("apply_sequence_start")
      def apply(sequence_start: yaml_event_s.Union0.Struct5)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_event_s.Union0.Struct5]]
          .update(0, sequence_start)
        ___ptr
      @scala.annotation.targetName("apply_mapping_start")
      def apply(mapping_start: yaml_event_s.Union0.Struct6)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_event_s.Union0.Struct6]]
          .update(0, mapping_start)
        ___ptr
      extension (struct: Union0)
        def stream_start: yaml_event_s.Union0.Struct0 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct0]]
        def stream_start_=(value: yaml_event_s.Union0.Struct0): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct0]] = value
        def document_start: yaml_event_s.Union0.Struct1 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct1]]
        def document_start_=(value: yaml_event_s.Union0.Struct1): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct1]] = value
        def document_end: yaml_event_s.Union0.Struct2 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct2]]
        def document_end_=(value: yaml_event_s.Union0.Struct2): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct2]] = value
        def alias: yaml_event_s.Union0.Struct3 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct3]]
        def alias_=(value: yaml_event_s.Union0.Struct3): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct3]] = value
        def scalar: yaml_event_s.Union0.Struct4 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct4]]
        def scalar_=(value: yaml_event_s.Union0.Struct4): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct4]] = value
        def sequence_start: yaml_event_s.Union0.Struct5 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct5]]
        def sequence_start_=(value: yaml_event_s.Union0.Struct5): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct5]] = value
        def mapping_start: yaml_event_s.Union0.Struct6 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct6]]
        def mapping_start_=(value: yaml_event_s.Union0.Struct6): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_s.Union0.Struct6]] = value
    given _tag: Tag[yaml_event_s] = Tag.materializeCStruct4Tag[
      yaml_event_type_t,
      yaml_event_s.Union0,
      yaml_mark_t,
      yaml_mark_t
    ]
    def apply()(using Zone): Ptr[yaml_event_s] =
      scala.scalanative.unsafe.alloc[yaml_event_s](1)
    def apply(
        `type`: yaml_event_type_t,
        data: yaml_event_s.Union0,
        start_mark: yaml_mark_t,
        end_mark: yaml_mark_t
    )(using Zone): Ptr[yaml_event_s] =
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).data = data
      (!____ptr).start_mark = start_mark
      (!____ptr).end_mark = end_mark
      ____ptr
    extension (struct: yaml_event_s)
      def `type`: yaml_event_type_t = struct._1
      def type_=(value: yaml_event_type_t): Unit = !struct.at1 = value
      def data: yaml_event_s.Union0 = struct._2
      def data_=(value: yaml_event_s.Union0): Unit = !struct.at2 = value
      def start_mark: yaml_mark_t = struct._3
      def start_mark_=(value: yaml_mark_t): Unit = !struct.at3 = value
      def end_mark: yaml_mark_t = struct._4
      def end_mark_=(value: yaml_mark_t): Unit = !struct.at4 = value

  /** The event structure.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_event_t =
    CStruct4[yaml_event_type_t, yaml_event_t.Union0, yaml_mark_t, yaml_mark_t]
  object yaml_event_t:
    /** The event data.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Union0 = CArray[Byte, Nat.Digit2[Nat._4, Nat._8]]
    object Union0:
      /** The stream parameters (for YAML_STREAM_START_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct0 = CStruct1[yaml_encoding_t]
      object Struct0:
        given _tag: Tag[Struct0] = Tag.materializeCStruct1Tag[yaml_encoding_t]
        def apply()(using Zone): Ptr[Struct0] =
          scala.scalanative.unsafe.alloc[Struct0](1)
        def apply(encoding: yaml_encoding_t)(using Zone): Ptr[Struct0] =
          val ____ptr = apply()
          (!____ptr).encoding = encoding
          ____ptr
        extension (struct: Struct0)
          def encoding: yaml_encoding_t = struct._1
          def encoding_=(value: yaml_encoding_t): Unit = !struct.at1 = value

      /** The document parameters (for YAML_DOCUMENT_START_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct1 = CStruct3[Ptr[
        yaml_version_directive_t
      ], yaml_event_t.Union0.Struct1.Struct0, CInt]
      object Struct1:
        /** The list of tag directives.
          *
          * [bindgen] header: /usr/include/yaml.h
          */
        opaque type Struct0 =
          CStruct2[Ptr[yaml_tag_directive_t], Ptr[yaml_tag_directive_t]]
        object Struct0:
          given _tag: Tag[Struct0] = Tag.materializeCStruct2Tag[Ptr[
            yaml_tag_directive_t
          ], Ptr[yaml_tag_directive_t]]
          def apply()(using Zone): Ptr[Struct0] =
            scala.scalanative.unsafe.alloc[Struct0](1)
          def apply(
              start: Ptr[yaml_tag_directive_t],
              end: Ptr[yaml_tag_directive_t]
          )(using Zone): Ptr[Struct0] =
            val ____ptr = apply()
            (!____ptr).start = start
            (!____ptr).end = end
            ____ptr
          extension (struct: Struct0)
            def start: Ptr[yaml_tag_directive_t] = struct._1
            def start_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at1 =
              value
            def end: Ptr[yaml_tag_directive_t] = struct._2
            def end_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at2 =
              value
        given _tag: Tag[Struct1] = Tag.materializeCStruct3Tag[Ptr[
          yaml_version_directive_t
        ], yaml_event_t.Union0.Struct1.Struct0, CInt]
        def apply()(using Zone): Ptr[Struct1] =
          scala.scalanative.unsafe.alloc[Struct1](1)
        def apply(
            version_directive: Ptr[yaml_version_directive_t],
            tag_directives: yaml_event_t.Union0.Struct1.Struct0,
            `implicit`: CInt
        )(using Zone): Ptr[Struct1] =
          val ____ptr = apply()
          (!____ptr).version_directive = version_directive
          (!____ptr).tag_directives = tag_directives
          (!____ptr).`implicit` = `implicit`
          ____ptr
        extension (struct: Struct1)
          def version_directive: Ptr[yaml_version_directive_t] = struct._1
          def version_directive_=(value: Ptr[yaml_version_directive_t]): Unit =
            !struct.at1 = value
          def tag_directives: yaml_event_t.Union0.Struct1.Struct0 = struct._2
          def tag_directives_=(
              value: yaml_event_t.Union0.Struct1.Struct0
          ): Unit = !struct.at2 = value
          def `implicit`: CInt = struct._3
          def implicit_=(value: CInt): Unit = !struct.at3 = value

      /** The document end parameters (for YAML_DOCUMENT_END_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct2 = CStruct1[CInt]
      object Struct2:
        given _tag: Tag[Struct2] = Tag.materializeCStruct1Tag[CInt]
        def apply()(using Zone): Ptr[Struct2] =
          scala.scalanative.unsafe.alloc[Struct2](1)
        def apply(`implicit`: CInt)(using Zone): Ptr[Struct2] =
          val ____ptr = apply()
          (!____ptr).`implicit` = `implicit`
          ____ptr
        extension (struct: Struct2)
          def `implicit`: CInt = struct._1
          def implicit_=(value: CInt): Unit = !struct.at1 = value

      /** The alias parameters (for YAML_ALIAS_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct3 = CStruct1[Ptr[yaml_char_t]]
      object Struct3:
        given _tag: Tag[Struct3] = Tag.materializeCStruct1Tag[Ptr[yaml_char_t]]
        def apply()(using Zone): Ptr[Struct3] =
          scala.scalanative.unsafe.alloc[Struct3](1)
        def apply(anchor: Ptr[yaml_char_t])(using Zone): Ptr[Struct3] =
          val ____ptr = apply()
          (!____ptr).anchor = anchor
          ____ptr
        extension (struct: Struct3)
          def anchor: Ptr[yaml_char_t] = struct._1
          def anchor_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value

      /** The scalar parameters (for YAML_SCALAR_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct4 = CStruct7[Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[
        yaml_char_t
      ], size_t, CInt, CInt, yaml_scalar_style_t]
      object Struct4:
        given _tag: Tag[Struct4] =
          Tag.materializeCStruct7Tag[Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[
            yaml_char_t
          ], size_t, CInt, CInt, yaml_scalar_style_t]
        def apply()(using Zone): Ptr[Struct4] =
          scala.scalanative.unsafe.alloc[Struct4](1)
        def apply(
            anchor: Ptr[yaml_char_t],
            tag: Ptr[yaml_char_t],
            value: Ptr[yaml_char_t],
            length: size_t,
            plain_implicit: CInt,
            quoted_implicit: CInt,
            style: yaml_scalar_style_t
        )(using Zone): Ptr[Struct4] =
          val ____ptr = apply()
          (!____ptr).anchor = anchor
          (!____ptr).tag = tag
          (!____ptr).value = value
          (!____ptr).length = length
          (!____ptr).plain_implicit = plain_implicit
          (!____ptr).quoted_implicit = quoted_implicit
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct4)
          def anchor: Ptr[yaml_char_t] = struct._1
          def anchor_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def tag: Ptr[yaml_char_t] = struct._2
          def tag_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
          def value: Ptr[yaml_char_t] = struct._3
          def value_=(value: Ptr[yaml_char_t]): Unit = !struct.at3 = value
          def length: size_t = struct._4
          def length_=(value: size_t): Unit = !struct.at4 = value
          def plain_implicit: CInt = struct._5
          def plain_implicit_=(value: CInt): Unit = !struct.at5 = value
          def quoted_implicit: CInt = struct._6
          def quoted_implicit_=(value: CInt): Unit = !struct.at6 = value
          def style: yaml_scalar_style_t = struct._7
          def style_=(value: yaml_scalar_style_t): Unit = !struct.at7 = value

      /** The sequence parameters (for YAML_SEQUENCE_START_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct5 = CStruct4[Ptr[yaml_char_t], Ptr[
        yaml_char_t
      ], CInt, yaml_sequence_style_t]
      object Struct5:
        given _tag: Tag[Struct5] = Tag.materializeCStruct4Tag[Ptr[
          yaml_char_t
        ], Ptr[yaml_char_t], CInt, yaml_sequence_style_t]
        def apply()(using Zone): Ptr[Struct5] =
          scala.scalanative.unsafe.alloc[Struct5](1)
        def apply(
            anchor: Ptr[yaml_char_t],
            tag: Ptr[yaml_char_t],
            `implicit`: CInt,
            style: yaml_sequence_style_t
        )(using Zone): Ptr[Struct5] =
          val ____ptr = apply()
          (!____ptr).anchor = anchor
          (!____ptr).tag = tag
          (!____ptr).`implicit` = `implicit`
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct5)
          def anchor: Ptr[yaml_char_t] = struct._1
          def anchor_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def tag: Ptr[yaml_char_t] = struct._2
          def tag_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
          def `implicit`: CInt = struct._3
          def implicit_=(value: CInt): Unit = !struct.at3 = value
          def style: yaml_sequence_style_t = struct._4
          def style_=(value: yaml_sequence_style_t): Unit = !struct.at4 = value

      /** The mapping parameters (for YAML_MAPPING_START_EVENT).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct6 =
        CStruct4[Ptr[yaml_char_t], Ptr[yaml_char_t], CInt, yaml_mapping_style_t]
      object Struct6:
        given _tag: Tag[Struct6] = Tag.materializeCStruct4Tag[Ptr[
          yaml_char_t
        ], Ptr[yaml_char_t], CInt, yaml_mapping_style_t]
        def apply()(using Zone): Ptr[Struct6] =
          scala.scalanative.unsafe.alloc[Struct6](1)
        def apply(
            anchor: Ptr[yaml_char_t],
            tag: Ptr[yaml_char_t],
            `implicit`: CInt,
            style: yaml_mapping_style_t
        )(using Zone): Ptr[Struct6] =
          val ____ptr = apply()
          (!____ptr).anchor = anchor
          (!____ptr).tag = tag
          (!____ptr).`implicit` = `implicit`
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct6)
          def anchor: Ptr[yaml_char_t] = struct._1
          def anchor_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def tag: Ptr[yaml_char_t] = struct._2
          def tag_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
          def `implicit`: CInt = struct._3
          def implicit_=(value: CInt): Unit = !struct.at3 = value
          def style: yaml_mapping_style_t = struct._4
          def style_=(value: yaml_mapping_style_t): Unit = !struct.at4 = value
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat.Digit2[Nat._4, Nat._8]](
        Tag.Byte,
        Tag.Digit2[Nat._4, Nat._8](Tag.Nat4, Tag.Nat8)
      )
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_stream_start")
      def apply(stream_start: yaml_event_t.Union0.Struct0)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_event_t.Union0.Struct0]]
          .update(0, stream_start)
        ___ptr
      @scala.annotation.targetName("apply_document_start")
      def apply(document_start: yaml_event_t.Union0.Struct1)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_event_t.Union0.Struct1]]
          .update(0, document_start)
        ___ptr
      @scala.annotation.targetName("apply_document_end")
      def apply(document_end: yaml_event_t.Union0.Struct2)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_event_t.Union0.Struct2]]
          .update(0, document_end)
        ___ptr
      @scala.annotation.targetName("apply_alias")
      def apply(alias: yaml_event_t.Union0.Struct3)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct3]].update(0, alias)
        ___ptr
      @scala.annotation.targetName("apply_scalar")
      def apply(scalar: yaml_event_t.Union0.Struct4)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_event_t.Union0.Struct4]]
          .update(0, scalar)
        ___ptr
      @scala.annotation.targetName("apply_sequence_start")
      def apply(sequence_start: yaml_event_t.Union0.Struct5)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_event_t.Union0.Struct5]]
          .update(0, sequence_start)
        ___ptr
      @scala.annotation.targetName("apply_mapping_start")
      def apply(mapping_start: yaml_event_t.Union0.Struct6)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_event_t.Union0.Struct6]]
          .update(0, mapping_start)
        ___ptr
      extension (struct: Union0)
        def stream_start: yaml_event_t.Union0.Struct0 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct0]]
        def stream_start_=(value: yaml_event_t.Union0.Struct0): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct0]] = value
        def document_start: yaml_event_t.Union0.Struct1 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct1]]
        def document_start_=(value: yaml_event_t.Union0.Struct1): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct1]] = value
        def document_end: yaml_event_t.Union0.Struct2 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct2]]
        def document_end_=(value: yaml_event_t.Union0.Struct2): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct2]] = value
        def alias: yaml_event_t.Union0.Struct3 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct3]]
        def alias_=(value: yaml_event_t.Union0.Struct3): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct3]] = value
        def scalar: yaml_event_t.Union0.Struct4 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct4]]
        def scalar_=(value: yaml_event_t.Union0.Struct4): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct4]] = value
        def sequence_start: yaml_event_t.Union0.Struct5 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct5]]
        def sequence_start_=(value: yaml_event_t.Union0.Struct5): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct5]] = value
        def mapping_start: yaml_event_t.Union0.Struct6 =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct6]]
        def mapping_start_=(value: yaml_event_t.Union0.Struct6): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_event_t.Union0.Struct6]] = value
    given _tag: Tag[yaml_event_t] = Tag.materializeCStruct4Tag[
      yaml_event_type_t,
      yaml_event_t.Union0,
      yaml_mark_t,
      yaml_mark_t
    ]
    def apply()(using Zone): Ptr[yaml_event_t] =
      scala.scalanative.unsafe.alloc[yaml_event_t](1)
    def apply(
        `type`: yaml_event_type_t,
        data: yaml_event_t.Union0,
        start_mark: yaml_mark_t,
        end_mark: yaml_mark_t
    )(using Zone): Ptr[yaml_event_t] =
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).data = data
      (!____ptr).start_mark = start_mark
      (!____ptr).end_mark = end_mark
      ____ptr
    extension (struct: yaml_event_t)
      def `type`: yaml_event_type_t = struct._1
      def type_=(value: yaml_event_type_t): Unit = !struct.at1 = value
      def data: yaml_event_t.Union0 = struct._2
      def data_=(value: yaml_event_t.Union0): Unit = !struct.at2 = value
      def start_mark: yaml_mark_t = struct._3
      def start_mark_=(value: yaml_mark_t): Unit = !struct.at3 = value
      def end_mark: yaml_mark_t = struct._4
      def end_mark_=(value: yaml_mark_t): Unit = !struct.at4 = value

  /** The pointer position.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_mark_s = CStruct3[size_t, size_t, size_t]
  object yaml_mark_s:
    given _tag: Tag[yaml_mark_s] =
      Tag.materializeCStruct3Tag[size_t, size_t, size_t]
    def apply()(using Zone): Ptr[yaml_mark_s] =
      scala.scalanative.unsafe.alloc[yaml_mark_s](1)
    def apply(index: size_t, line: size_t, column: size_t)(using
        Zone
    ): Ptr[yaml_mark_s] =
      val ____ptr = apply()
      (!____ptr).index = index
      (!____ptr).line = line
      (!____ptr).column = column
      ____ptr
    extension (struct: yaml_mark_s)
      def index: size_t = struct._1
      def index_=(value: size_t): Unit = !struct.at1 = value
      def line: size_t = struct._2
      def line_=(value: size_t): Unit = !struct.at2 = value
      def column: size_t = struct._3
      def column_=(value: size_t): Unit = !struct.at3 = value

  /** The pointer position.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_mark_t = CStruct3[size_t, size_t, size_t]
  object yaml_mark_t:
    given _tag: Tag[yaml_mark_t] =
      Tag.materializeCStruct3Tag[size_t, size_t, size_t]
    def apply()(using Zone): Ptr[yaml_mark_t] =
      scala.scalanative.unsafe.alloc[yaml_mark_t](1)
    def apply(index: size_t, line: size_t, column: size_t)(using
        Zone
    ): Ptr[yaml_mark_t] =
      val ____ptr = apply()
      (!____ptr).index = index
      (!____ptr).line = line
      (!____ptr).column = column
      ____ptr
    extension (struct: yaml_mark_t)
      def index: size_t = struct._1
      def index_=(value: size_t): Unit = !struct.at1 = value
      def line: size_t = struct._2
      def line_=(value: size_t): Unit = !struct.at2 = value
      def column: size_t = struct._3
      def column_=(value: size_t): Unit = !struct.at3 = value

  /** An element of a mapping node.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_node_pair_s = CStruct2[CInt, CInt]
  object yaml_node_pair_s:
    given _tag: Tag[yaml_node_pair_s] = Tag.materializeCStruct2Tag[CInt, CInt]
    def apply()(using Zone): Ptr[yaml_node_pair_s] =
      scala.scalanative.unsafe.alloc[yaml_node_pair_s](1)
    def apply(key: CInt, value: CInt)(using Zone): Ptr[yaml_node_pair_s] =
      val ____ptr = apply()
      (!____ptr).key = key
      (!____ptr).value = value
      ____ptr
    extension (struct: yaml_node_pair_s)
      def key: CInt = struct._1
      def key_=(value: CInt): Unit = !struct.at1 = value
      def value: CInt = struct._2
      def value_=(value: CInt): Unit = !struct.at2 = value

  /** An element of a mapping node.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_node_pair_t = CStruct2[CInt, CInt]
  object yaml_node_pair_t:
    given _tag: Tag[yaml_node_pair_t] = Tag.materializeCStruct2Tag[CInt, CInt]
    def apply()(using Zone): Ptr[yaml_node_pair_t] =
      scala.scalanative.unsafe.alloc[yaml_node_pair_t](1)
    def apply(key: CInt, value: CInt)(using Zone): Ptr[yaml_node_pair_t] =
      val ____ptr = apply()
      (!____ptr).key = key
      (!____ptr).value = value
      ____ptr
    extension (struct: yaml_node_pair_t)
      def key: CInt = struct._1
      def key_=(value: CInt): Unit = !struct.at1 = value
      def value: CInt = struct._2
      def value_=(value: CInt): Unit = !struct.at2 = value

  /** The node structure.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_node_s = CStruct5[yaml_node_type_t, Ptr[
    yaml_char_t
  ], yaml_node_s.Union0, yaml_mark_t, yaml_mark_t]
  object yaml_node_s:
    /** The node data.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Union0 = CArray[Byte, Nat.Digit2[Nat._3, Nat._2]]
    object Union0:
      /** The scalar parameters (for YAML_SCALAR_NODE).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct0 =
        CStruct3[Ptr[yaml_char_t], size_t, yaml_scalar_style_t]
      object Struct0:
        given _tag: Tag[Struct0] = Tag
          .materializeCStruct3Tag[Ptr[yaml_char_t], size_t, yaml_scalar_style_t]
        def apply()(using Zone): Ptr[Struct0] =
          scala.scalanative.unsafe.alloc[Struct0](1)
        def apply(
            value: Ptr[yaml_char_t],
            length: size_t,
            style: yaml_scalar_style_t
        )(using Zone): Ptr[Struct0] =
          val ____ptr = apply()
          (!____ptr).value = value
          (!____ptr).length = length
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct0)
          def value: Ptr[yaml_char_t] = struct._1
          def value_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def length: size_t = struct._2
          def length_=(value: size_t): Unit = !struct.at2 = value
          def style: yaml_scalar_style_t = struct._3
          def style_=(value: yaml_scalar_style_t): Unit = !struct.at3 = value

      /** The sequence parameters (for YAML_SEQUENCE_NODE).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct1 =
        CStruct2[yaml_node_s.Union0.Struct1.Struct0, yaml_sequence_style_t]
      object Struct1:
        /** The stack of sequence items.
          *
          * [bindgen] header: /usr/include/yaml.h
          */
        opaque type Struct0 = CStruct3[Ptr[yaml_node_item_t], Ptr[
          yaml_node_item_t
        ], Ptr[yaml_node_item_t]]
        object Struct0:
          given _tag: Tag[Struct0] = Tag.materializeCStruct3Tag[Ptr[
            yaml_node_item_t
          ], Ptr[yaml_node_item_t], Ptr[yaml_node_item_t]]
          def apply()(using Zone): Ptr[Struct0] =
            scala.scalanative.unsafe.alloc[Struct0](1)
          def apply(
              start: Ptr[yaml_node_item_t],
              end: Ptr[yaml_node_item_t],
              top: Ptr[yaml_node_item_t]
          )(using Zone): Ptr[Struct0] =
            val ____ptr = apply()
            (!____ptr).start = start
            (!____ptr).end = end
            (!____ptr).top = top
            ____ptr
          extension (struct: Struct0)
            def start: Ptr[yaml_node_item_t] = struct._1
            def start_=(value: Ptr[yaml_node_item_t]): Unit = !struct.at1 =
              value
            def end: Ptr[yaml_node_item_t] = struct._2
            def end_=(value: Ptr[yaml_node_item_t]): Unit = !struct.at2 = value
            def top: Ptr[yaml_node_item_t] = struct._3
            def top_=(value: Ptr[yaml_node_item_t]): Unit = !struct.at3 = value
        given _tag: Tag[Struct1] = Tag.materializeCStruct2Tag[
          yaml_node_s.Union0.Struct1.Struct0,
          yaml_sequence_style_t
        ]
        def apply()(using Zone): Ptr[Struct1] =
          scala.scalanative.unsafe.alloc[Struct1](1)
        def apply(
            items: yaml_node_s.Union0.Struct1.Struct0,
            style: yaml_sequence_style_t
        )(using Zone): Ptr[Struct1] =
          val ____ptr = apply()
          (!____ptr).items = items
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct1)
          def items: yaml_node_s.Union0.Struct1.Struct0 = struct._1
          def items_=(value: yaml_node_s.Union0.Struct1.Struct0): Unit =
            !struct.at1 = value
          def style: yaml_sequence_style_t = struct._2
          def style_=(value: yaml_sequence_style_t): Unit = !struct.at2 = value

      /** The mapping parameters (for YAML_MAPPING_NODE).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct2 =
        CStruct2[yaml_node_s.Union0.Struct2.Struct0, yaml_mapping_style_t]
      object Struct2:
        /** The stack of mapping pairs (key, value).
          *
          * [bindgen] header: /usr/include/yaml.h
          */
        opaque type Struct0 = CStruct3[Ptr[yaml_node_pair_t], Ptr[
          yaml_node_pair_t
        ], Ptr[yaml_node_pair_t]]
        object Struct0:
          given _tag: Tag[Struct0] = Tag.materializeCStruct3Tag[Ptr[
            yaml_node_pair_t
          ], Ptr[yaml_node_pair_t], Ptr[yaml_node_pair_t]]
          def apply()(using Zone): Ptr[Struct0] =
            scala.scalanative.unsafe.alloc[Struct0](1)
          def apply(
              start: Ptr[yaml_node_pair_t],
              end: Ptr[yaml_node_pair_t],
              top: Ptr[yaml_node_pair_t]
          )(using Zone): Ptr[Struct0] =
            val ____ptr = apply()
            (!____ptr).start = start
            (!____ptr).end = end
            (!____ptr).top = top
            ____ptr
          extension (struct: Struct0)
            def start: Ptr[yaml_node_pair_t] = struct._1
            def start_=(value: Ptr[yaml_node_pair_t]): Unit = !struct.at1 =
              value
            def end: Ptr[yaml_node_pair_t] = struct._2
            def end_=(value: Ptr[yaml_node_pair_t]): Unit = !struct.at2 = value
            def top: Ptr[yaml_node_pair_t] = struct._3
            def top_=(value: Ptr[yaml_node_pair_t]): Unit = !struct.at3 = value
        given _tag: Tag[Struct2] = Tag.materializeCStruct2Tag[
          yaml_node_s.Union0.Struct2.Struct0,
          yaml_mapping_style_t
        ]
        def apply()(using Zone): Ptr[Struct2] =
          scala.scalanative.unsafe.alloc[Struct2](1)
        def apply(
            pairs: yaml_node_s.Union0.Struct2.Struct0,
            style: yaml_mapping_style_t
        )(using Zone): Ptr[Struct2] =
          val ____ptr = apply()
          (!____ptr).pairs = pairs
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct2)
          def pairs: yaml_node_s.Union0.Struct2.Struct0 = struct._1
          def pairs_=(value: yaml_node_s.Union0.Struct2.Struct0): Unit =
            !struct.at1 = value
          def style: yaml_mapping_style_t = struct._2
          def style_=(value: yaml_mapping_style_t): Unit = !struct.at2 = value
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat.Digit2[Nat._3, Nat._2]](
        Tag.Byte,
        Tag.Digit2[Nat._3, Nat._2](Tag.Nat3, Tag.Nat2)
      )
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_scalar")
      def apply(scalar: yaml_node_s.Union0.Struct0)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[yaml_node_s.Union0.Struct0]].update(0, scalar)
        ___ptr
      @scala.annotation.targetName("apply_sequence")
      def apply(sequence: yaml_node_s.Union0.Struct1)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_node_s.Union0.Struct1]]
          .update(0, sequence)
        ___ptr
      @scala.annotation.targetName("apply_mapping")
      def apply(mapping: yaml_node_s.Union0.Struct2)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_node_s.Union0.Struct2]]
          .update(0, mapping)
        ___ptr
      extension (struct: Union0)
        def scalar: yaml_node_s.Union0.Struct0 =
          !struct.at(0).asInstanceOf[Ptr[yaml_node_s.Union0.Struct0]]
        def scalar_=(value: yaml_node_s.Union0.Struct0): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_node_s.Union0.Struct0]] = value
        def sequence: yaml_node_s.Union0.Struct1 =
          !struct.at(0).asInstanceOf[Ptr[yaml_node_s.Union0.Struct1]]
        def sequence_=(value: yaml_node_s.Union0.Struct1): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_node_s.Union0.Struct1]] = value
        def mapping: yaml_node_s.Union0.Struct2 =
          !struct.at(0).asInstanceOf[Ptr[yaml_node_s.Union0.Struct2]]
        def mapping_=(value: yaml_node_s.Union0.Struct2): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_node_s.Union0.Struct2]] = value
    given _tag: Tag[yaml_node_s] =
      Tag.materializeCStruct5Tag[yaml_node_type_t, Ptr[
        yaml_char_t
      ], yaml_node_s.Union0, yaml_mark_t, yaml_mark_t]
    def apply()(using Zone): Ptr[yaml_node_s] =
      scala.scalanative.unsafe.alloc[yaml_node_s](1)
    def apply(
        `type`: yaml_node_type_t,
        tag: Ptr[yaml_char_t],
        data: yaml_node_s.Union0,
        start_mark: yaml_mark_t,
        end_mark: yaml_mark_t
    )(using Zone): Ptr[yaml_node_s] =
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).tag = tag
      (!____ptr).data = data
      (!____ptr).start_mark = start_mark
      (!____ptr).end_mark = end_mark
      ____ptr
    extension (struct: yaml_node_s)
      def `type`: yaml_node_type_t = struct._1
      def type_=(value: yaml_node_type_t): Unit = !struct.at1 = value
      def tag: Ptr[yaml_char_t] = struct._2
      def tag_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
      def data: yaml_node_s.Union0 = struct._3
      def data_=(value: yaml_node_s.Union0): Unit = !struct.at3 = value
      def start_mark: yaml_mark_t = struct._4
      def start_mark_=(value: yaml_mark_t): Unit = !struct.at4 = value
      def end_mark: yaml_mark_t = struct._5
      def end_mark_=(value: yaml_mark_t): Unit = !struct.at5 = value

  /** The node structure.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_node_t = CStruct5[yaml_node_type_t, Ptr[
    yaml_char_t
  ], yaml_node_t.Union0, yaml_mark_t, yaml_mark_t]
  object yaml_node_t:
    /** The node data.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Union0 = CArray[Byte, Nat.Digit2[Nat._3, Nat._2]]
    object Union0:
      /** The scalar parameters (for YAML_SCALAR_NODE).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct0 =
        CStruct3[Ptr[yaml_char_t], size_t, yaml_scalar_style_t]
      object Struct0:
        given _tag: Tag[Struct0] = Tag
          .materializeCStruct3Tag[Ptr[yaml_char_t], size_t, yaml_scalar_style_t]
        def apply()(using Zone): Ptr[Struct0] =
          scala.scalanative.unsafe.alloc[Struct0](1)
        def apply(
            value: Ptr[yaml_char_t],
            length: size_t,
            style: yaml_scalar_style_t
        )(using Zone): Ptr[Struct0] =
          val ____ptr = apply()
          (!____ptr).value = value
          (!____ptr).length = length
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct0)
          def value: Ptr[yaml_char_t] = struct._1
          def value_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def length: size_t = struct._2
          def length_=(value: size_t): Unit = !struct.at2 = value
          def style: yaml_scalar_style_t = struct._3
          def style_=(value: yaml_scalar_style_t): Unit = !struct.at3 = value

      /** The sequence parameters (for YAML_SEQUENCE_NODE).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct1 =
        CStruct2[yaml_node_t.Union0.Struct1.Struct0, yaml_sequence_style_t]
      object Struct1:
        /** The stack of sequence items.
          *
          * [bindgen] header: /usr/include/yaml.h
          */
        opaque type Struct0 = CStruct3[Ptr[yaml_node_item_t], Ptr[
          yaml_node_item_t
        ], Ptr[yaml_node_item_t]]
        object Struct0:
          given _tag: Tag[Struct0] = Tag.materializeCStruct3Tag[Ptr[
            yaml_node_item_t
          ], Ptr[yaml_node_item_t], Ptr[yaml_node_item_t]]
          def apply()(using Zone): Ptr[Struct0] =
            scala.scalanative.unsafe.alloc[Struct0](1)
          def apply(
              start: Ptr[yaml_node_item_t],
              end: Ptr[yaml_node_item_t],
              top: Ptr[yaml_node_item_t]
          )(using Zone): Ptr[Struct0] =
            val ____ptr = apply()
            (!____ptr).start = start
            (!____ptr).end = end
            (!____ptr).top = top
            ____ptr
          extension (struct: Struct0)
            def start: Ptr[yaml_node_item_t] = struct._1
            def start_=(value: Ptr[yaml_node_item_t]): Unit = !struct.at1 =
              value
            def end: Ptr[yaml_node_item_t] = struct._2
            def end_=(value: Ptr[yaml_node_item_t]): Unit = !struct.at2 = value
            def top: Ptr[yaml_node_item_t] = struct._3
            def top_=(value: Ptr[yaml_node_item_t]): Unit = !struct.at3 = value
        given _tag: Tag[Struct1] = Tag.materializeCStruct2Tag[
          yaml_node_t.Union0.Struct1.Struct0,
          yaml_sequence_style_t
        ]
        def apply()(using Zone): Ptr[Struct1] =
          scala.scalanative.unsafe.alloc[Struct1](1)
        def apply(
            items: yaml_node_t.Union0.Struct1.Struct0,
            style: yaml_sequence_style_t
        )(using Zone): Ptr[Struct1] =
          val ____ptr = apply()
          (!____ptr).items = items
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct1)
          def items: yaml_node_t.Union0.Struct1.Struct0 = struct._1
          def items_=(value: yaml_node_t.Union0.Struct1.Struct0): Unit =
            !struct.at1 = value
          def style: yaml_sequence_style_t = struct._2
          def style_=(value: yaml_sequence_style_t): Unit = !struct.at2 = value

      /** The mapping parameters (for YAML_MAPPING_NODE).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct2 =
        CStruct2[yaml_node_t.Union0.Struct2.Struct0, yaml_mapping_style_t]
      object Struct2:
        /** The stack of mapping pairs (key, value).
          *
          * [bindgen] header: /usr/include/yaml.h
          */
        opaque type Struct0 = CStruct3[Ptr[yaml_node_pair_t], Ptr[
          yaml_node_pair_t
        ], Ptr[yaml_node_pair_t]]
        object Struct0:
          given _tag: Tag[Struct0] = Tag.materializeCStruct3Tag[Ptr[
            yaml_node_pair_t
          ], Ptr[yaml_node_pair_t], Ptr[yaml_node_pair_t]]
          def apply()(using Zone): Ptr[Struct0] =
            scala.scalanative.unsafe.alloc[Struct0](1)
          def apply(
              start: Ptr[yaml_node_pair_t],
              end: Ptr[yaml_node_pair_t],
              top: Ptr[yaml_node_pair_t]
          )(using Zone): Ptr[Struct0] =
            val ____ptr = apply()
            (!____ptr).start = start
            (!____ptr).end = end
            (!____ptr).top = top
            ____ptr
          extension (struct: Struct0)
            def start: Ptr[yaml_node_pair_t] = struct._1
            def start_=(value: Ptr[yaml_node_pair_t]): Unit = !struct.at1 =
              value
            def end: Ptr[yaml_node_pair_t] = struct._2
            def end_=(value: Ptr[yaml_node_pair_t]): Unit = !struct.at2 = value
            def top: Ptr[yaml_node_pair_t] = struct._3
            def top_=(value: Ptr[yaml_node_pair_t]): Unit = !struct.at3 = value
        given _tag: Tag[Struct2] = Tag.materializeCStruct2Tag[
          yaml_node_t.Union0.Struct2.Struct0,
          yaml_mapping_style_t
        ]
        def apply()(using Zone): Ptr[Struct2] =
          scala.scalanative.unsafe.alloc[Struct2](1)
        def apply(
            pairs: yaml_node_t.Union0.Struct2.Struct0,
            style: yaml_mapping_style_t
        )(using Zone): Ptr[Struct2] =
          val ____ptr = apply()
          (!____ptr).pairs = pairs
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct2)
          def pairs: yaml_node_t.Union0.Struct2.Struct0 = struct._1
          def pairs_=(value: yaml_node_t.Union0.Struct2.Struct0): Unit =
            !struct.at1 = value
          def style: yaml_mapping_style_t = struct._2
          def style_=(value: yaml_mapping_style_t): Unit = !struct.at2 = value
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat.Digit2[Nat._3, Nat._2]](
        Tag.Byte,
        Tag.Digit2[Nat._3, Nat._2](Tag.Nat3, Tag.Nat2)
      )
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_scalar")
      def apply(scalar: yaml_node_t.Union0.Struct0)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[yaml_node_t.Union0.Struct0]].update(0, scalar)
        ___ptr
      @scala.annotation.targetName("apply_sequence")
      def apply(sequence: yaml_node_t.Union0.Struct1)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_node_t.Union0.Struct1]]
          .update(0, sequence)
        ___ptr
      @scala.annotation.targetName("apply_mapping")
      def apply(mapping: yaml_node_t.Union0.Struct2)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_node_t.Union0.Struct2]]
          .update(0, mapping)
        ___ptr
      extension (struct: Union0)
        def scalar: yaml_node_t.Union0.Struct0 =
          !struct.at(0).asInstanceOf[Ptr[yaml_node_t.Union0.Struct0]]
        def scalar_=(value: yaml_node_t.Union0.Struct0): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_node_t.Union0.Struct0]] = value
        def sequence: yaml_node_t.Union0.Struct1 =
          !struct.at(0).asInstanceOf[Ptr[yaml_node_t.Union0.Struct1]]
        def sequence_=(value: yaml_node_t.Union0.Struct1): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_node_t.Union0.Struct1]] = value
        def mapping: yaml_node_t.Union0.Struct2 =
          !struct.at(0).asInstanceOf[Ptr[yaml_node_t.Union0.Struct2]]
        def mapping_=(value: yaml_node_t.Union0.Struct2): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_node_t.Union0.Struct2]] = value
    given _tag: Tag[yaml_node_t] =
      Tag.materializeCStruct5Tag[yaml_node_type_t, Ptr[
        yaml_char_t
      ], yaml_node_t.Union0, yaml_mark_t, yaml_mark_t]
    def apply()(using Zone): Ptr[yaml_node_t] =
      scala.scalanative.unsafe.alloc[yaml_node_t](1)
    def apply(
        `type`: yaml_node_type_t,
        tag: Ptr[yaml_char_t],
        data: yaml_node_t.Union0,
        start_mark: yaml_mark_t,
        end_mark: yaml_mark_t
    )(using Zone): Ptr[yaml_node_t] =
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).tag = tag
      (!____ptr).data = data
      (!____ptr).start_mark = start_mark
      (!____ptr).end_mark = end_mark
      ____ptr
    extension (struct: yaml_node_t)
      def `type`: yaml_node_type_t = struct._1
      def type_=(value: yaml_node_type_t): Unit = !struct.at1 = value
      def tag: Ptr[yaml_char_t] = struct._2
      def tag_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
      def data: yaml_node_t.Union0 = struct._3
      def data_=(value: yaml_node_t.Union0): Unit = !struct.at3 = value
      def start_mark: yaml_mark_t = struct._4
      def start_mark_=(value: yaml_mark_t): Unit = !struct.at4 = value
      def end_mark: yaml_mark_t = struct._5
      def end_mark_=(value: yaml_mark_t): Unit = !struct.at5 = value

  /** The parser structure.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_parser_s = CArray[CChar, Nat.Digit3[Nat._4, Nat._8, Nat._0]]
  object yaml_parser_s:
    /** Standard (string or file) input data.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Union0 = CArray[Byte, Nat.Digit2[Nat._2, Nat._4]]
    object Union0:
      /** String input data.
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct0 =
        CStruct3[Ptr[CUnsignedChar], Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
      object Struct0:
        given _tag: Tag[Struct0] = Tag.materializeCStruct3Tag[Ptr[
          CUnsignedChar
        ], Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
        def apply()(using Zone): Ptr[Struct0] =
          scala.scalanative.unsafe.alloc[Struct0](1)
        def apply(
            start: Ptr[CUnsignedChar],
            end: Ptr[CUnsignedChar],
            current: Ptr[CUnsignedChar]
        )(using Zone): Ptr[Struct0] =
          val ____ptr = apply()
          (!____ptr).start = start
          (!____ptr).end = end
          (!____ptr).current = current
          ____ptr
        extension (struct: Struct0)
          def start: Ptr[CUnsignedChar] = struct._1
          def start_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
          def end: Ptr[CUnsignedChar] = struct._2
          def end_=(value: Ptr[CUnsignedChar]): Unit = !struct.at2 = value
          def current: Ptr[CUnsignedChar] = struct._3
          def current_=(value: Ptr[CUnsignedChar]): Unit = !struct.at3 = value
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat.Digit2[Nat._2, Nat._4]](
        Tag.Byte,
        Tag.Digit2[Nat._2, Nat._4](Tag.Nat2, Tag.Nat4)
      )
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_string")
      def apply(string: yaml_parser_s.Union0.Struct0)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_parser_s.Union0.Struct0]]
          .update(0, string)
        ___ptr
      @scala.annotation.targetName("apply_file")
      def apply(file: Ptr[FILE])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FILE]]].update(0, file)
        ___ptr
      extension (struct: Union0)
        def string: yaml_parser_s.Union0.Struct0 =
          !struct.at(0).asInstanceOf[Ptr[yaml_parser_s.Union0.Struct0]]
        def string_=(value: yaml_parser_s.Union0.Struct0): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_parser_s.Union0.Struct0]] = value
        def file: Ptr[FILE] = !struct.at(0).asInstanceOf[Ptr[Ptr[FILE]]]
        def file_=(value: Ptr[FILE]): Unit =
          !struct.at(0).asInstanceOf[Ptr[Ptr[FILE]]] = value

    /** The working buffer.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct1 = CStruct4[Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[
      yaml_char_t
    ], Ptr[yaml_char_t]]
    object Struct1:
      given _tag: Tag[Struct1] = Tag.materializeCStruct4Tag[Ptr[
        yaml_char_t
      ], Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[yaml_char_t]]
      def apply()(using Zone): Ptr[Struct1] =
        scala.scalanative.unsafe.alloc[Struct1](1)
      def apply(
          start: Ptr[yaml_char_t],
          end: Ptr[yaml_char_t],
          pointer: Ptr[yaml_char_t],
          last: Ptr[yaml_char_t]
      )(using Zone): Ptr[Struct1] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).pointer = pointer
        (!____ptr).last = last
        ____ptr
      extension (struct: Struct1)
        def start: Ptr[yaml_char_t] = struct._1
        def start_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_char_t] = struct._2
        def end_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
        def pointer: Ptr[yaml_char_t] = struct._3
        def pointer_=(value: Ptr[yaml_char_t]): Unit = !struct.at3 = value
        def last: Ptr[yaml_char_t] = struct._4
        def last_=(value: Ptr[yaml_char_t]): Unit = !struct.at4 = value

    /** The raw buffer.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct2 = CStruct4[Ptr[CUnsignedChar], Ptr[CUnsignedChar], Ptr[
      CUnsignedChar
    ], Ptr[CUnsignedChar]]
    object Struct2:
      given _tag: Tag[Struct2] = Tag.materializeCStruct4Tag[Ptr[
        CUnsignedChar
      ], Ptr[CUnsignedChar], Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
      def apply()(using Zone): Ptr[Struct2] =
        scala.scalanative.unsafe.alloc[Struct2](1)
      def apply(
          start: Ptr[CUnsignedChar],
          end: Ptr[CUnsignedChar],
          pointer: Ptr[CUnsignedChar],
          last: Ptr[CUnsignedChar]
      )(using Zone): Ptr[Struct2] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).pointer = pointer
        (!____ptr).last = last
        ____ptr
      extension (struct: Struct2)
        def start: Ptr[CUnsignedChar] = struct._1
        def start_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
        def end: Ptr[CUnsignedChar] = struct._2
        def end_=(value: Ptr[CUnsignedChar]): Unit = !struct.at2 = value
        def pointer: Ptr[CUnsignedChar] = struct._3
        def pointer_=(value: Ptr[CUnsignedChar]): Unit = !struct.at3 = value
        def last: Ptr[CUnsignedChar] = struct._4
        def last_=(value: Ptr[CUnsignedChar]): Unit = !struct.at4 = value

    /** The tokens queue.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct3 = CStruct4[Ptr[yaml_token_t], Ptr[yaml_token_t], Ptr[
      yaml_token_t
    ], Ptr[yaml_token_t]]
    object Struct3:
      given _tag: Tag[Struct3] = Tag.materializeCStruct4Tag[Ptr[
        yaml_token_t
      ], Ptr[yaml_token_t], Ptr[yaml_token_t], Ptr[yaml_token_t]]
      def apply()(using Zone): Ptr[Struct3] =
        scala.scalanative.unsafe.alloc[Struct3](1)
      def apply(
          start: Ptr[yaml_token_t],
          end: Ptr[yaml_token_t],
          head: Ptr[yaml_token_t],
          tail: Ptr[yaml_token_t]
      )(using Zone): Ptr[Struct3] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).head = head
        (!____ptr).tail = tail
        ____ptr
      extension (struct: Struct3)
        def start: Ptr[yaml_token_t] = struct._1
        def start_=(value: Ptr[yaml_token_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_token_t] = struct._2
        def end_=(value: Ptr[yaml_token_t]): Unit = !struct.at2 = value
        def head: Ptr[yaml_token_t] = struct._3
        def head_=(value: Ptr[yaml_token_t]): Unit = !struct.at3 = value
        def tail: Ptr[yaml_token_t] = struct._4
        def tail_=(value: Ptr[yaml_token_t]): Unit = !struct.at4 = value

    /** The indentation levels stack.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct4 = CStruct3[Ptr[CInt], Ptr[CInt], Ptr[CInt]]
    object Struct4:
      given _tag: Tag[Struct4] =
        Tag.materializeCStruct3Tag[Ptr[CInt], Ptr[CInt], Ptr[CInt]]
      def apply()(using Zone): Ptr[Struct4] =
        scala.scalanative.unsafe.alloc[Struct4](1)
      def apply(start: Ptr[CInt], end: Ptr[CInt], top: Ptr[CInt])(using
          Zone
      ): Ptr[Struct4] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct4)
        def start: Ptr[CInt] = struct._1
        def start_=(value: Ptr[CInt]): Unit = !struct.at1 = value
        def end: Ptr[CInt] = struct._2
        def end_=(value: Ptr[CInt]): Unit = !struct.at2 = value
        def top: Ptr[CInt] = struct._3
        def top_=(value: Ptr[CInt]): Unit = !struct.at3 = value

    /** The stack of simple keys.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct5 = CStruct3[Ptr[yaml_simple_key_t], Ptr[
      yaml_simple_key_t
    ], Ptr[yaml_simple_key_t]]
    object Struct5:
      given _tag: Tag[Struct5] = Tag.materializeCStruct3Tag[Ptr[
        yaml_simple_key_t
      ], Ptr[yaml_simple_key_t], Ptr[yaml_simple_key_t]]
      def apply()(using Zone): Ptr[Struct5] =
        scala.scalanative.unsafe.alloc[Struct5](1)
      def apply(
          start: Ptr[yaml_simple_key_t],
          end: Ptr[yaml_simple_key_t],
          top: Ptr[yaml_simple_key_t]
      )(using Zone): Ptr[Struct5] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct5)
        def start: Ptr[yaml_simple_key_t] = struct._1
        def start_=(value: Ptr[yaml_simple_key_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_simple_key_t] = struct._2
        def end_=(value: Ptr[yaml_simple_key_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_simple_key_t] = struct._3
        def top_=(value: Ptr[yaml_simple_key_t]): Unit = !struct.at3 = value

    /** The parser states stack.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct6 = CStruct3[Ptr[yaml_parser_state_t], Ptr[
      yaml_parser_state_t
    ], Ptr[yaml_parser_state_t]]
    object Struct6:
      given _tag: Tag[Struct6] = Tag.materializeCStruct3Tag[Ptr[
        yaml_parser_state_t
      ], Ptr[yaml_parser_state_t], Ptr[yaml_parser_state_t]]
      def apply()(using Zone): Ptr[Struct6] =
        scala.scalanative.unsafe.alloc[Struct6](1)
      def apply(
          start: Ptr[yaml_parser_state_t],
          end: Ptr[yaml_parser_state_t],
          top: Ptr[yaml_parser_state_t]
      )(using Zone): Ptr[Struct6] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct6)
        def start: Ptr[yaml_parser_state_t] = struct._1
        def start_=(value: Ptr[yaml_parser_state_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_parser_state_t] = struct._2
        def end_=(value: Ptr[yaml_parser_state_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_parser_state_t] = struct._3
        def top_=(value: Ptr[yaml_parser_state_t]): Unit = !struct.at3 = value

    /** The stack of marks.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct7 =
      CStruct3[Ptr[yaml_mark_t], Ptr[yaml_mark_t], Ptr[yaml_mark_t]]
    object Struct7:
      given _tag: Tag[Struct7] = Tag.materializeCStruct3Tag[Ptr[
        yaml_mark_t
      ], Ptr[yaml_mark_t], Ptr[yaml_mark_t]]
      def apply()(using Zone): Ptr[Struct7] =
        scala.scalanative.unsafe.alloc[Struct7](1)
      def apply(
          start: Ptr[yaml_mark_t],
          end: Ptr[yaml_mark_t],
          top: Ptr[yaml_mark_t]
      )(using Zone): Ptr[Struct7] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct7)
        def start: Ptr[yaml_mark_t] = struct._1
        def start_=(value: Ptr[yaml_mark_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_mark_t] = struct._2
        def end_=(value: Ptr[yaml_mark_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_mark_t] = struct._3
        def top_=(value: Ptr[yaml_mark_t]): Unit = !struct.at3 = value

    /** The list of TAG directives.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct8 = CStruct3[Ptr[yaml_tag_directive_t], Ptr[
      yaml_tag_directive_t
    ], Ptr[yaml_tag_directive_t]]
    object Struct8:
      given _tag: Tag[Struct8] = Tag.materializeCStruct3Tag[Ptr[
        yaml_tag_directive_t
      ], Ptr[yaml_tag_directive_t], Ptr[yaml_tag_directive_t]]
      def apply()(using Zone): Ptr[Struct8] =
        scala.scalanative.unsafe.alloc[Struct8](1)
      def apply(
          start: Ptr[yaml_tag_directive_t],
          end: Ptr[yaml_tag_directive_t],
          top: Ptr[yaml_tag_directive_t]
      )(using Zone): Ptr[Struct8] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct8)
        def start: Ptr[yaml_tag_directive_t] = struct._1
        def start_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at1 =
          value
        def end: Ptr[yaml_tag_directive_t] = struct._2
        def end_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_tag_directive_t] = struct._3
        def top_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at3 = value

    /** The alias data.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct9 = CStruct3[Ptr[yaml_alias_data_t], Ptr[
      yaml_alias_data_t
    ], Ptr[yaml_alias_data_t]]
    object Struct9:
      given _tag: Tag[Struct9] = Tag.materializeCStruct3Tag[Ptr[
        yaml_alias_data_t
      ], Ptr[yaml_alias_data_t], Ptr[yaml_alias_data_t]]
      def apply()(using Zone): Ptr[Struct9] =
        scala.scalanative.unsafe.alloc[Struct9](1)
      def apply(
          start: Ptr[yaml_alias_data_t],
          end: Ptr[yaml_alias_data_t],
          top: Ptr[yaml_alias_data_t]
      )(using Zone): Ptr[Struct9] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct9)
        def start: Ptr[yaml_alias_data_t] = struct._1
        def start_=(value: Ptr[yaml_alias_data_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_alias_data_t] = struct._2
        def end_=(value: Ptr[yaml_alias_data_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_alias_data_t] = struct._3
        def top_=(value: Ptr[yaml_alias_data_t]): Unit = !struct.at3 = value
    given _tag: Tag[yaml_parser_s] =
      Tag.CArray[CChar, Nat.Digit3[Nat._4, Nat._8, Nat._0]](
        Tag.Byte,
        Tag.Digit3[Nat._4, Nat._8, Nat._0](Tag.Nat4, Tag.Nat8, Tag.Nat0)
      )
    def apply()(using Zone): Ptr[yaml_parser_s] =
      scala.scalanative.unsafe.alloc[yaml_parser_s](1)
    def apply(
        error: yaml_error_type_t,
        problem: CString,
        problem_offset: size_t,
        problem_value: CInt,
        problem_mark: yaml_mark_t,
        context: CString,
        context_mark: yaml_mark_t,
        read_handler: Ptr[yaml_read_handler_t],
        read_handler_data: Ptr[Byte],
        input: yaml_parser_s.Union0,
        eof: CInt,
        buffer: yaml_parser_s.Struct1,
        unread: size_t,
        raw_buffer: yaml_parser_s.Struct2,
        encoding: yaml_encoding_t,
        offset: size_t,
        mark: yaml_mark_t,
        stream_start_produced: CInt,
        stream_end_produced: CInt,
        flow_level: CInt,
        tokens: yaml_parser_s.Struct3,
        tokens_parsed: size_t,
        token_available: CInt,
        indents: yaml_parser_s.Struct4,
        indent: CInt,
        simple_key_allowed: CInt,
        simple_keys: yaml_parser_s.Struct5,
        states: yaml_parser_s.Struct6,
        state: yaml_parser_state_t,
        marks: yaml_parser_s.Struct7,
        tag_directives: yaml_parser_s.Struct8,
        aliases: yaml_parser_s.Struct9,
        document: Ptr[yaml_document_t]
    )(using Zone): Ptr[yaml_parser_s] =
      val ____ptr = apply()
      (!____ptr).error = error
      (!____ptr).problem = problem
      (!____ptr).problem_offset = problem_offset
      (!____ptr).problem_value = problem_value
      (!____ptr).problem_mark = problem_mark
      (!____ptr).context = context
      (!____ptr).context_mark = context_mark
      (!____ptr).read_handler = read_handler
      (!____ptr).read_handler_data = read_handler_data
      (!____ptr).input = input
      (!____ptr).eof = eof
      (!____ptr).buffer = buffer
      (!____ptr).unread = unread
      (!____ptr).raw_buffer = raw_buffer
      (!____ptr).encoding = encoding
      (!____ptr).offset = offset
      (!____ptr).mark = mark
      (!____ptr).stream_start_produced = stream_start_produced
      (!____ptr).stream_end_produced = stream_end_produced
      (!____ptr).flow_level = flow_level
      (!____ptr).tokens = tokens
      (!____ptr).tokens_parsed = tokens_parsed
      (!____ptr).token_available = token_available
      (!____ptr).indents = indents
      (!____ptr).indent = indent
      (!____ptr).simple_key_allowed = simple_key_allowed
      (!____ptr).simple_keys = simple_keys
      (!____ptr).states = states
      (!____ptr).state = state
      (!____ptr).marks = marks
      (!____ptr).tag_directives = tag_directives
      (!____ptr).aliases = aliases
      (!____ptr).document = document
      ____ptr
    extension (struct: yaml_parser_s)
      def error: yaml_error_type_t =
        !struct.at(0).asInstanceOf[Ptr[yaml_error_type_t]]
      def error_=(value: yaml_error_type_t): Unit =
        !struct.at(0).asInstanceOf[Ptr[yaml_error_type_t]] = value
      def problem: CString = !struct.at(8).asInstanceOf[Ptr[CString]]
      def problem_=(value: CString): Unit =
        !struct.at(8).asInstanceOf[Ptr[CString]] = value
      def problem_offset: size_t = !struct.at(16).asInstanceOf[Ptr[size_t]]
      def problem_offset_=(value: size_t): Unit =
        !struct.at(16).asInstanceOf[Ptr[size_t]] = value
      def problem_value: CInt = !struct.at(24).asInstanceOf[Ptr[CInt]]
      def problem_value_=(value: CInt): Unit =
        !struct.at(24).asInstanceOf[Ptr[CInt]] = value
      def problem_mark: yaml_mark_t =
        !struct.at(32).asInstanceOf[Ptr[yaml_mark_t]]
      def problem_mark_=(value: yaml_mark_t): Unit =
        !struct.at(32).asInstanceOf[Ptr[yaml_mark_t]] = value
      def context: CString = !struct.at(56).asInstanceOf[Ptr[CString]]
      def context_=(value: CString): Unit =
        !struct.at(56).asInstanceOf[Ptr[CString]] = value
      def context_mark: yaml_mark_t =
        !struct.at(64).asInstanceOf[Ptr[yaml_mark_t]]
      def context_mark_=(value: yaml_mark_t): Unit =
        !struct.at(64).asInstanceOf[Ptr[yaml_mark_t]] = value
      def read_handler: Ptr[yaml_read_handler_t] =
        !struct.at(88).asInstanceOf[Ptr[Ptr[yaml_read_handler_t]]]
      def read_handler_=(value: Ptr[yaml_read_handler_t]): Unit =
        !struct.at(88).asInstanceOf[Ptr[Ptr[yaml_read_handler_t]]] = value
      def read_handler_data: Ptr[Byte] =
        !struct.at(96).asInstanceOf[Ptr[Ptr[Byte]]]
      def read_handler_data_=(value: Ptr[Byte]): Unit =
        !struct.at(96).asInstanceOf[Ptr[Ptr[Byte]]] = value
      def input: yaml_parser_s.Union0 =
        !struct.at(104).asInstanceOf[Ptr[yaml_parser_s.Union0]]
      def input_=(value: yaml_parser_s.Union0): Unit =
        !struct.at(104).asInstanceOf[Ptr[yaml_parser_s.Union0]] = value
      def eof: CInt = !struct.at(128).asInstanceOf[Ptr[CInt]]
      def eof_=(value: CInt): Unit = !struct.at(128).asInstanceOf[Ptr[CInt]] =
        value
      def buffer: yaml_parser_s.Struct1 =
        !struct.at(136).asInstanceOf[Ptr[yaml_parser_s.Struct1]]
      def buffer_=(value: yaml_parser_s.Struct1): Unit =
        !struct.at(136).asInstanceOf[Ptr[yaml_parser_s.Struct1]] = value
      def unread: size_t = !struct.at(168).asInstanceOf[Ptr[size_t]]
      def unread_=(value: size_t): Unit =
        !struct.at(168).asInstanceOf[Ptr[size_t]] = value
      def raw_buffer: yaml_parser_s.Struct2 =
        !struct.at(176).asInstanceOf[Ptr[yaml_parser_s.Struct2]]
      def raw_buffer_=(value: yaml_parser_s.Struct2): Unit =
        !struct.at(176).asInstanceOf[Ptr[yaml_parser_s.Struct2]] = value
      def encoding: yaml_encoding_t =
        !struct.at(208).asInstanceOf[Ptr[yaml_encoding_t]]
      def encoding_=(value: yaml_encoding_t): Unit =
        !struct.at(208).asInstanceOf[Ptr[yaml_encoding_t]] = value
      def offset: size_t = !struct.at(216).asInstanceOf[Ptr[size_t]]
      def offset_=(value: size_t): Unit =
        !struct.at(216).asInstanceOf[Ptr[size_t]] = value
      def mark: yaml_mark_t = !struct.at(224).asInstanceOf[Ptr[yaml_mark_t]]
      def mark_=(value: yaml_mark_t): Unit =
        !struct.at(224).asInstanceOf[Ptr[yaml_mark_t]] = value
      def stream_start_produced: CInt = !struct.at(248).asInstanceOf[Ptr[CInt]]
      def stream_start_produced_=(value: CInt): Unit =
        !struct.at(248).asInstanceOf[Ptr[CInt]] = value
      def stream_end_produced: CInt = !struct.at(252).asInstanceOf[Ptr[CInt]]
      def stream_end_produced_=(value: CInt): Unit =
        !struct.at(252).asInstanceOf[Ptr[CInt]] = value
      def flow_level: CInt = !struct.at(256).asInstanceOf[Ptr[CInt]]
      def flow_level_=(value: CInt): Unit =
        !struct.at(256).asInstanceOf[Ptr[CInt]] = value
      def tokens: yaml_parser_s.Struct3 =
        !struct.at(264).asInstanceOf[Ptr[yaml_parser_s.Struct3]]
      def tokens_=(value: yaml_parser_s.Struct3): Unit =
        !struct.at(264).asInstanceOf[Ptr[yaml_parser_s.Struct3]] = value
      def tokens_parsed: size_t = !struct.at(296).asInstanceOf[Ptr[size_t]]
      def tokens_parsed_=(value: size_t): Unit =
        !struct.at(296).asInstanceOf[Ptr[size_t]] = value
      def token_available: CInt = !struct.at(304).asInstanceOf[Ptr[CInt]]
      def token_available_=(value: CInt): Unit =
        !struct.at(304).asInstanceOf[Ptr[CInt]] = value
      def indents: yaml_parser_s.Struct4 =
        !struct.at(312).asInstanceOf[Ptr[yaml_parser_s.Struct4]]
      def indents_=(value: yaml_parser_s.Struct4): Unit =
        !struct.at(312).asInstanceOf[Ptr[yaml_parser_s.Struct4]] = value
      def indent: CInt = !struct.at(336).asInstanceOf[Ptr[CInt]]
      def indent_=(value: CInt): Unit =
        !struct.at(336).asInstanceOf[Ptr[CInt]] = value
      def simple_key_allowed: CInt = !struct.at(340).asInstanceOf[Ptr[CInt]]
      def simple_key_allowed_=(value: CInt): Unit =
        !struct.at(340).asInstanceOf[Ptr[CInt]] = value
      def simple_keys: yaml_parser_s.Struct5 =
        !struct.at(344).asInstanceOf[Ptr[yaml_parser_s.Struct5]]
      def simple_keys_=(value: yaml_parser_s.Struct5): Unit =
        !struct.at(344).asInstanceOf[Ptr[yaml_parser_s.Struct5]] = value
      def states: yaml_parser_s.Struct6 =
        !struct.at(368).asInstanceOf[Ptr[yaml_parser_s.Struct6]]
      def states_=(value: yaml_parser_s.Struct6): Unit =
        !struct.at(368).asInstanceOf[Ptr[yaml_parser_s.Struct6]] = value
      def state: yaml_parser_state_t =
        !struct.at(392).asInstanceOf[Ptr[yaml_parser_state_t]]
      def state_=(value: yaml_parser_state_t): Unit =
        !struct.at(392).asInstanceOf[Ptr[yaml_parser_state_t]] = value
      def marks: yaml_parser_s.Struct7 =
        !struct.at(400).asInstanceOf[Ptr[yaml_parser_s.Struct7]]
      def marks_=(value: yaml_parser_s.Struct7): Unit =
        !struct.at(400).asInstanceOf[Ptr[yaml_parser_s.Struct7]] = value
      def tag_directives: yaml_parser_s.Struct8 =
        !struct.at(424).asInstanceOf[Ptr[yaml_parser_s.Struct8]]
      def tag_directives_=(value: yaml_parser_s.Struct8): Unit =
        !struct.at(424).asInstanceOf[Ptr[yaml_parser_s.Struct8]] = value
      def aliases: yaml_parser_s.Struct9 =
        !struct.at(448).asInstanceOf[Ptr[yaml_parser_s.Struct9]]
      def aliases_=(value: yaml_parser_s.Struct9): Unit =
        !struct.at(448).asInstanceOf[Ptr[yaml_parser_s.Struct9]] = value
      def document: Ptr[yaml_document_t] =
        !struct.at(472).asInstanceOf[Ptr[Ptr[yaml_document_t]]]
      def document_=(value: Ptr[yaml_document_t]): Unit =
        !struct.at(472).asInstanceOf[Ptr[Ptr[yaml_document_t]]] = value

  /** The parser structure.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_parser_t = CArray[CChar, Nat.Digit3[Nat._4, Nat._8, Nat._0]]
  object yaml_parser_t:
    /** Standard (string or file) input data.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Union0 = CArray[Byte, Nat.Digit2[Nat._2, Nat._4]]
    object Union0:
      /** String input data.
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct0 =
        CStruct3[Ptr[CUnsignedChar], Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
      object Struct0:
        given _tag: Tag[Struct0] = Tag.materializeCStruct3Tag[Ptr[
          CUnsignedChar
        ], Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
        def apply()(using Zone): Ptr[Struct0] =
          scala.scalanative.unsafe.alloc[Struct0](1)
        def apply(
            start: Ptr[CUnsignedChar],
            end: Ptr[CUnsignedChar],
            current: Ptr[CUnsignedChar]
        )(using Zone): Ptr[Struct0] =
          val ____ptr = apply()
          (!____ptr).start = start
          (!____ptr).end = end
          (!____ptr).current = current
          ____ptr
        extension (struct: Struct0)
          def start: Ptr[CUnsignedChar] = struct._1
          def start_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
          def end: Ptr[CUnsignedChar] = struct._2
          def end_=(value: Ptr[CUnsignedChar]): Unit = !struct.at2 = value
          def current: Ptr[CUnsignedChar] = struct._3
          def current_=(value: Ptr[CUnsignedChar]): Unit = !struct.at3 = value
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat.Digit2[Nat._2, Nat._4]](
        Tag.Byte,
        Tag.Digit2[Nat._2, Nat._4](Tag.Nat2, Tag.Nat4)
      )
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_string")
      def apply(string: yaml_parser_t.Union0.Struct0)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_parser_t.Union0.Struct0]]
          .update(0, string)
        ___ptr
      @scala.annotation.targetName("apply_file")
      def apply(file: Ptr[FILE])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FILE]]].update(0, file)
        ___ptr
      extension (struct: Union0)
        def string: yaml_parser_t.Union0.Struct0 =
          !struct.at(0).asInstanceOf[Ptr[yaml_parser_t.Union0.Struct0]]
        def string_=(value: yaml_parser_t.Union0.Struct0): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_parser_t.Union0.Struct0]] = value
        def file: Ptr[FILE] = !struct.at(0).asInstanceOf[Ptr[Ptr[FILE]]]
        def file_=(value: Ptr[FILE]): Unit =
          !struct.at(0).asInstanceOf[Ptr[Ptr[FILE]]] = value

    /** The working buffer.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct1 = CStruct4[Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[
      yaml_char_t
    ], Ptr[yaml_char_t]]
    object Struct1:
      given _tag: Tag[Struct1] = Tag.materializeCStruct4Tag[Ptr[
        yaml_char_t
      ], Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[yaml_char_t]]
      def apply()(using Zone): Ptr[Struct1] =
        scala.scalanative.unsafe.alloc[Struct1](1)
      def apply(
          start: Ptr[yaml_char_t],
          end: Ptr[yaml_char_t],
          pointer: Ptr[yaml_char_t],
          last: Ptr[yaml_char_t]
      )(using Zone): Ptr[Struct1] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).pointer = pointer
        (!____ptr).last = last
        ____ptr
      extension (struct: Struct1)
        def start: Ptr[yaml_char_t] = struct._1
        def start_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_char_t] = struct._2
        def end_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
        def pointer: Ptr[yaml_char_t] = struct._3
        def pointer_=(value: Ptr[yaml_char_t]): Unit = !struct.at3 = value
        def last: Ptr[yaml_char_t] = struct._4
        def last_=(value: Ptr[yaml_char_t]): Unit = !struct.at4 = value

    /** The raw buffer.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct2 = CStruct4[Ptr[CUnsignedChar], Ptr[CUnsignedChar], Ptr[
      CUnsignedChar
    ], Ptr[CUnsignedChar]]
    object Struct2:
      given _tag: Tag[Struct2] = Tag.materializeCStruct4Tag[Ptr[
        CUnsignedChar
      ], Ptr[CUnsignedChar], Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
      def apply()(using Zone): Ptr[Struct2] =
        scala.scalanative.unsafe.alloc[Struct2](1)
      def apply(
          start: Ptr[CUnsignedChar],
          end: Ptr[CUnsignedChar],
          pointer: Ptr[CUnsignedChar],
          last: Ptr[CUnsignedChar]
      )(using Zone): Ptr[Struct2] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).pointer = pointer
        (!____ptr).last = last
        ____ptr
      extension (struct: Struct2)
        def start: Ptr[CUnsignedChar] = struct._1
        def start_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
        def end: Ptr[CUnsignedChar] = struct._2
        def end_=(value: Ptr[CUnsignedChar]): Unit = !struct.at2 = value
        def pointer: Ptr[CUnsignedChar] = struct._3
        def pointer_=(value: Ptr[CUnsignedChar]): Unit = !struct.at3 = value
        def last: Ptr[CUnsignedChar] = struct._4
        def last_=(value: Ptr[CUnsignedChar]): Unit = !struct.at4 = value

    /** The tokens queue.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct3 = CStruct4[Ptr[yaml_token_t], Ptr[yaml_token_t], Ptr[
      yaml_token_t
    ], Ptr[yaml_token_t]]
    object Struct3:
      given _tag: Tag[Struct3] = Tag.materializeCStruct4Tag[Ptr[
        yaml_token_t
      ], Ptr[yaml_token_t], Ptr[yaml_token_t], Ptr[yaml_token_t]]
      def apply()(using Zone): Ptr[Struct3] =
        scala.scalanative.unsafe.alloc[Struct3](1)
      def apply(
          start: Ptr[yaml_token_t],
          end: Ptr[yaml_token_t],
          head: Ptr[yaml_token_t],
          tail: Ptr[yaml_token_t]
      )(using Zone): Ptr[Struct3] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).head = head
        (!____ptr).tail = tail
        ____ptr
      extension (struct: Struct3)
        def start: Ptr[yaml_token_t] = struct._1
        def start_=(value: Ptr[yaml_token_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_token_t] = struct._2
        def end_=(value: Ptr[yaml_token_t]): Unit = !struct.at2 = value
        def head: Ptr[yaml_token_t] = struct._3
        def head_=(value: Ptr[yaml_token_t]): Unit = !struct.at3 = value
        def tail: Ptr[yaml_token_t] = struct._4
        def tail_=(value: Ptr[yaml_token_t]): Unit = !struct.at4 = value

    /** The indentation levels stack.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct4 = CStruct3[Ptr[CInt], Ptr[CInt], Ptr[CInt]]
    object Struct4:
      given _tag: Tag[Struct4] =
        Tag.materializeCStruct3Tag[Ptr[CInt], Ptr[CInt], Ptr[CInt]]
      def apply()(using Zone): Ptr[Struct4] =
        scala.scalanative.unsafe.alloc[Struct4](1)
      def apply(start: Ptr[CInt], end: Ptr[CInt], top: Ptr[CInt])(using
          Zone
      ): Ptr[Struct4] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct4)
        def start: Ptr[CInt] = struct._1
        def start_=(value: Ptr[CInt]): Unit = !struct.at1 = value
        def end: Ptr[CInt] = struct._2
        def end_=(value: Ptr[CInt]): Unit = !struct.at2 = value
        def top: Ptr[CInt] = struct._3
        def top_=(value: Ptr[CInt]): Unit = !struct.at3 = value

    /** The stack of simple keys.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct5 = CStruct3[Ptr[yaml_simple_key_t], Ptr[
      yaml_simple_key_t
    ], Ptr[yaml_simple_key_t]]
    object Struct5:
      given _tag: Tag[Struct5] = Tag.materializeCStruct3Tag[Ptr[
        yaml_simple_key_t
      ], Ptr[yaml_simple_key_t], Ptr[yaml_simple_key_t]]
      def apply()(using Zone): Ptr[Struct5] =
        scala.scalanative.unsafe.alloc[Struct5](1)
      def apply(
          start: Ptr[yaml_simple_key_t],
          end: Ptr[yaml_simple_key_t],
          top: Ptr[yaml_simple_key_t]
      )(using Zone): Ptr[Struct5] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct5)
        def start: Ptr[yaml_simple_key_t] = struct._1
        def start_=(value: Ptr[yaml_simple_key_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_simple_key_t] = struct._2
        def end_=(value: Ptr[yaml_simple_key_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_simple_key_t] = struct._3
        def top_=(value: Ptr[yaml_simple_key_t]): Unit = !struct.at3 = value

    /** The parser states stack.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct6 = CStruct3[Ptr[yaml_parser_state_t], Ptr[
      yaml_parser_state_t
    ], Ptr[yaml_parser_state_t]]
    object Struct6:
      given _tag: Tag[Struct6] = Tag.materializeCStruct3Tag[Ptr[
        yaml_parser_state_t
      ], Ptr[yaml_parser_state_t], Ptr[yaml_parser_state_t]]
      def apply()(using Zone): Ptr[Struct6] =
        scala.scalanative.unsafe.alloc[Struct6](1)
      def apply(
          start: Ptr[yaml_parser_state_t],
          end: Ptr[yaml_parser_state_t],
          top: Ptr[yaml_parser_state_t]
      )(using Zone): Ptr[Struct6] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct6)
        def start: Ptr[yaml_parser_state_t] = struct._1
        def start_=(value: Ptr[yaml_parser_state_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_parser_state_t] = struct._2
        def end_=(value: Ptr[yaml_parser_state_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_parser_state_t] = struct._3
        def top_=(value: Ptr[yaml_parser_state_t]): Unit = !struct.at3 = value

    /** The stack of marks.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct7 =
      CStruct3[Ptr[yaml_mark_t], Ptr[yaml_mark_t], Ptr[yaml_mark_t]]
    object Struct7:
      given _tag: Tag[Struct7] = Tag.materializeCStruct3Tag[Ptr[
        yaml_mark_t
      ], Ptr[yaml_mark_t], Ptr[yaml_mark_t]]
      def apply()(using Zone): Ptr[Struct7] =
        scala.scalanative.unsafe.alloc[Struct7](1)
      def apply(
          start: Ptr[yaml_mark_t],
          end: Ptr[yaml_mark_t],
          top: Ptr[yaml_mark_t]
      )(using Zone): Ptr[Struct7] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct7)
        def start: Ptr[yaml_mark_t] = struct._1
        def start_=(value: Ptr[yaml_mark_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_mark_t] = struct._2
        def end_=(value: Ptr[yaml_mark_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_mark_t] = struct._3
        def top_=(value: Ptr[yaml_mark_t]): Unit = !struct.at3 = value

    /** The list of TAG directives.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct8 = CStruct3[Ptr[yaml_tag_directive_t], Ptr[
      yaml_tag_directive_t
    ], Ptr[yaml_tag_directive_t]]
    object Struct8:
      given _tag: Tag[Struct8] = Tag.materializeCStruct3Tag[Ptr[
        yaml_tag_directive_t
      ], Ptr[yaml_tag_directive_t], Ptr[yaml_tag_directive_t]]
      def apply()(using Zone): Ptr[Struct8] =
        scala.scalanative.unsafe.alloc[Struct8](1)
      def apply(
          start: Ptr[yaml_tag_directive_t],
          end: Ptr[yaml_tag_directive_t],
          top: Ptr[yaml_tag_directive_t]
      )(using Zone): Ptr[Struct8] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct8)
        def start: Ptr[yaml_tag_directive_t] = struct._1
        def start_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at1 =
          value
        def end: Ptr[yaml_tag_directive_t] = struct._2
        def end_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_tag_directive_t] = struct._3
        def top_=(value: Ptr[yaml_tag_directive_t]): Unit = !struct.at3 = value

    /** The alias data.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Struct9 = CStruct3[Ptr[yaml_alias_data_t], Ptr[
      yaml_alias_data_t
    ], Ptr[yaml_alias_data_t]]
    object Struct9:
      given _tag: Tag[Struct9] = Tag.materializeCStruct3Tag[Ptr[
        yaml_alias_data_t
      ], Ptr[yaml_alias_data_t], Ptr[yaml_alias_data_t]]
      def apply()(using Zone): Ptr[Struct9] =
        scala.scalanative.unsafe.alloc[Struct9](1)
      def apply(
          start: Ptr[yaml_alias_data_t],
          end: Ptr[yaml_alias_data_t],
          top: Ptr[yaml_alias_data_t]
      )(using Zone): Ptr[Struct9] =
        val ____ptr = apply()
        (!____ptr).start = start
        (!____ptr).end = end
        (!____ptr).top = top
        ____ptr
      extension (struct: Struct9)
        def start: Ptr[yaml_alias_data_t] = struct._1
        def start_=(value: Ptr[yaml_alias_data_t]): Unit = !struct.at1 = value
        def end: Ptr[yaml_alias_data_t] = struct._2
        def end_=(value: Ptr[yaml_alias_data_t]): Unit = !struct.at2 = value
        def top: Ptr[yaml_alias_data_t] = struct._3
        def top_=(value: Ptr[yaml_alias_data_t]): Unit = !struct.at3 = value
    given _tag: Tag[yaml_parser_t] =
      Tag.CArray[CChar, Nat.Digit3[Nat._4, Nat._8, Nat._0]](
        Tag.Byte,
        Tag.Digit3[Nat._4, Nat._8, Nat._0](Tag.Nat4, Tag.Nat8, Tag.Nat0)
      )
    def apply()(using Zone): Ptr[yaml_parser_t] =
      scala.scalanative.unsafe.alloc[yaml_parser_t](1)
    def apply(
        error: yaml_error_type_t,
        problem: CString,
        problem_offset: size_t,
        problem_value: CInt,
        problem_mark: yaml_mark_t,
        context: CString,
        context_mark: yaml_mark_t,
        read_handler: Ptr[yaml_read_handler_t],
        read_handler_data: Ptr[Byte],
        input: yaml_parser_t.Union0,
        eof: CInt,
        buffer: yaml_parser_t.Struct1,
        unread: size_t,
        raw_buffer: yaml_parser_t.Struct2,
        encoding: yaml_encoding_t,
        offset: size_t,
        mark: yaml_mark_t,
        stream_start_produced: CInt,
        stream_end_produced: CInt,
        flow_level: CInt,
        tokens: yaml_parser_t.Struct3,
        tokens_parsed: size_t,
        token_available: CInt,
        indents: yaml_parser_t.Struct4,
        indent: CInt,
        simple_key_allowed: CInt,
        simple_keys: yaml_parser_t.Struct5,
        states: yaml_parser_t.Struct6,
        state: yaml_parser_state_t,
        marks: yaml_parser_t.Struct7,
        tag_directives: yaml_parser_t.Struct8,
        aliases: yaml_parser_t.Struct9,
        document: Ptr[yaml_document_t]
    )(using Zone): Ptr[yaml_parser_t] =
      val ____ptr = apply()
      (!____ptr).error = error
      (!____ptr).problem = problem
      (!____ptr).problem_offset = problem_offset
      (!____ptr).problem_value = problem_value
      (!____ptr).problem_mark = problem_mark
      (!____ptr).context = context
      (!____ptr).context_mark = context_mark
      (!____ptr).read_handler = read_handler
      (!____ptr).read_handler_data = read_handler_data
      (!____ptr).input = input
      (!____ptr).eof = eof
      (!____ptr).buffer = buffer
      (!____ptr).unread = unread
      (!____ptr).raw_buffer = raw_buffer
      (!____ptr).encoding = encoding
      (!____ptr).offset = offset
      (!____ptr).mark = mark
      (!____ptr).stream_start_produced = stream_start_produced
      (!____ptr).stream_end_produced = stream_end_produced
      (!____ptr).flow_level = flow_level
      (!____ptr).tokens = tokens
      (!____ptr).tokens_parsed = tokens_parsed
      (!____ptr).token_available = token_available
      (!____ptr).indents = indents
      (!____ptr).indent = indent
      (!____ptr).simple_key_allowed = simple_key_allowed
      (!____ptr).simple_keys = simple_keys
      (!____ptr).states = states
      (!____ptr).state = state
      (!____ptr).marks = marks
      (!____ptr).tag_directives = tag_directives
      (!____ptr).aliases = aliases
      (!____ptr).document = document
      ____ptr
    extension (struct: yaml_parser_t)
      def error: yaml_error_type_t =
        !struct.at(0).asInstanceOf[Ptr[yaml_error_type_t]]
      def error_=(value: yaml_error_type_t): Unit =
        !struct.at(0).asInstanceOf[Ptr[yaml_error_type_t]] = value
      def problem: CString = !struct.at(8).asInstanceOf[Ptr[CString]]
      def problem_=(value: CString): Unit =
        !struct.at(8).asInstanceOf[Ptr[CString]] = value
      def problem_offset: size_t = !struct.at(16).asInstanceOf[Ptr[size_t]]
      def problem_offset_=(value: size_t): Unit =
        !struct.at(16).asInstanceOf[Ptr[size_t]] = value
      def problem_value: CInt = !struct.at(24).asInstanceOf[Ptr[CInt]]
      def problem_value_=(value: CInt): Unit =
        !struct.at(24).asInstanceOf[Ptr[CInt]] = value
      def problem_mark: yaml_mark_t =
        !struct.at(32).asInstanceOf[Ptr[yaml_mark_t]]
      def problem_mark_=(value: yaml_mark_t): Unit =
        !struct.at(32).asInstanceOf[Ptr[yaml_mark_t]] = value
      def context: CString = !struct.at(56).asInstanceOf[Ptr[CString]]
      def context_=(value: CString): Unit =
        !struct.at(56).asInstanceOf[Ptr[CString]] = value
      def context_mark: yaml_mark_t =
        !struct.at(64).asInstanceOf[Ptr[yaml_mark_t]]
      def context_mark_=(value: yaml_mark_t): Unit =
        !struct.at(64).asInstanceOf[Ptr[yaml_mark_t]] = value
      def read_handler: Ptr[yaml_read_handler_t] =
        !struct.at(88).asInstanceOf[Ptr[Ptr[yaml_read_handler_t]]]
      def read_handler_=(value: Ptr[yaml_read_handler_t]): Unit =
        !struct.at(88).asInstanceOf[Ptr[Ptr[yaml_read_handler_t]]] = value
      def read_handler_data: Ptr[Byte] =
        !struct.at(96).asInstanceOf[Ptr[Ptr[Byte]]]
      def read_handler_data_=(value: Ptr[Byte]): Unit =
        !struct.at(96).asInstanceOf[Ptr[Ptr[Byte]]] = value
      def input: yaml_parser_t.Union0 =
        !struct.at(104).asInstanceOf[Ptr[yaml_parser_t.Union0]]
      def input_=(value: yaml_parser_t.Union0): Unit =
        !struct.at(104).asInstanceOf[Ptr[yaml_parser_t.Union0]] = value
      def eof: CInt = !struct.at(128).asInstanceOf[Ptr[CInt]]
      def eof_=(value: CInt): Unit = !struct.at(128).asInstanceOf[Ptr[CInt]] =
        value
      def buffer: yaml_parser_t.Struct1 =
        !struct.at(136).asInstanceOf[Ptr[yaml_parser_t.Struct1]]
      def buffer_=(value: yaml_parser_t.Struct1): Unit =
        !struct.at(136).asInstanceOf[Ptr[yaml_parser_t.Struct1]] = value
      def unread: size_t = !struct.at(168).asInstanceOf[Ptr[size_t]]
      def unread_=(value: size_t): Unit =
        !struct.at(168).asInstanceOf[Ptr[size_t]] = value
      def raw_buffer: yaml_parser_t.Struct2 =
        !struct.at(176).asInstanceOf[Ptr[yaml_parser_t.Struct2]]
      def raw_buffer_=(value: yaml_parser_t.Struct2): Unit =
        !struct.at(176).asInstanceOf[Ptr[yaml_parser_t.Struct2]] = value
      def encoding: yaml_encoding_t =
        !struct.at(208).asInstanceOf[Ptr[yaml_encoding_t]]
      def encoding_=(value: yaml_encoding_t): Unit =
        !struct.at(208).asInstanceOf[Ptr[yaml_encoding_t]] = value
      def offset: size_t = !struct.at(216).asInstanceOf[Ptr[size_t]]
      def offset_=(value: size_t): Unit =
        !struct.at(216).asInstanceOf[Ptr[size_t]] = value
      def mark: yaml_mark_t = !struct.at(224).asInstanceOf[Ptr[yaml_mark_t]]
      def mark_=(value: yaml_mark_t): Unit =
        !struct.at(224).asInstanceOf[Ptr[yaml_mark_t]] = value
      def stream_start_produced: CInt = !struct.at(248).asInstanceOf[Ptr[CInt]]
      def stream_start_produced_=(value: CInt): Unit =
        !struct.at(248).asInstanceOf[Ptr[CInt]] = value
      def stream_end_produced: CInt = !struct.at(252).asInstanceOf[Ptr[CInt]]
      def stream_end_produced_=(value: CInt): Unit =
        !struct.at(252).asInstanceOf[Ptr[CInt]] = value
      def flow_level: CInt = !struct.at(256).asInstanceOf[Ptr[CInt]]
      def flow_level_=(value: CInt): Unit =
        !struct.at(256).asInstanceOf[Ptr[CInt]] = value
      def tokens: yaml_parser_t.Struct3 =
        !struct.at(264).asInstanceOf[Ptr[yaml_parser_t.Struct3]]
      def tokens_=(value: yaml_parser_t.Struct3): Unit =
        !struct.at(264).asInstanceOf[Ptr[yaml_parser_t.Struct3]] = value
      def tokens_parsed: size_t = !struct.at(296).asInstanceOf[Ptr[size_t]]
      def tokens_parsed_=(value: size_t): Unit =
        !struct.at(296).asInstanceOf[Ptr[size_t]] = value
      def token_available: CInt = !struct.at(304).asInstanceOf[Ptr[CInt]]
      def token_available_=(value: CInt): Unit =
        !struct.at(304).asInstanceOf[Ptr[CInt]] = value
      def indents: yaml_parser_t.Struct4 =
        !struct.at(312).asInstanceOf[Ptr[yaml_parser_t.Struct4]]
      def indents_=(value: yaml_parser_t.Struct4): Unit =
        !struct.at(312).asInstanceOf[Ptr[yaml_parser_t.Struct4]] = value
      def indent: CInt = !struct.at(336).asInstanceOf[Ptr[CInt]]
      def indent_=(value: CInt): Unit =
        !struct.at(336).asInstanceOf[Ptr[CInt]] = value
      def simple_key_allowed: CInt = !struct.at(340).asInstanceOf[Ptr[CInt]]
      def simple_key_allowed_=(value: CInt): Unit =
        !struct.at(340).asInstanceOf[Ptr[CInt]] = value
      def simple_keys: yaml_parser_t.Struct5 =
        !struct.at(344).asInstanceOf[Ptr[yaml_parser_t.Struct5]]
      def simple_keys_=(value: yaml_parser_t.Struct5): Unit =
        !struct.at(344).asInstanceOf[Ptr[yaml_parser_t.Struct5]] = value
      def states: yaml_parser_t.Struct6 =
        !struct.at(368).asInstanceOf[Ptr[yaml_parser_t.Struct6]]
      def states_=(value: yaml_parser_t.Struct6): Unit =
        !struct.at(368).asInstanceOf[Ptr[yaml_parser_t.Struct6]] = value
      def state: yaml_parser_state_t =
        !struct.at(392).asInstanceOf[Ptr[yaml_parser_state_t]]
      def state_=(value: yaml_parser_state_t): Unit =
        !struct.at(392).asInstanceOf[Ptr[yaml_parser_state_t]] = value
      def marks: yaml_parser_t.Struct7 =
        !struct.at(400).asInstanceOf[Ptr[yaml_parser_t.Struct7]]
      def marks_=(value: yaml_parser_t.Struct7): Unit =
        !struct.at(400).asInstanceOf[Ptr[yaml_parser_t.Struct7]] = value
      def tag_directives: yaml_parser_t.Struct8 =
        !struct.at(424).asInstanceOf[Ptr[yaml_parser_t.Struct8]]
      def tag_directives_=(value: yaml_parser_t.Struct8): Unit =
        !struct.at(424).asInstanceOf[Ptr[yaml_parser_t.Struct8]] = value
      def aliases: yaml_parser_t.Struct9 =
        !struct.at(448).asInstanceOf[Ptr[yaml_parser_t.Struct9]]
      def aliases_=(value: yaml_parser_t.Struct9): Unit =
        !struct.at(448).asInstanceOf[Ptr[yaml_parser_t.Struct9]] = value
      def document: Ptr[yaml_document_t] =
        !struct.at(472).asInstanceOf[Ptr[Ptr[yaml_document_t]]]
      def document_=(value: Ptr[yaml_document_t]): Unit =
        !struct.at(472).asInstanceOf[Ptr[Ptr[yaml_document_t]]] = value

  /** This structure holds information about a potential simple key.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_simple_key_s = CStruct4[CInt, CInt, size_t, yaml_mark_t]
  object yaml_simple_key_s:
    given _tag: Tag[yaml_simple_key_s] =
      Tag.materializeCStruct4Tag[CInt, CInt, size_t, yaml_mark_t]
    def apply()(using Zone): Ptr[yaml_simple_key_s] =
      scala.scalanative.unsafe.alloc[yaml_simple_key_s](1)
    def apply(
        possible: CInt,
        required: CInt,
        token_number: size_t,
        mark: yaml_mark_t
    )(using Zone): Ptr[yaml_simple_key_s] =
      val ____ptr = apply()
      (!____ptr).possible = possible
      (!____ptr).required = required
      (!____ptr).token_number = token_number
      (!____ptr).mark = mark
      ____ptr
    extension (struct: yaml_simple_key_s)
      def possible: CInt = struct._1
      def possible_=(value: CInt): Unit = !struct.at1 = value
      def required: CInt = struct._2
      def required_=(value: CInt): Unit = !struct.at2 = value
      def token_number: size_t = struct._3
      def token_number_=(value: size_t): Unit = !struct.at3 = value
      def mark: yaml_mark_t = struct._4
      def mark_=(value: yaml_mark_t): Unit = !struct.at4 = value

  /** This structure holds information about a potential simple key.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_simple_key_t = CStruct4[CInt, CInt, size_t, yaml_mark_t]
  object yaml_simple_key_t:
    given _tag: Tag[yaml_simple_key_t] =
      Tag.materializeCStruct4Tag[CInt, CInt, size_t, yaml_mark_t]
    def apply()(using Zone): Ptr[yaml_simple_key_t] =
      scala.scalanative.unsafe.alloc[yaml_simple_key_t](1)
    def apply(
        possible: CInt,
        required: CInt,
        token_number: size_t,
        mark: yaml_mark_t
    )(using Zone): Ptr[yaml_simple_key_t] =
      val ____ptr = apply()
      (!____ptr).possible = possible
      (!____ptr).required = required
      (!____ptr).token_number = token_number
      (!____ptr).mark = mark
      ____ptr
    extension (struct: yaml_simple_key_t)
      def possible: CInt = struct._1
      def possible_=(value: CInt): Unit = !struct.at1 = value
      def required: CInt = struct._2
      def required_=(value: CInt): Unit = !struct.at2 = value
      def token_number: size_t = struct._3
      def token_number_=(value: size_t): Unit = !struct.at3 = value
      def mark: yaml_mark_t = struct._4
      def mark_=(value: yaml_mark_t): Unit = !struct.at4 = value

  /** The tag directive data.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_tag_directive_s =
    CStruct2[Ptr[yaml_char_t], Ptr[yaml_char_t]]
  object yaml_tag_directive_s:
    given _tag: Tag[yaml_tag_directive_s] =
      Tag.materializeCStruct2Tag[Ptr[yaml_char_t], Ptr[yaml_char_t]]
    def apply()(using Zone): Ptr[yaml_tag_directive_s] =
      scala.scalanative.unsafe.alloc[yaml_tag_directive_s](1)
    def apply(handle: Ptr[yaml_char_t], prefix: Ptr[yaml_char_t])(using
        Zone
    ): Ptr[yaml_tag_directive_s] =
      val ____ptr = apply()
      (!____ptr).handle = handle
      (!____ptr).prefix = prefix
      ____ptr
    extension (struct: yaml_tag_directive_s)
      def handle: Ptr[yaml_char_t] = struct._1
      def handle_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
      def prefix: Ptr[yaml_char_t] = struct._2
      def prefix_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value

  /** The tag directive data.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_tag_directive_t =
    CStruct2[Ptr[yaml_char_t], Ptr[yaml_char_t]]
  object yaml_tag_directive_t:
    given _tag: Tag[yaml_tag_directive_t] =
      Tag.materializeCStruct2Tag[Ptr[yaml_char_t], Ptr[yaml_char_t]]
    def apply()(using Zone): Ptr[yaml_tag_directive_t] =
      scala.scalanative.unsafe.alloc[yaml_tag_directive_t](1)
    def apply(handle: Ptr[yaml_char_t], prefix: Ptr[yaml_char_t])(using
        Zone
    ): Ptr[yaml_tag_directive_t] =
      val ____ptr = apply()
      (!____ptr).handle = handle
      (!____ptr).prefix = prefix
      ____ptr
    extension (struct: yaml_tag_directive_t)
      def handle: Ptr[yaml_char_t] = struct._1
      def handle_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
      def prefix: Ptr[yaml_char_t] = struct._2
      def prefix_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value

  /** The token structure.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_token_s =
    CStruct4[yaml_token_type_t, yaml_token_s.Union0, yaml_mark_t, yaml_mark_t]
  object yaml_token_s:
    /** The token data.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Union0 = CArray[Byte, Nat.Digit2[Nat._2, Nat._4]]
    object Union0:
      /** The stream start (for YAML_STREAM_START_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct0 = CStruct1[yaml_encoding_t]
      object Struct0:
        given _tag: Tag[Struct0] = Tag.materializeCStruct1Tag[yaml_encoding_t]
        def apply()(using Zone): Ptr[Struct0] =
          scala.scalanative.unsafe.alloc[Struct0](1)
        def apply(encoding: yaml_encoding_t)(using Zone): Ptr[Struct0] =
          val ____ptr = apply()
          (!____ptr).encoding = encoding
          ____ptr
        extension (struct: Struct0)
          def encoding: yaml_encoding_t = struct._1
          def encoding_=(value: yaml_encoding_t): Unit = !struct.at1 = value

      /** The alias (for YAML_ALIAS_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct1 = CStruct1[Ptr[yaml_char_t]]
      object Struct1:
        given _tag: Tag[Struct1] = Tag.materializeCStruct1Tag[Ptr[yaml_char_t]]
        def apply()(using Zone): Ptr[Struct1] =
          scala.scalanative.unsafe.alloc[Struct1](1)
        def apply(value: Ptr[yaml_char_t])(using Zone): Ptr[Struct1] =
          val ____ptr = apply()
          (!____ptr).value = value
          ____ptr
        extension (struct: Struct1)
          def value: Ptr[yaml_char_t] = struct._1
          def value_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value

      /** The anchor (for YAML_ANCHOR_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct2 = CStruct1[Ptr[yaml_char_t]]
      object Struct2:
        given _tag: Tag[Struct2] = Tag.materializeCStruct1Tag[Ptr[yaml_char_t]]
        def apply()(using Zone): Ptr[Struct2] =
          scala.scalanative.unsafe.alloc[Struct2](1)
        def apply(value: Ptr[yaml_char_t])(using Zone): Ptr[Struct2] =
          val ____ptr = apply()
          (!____ptr).value = value
          ____ptr
        extension (struct: Struct2)
          def value: Ptr[yaml_char_t] = struct._1
          def value_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value

      /** The tag (for YAML_TAG_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct3 = CStruct2[Ptr[yaml_char_t], Ptr[yaml_char_t]]
      object Struct3:
        given _tag: Tag[Struct3] =
          Tag.materializeCStruct2Tag[Ptr[yaml_char_t], Ptr[yaml_char_t]]
        def apply()(using Zone): Ptr[Struct3] =
          scala.scalanative.unsafe.alloc[Struct3](1)
        def apply(handle: Ptr[yaml_char_t], suffix: Ptr[yaml_char_t])(using
            Zone
        ): Ptr[Struct3] =
          val ____ptr = apply()
          (!____ptr).handle = handle
          (!____ptr).suffix = suffix
          ____ptr
        extension (struct: Struct3)
          def handle: Ptr[yaml_char_t] = struct._1
          def handle_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def suffix: Ptr[yaml_char_t] = struct._2
          def suffix_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value

      /** The scalar value (for YAML_SCALAR_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct4 =
        CStruct3[Ptr[yaml_char_t], size_t, yaml_scalar_style_t]
      object Struct4:
        given _tag: Tag[Struct4] = Tag
          .materializeCStruct3Tag[Ptr[yaml_char_t], size_t, yaml_scalar_style_t]
        def apply()(using Zone): Ptr[Struct4] =
          scala.scalanative.unsafe.alloc[Struct4](1)
        def apply(
            value: Ptr[yaml_char_t],
            length: size_t,
            style: yaml_scalar_style_t
        )(using Zone): Ptr[Struct4] =
          val ____ptr = apply()
          (!____ptr).value = value
          (!____ptr).length = length
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct4)
          def value: Ptr[yaml_char_t] = struct._1
          def value_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def length: size_t = struct._2
          def length_=(value: size_t): Unit = !struct.at2 = value
          def style: yaml_scalar_style_t = struct._3
          def style_=(value: yaml_scalar_style_t): Unit = !struct.at3 = value

      /** The version directive (for YAML_VERSION_DIRECTIVE_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct5 = CStruct2[CInt, CInt]
      object Struct5:
        given _tag: Tag[Struct5] = Tag.materializeCStruct2Tag[CInt, CInt]
        def apply()(using Zone): Ptr[Struct5] =
          scala.scalanative.unsafe.alloc[Struct5](1)
        def apply(major: CInt, minor: CInt)(using Zone): Ptr[Struct5] =
          val ____ptr = apply()
          (!____ptr).major = major
          (!____ptr).minor = minor
          ____ptr
        extension (struct: Struct5)
          def major: CInt = struct._1
          def major_=(value: CInt): Unit = !struct.at1 = value
          def minor: CInt = struct._2
          def minor_=(value: CInt): Unit = !struct.at2 = value

      /** The tag directive (for YAML_TAG_DIRECTIVE_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct6 = CStruct2[Ptr[yaml_char_t], Ptr[yaml_char_t]]
      object Struct6:
        given _tag: Tag[Struct6] =
          Tag.materializeCStruct2Tag[Ptr[yaml_char_t], Ptr[yaml_char_t]]
        def apply()(using Zone): Ptr[Struct6] =
          scala.scalanative.unsafe.alloc[Struct6](1)
        def apply(handle: Ptr[yaml_char_t], prefix: Ptr[yaml_char_t])(using
            Zone
        ): Ptr[Struct6] =
          val ____ptr = apply()
          (!____ptr).handle = handle
          (!____ptr).prefix = prefix
          ____ptr
        extension (struct: Struct6)
          def handle: Ptr[yaml_char_t] = struct._1
          def handle_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def prefix: Ptr[yaml_char_t] = struct._2
          def prefix_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat.Digit2[Nat._2, Nat._4]](
        Tag.Byte,
        Tag.Digit2[Nat._2, Nat._4](Tag.Nat2, Tag.Nat4)
      )
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_stream_start")
      def apply(stream_start: yaml_token_s.Union0.Struct0)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_token_s.Union0.Struct0]]
          .update(0, stream_start)
        ___ptr
      @scala.annotation.targetName("apply_alias")
      def apply(alias: yaml_token_s.Union0.Struct1)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct1]].update(0, alias)
        ___ptr
      @scala.annotation.targetName("apply_anchor")
      def apply(anchor: yaml_token_s.Union0.Struct2)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_token_s.Union0.Struct2]]
          .update(0, anchor)
        ___ptr
      @scala.annotation.targetName("apply_tag")
      def apply(tag: yaml_token_s.Union0.Struct3)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct3]].update(0, tag)
        ___ptr
      @scala.annotation.targetName("apply_scalar")
      def apply(scalar: yaml_token_s.Union0.Struct4)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_token_s.Union0.Struct4]]
          .update(0, scalar)
        ___ptr
      @scala.annotation.targetName("apply_version_directive")
      def apply(version_directive: yaml_token_s.Union0.Struct5)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_token_s.Union0.Struct5]]
          .update(0, version_directive)
        ___ptr
      @scala.annotation.targetName("apply_tag_directive")
      def apply(tag_directive: yaml_token_s.Union0.Struct6)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_token_s.Union0.Struct6]]
          .update(0, tag_directive)
        ___ptr
      extension (struct: Union0)
        def stream_start: yaml_token_s.Union0.Struct0 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct0]]
        def stream_start_=(value: yaml_token_s.Union0.Struct0): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct0]] = value
        def alias: yaml_token_s.Union0.Struct1 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct1]]
        def alias_=(value: yaml_token_s.Union0.Struct1): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct1]] = value
        def anchor: yaml_token_s.Union0.Struct2 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct2]]
        def anchor_=(value: yaml_token_s.Union0.Struct2): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct2]] = value
        def tag: yaml_token_s.Union0.Struct3 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct3]]
        def tag_=(value: yaml_token_s.Union0.Struct3): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct3]] = value
        def scalar: yaml_token_s.Union0.Struct4 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct4]]
        def scalar_=(value: yaml_token_s.Union0.Struct4): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct4]] = value
        def version_directive: yaml_token_s.Union0.Struct5 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct5]]
        def version_directive_=(value: yaml_token_s.Union0.Struct5): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct5]] = value
        def tag_directive: yaml_token_s.Union0.Struct6 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct6]]
        def tag_directive_=(value: yaml_token_s.Union0.Struct6): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_s.Union0.Struct6]] = value
    given _tag: Tag[yaml_token_s] = Tag.materializeCStruct4Tag[
      yaml_token_type_t,
      yaml_token_s.Union0,
      yaml_mark_t,
      yaml_mark_t
    ]
    def apply()(using Zone): Ptr[yaml_token_s] =
      scala.scalanative.unsafe.alloc[yaml_token_s](1)
    def apply(
        `type`: yaml_token_type_t,
        data: yaml_token_s.Union0,
        start_mark: yaml_mark_t,
        end_mark: yaml_mark_t
    )(using Zone): Ptr[yaml_token_s] =
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).data = data
      (!____ptr).start_mark = start_mark
      (!____ptr).end_mark = end_mark
      ____ptr
    extension (struct: yaml_token_s)
      def `type`: yaml_token_type_t = struct._1
      def type_=(value: yaml_token_type_t): Unit = !struct.at1 = value
      def data: yaml_token_s.Union0 = struct._2
      def data_=(value: yaml_token_s.Union0): Unit = !struct.at2 = value
      def start_mark: yaml_mark_t = struct._3
      def start_mark_=(value: yaml_mark_t): Unit = !struct.at3 = value
      def end_mark: yaml_mark_t = struct._4
      def end_mark_=(value: yaml_mark_t): Unit = !struct.at4 = value

  /** The token structure.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_token_t =
    CStruct4[yaml_token_type_t, yaml_token_t.Union0, yaml_mark_t, yaml_mark_t]
  object yaml_token_t:
    /** The token data.
      *
      * [bindgen] header: /usr/include/yaml.h
      */
    opaque type Union0 = CArray[Byte, Nat.Digit2[Nat._2, Nat._4]]
    object Union0:
      /** The stream start (for YAML_STREAM_START_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct0 = CStruct1[yaml_encoding_t]
      object Struct0:
        given _tag: Tag[Struct0] = Tag.materializeCStruct1Tag[yaml_encoding_t]
        def apply()(using Zone): Ptr[Struct0] =
          scala.scalanative.unsafe.alloc[Struct0](1)
        def apply(encoding: yaml_encoding_t)(using Zone): Ptr[Struct0] =
          val ____ptr = apply()
          (!____ptr).encoding = encoding
          ____ptr
        extension (struct: Struct0)
          def encoding: yaml_encoding_t = struct._1
          def encoding_=(value: yaml_encoding_t): Unit = !struct.at1 = value

      /** The alias (for YAML_ALIAS_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct1 = CStruct1[Ptr[yaml_char_t]]
      object Struct1:
        given _tag: Tag[Struct1] = Tag.materializeCStruct1Tag[Ptr[yaml_char_t]]
        def apply()(using Zone): Ptr[Struct1] =
          scala.scalanative.unsafe.alloc[Struct1](1)
        def apply(value: Ptr[yaml_char_t])(using Zone): Ptr[Struct1] =
          val ____ptr = apply()
          (!____ptr).value = value
          ____ptr
        extension (struct: Struct1)
          def value: Ptr[yaml_char_t] = struct._1
          def value_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value

      /** The anchor (for YAML_ANCHOR_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct2 = CStruct1[Ptr[yaml_char_t]]
      object Struct2:
        given _tag: Tag[Struct2] = Tag.materializeCStruct1Tag[Ptr[yaml_char_t]]
        def apply()(using Zone): Ptr[Struct2] =
          scala.scalanative.unsafe.alloc[Struct2](1)
        def apply(value: Ptr[yaml_char_t])(using Zone): Ptr[Struct2] =
          val ____ptr = apply()
          (!____ptr).value = value
          ____ptr
        extension (struct: Struct2)
          def value: Ptr[yaml_char_t] = struct._1
          def value_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value

      /** The tag (for YAML_TAG_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct3 = CStruct2[Ptr[yaml_char_t], Ptr[yaml_char_t]]
      object Struct3:
        given _tag: Tag[Struct3] =
          Tag.materializeCStruct2Tag[Ptr[yaml_char_t], Ptr[yaml_char_t]]
        def apply()(using Zone): Ptr[Struct3] =
          scala.scalanative.unsafe.alloc[Struct3](1)
        def apply(handle: Ptr[yaml_char_t], suffix: Ptr[yaml_char_t])(using
            Zone
        ): Ptr[Struct3] =
          val ____ptr = apply()
          (!____ptr).handle = handle
          (!____ptr).suffix = suffix
          ____ptr
        extension (struct: Struct3)
          def handle: Ptr[yaml_char_t] = struct._1
          def handle_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def suffix: Ptr[yaml_char_t] = struct._2
          def suffix_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value

      /** The scalar value (for YAML_SCALAR_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct4 =
        CStruct3[Ptr[yaml_char_t], size_t, yaml_scalar_style_t]
      object Struct4:
        given _tag: Tag[Struct4] = Tag
          .materializeCStruct3Tag[Ptr[yaml_char_t], size_t, yaml_scalar_style_t]
        def apply()(using Zone): Ptr[Struct4] =
          scala.scalanative.unsafe.alloc[Struct4](1)
        def apply(
            value: Ptr[yaml_char_t],
            length: size_t,
            style: yaml_scalar_style_t
        )(using Zone): Ptr[Struct4] =
          val ____ptr = apply()
          (!____ptr).value = value
          (!____ptr).length = length
          (!____ptr).style = style
          ____ptr
        extension (struct: Struct4)
          def value: Ptr[yaml_char_t] = struct._1
          def value_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def length: size_t = struct._2
          def length_=(value: size_t): Unit = !struct.at2 = value
          def style: yaml_scalar_style_t = struct._3
          def style_=(value: yaml_scalar_style_t): Unit = !struct.at3 = value

      /** The version directive (for YAML_VERSION_DIRECTIVE_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct5 = CStruct2[CInt, CInt]
      object Struct5:
        given _tag: Tag[Struct5] = Tag.materializeCStruct2Tag[CInt, CInt]
        def apply()(using Zone): Ptr[Struct5] =
          scala.scalanative.unsafe.alloc[Struct5](1)
        def apply(major: CInt, minor: CInt)(using Zone): Ptr[Struct5] =
          val ____ptr = apply()
          (!____ptr).major = major
          (!____ptr).minor = minor
          ____ptr
        extension (struct: Struct5)
          def major: CInt = struct._1
          def major_=(value: CInt): Unit = !struct.at1 = value
          def minor: CInt = struct._2
          def minor_=(value: CInt): Unit = !struct.at2 = value

      /** The tag directive (for YAML_TAG_DIRECTIVE_TOKEN).
        *
        * [bindgen] header: /usr/include/yaml.h
        */
      opaque type Struct6 = CStruct2[Ptr[yaml_char_t], Ptr[yaml_char_t]]
      object Struct6:
        given _tag: Tag[Struct6] =
          Tag.materializeCStruct2Tag[Ptr[yaml_char_t], Ptr[yaml_char_t]]
        def apply()(using Zone): Ptr[Struct6] =
          scala.scalanative.unsafe.alloc[Struct6](1)
        def apply(handle: Ptr[yaml_char_t], prefix: Ptr[yaml_char_t])(using
            Zone
        ): Ptr[Struct6] =
          val ____ptr = apply()
          (!____ptr).handle = handle
          (!____ptr).prefix = prefix
          ____ptr
        extension (struct: Struct6)
          def handle: Ptr[yaml_char_t] = struct._1
          def handle_=(value: Ptr[yaml_char_t]): Unit = !struct.at1 = value
          def prefix: Ptr[yaml_char_t] = struct._2
          def prefix_=(value: Ptr[yaml_char_t]): Unit = !struct.at2 = value
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat.Digit2[Nat._2, Nat._4]](
        Tag.Byte,
        Tag.Digit2[Nat._2, Nat._4](Tag.Nat2, Tag.Nat4)
      )
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_stream_start")
      def apply(stream_start: yaml_token_t.Union0.Struct0)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_token_t.Union0.Struct0]]
          .update(0, stream_start)
        ___ptr
      @scala.annotation.targetName("apply_alias")
      def apply(alias: yaml_token_t.Union0.Struct1)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct1]].update(0, alias)
        ___ptr
      @scala.annotation.targetName("apply_anchor")
      def apply(anchor: yaml_token_t.Union0.Struct2)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_token_t.Union0.Struct2]]
          .update(0, anchor)
        ___ptr
      @scala.annotation.targetName("apply_tag")
      def apply(tag: yaml_token_t.Union0.Struct3)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct3]].update(0, tag)
        ___ptr
      @scala.annotation.targetName("apply_scalar")
      def apply(scalar: yaml_token_t.Union0.Struct4)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_token_t.Union0.Struct4]]
          .update(0, scalar)
        ___ptr
      @scala.annotation.targetName("apply_version_directive")
      def apply(version_directive: yaml_token_t.Union0.Struct5)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_token_t.Union0.Struct5]]
          .update(0, version_directive)
        ___ptr
      @scala.annotation.targetName("apply_tag_directive")
      def apply(tag_directive: yaml_token_t.Union0.Struct6)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[yaml_token_t.Union0.Struct6]]
          .update(0, tag_directive)
        ___ptr
      extension (struct: Union0)
        def stream_start: yaml_token_t.Union0.Struct0 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct0]]
        def stream_start_=(value: yaml_token_t.Union0.Struct0): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct0]] = value
        def alias: yaml_token_t.Union0.Struct1 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct1]]
        def alias_=(value: yaml_token_t.Union0.Struct1): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct1]] = value
        def anchor: yaml_token_t.Union0.Struct2 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct2]]
        def anchor_=(value: yaml_token_t.Union0.Struct2): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct2]] = value
        def tag: yaml_token_t.Union0.Struct3 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct3]]
        def tag_=(value: yaml_token_t.Union0.Struct3): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct3]] = value
        def scalar: yaml_token_t.Union0.Struct4 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct4]]
        def scalar_=(value: yaml_token_t.Union0.Struct4): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct4]] = value
        def version_directive: yaml_token_t.Union0.Struct5 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct5]]
        def version_directive_=(value: yaml_token_t.Union0.Struct5): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct5]] = value
        def tag_directive: yaml_token_t.Union0.Struct6 =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct6]]
        def tag_directive_=(value: yaml_token_t.Union0.Struct6): Unit =
          !struct.at(0).asInstanceOf[Ptr[yaml_token_t.Union0.Struct6]] = value
    given _tag: Tag[yaml_token_t] = Tag.materializeCStruct4Tag[
      yaml_token_type_t,
      yaml_token_t.Union0,
      yaml_mark_t,
      yaml_mark_t
    ]
    def apply()(using Zone): Ptr[yaml_token_t] =
      scala.scalanative.unsafe.alloc[yaml_token_t](1)
    def apply(
        `type`: yaml_token_type_t,
        data: yaml_token_t.Union0,
        start_mark: yaml_mark_t,
        end_mark: yaml_mark_t
    )(using Zone): Ptr[yaml_token_t] =
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).data = data
      (!____ptr).start_mark = start_mark
      (!____ptr).end_mark = end_mark
      ____ptr
    extension (struct: yaml_token_t)
      def `type`: yaml_token_type_t = struct._1
      def type_=(value: yaml_token_type_t): Unit = !struct.at1 = value
      def data: yaml_token_t.Union0 = struct._2
      def data_=(value: yaml_token_t.Union0): Unit = !struct.at2 = value
      def start_mark: yaml_mark_t = struct._3
      def start_mark_=(value: yaml_mark_t): Unit = !struct.at3 = value
      def end_mark: yaml_mark_t = struct._4
      def end_mark_=(value: yaml_mark_t): Unit = !struct.at4 = value

  /** The version directive data.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_version_directive_s = CStruct2[CInt, CInt]
  object yaml_version_directive_s:
    given _tag: Tag[yaml_version_directive_s] =
      Tag.materializeCStruct2Tag[CInt, CInt]
    def apply()(using Zone): Ptr[yaml_version_directive_s] =
      scala.scalanative.unsafe.alloc[yaml_version_directive_s](1)
    def apply(major: CInt, minor: CInt)(using
        Zone
    ): Ptr[yaml_version_directive_s] =
      val ____ptr = apply()
      (!____ptr).major = major
      (!____ptr).minor = minor
      ____ptr
    extension (struct: yaml_version_directive_s)
      def major: CInt = struct._1
      def major_=(value: CInt): Unit = !struct.at1 = value
      def minor: CInt = struct._2
      def minor_=(value: CInt): Unit = !struct.at2 = value

  /** The version directive data.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  opaque type yaml_version_directive_t = CStruct2[CInt, CInt]
  object yaml_version_directive_t:
    given _tag: Tag[yaml_version_directive_t] =
      Tag.materializeCStruct2Tag[CInt, CInt]
    def apply()(using Zone): Ptr[yaml_version_directive_t] =
      scala.scalanative.unsafe.alloc[yaml_version_directive_t](1)
    def apply(major: CInt, minor: CInt)(using
        Zone
    ): Ptr[yaml_version_directive_t] =
      val ____ptr = apply()
      (!____ptr).major = major
      (!____ptr).minor = minor
      ____ptr
    extension (struct: yaml_version_directive_t)
      def major: CInt = struct._1
      def major_=(value: CInt): Unit = !struct.at1 = value
      def minor: CInt = struct._2
      def minor_=(value: CInt): Unit = !struct.at2 = value

@extern
private[libyaml] object extern_functions:
  import _root_.dev.hnaderi.libyaml.enumerations.*
  import _root_.dev.hnaderi.libyaml.aliases.*
  import _root_.dev.hnaderi.libyaml.structs.*

  /** Create an ALIAS event.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_alias_event_initialize(
      event: Ptr[yaml_event_t],
      anchor: Ptr[yaml_char_t]
  ): CInt = extern

  /** Create a MAPPING node and attach it to the document.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_document_add_mapping(
      document: Ptr[yaml_document_t],
      tag: Ptr[yaml_char_t],
      style: yaml_mapping_style_t
  ): CInt = extern

  /** Create a SCALAR node and attach it to the document.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_document_add_scalar(
      document: Ptr[yaml_document_t],
      tag: Ptr[yaml_char_t],
      value: Ptr[yaml_char_t],
      length: CInt,
      style: yaml_scalar_style_t
  ): CInt = extern

  /** Create a SEQUENCE node and attach it to the document.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_document_add_sequence(
      document: Ptr[yaml_document_t],
      tag: Ptr[yaml_char_t],
      style: yaml_sequence_style_t
  ): CInt = extern

  /** Add a pair of a key and a value to a MAPPING node.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_document_append_mapping_pair(
      document: Ptr[yaml_document_t],
      mapping: CInt,
      key: CInt,
      value: CInt
  ): CInt = extern

  /** Add an item to a SEQUENCE node.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_document_append_sequence_item(
      document: Ptr[yaml_document_t],
      sequence: CInt,
      item: CInt
  ): CInt = extern

  /** Delete a YAML document and all its nodes.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_document_delete(document: Ptr[yaml_document_t]): Unit = extern

  /** Create the DOCUMENT-END event.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_document_end_event_initialize(
      event: Ptr[yaml_event_t],
      `implicit`: CInt
  ): CInt = extern

  /** Get a node of a YAML document.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_document_get_node(
      document: Ptr[yaml_document_t],
      index: CInt
  ): Ptr[yaml_node_t] = extern

  /** Get the root of a YAML document node.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_document_get_root_node(
      document: Ptr[yaml_document_t]
  ): Ptr[yaml_node_t] = extern

  /** Create a YAML document.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_document_initialize(
      document: Ptr[yaml_document_t],
      version_directive: Ptr[yaml_version_directive_t],
      tag_directives_start: Ptr[yaml_tag_directive_t],
      tag_directives_end: Ptr[yaml_tag_directive_t],
      start_implicit: CInt,
      end_implicit: CInt
  ): CInt = extern

  /** Create the DOCUMENT-START event.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_document_start_event_initialize(
      event: Ptr[yaml_event_t],
      version_directive: Ptr[yaml_version_directive_t],
      tag_directives_start: Ptr[yaml_tag_directive_t],
      tag_directives_end: Ptr[yaml_tag_directive_t],
      `implicit`: CInt
  ): CInt = extern

  /** Finish a YAML stream.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_close(emitter: Ptr[yaml_emitter_t]): CInt = extern

  /** Destroy an emitter.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_delete(emitter: Ptr[yaml_emitter_t]): Unit = extern

  /** Emit a YAML document.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_dump(
      emitter: Ptr[yaml_emitter_t],
      document: Ptr[yaml_document_t]
  ): CInt = extern

  /** Emit an event.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_emit(
      emitter: Ptr[yaml_emitter_t],
      event: Ptr[yaml_event_t]
  ): CInt = extern

  /** Flush the accumulated characters to the output.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_flush(emitter: Ptr[yaml_emitter_t]): CInt = extern

  /** Initialize an emitter.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_initialize(emitter: Ptr[yaml_emitter_t]): CInt = extern

  /** Start a YAML stream.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_open(emitter: Ptr[yaml_emitter_t]): CInt = extern

  /** Set the preferred line break.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_set_break(
      emitter: Ptr[yaml_emitter_t],
      line_break: yaml_break_t
  ): Unit = extern

  /** Set if the output should be in the "canonical" format as in the YAML
    * specification.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_set_canonical(
      emitter: Ptr[yaml_emitter_t],
      canonical: CInt
  ): Unit = extern

  /** Set the output encoding.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_set_encoding(
      emitter: Ptr[yaml_emitter_t],
      encoding: yaml_encoding_t
  ): Unit = extern

  /** Set the intendation increment.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_set_indent(
      emitter: Ptr[yaml_emitter_t],
      indent: CInt
  ): Unit = extern

  /** Set a generic output handler.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_set_output(
      emitter: Ptr[yaml_emitter_t],
      handler: yaml_write_handler_t, // TODO check
      data: Ptr[Byte]
  ): Unit = extern

  /** Set a file output.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_set_output_file(
      emitter: Ptr[yaml_emitter_t],
      file: Ptr[FILE]
  ): Unit = extern

  /** Set a string output.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_set_output_string(
      emitter: Ptr[yaml_emitter_t],
      output: Ptr[CUnsignedChar],
      size: size_t,
      size_written: Ptr[size_t]
  ): Unit = extern

  /** Set if unescaped non-ASCII characters are allowed.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_set_unicode(
      emitter: Ptr[yaml_emitter_t],
      unicode: CInt
  ): Unit = extern

  /** Set the preferred line width. -1 means unlimited.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_emitter_set_width(emitter: Ptr[yaml_emitter_t], width: CInt): Unit =
    extern

  /** Free any memory allocated for an event object.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_event_delete(event: Ptr[yaml_event_t]): Unit = extern

  /** Get the library version numbers.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_get_version(
      major: Ptr[CInt],
      minor: Ptr[CInt],
      patch: Ptr[CInt]
  ): Unit = extern

  /** Get the library version as a string.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_get_version_string(): CString = extern

  /** Create a MAPPING-END event.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_mapping_end_event_initialize(event: Ptr[yaml_event_t]): CInt = extern

  /** Create a MAPPING-START event.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_mapping_start_event_initialize(
      event: Ptr[yaml_event_t],
      anchor: Ptr[yaml_char_t],
      tag: Ptr[yaml_char_t],
      `implicit`: CInt,
      style: yaml_mapping_style_t
  ): CInt = extern

  /** Destroy a parser.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_parser_delete(parser: Ptr[yaml_parser_t]): Unit = extern

  /** Initialize a parser.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_parser_initialize(parser: Ptr[yaml_parser_t]): CInt = extern

  /** Parse the input stream and produce the next YAML document.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_parser_load(
      parser: Ptr[yaml_parser_t],
      document: Ptr[yaml_document_t]
  ): CInt = extern

  /** Parse the input stream and produce the next parsing event.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_parser_parse(
      parser: Ptr[yaml_parser_t],
      event: Ptr[yaml_event_t]
  ): CInt = extern

  /** Scan the input stream and produce the next token.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_parser_scan(
      parser: Ptr[yaml_parser_t],
      token: Ptr[yaml_token_t]
  ): CInt = extern

  /** Set the source encoding.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_parser_set_encoding(
      parser: Ptr[yaml_parser_t],
      encoding: yaml_encoding_t
  ): Unit = extern

  /** Set a generic input handler.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_parser_set_input(
      parser: Ptr[yaml_parser_t],
      handler: Ptr[yaml_read_handler_t],
      data: Ptr[Byte]
  ): Unit = extern

  /** Set a file input.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_parser_set_input_file(
      parser: Ptr[yaml_parser_t],
      file: Ptr[FILE]
  ): Unit = extern

  /** Set a string input.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_parser_set_input_string(
      parser: Ptr[yaml_parser_t],
      input: Ptr[CUnsignedChar],
      size: size_t
  ): Unit = extern

  /** Create a SCALAR event.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_scalar_event_initialize(
      event: Ptr[yaml_event_t],
      anchor: Ptr[yaml_char_t],
      tag: Ptr[yaml_char_t],
      value: Ptr[yaml_char_t],
      length: CInt,
      plain_implicit: CInt,
      quoted_implicit: CInt,
      style: yaml_scalar_style_t
  ): CInt = extern

  /** Create a SEQUENCE-END event.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_sequence_end_event_initialize(event: Ptr[yaml_event_t]): CInt =
    extern

  /** Create a SEQUENCE-START event.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_sequence_start_event_initialize(
      event: Ptr[yaml_event_t],
      anchor: Ptr[yaml_char_t],
      tag: Ptr[yaml_char_t],
      `implicit`: CInt,
      style: yaml_sequence_style_t
  ): CInt = extern

  /** Create the STREAM-END event.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_stream_end_event_initialize(event: Ptr[yaml_event_t]): CInt = extern

  /** Create the STREAM-START event.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_stream_start_event_initialize(
      event: Ptr[yaml_event_t],
      encoding: yaml_encoding_t
  ): CInt = extern

  /** Free any memory allocated for a token object.
    *
    * [bindgen] header: /usr/include/yaml.h
    */
  def yaml_token_delete(token: Ptr[yaml_token_t]): Unit = extern

object functions:
  import _root_.dev.hnaderi.libyaml.enumerations.*
  import _root_.dev.hnaderi.libyaml.aliases.*
  import _root_.dev.hnaderi.libyaml.structs.*

  import extern_functions.*
  export extern_functions.*

object types:
  export _root_.dev.hnaderi.libyaml.structs.*
  export _root_.dev.hnaderi.libyaml.aliases.*
  export _root_.dev.hnaderi.libyaml.enumerations.*

object all:
  export _root_.dev.hnaderi.libyaml.enumerations.yaml_break_e
  export _root_.dev.hnaderi.libyaml.enumerations.yaml_emitter_state_e
  export _root_.dev.hnaderi.libyaml.enumerations.yaml_encoding_e
  export _root_.dev.hnaderi.libyaml.enumerations.yaml_error_type_e
  export _root_.dev.hnaderi.libyaml.enumerations.yaml_event_type_e
  export _root_.dev.hnaderi.libyaml.enumerations.yaml_mapping_style_e
  export _root_.dev.hnaderi.libyaml.enumerations.yaml_node_type_e
  export _root_.dev.hnaderi.libyaml.enumerations.yaml_parser_state_e
  export _root_.dev.hnaderi.libyaml.enumerations.yaml_scalar_style_e
  export _root_.dev.hnaderi.libyaml.enumerations.yaml_sequence_style_e
  export _root_.dev.hnaderi.libyaml.enumerations.yaml_token_type_e
  export _root_.dev.hnaderi.libyaml.aliases.FILE
  export _root_.dev.hnaderi.libyaml.aliases.size_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_break_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_char_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_emitter_state_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_encoding_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_error_type_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_event_type_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_mapping_style_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_node_item_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_node_type_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_parser_state_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_read_handler_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_scalar_style_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_sequence_style_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_token_type_t
  export _root_.dev.hnaderi.libyaml.aliases.yaml_write_handler_t
  export _root_.dev.hnaderi.libyaml.structs.yaml_alias_data_s
  export _root_.dev.hnaderi.libyaml.structs.yaml_alias_data_t
  export _root_.dev.hnaderi.libyaml.structs.yaml_anchors_s
  export _root_.dev.hnaderi.libyaml.structs.yaml_anchors_t
  export _root_.dev.hnaderi.libyaml.structs.yaml_document_s
  export _root_.dev.hnaderi.libyaml.structs.yaml_document_t
  export _root_.dev.hnaderi.libyaml.structs.yaml_emitter_s
  export _root_.dev.hnaderi.libyaml.structs.yaml_emitter_t
  export _root_.dev.hnaderi.libyaml.structs.yaml_event_s
  export _root_.dev.hnaderi.libyaml.structs.yaml_event_t
  export _root_.dev.hnaderi.libyaml.structs.yaml_mark_s
  export _root_.dev.hnaderi.libyaml.structs.yaml_mark_t
  export _root_.dev.hnaderi.libyaml.structs.yaml_node_pair_s
  export _root_.dev.hnaderi.libyaml.structs.yaml_node_pair_t
  export _root_.dev.hnaderi.libyaml.structs.yaml_node_s
  export _root_.dev.hnaderi.libyaml.structs.yaml_node_t
  export _root_.dev.hnaderi.libyaml.structs.yaml_parser_s
  export _root_.dev.hnaderi.libyaml.structs.yaml_parser_t
  export _root_.dev.hnaderi.libyaml.structs.yaml_simple_key_s
  export _root_.dev.hnaderi.libyaml.structs.yaml_simple_key_t
  export _root_.dev.hnaderi.libyaml.structs.yaml_tag_directive_s
  export _root_.dev.hnaderi.libyaml.structs.yaml_tag_directive_t
  export _root_.dev.hnaderi.libyaml.structs.yaml_token_s
  export _root_.dev.hnaderi.libyaml.structs.yaml_token_t
  export _root_.dev.hnaderi.libyaml.structs.yaml_version_directive_s
  export _root_.dev.hnaderi.libyaml.structs.yaml_version_directive_t
  export _root_.dev.hnaderi.libyaml.functions.yaml_alias_event_initialize
  export _root_.dev.hnaderi.libyaml.functions.yaml_document_add_mapping
  export _root_.dev.hnaderi.libyaml.functions.yaml_document_add_scalar
  export _root_.dev.hnaderi.libyaml.functions.yaml_document_add_sequence
  export _root_.dev.hnaderi.libyaml.functions.yaml_document_append_mapping_pair
  export _root_.dev.hnaderi.libyaml.functions.yaml_document_append_sequence_item
  export _root_.dev.hnaderi.libyaml.functions.yaml_document_delete
  export _root_.dev.hnaderi.libyaml.functions.yaml_document_end_event_initialize
  export _root_.dev.hnaderi.libyaml.functions.yaml_document_get_node
  export _root_.dev.hnaderi.libyaml.functions.yaml_document_get_root_node
  export _root_.dev.hnaderi.libyaml.functions.yaml_document_initialize
  export _root_.dev.hnaderi.libyaml.functions.yaml_document_start_event_initialize
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_close
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_delete
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_dump
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_emit
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_flush
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_initialize
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_open
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_set_break
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_set_canonical
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_set_encoding
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_set_indent
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_set_output
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_set_output_file
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_set_output_string
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_set_unicode
  export _root_.dev.hnaderi.libyaml.functions.yaml_emitter_set_width
  export _root_.dev.hnaderi.libyaml.functions.yaml_event_delete
  export _root_.dev.hnaderi.libyaml.functions.yaml_get_version
  export _root_.dev.hnaderi.libyaml.functions.yaml_get_version_string
  export _root_.dev.hnaderi.libyaml.functions.yaml_mapping_end_event_initialize
  export _root_.dev.hnaderi.libyaml.functions.yaml_mapping_start_event_initialize
  export _root_.dev.hnaderi.libyaml.functions.yaml_parser_delete
  export _root_.dev.hnaderi.libyaml.functions.yaml_parser_initialize
  export _root_.dev.hnaderi.libyaml.functions.yaml_parser_load
  export _root_.dev.hnaderi.libyaml.functions.yaml_parser_parse
  export _root_.dev.hnaderi.libyaml.functions.yaml_parser_scan
  export _root_.dev.hnaderi.libyaml.functions.yaml_parser_set_encoding
  export _root_.dev.hnaderi.libyaml.functions.yaml_parser_set_input
  export _root_.dev.hnaderi.libyaml.functions.yaml_parser_set_input_file
  export _root_.dev.hnaderi.libyaml.functions.yaml_parser_set_input_string
  export _root_.dev.hnaderi.libyaml.functions.yaml_scalar_event_initialize
  export _root_.dev.hnaderi.libyaml.functions.yaml_sequence_end_event_initialize
  export _root_.dev.hnaderi.libyaml.functions.yaml_sequence_start_event_initialize
  export _root_.dev.hnaderi.libyaml.functions.yaml_stream_end_event_initialize
  export _root_.dev.hnaderi.libyaml.functions.yaml_stream_start_event_initialize
  export _root_.dev.hnaderi.libyaml.functions.yaml_token_delete

package dev.hnaderi.libyaml.binding

import scala.scalanative._
import scala.scalanative.unsigned._
import scala.scalanative.unsafe._

object definitions {
  type enum_yaml_encoding_e = CUnsignedInt
  object enum_yaml_encoding_e {
    final val YAML_ANY_ENCODING: enum_yaml_encoding_e = 0.toUInt
    final val YAML_UTF8_ENCODING: enum_yaml_encoding_e = 1.toUInt
    final val YAML_UTF16LE_ENCODING: enum_yaml_encoding_e = 2.toUInt
    final val YAML_UTF16BE_ENCODING: enum_yaml_encoding_e = 3.toUInt
  }
  type enum_yaml_break_e = CUnsignedInt
  object enum_yaml_break_e {
    final val YAML_ANY_BREAK: enum_yaml_break_e = 0.toUInt
    final val YAML_CR_BREAK: enum_yaml_break_e = 1.toUInt
    final val YAML_LN_BREAK: enum_yaml_break_e = 2.toUInt
    final val YAML_CRLN_BREAK: enum_yaml_break_e = 3.toUInt
  }
  type enum_yaml_error_type_e = CUnsignedInt
  object enum_yaml_error_type_e {
    final val YAML_NO_ERROR: enum_yaml_error_type_e = 0.toUInt
    final val YAML_MEMORY_ERROR: enum_yaml_error_type_e = 1.toUInt
    final val YAML_READER_ERROR: enum_yaml_error_type_e = 2.toUInt
    final val YAML_SCANNER_ERROR: enum_yaml_error_type_e = 3.toUInt
    final val YAML_PARSER_ERROR: enum_yaml_error_type_e = 4.toUInt
    final val YAML_COMPOSER_ERROR: enum_yaml_error_type_e = 5.toUInt
    final val YAML_WRITER_ERROR: enum_yaml_error_type_e = 6.toUInt
    final val YAML_EMITTER_ERROR: enum_yaml_error_type_e = 7.toUInt
  }
  type enum_yaml_scalar_style_e = CUnsignedInt
  object enum_yaml_scalar_style_e {
    final val YAML_ANY_SCALAR_STYLE: enum_yaml_scalar_style_e = 0.toUInt
    final val YAML_PLAIN_SCALAR_STYLE: enum_yaml_scalar_style_e = 1.toUInt
    final val YAML_SINGLE_QUOTED_SCALAR_STYLE: enum_yaml_scalar_style_e =
      2.toUInt
    final val YAML_DOUBLE_QUOTED_SCALAR_STYLE: enum_yaml_scalar_style_e =
      3.toUInt
    final val YAML_LITERAL_SCALAR_STYLE: enum_yaml_scalar_style_e = 4.toUInt
    final val YAML_FOLDED_SCALAR_STYLE: enum_yaml_scalar_style_e = 5.toUInt
  }
  type enum_yaml_sequence_style_e = CUnsignedInt
  object enum_yaml_sequence_style_e {
    final val YAML_ANY_SEQUENCE_STYLE: enum_yaml_sequence_style_e = 0.toUInt
    final val YAML_BLOCK_SEQUENCE_STYLE: enum_yaml_sequence_style_e = 1.toUInt
    final val YAML_FLOW_SEQUENCE_STYLE: enum_yaml_sequence_style_e = 2.toUInt
  }
  type enum_yaml_mapping_style_e = CUnsignedInt
  object enum_yaml_mapping_style_e {
    final val YAML_ANY_MAPPING_STYLE: enum_yaml_mapping_style_e = 0.toUInt
    final val YAML_BLOCK_MAPPING_STYLE: enum_yaml_mapping_style_e = 1.toUInt
    final val YAML_FLOW_MAPPING_STYLE: enum_yaml_mapping_style_e = 2.toUInt
  }
  type enum_yaml_token_type_e = CUnsignedInt
  object enum_yaml_token_type_e {
    final val YAML_NO_TOKEN: enum_yaml_token_type_e = 0.toUInt
    final val YAML_STREAM_START_TOKEN: enum_yaml_token_type_e = 1.toUInt
    final val YAML_STREAM_END_TOKEN: enum_yaml_token_type_e = 2.toUInt
    final val YAML_VERSION_DIRECTIVE_TOKEN: enum_yaml_token_type_e = 3.toUInt
    final val YAML_TAG_DIRECTIVE_TOKEN: enum_yaml_token_type_e = 4.toUInt
    final val YAML_DOCUMENT_START_TOKEN: enum_yaml_token_type_e = 5.toUInt
    final val YAML_DOCUMENT_END_TOKEN: enum_yaml_token_type_e = 6.toUInt
    final val YAML_BLOCK_SEQUENCE_START_TOKEN: enum_yaml_token_type_e = 7.toUInt
    final val YAML_BLOCK_MAPPING_START_TOKEN: enum_yaml_token_type_e = 8.toUInt
    final val YAML_BLOCK_END_TOKEN: enum_yaml_token_type_e = 9.toUInt
    final val YAML_FLOW_SEQUENCE_START_TOKEN: enum_yaml_token_type_e = 10.toUInt
    final val YAML_FLOW_SEQUENCE_END_TOKEN: enum_yaml_token_type_e = 11.toUInt
    final val YAML_FLOW_MAPPING_START_TOKEN: enum_yaml_token_type_e = 12.toUInt
    final val YAML_FLOW_MAPPING_END_TOKEN: enum_yaml_token_type_e = 13.toUInt
    final val YAML_BLOCK_ENTRY_TOKEN: enum_yaml_token_type_e = 14.toUInt
    final val YAML_FLOW_ENTRY_TOKEN: enum_yaml_token_type_e = 15.toUInt
    final val YAML_KEY_TOKEN: enum_yaml_token_type_e = 16.toUInt
    final val YAML_VALUE_TOKEN: enum_yaml_token_type_e = 17.toUInt
    final val YAML_ALIAS_TOKEN: enum_yaml_token_type_e = 18.toUInt
    final val YAML_ANCHOR_TOKEN: enum_yaml_token_type_e = 19.toUInt
    final val YAML_TAG_TOKEN: enum_yaml_token_type_e = 20.toUInt
    final val YAML_SCALAR_TOKEN: enum_yaml_token_type_e = 21.toUInt
  }
  type enum_yaml_event_type_e = CUnsignedInt
  object enum_yaml_event_type_e {
    final val YAML_NO_EVENT: enum_yaml_event_type_e = 0.toUInt
    final val YAML_STREAM_START_EVENT: enum_yaml_event_type_e = 1.toUInt
    final val YAML_STREAM_END_EVENT: enum_yaml_event_type_e = 2.toUInt
    final val YAML_DOCUMENT_START_EVENT: enum_yaml_event_type_e = 3.toUInt
    final val YAML_DOCUMENT_END_EVENT: enum_yaml_event_type_e = 4.toUInt
    final val YAML_ALIAS_EVENT: enum_yaml_event_type_e = 5.toUInt
    final val YAML_SCALAR_EVENT: enum_yaml_event_type_e = 6.toUInt
    final val YAML_SEQUENCE_START_EVENT: enum_yaml_event_type_e = 7.toUInt
    final val YAML_SEQUENCE_END_EVENT: enum_yaml_event_type_e = 8.toUInt
    final val YAML_MAPPING_START_EVENT: enum_yaml_event_type_e = 9.toUInt
    final val YAML_MAPPING_END_EVENT: enum_yaml_event_type_e = 10.toUInt
  }
  type enum_yaml_node_type_e = CUnsignedInt
  object enum_yaml_node_type_e {
    final val YAML_NO_NODE: enum_yaml_node_type_e = 0.toUInt
    final val YAML_SCALAR_NODE: enum_yaml_node_type_e = 1.toUInt
    final val YAML_SEQUENCE_NODE: enum_yaml_node_type_e = 2.toUInt
    final val YAML_MAPPING_NODE: enum_yaml_node_type_e = 3.toUInt
  }
  type enum_yaml_parser_state_e = CUnsignedInt
  object enum_yaml_parser_state_e {
    final val YAML_PARSE_STREAM_START_STATE: enum_yaml_parser_state_e = 0.toUInt
    final val YAML_PARSE_IMPLICIT_DOCUMENT_START_STATE
        : enum_yaml_parser_state_e = 1.toUInt
    final val YAML_PARSE_DOCUMENT_START_STATE: enum_yaml_parser_state_e =
      2.toUInt
    final val YAML_PARSE_DOCUMENT_CONTENT_STATE: enum_yaml_parser_state_e =
      3.toUInt
    final val YAML_PARSE_DOCUMENT_END_STATE: enum_yaml_parser_state_e = 4.toUInt
    final val YAML_PARSE_BLOCK_NODE_STATE: enum_yaml_parser_state_e = 5.toUInt
    final val YAML_PARSE_BLOCK_NODE_OR_INDENTLESS_SEQUENCE_STATE
        : enum_yaml_parser_state_e = 6.toUInt
    final val YAML_PARSE_FLOW_NODE_STATE: enum_yaml_parser_state_e = 7.toUInt
    final val YAML_PARSE_BLOCK_SEQUENCE_FIRST_ENTRY_STATE
        : enum_yaml_parser_state_e = 8.toUInt
    final val YAML_PARSE_BLOCK_SEQUENCE_ENTRY_STATE: enum_yaml_parser_state_e =
      9.toUInt
    final val YAML_PARSE_INDENTLESS_SEQUENCE_ENTRY_STATE
        : enum_yaml_parser_state_e = 10.toUInt
    final val YAML_PARSE_BLOCK_MAPPING_FIRST_KEY_STATE
        : enum_yaml_parser_state_e = 11.toUInt
    final val YAML_PARSE_BLOCK_MAPPING_KEY_STATE: enum_yaml_parser_state_e =
      12.toUInt
    final val YAML_PARSE_BLOCK_MAPPING_VALUE_STATE: enum_yaml_parser_state_e =
      13.toUInt
    final val YAML_PARSE_FLOW_SEQUENCE_FIRST_ENTRY_STATE
        : enum_yaml_parser_state_e = 14.toUInt
    final val YAML_PARSE_FLOW_SEQUENCE_ENTRY_STATE: enum_yaml_parser_state_e =
      15.toUInt
    final val YAML_PARSE_FLOW_SEQUENCE_ENTRY_MAPPING_KEY_STATE
        : enum_yaml_parser_state_e = 16.toUInt
    final val YAML_PARSE_FLOW_SEQUENCE_ENTRY_MAPPING_VALUE_STATE
        : enum_yaml_parser_state_e = 17.toUInt
    final val YAML_PARSE_FLOW_SEQUENCE_ENTRY_MAPPING_END_STATE
        : enum_yaml_parser_state_e = 18.toUInt
    final val YAML_PARSE_FLOW_MAPPING_FIRST_KEY_STATE
        : enum_yaml_parser_state_e = 19.toUInt
    final val YAML_PARSE_FLOW_MAPPING_KEY_STATE: enum_yaml_parser_state_e =
      20.toUInt
    final val YAML_PARSE_FLOW_MAPPING_VALUE_STATE: enum_yaml_parser_state_e =
      21.toUInt
    final val YAML_PARSE_FLOW_MAPPING_EMPTY_VALUE_STATE
        : enum_yaml_parser_state_e = 22.toUInt
    final val YAML_PARSE_END_STATE: enum_yaml_parser_state_e = 23.toUInt
  }
  type enum_yaml_emitter_state_e = CUnsignedInt
  object enum_yaml_emitter_state_e {
    final val YAML_EMIT_STREAM_START_STATE: enum_yaml_emitter_state_e = 0.toUInt
    final val YAML_EMIT_FIRST_DOCUMENT_START_STATE: enum_yaml_emitter_state_e =
      1.toUInt
    final val YAML_EMIT_DOCUMENT_START_STATE: enum_yaml_emitter_state_e =
      2.toUInt
    final val YAML_EMIT_DOCUMENT_CONTENT_STATE: enum_yaml_emitter_state_e =
      3.toUInt
    final val YAML_EMIT_DOCUMENT_END_STATE: enum_yaml_emitter_state_e = 4.toUInt
    final val YAML_EMIT_FLOW_SEQUENCE_FIRST_ITEM_STATE
        : enum_yaml_emitter_state_e = 5.toUInt
    final val YAML_EMIT_FLOW_SEQUENCE_ITEM_STATE: enum_yaml_emitter_state_e =
      6.toUInt
    final val YAML_EMIT_FLOW_MAPPING_FIRST_KEY_STATE
        : enum_yaml_emitter_state_e = 7.toUInt
    final val YAML_EMIT_FLOW_MAPPING_KEY_STATE: enum_yaml_emitter_state_e =
      8.toUInt
    final val YAML_EMIT_FLOW_MAPPING_SIMPLE_VALUE_STATE
        : enum_yaml_emitter_state_e = 9.toUInt
    final val YAML_EMIT_FLOW_MAPPING_VALUE_STATE: enum_yaml_emitter_state_e =
      10.toUInt
    final val YAML_EMIT_BLOCK_SEQUENCE_FIRST_ITEM_STATE
        : enum_yaml_emitter_state_e = 11.toUInt
    final val YAML_EMIT_BLOCK_SEQUENCE_ITEM_STATE: enum_yaml_emitter_state_e =
      12.toUInt
    final val YAML_EMIT_BLOCK_MAPPING_FIRST_KEY_STATE
        : enum_yaml_emitter_state_e = 13.toUInt
    final val YAML_EMIT_BLOCK_MAPPING_KEY_STATE: enum_yaml_emitter_state_e =
      14.toUInt
    final val YAML_EMIT_BLOCK_MAPPING_SIMPLE_VALUE_STATE
        : enum_yaml_emitter_state_e = 15.toUInt
    final val YAML_EMIT_BLOCK_MAPPING_VALUE_STATE: enum_yaml_emitter_state_e =
      16.toUInt
    final val YAML_EMIT_END_STATE: enum_yaml_emitter_state_e = 17.toUInt
  }
  type __off_t = CLong
  type __off64_t = CLong
  type struct__IO_FILE
  type FILE = struct__IO_FILE
  type struct__IO_marker = CStruct0 // incomplete type
  type struct__IO_codecvt = CStruct0 // incomplete type
  type struct__IO_wide_data = CStruct0 // incomplete type
  type yaml_char_t = CUnsignedChar
  type struct_yaml_version_directive_s = CStruct2[CInt, CInt]
  type yaml_version_directive_t = struct_yaml_version_directive_s
  type struct_yaml_tag_directive_s =
    CStruct2[Ptr[yaml_char_t], Ptr[yaml_char_t]]
  type yaml_tag_directive_t = struct_yaml_tag_directive_s
  type yaml_encoding_t = enum_yaml_encoding_e
  type yaml_break_t = enum_yaml_break_e
  type yaml_error_type_t = enum_yaml_error_type_e
  type struct_yaml_mark_s = CStruct3[CInt, CInt, CInt]
  type yaml_mark_t = struct_yaml_mark_s
  type yaml_scalar_style_t = enum_yaml_scalar_style_e
  type yaml_sequence_style_t = enum_yaml_sequence_style_e
  type yaml_mapping_style_t = enum_yaml_mapping_style_e
  type yaml_token_type_t = enum_yaml_token_type_e
  type struct_anonymous_1 = CStruct1[enum_yaml_encoding_e]
  type struct_anonymous_2 = CStruct1[Ptr[yaml_char_t]]
  type struct_anonymous_3 = CStruct1[Ptr[yaml_char_t]]
  type struct_anonymous_4 = CStruct2[Ptr[yaml_char_t], Ptr[yaml_char_t]]
  type struct_anonymous_5 =
    CStruct3[Ptr[yaml_char_t], CInt, enum_yaml_scalar_style_e]
  type struct_anonymous_6 = CStruct2[CInt, CInt]
  type struct_anonymous_7 = CStruct2[Ptr[yaml_char_t], Ptr[yaml_char_t]]
  type union_anonymous_1 = CArray[Byte, Nat._1]
  type struct_yaml_token_s = CStruct4[
    enum_yaml_token_type_e,
    union_anonymous_1,
    yaml_mark_t,
    yaml_mark_t
  ]
  type yaml_token_t = struct_yaml_token_s
  type yaml_event_type_t = enum_yaml_event_type_e
  type struct_anonymous_8 = CStruct1[enum_yaml_encoding_e]
  type struct_anonymous_10 =
    CStruct2[Ptr[yaml_tag_directive_t], Ptr[yaml_tag_directive_t]]
  type struct_anonymous_9 =
    CStruct3[Ptr[yaml_version_directive_t], struct_anonymous_10, CInt]
  type struct_anonymous_11 = CStruct1[CInt]
  type struct_anonymous_12 = CStruct1[Ptr[yaml_char_t]]
  type struct_anonymous_13 = CStruct7[Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[
    yaml_char_t
  ], CInt, CInt, CInt, enum_yaml_scalar_style_e]
  type struct_anonymous_14 = CStruct4[Ptr[yaml_char_t], Ptr[
    yaml_char_t
  ], CInt, enum_yaml_sequence_style_e]
  type struct_anonymous_15 = CStruct4[Ptr[yaml_char_t], Ptr[
    yaml_char_t
  ], CInt, enum_yaml_mapping_style_e]
  type union_anonymous_2 = CArray[Byte, Nat._1]
  type struct_yaml_event_s = CStruct4[
    enum_yaml_event_type_e,
    union_anonymous_2,
    yaml_mark_t,
    yaml_mark_t
  ]
  type yaml_event_t = struct_yaml_event_s
  type yaml_node_type_t = enum_yaml_node_type_e
  type struct_yaml_node_s = CStruct5[enum_yaml_node_type_e, Ptr[
    yaml_char_t
  ], union_yaml_node, yaml_mark_t, yaml_mark_t]
  type yaml_node_t = struct_yaml_node_s
  type yaml_node_item_t = CInt
  type struct_yaml_node_pair_s = CStruct2[CInt, CInt]
  type yaml_node_pair_t = struct_yaml_node_pair_s
  type struct_scalar_node =
    CStruct3[Ptr[yaml_char_t], CInt, enum_yaml_scalar_style_e]
  type struct_sequence_item = CStruct3[Ptr[yaml_node_item_t], Ptr[
    yaml_node_item_t
  ], Ptr[yaml_node_item_t]]
  type struct_sequence_node =
    CStruct2[struct_sequence_item, enum_yaml_sequence_style_e]
  type struct_mapping_pair = CStruct3[Ptr[yaml_node_pair_t], Ptr[
    yaml_node_pair_t
  ], Ptr[yaml_node_pair_t]]
  type struct_mapping_node =
    CStruct2[struct_mapping_pair, enum_yaml_mapping_style_e]
  type union_yaml_node = CArray[Byte, Nat._1]
  type struct_anonymous_21 =
    CStruct3[Ptr[yaml_node_t], Ptr[yaml_node_t], Ptr[yaml_node_t]]
  type struct_anonymous_22 =
    CStruct2[Ptr[yaml_tag_directive_t], Ptr[yaml_tag_directive_t]]
  type struct_yaml_document_s = CStruct7[struct_anonymous_21, Ptr[
    yaml_version_directive_t
  ], struct_anonymous_22, CInt, CInt, yaml_mark_t, yaml_mark_t]
  type yaml_document_t = struct_yaml_document_s
  type struct_yaml_simple_key_s = CStruct4[CInt, CInt, CInt, yaml_mark_t]
  type yaml_simple_key_t = struct_yaml_simple_key_s
  type yaml_parser_state_t = enum_yaml_parser_state_e
  type struct_yaml_alias_data_s = CStruct3[Ptr[yaml_char_t], CInt, yaml_mark_t]
  type yaml_alias_data_t = struct_yaml_alias_data_s
  type struct_anonymous_23 =
    CStruct3[Ptr[CUnsignedChar], Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
  type union_anonymous_4 = CArray[Byte, Nat.Digit2[Nat._2, Nat._4]]
  type struct_anonymous_24 = CStruct4[Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[
    yaml_char_t
  ], Ptr[yaml_char_t]]
  type struct_anonymous_25 = CStruct4[Ptr[CUnsignedChar], Ptr[
    CUnsignedChar
  ], Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
  type struct_anonymous_26 = CStruct4[Ptr[yaml_token_t], Ptr[yaml_token_t], Ptr[
    yaml_token_t
  ], Ptr[yaml_token_t]]
  type struct_anonymous_27 = CStruct3[Ptr[CInt], Ptr[CInt], Ptr[CInt]]
  type struct_anonymous_28 = CStruct3[Ptr[yaml_simple_key_t], Ptr[
    yaml_simple_key_t
  ], Ptr[yaml_simple_key_t]]
  type struct_anonymous_29 = CStruct3[Ptr[enum_yaml_parser_state_e], Ptr[
    enum_yaml_parser_state_e
  ], Ptr[enum_yaml_parser_state_e]]
  type struct_anonymous_30 =
    CStruct3[Ptr[yaml_mark_t], Ptr[yaml_mark_t], Ptr[yaml_mark_t]]
  type struct_anonymous_31 = CStruct3[Ptr[yaml_tag_directive_t], Ptr[
    yaml_tag_directive_t
  ], Ptr[yaml_tag_directive_t]]
  type struct_anonymous_32 = CStruct3[Ptr[yaml_alias_data_t], Ptr[
    yaml_alias_data_t
  ], Ptr[yaml_alias_data_t]]
  type struct_yaml_parser_s = CArray[CChar, Nat.Digit3[Nat._4, Nat._8, Nat._0]]
  type yaml_parser_t = struct_yaml_parser_s
  type yaml_emitter_state_t = enum_yaml_emitter_state_e
  type struct_yaml_anchors_s = CStruct3[CInt, CInt, CInt]
  type yaml_anchors_t = struct_yaml_anchors_s
  type struct_anonymous_33 = CStruct3[Ptr[CUnsignedChar], CInt, Ptr[CInt]]
  type union_anonymous_5 = CArray[Byte, Nat._1]
  type struct_anonymous_34 = CStruct4[Ptr[yaml_char_t], Ptr[yaml_char_t], Ptr[
    yaml_char_t
  ], Ptr[yaml_char_t]]
  type struct_anonymous_35 = CStruct4[Ptr[CUnsignedChar], Ptr[
    CUnsignedChar
  ], Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
  type struct_anonymous_36 = CStruct3[Ptr[enum_yaml_emitter_state_e], Ptr[
    enum_yaml_emitter_state_e
  ], Ptr[enum_yaml_emitter_state_e]]
  type struct_anonymous_37 = CStruct4[Ptr[yaml_event_t], Ptr[yaml_event_t], Ptr[
    yaml_event_t
  ], Ptr[yaml_event_t]]
  type struct_anonymous_38 = CStruct3[Ptr[CInt], Ptr[CInt], Ptr[CInt]]
  type struct_anonymous_39 = CStruct3[Ptr[yaml_tag_directive_t], Ptr[
    yaml_tag_directive_t
  ], Ptr[yaml_tag_directive_t]]
  type struct_anonymous_40 = CStruct3[Ptr[yaml_char_t], CInt, CInt]
  type struct_anonymous_41 =
    CStruct4[Ptr[yaml_char_t], CInt, Ptr[yaml_char_t], CInt]
  type struct_anonymous_42 = CStruct8[Ptr[
    yaml_char_t
  ], CInt, CInt, CInt, CInt, CInt, CInt, enum_yaml_scalar_style_e]
  type struct_yaml_emitter_s = CArray[CChar, Nat.Digit3[Nat._4, Nat._3, Nat._2]]
  type yaml_emitter_t = struct_yaml_emitter_s

  object defines {
    val YAML_NULL_TAG: CString = c"tag:yaml.org,2002:null"
    val YAML_BOOL_TAG: CString = c"tag:yaml.org,2002:bool"
    val YAML_STR_TAG: CString = c"tag:yaml.org,2002:str"
    val YAML_INT_TAG: CString = c"tag:yaml.org,2002:int"
    val YAML_FLOAT_TAG: CString = c"tag:yaml.org,2002:float"
    val YAML_TIMESTAMP_TAG: CString = c"tag:yaml.org,2002:timestamp"
    val YAML_SEQ_TAG: CString = c"tag:yaml.org,2002:seq"
    val YAML_MAP_TAG: CString = c"tag:yaml.org,2002:map"
    val YAML_DEFAULT_SCALAR_TAG: CString = c"tag:yaml.org,2002:str"
    val YAML_DEFAULT_SEQUENCE_TAG: CString = c"tag:yaml.org,2002:seq"
    val YAML_DEFAULT_MAPPING_TAG: CString = c"tag:yaml.org,2002:map"
  }
}

@link("yaml")
@extern
object libyaml {
  import definitions._

  def yaml_get_version_string(): CString = extern
  def yaml_get_version(
      major: Ptr[CInt],
      minor: Ptr[CInt],
      patch: Ptr[CInt]
  ): Unit = extern
  def yaml_token_delete(token: Ptr[yaml_token_t]): Unit = extern
  def yaml_stream_start_event_initialize(
      event: Ptr[yaml_event_t],
      encoding: enum_yaml_encoding_e
  ): CInt = extern
  def yaml_stream_end_event_initialize(event: Ptr[yaml_event_t]): CInt = extern
  def yaml_document_start_event_initialize(
      event: Ptr[yaml_event_t],
      version_directive: Ptr[yaml_version_directive_t],
      tag_directives_start: Ptr[yaml_tag_directive_t],
      tag_directives_end: Ptr[yaml_tag_directive_t],
      `implicit`: CInt
  ): CInt = extern
  def yaml_document_end_event_initialize(
      event: Ptr[yaml_event_t],
      `implicit`: CInt
  ): CInt = extern
  def yaml_alias_event_initialize(
      event: Ptr[yaml_event_t],
      anchor: Ptr[yaml_char_t]
  ): CInt = extern
  def yaml_scalar_event_initialize(
      event: Ptr[yaml_event_t],
      anchor: Ptr[yaml_char_t],
      tag: Ptr[yaml_char_t],
      value: Ptr[yaml_char_t],
      length: CInt,
      plain_implicit: CInt,
      quoted_implicit: CInt,
      style: enum_yaml_scalar_style_e
  ): CInt = extern
  def yaml_sequence_start_event_initialize(
      event: Ptr[yaml_event_t],
      anchor: Ptr[yaml_char_t],
      tag: Ptr[yaml_char_t],
      `implicit`: CInt,
      style: enum_yaml_sequence_style_e
  ): CInt = extern
  def yaml_sequence_end_event_initialize(event: Ptr[yaml_event_t]): CInt =
    extern
  def yaml_mapping_start_event_initialize(
      event: Ptr[yaml_event_t],
      anchor: Ptr[yaml_char_t],
      tag: Ptr[yaml_char_t],
      `implicit`: CInt,
      style: enum_yaml_mapping_style_e
  ): CInt = extern
  def yaml_mapping_end_event_initialize(event: Ptr[yaml_event_t]): CInt = extern
  def yaml_event_delete(event: Ptr[yaml_event_t]): Unit = extern
  def yaml_document_initialize(
      document: Ptr[yaml_document_t],
      version_directive: Ptr[yaml_version_directive_t],
      tag_directives_start: Ptr[yaml_tag_directive_t],
      tag_directives_end: Ptr[yaml_tag_directive_t],
      start_implicit: CInt,
      end_implicit: CInt
  ): CInt = extern
  def yaml_document_delete(document: Ptr[yaml_document_t]): Unit = extern
  def yaml_document_get_node(
      document: Ptr[yaml_document_t],
      index: CInt
  ): Ptr[yaml_node_t] = extern
  def yaml_document_get_root_node(
      document: Ptr[yaml_document_t]
  ): Ptr[yaml_node_t] = extern
  def yaml_document_add_scalar(
      document: Ptr[yaml_document_t],
      tag: Ptr[yaml_char_t],
      value: Ptr[yaml_char_t],
      length: CInt,
      style: enum_yaml_scalar_style_e
  ): CInt = extern
  def yaml_document_add_sequence(
      document: Ptr[yaml_document_t],
      tag: Ptr[yaml_char_t],
      style: enum_yaml_sequence_style_e
  ): CInt = extern
  def yaml_document_add_mapping(
      document: Ptr[yaml_document_t],
      tag: Ptr[yaml_char_t],
      style: enum_yaml_mapping_style_e
  ): CInt = extern
  def yaml_document_append_sequence_item(
      document: Ptr[yaml_document_t],
      sequence: CInt,
      item: CInt
  ): CInt = extern
  def yaml_document_append_mapping_pair(
      document: Ptr[yaml_document_t],
      mapping: CInt,
      key: CInt,
      value: CInt
  ): CInt = extern
  def yaml_parser_initialize(parser: Ptr[yaml_parser_t]): CInt = extern
  def yaml_parser_delete(parser: Ptr[yaml_parser_t]): Unit = extern
  def yaml_parser_set_input_string(
      parser: Ptr[yaml_parser_t],
      input: Ptr[CUnsignedChar],
      size: CInt
  ): Unit = extern
  def yaml_parser_set_input_file(
      parser: Ptr[yaml_parser_t],
      file: Ptr[FILE]
  ): Unit = extern
  def yaml_parser_set_input(
      parser: Ptr[yaml_parser_t],
      handler: CFuncPtr4[Ptr[Byte], Ptr[CUnsignedChar], CInt, Ptr[
        CInt
      ], CInt],
      data: Ptr[Byte]
  ): Unit = extern
  def yaml_parser_set_encoding(
      parser: Ptr[yaml_parser_t],
      encoding: enum_yaml_encoding_e
  ): Unit = extern
  def yaml_parser_scan(
      parser: Ptr[yaml_parser_t],
      token: Ptr[yaml_token_t]
  ): CInt = extern
  def yaml_parser_parse(
      parser: Ptr[yaml_parser_t],
      event: Ptr[yaml_event_t]
  ): CInt = extern
  def yaml_parser_load(
      parser: Ptr[yaml_parser_t],
      document: Ptr[yaml_document_t]
  ): CInt = extern
  def yaml_emitter_initialize(emitter: Ptr[yaml_emitter_t]): CInt = extern
  def yaml_emitter_delete(emitter: Ptr[yaml_emitter_t]): Unit = extern
  def yaml_emitter_set_output_string(
      emitter: Ptr[yaml_emitter_t],
      output: Ptr[CUnsignedChar],
      size: CInt,
      size_written: Ptr[CInt]
  ): Unit = extern
  def yaml_emitter_set_output_file(
      emitter: Ptr[yaml_emitter_t],
      file: Ptr[FILE]
  ): Unit = extern
  def yaml_emitter_set_output(
      emitter: Ptr[yaml_emitter_t],
      handler: CFuncPtr3[Ptr[Byte], Ptr[CUnsignedChar], CInt, CInt],
      data: Ptr[Byte]
  ): Unit = extern
  def yaml_emitter_set_encoding(
      emitter: Ptr[yaml_emitter_t],
      encoding: enum_yaml_encoding_e
  ): Unit = extern
  def yaml_emitter_set_canonical(
      emitter: Ptr[yaml_emitter_t],
      canonical: CInt
  ): Unit = extern
  def yaml_emitter_set_indent(
      emitter: Ptr[yaml_emitter_t],
      indent: CInt
  ): Unit = extern
  def yaml_emitter_set_width(emitter: Ptr[yaml_emitter_t], width: CInt): Unit =
    extern
  def yaml_emitter_set_unicode(
      emitter: Ptr[yaml_emitter_t],
      unicode: CInt
  ): Unit = extern
  def yaml_emitter_set_break(
      emitter: Ptr[yaml_emitter_t],
      line_break: enum_yaml_break_e
  ): Unit = extern
  def yaml_emitter_emit(
      emitter: Ptr[yaml_emitter_t],
      event: Ptr[yaml_event_t]
  ): CInt = extern
  def yaml_emitter_open(emitter: Ptr[yaml_emitter_t]): CInt = extern
  def yaml_emitter_close(emitter: Ptr[yaml_emitter_t]): CInt = extern
  def yaml_emitter_dump(
      emitter: Ptr[yaml_emitter_t],
      document: Ptr[yaml_document_t]
  ): CInt = extern
  def yaml_emitter_flush(emitter: Ptr[yaml_emitter_t]): CInt = extern
}

object others {
  import definitions._
  object implicits {
    implicit class struct_yaml_version_directive_s_ops(
        val p: Ptr[struct_yaml_version_directive_s]
    ) extends AnyVal {
      def major: CInt = !p.at1
      def major_=(value: CInt): Unit = p._1 = value
      def minor: CInt = !p.at2
      def minor_=(value: CInt): Unit = p._2 = value
    }
    implicit class struct_yaml_tag_directive_s_ops(
        val p: Ptr[struct_yaml_tag_directive_s]
    ) extends AnyVal {
      def handle: Ptr[yaml_char_t] = !p.at1
      def handle_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
      def prefix: Ptr[yaml_char_t] = !p.at2
      def prefix_=(value: Ptr[yaml_char_t]): Unit = (!p)._2 = value
    }
    implicit class struct_yaml_mark_s_ops(val p: Ptr[struct_yaml_mark_s])
        extends AnyVal {
      def index: CInt = !p.at1
      def index_=(value: CInt): Unit = (!p)._1 = value
      def line: CInt = !p.at2
      def line_=(value: CInt): Unit = (!p)._2 = value
      def column: CInt = !p.at3
      def column_=(value: CInt): Unit = (!p)._3 = value
    }
    implicit class struct_anonymous_1_ops(val p: Ptr[struct_anonymous_1])
        extends AnyVal {
      def encoding: enum_yaml_encoding_e = !p.at1
      def encoding_=(value: enum_yaml_encoding_e): Unit = (!p)._1 = value
    }
    implicit class struct_anonymous_2_ops(val p: Ptr[struct_anonymous_2])
        extends AnyVal {
      def value: Ptr[yaml_char_t] = !p.at1
      def value_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
    }
    implicit class struct_anonymous_3_ops(val p: Ptr[struct_anonymous_3])
        extends AnyVal {
      def value: Ptr[yaml_char_t] = !p.at1
      def value_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
    }
    implicit class struct_anonymous_4_ops(val p: Ptr[struct_anonymous_4])
        extends AnyVal {
      def handle: Ptr[yaml_char_t] = !p.at1
      def handle_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
      def suffix: Ptr[yaml_char_t] = !p.at2
      def suffix_=(value: Ptr[yaml_char_t]): Unit = (!p)._2 = value
    }

    implicit class struct_anonymous_6_ops(val p: Ptr[struct_anonymous_6])
        extends AnyVal {
      def major: CInt = !p.at1
      def major_=(value: CInt): Unit = (!p)._1 = value
      def minor: CInt = !p.at2
      def minor_=(value: CInt): Unit = (!p)._2 = value
    }
    implicit class struct_anonymous_7_ops(val p: Ptr[struct_anonymous_7])
        extends AnyVal {
      def handle: Ptr[yaml_char_t] = !p.at1
      def handle_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
      def prefix: Ptr[yaml_char_t] = !p.at2
      def prefix_=(value: Ptr[yaml_char_t]): Unit = (!p)._2 = value
    }
    implicit class struct_yaml_token_s_ops(val p: Ptr[struct_yaml_token_s])
        extends AnyVal {
      def `type`: enum_yaml_token_type_e = !p.at1
      def `type_=`(value: enum_yaml_token_type_e): Unit = (!p)._1 = value
      def data: Ptr[union_anonymous_1] = p.at2
      def data_=(value: Ptr[union_anonymous_1]): Unit = (!p)._2 = !value
      def start_mark: Ptr[yaml_mark_t] = p.at3
      def start_mark_=(value: Ptr[yaml_mark_t]): Unit = (!p)._3 = !value
      def end_mark: Ptr[yaml_mark_t] = p.at4
      def end_mark_=(value: Ptr[yaml_mark_t]): Unit = (!p)._4 = !value
    }
    implicit class struct_anonymous_8_ops(val p: Ptr[struct_anonymous_8])
        extends AnyVal {
      def encoding: enum_yaml_encoding_e = !p.at1
      def encoding_=(value: enum_yaml_encoding_e): Unit = (!p)._1 = value
    }
    implicit class struct_anonymous_10_ops(val p: Ptr[struct_anonymous_10])
        extends AnyVal {
      def start: Ptr[yaml_tag_directive_t] = !p.at1
      def start_=(value: Ptr[yaml_tag_directive_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_tag_directive_t] = !p.at2
      def end_=(value: Ptr[yaml_tag_directive_t]): Unit = (!p)._2 = value
    }
    implicit class struct_anonymous_9_ops(val p: Ptr[struct_anonymous_9])
        extends AnyVal {
      def version_directive: Ptr[yaml_version_directive_t] = !p.at1
      def version_directive_=(value: Ptr[yaml_version_directive_t]): Unit =
        (!p)._1 = value
      def tag_directives: Ptr[struct_anonymous_10] = p.at2
      def tag_directives_=(value: Ptr[struct_anonymous_10]): Unit = (!p)._2 =
        !value
      def `implicit`: CInt = !p.at3
      def `implicit_=`(value: CInt): Unit = (!p)._3 = value
    }
    implicit class struct_anonymous_11_ops(val p: Ptr[struct_anonymous_11])
        extends AnyVal {
      def `implicit`: CInt = !p.at1
      def `implicit_=`(value: CInt): Unit = (!p)._1 = value
    }
    implicit class struct_anonymous_12_ops(val p: Ptr[struct_anonymous_12])
        extends AnyVal {
      def anchor: Ptr[yaml_char_t] = !p.at1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
    }
    implicit class struct_anonymous_13_ops(val p: Ptr[struct_anonymous_13])
        extends AnyVal {
      def anchor: Ptr[yaml_char_t] = !p.at1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
      def tag: Ptr[yaml_char_t] = !p.at2
      def tag_=(value: Ptr[yaml_char_t]): Unit = (!p)._2 = value
      def value: Ptr[yaml_char_t] = !p.at3
      def value_=(value: Ptr[yaml_char_t]): Unit = (!p)._3 = value
      def length: CInt = !p.at4
      def length_=(value: CInt): Unit = (!p)._4 = value
      def plain_implicit: CInt = !p.at5
      def plain_implicit_=(value: CInt): Unit = (!p)._5 = value
      def quoted_implicit: CInt = !p.at6
      def quoted_implicit_=(value: CInt): Unit = (!p)._6 = value
      def style: enum_yaml_scalar_style_e = !p.at7
      def style_=(value: enum_yaml_scalar_style_e): Unit = (!p)._7 = value
    }
    implicit class struct_anonymous_14_ops(val p: Ptr[struct_anonymous_14])
        extends AnyVal {
      def anchor: Ptr[yaml_char_t] = !p.at1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
      def tag: Ptr[yaml_char_t] = !p.at2
      def tag_=(value: Ptr[yaml_char_t]): Unit = (!p)._2 = value
      def `implicit`: CInt = !p.at3
      def `implicit_=`(value: CInt): Unit = (!p)._3 = value
      def style: enum_yaml_sequence_style_e = !p.at4
      def style_=(value: enum_yaml_sequence_style_e): Unit = (!p)._4 = value
    }
    implicit class struct_anonymous_15_ops(val p: Ptr[struct_anonymous_15])
        extends AnyVal {
      def anchor: Ptr[yaml_char_t] = !p.at1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
      def tag: Ptr[yaml_char_t] = !p.at2
      def tag_=(value: Ptr[yaml_char_t]): Unit = (!p)._2 = value
      def `implicit`: CInt = !p.at3
      def `implicit_=`(value: CInt): Unit = (!p)._3 = value
      def style: enum_yaml_mapping_style_e = !p.at4
      def style_=(value: enum_yaml_mapping_style_e): Unit = (!p)._4 = value
    }
    implicit class struct_yaml_event_s_ops(val p: Ptr[struct_yaml_event_s])
        extends AnyVal {
      def `type`: enum_yaml_event_type_e = !p.at1
      def `type_=`(value: enum_yaml_event_type_e): Unit = (!p)._1 = value
      def data: Ptr[union_anonymous_2] = p.at2
      def data_=(value: Ptr[union_anonymous_2]): Unit = (!p)._2 = !value
      def start_mark: Ptr[yaml_mark_t] = p.at3
      def start_mark_=(value: Ptr[yaml_mark_t]): Unit = (!p)._3 = !value
      def end_mark: Ptr[yaml_mark_t] = p.at4
      def end_mark_=(value: Ptr[yaml_mark_t]): Unit = (!p)._4 = !value
    }
    implicit class struct_yaml_node_pair_s_ops(
        val p: Ptr[struct_yaml_node_pair_s]
    ) extends AnyVal {
      def key: CInt = !p.at1
      def key_=(value: CInt): Unit = (!p)._1 = value
      def value: CInt = !p.at2
      def value_=(value: CInt): Unit = (!p)._2 = value
    }
    implicit class struct_scalar_node_ops(val p: Ptr[struct_scalar_node])
        extends AnyVal {
      def value: Ptr[yaml_char_t] = !p.at1
      def value_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
      def length: CInt = !p.at2
      def length_=(value: CInt): Unit = (!p)._2 = value
      def style: enum_yaml_scalar_style_e = !p.at3
      def style_=(value: enum_yaml_scalar_style_e): Unit = (!p)._3 = value
    }
    implicit class struct_sequence_item_ops(val p: Ptr[struct_sequence_item])
        extends AnyVal {
      def start: Ptr[yaml_node_item_t] = !p.at1
      def start_=(value: Ptr[yaml_node_item_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_node_item_t] = !p.at2
      def end_=(value: Ptr[yaml_node_item_t]): Unit = (!p)._2 = value
      def top: Ptr[yaml_node_item_t] = !p.at3
      def top_=(value: Ptr[yaml_node_item_t]): Unit = (!p)._3 = value
    }
    implicit class struct_sequence_node_ops(val p: Ptr[struct_sequence_node])
        extends AnyVal {
      def items: Ptr[struct_sequence_item] = p.at1
      def items_=(value: Ptr[struct_sequence_item]): Unit = (!p)._1 = !value
      def style: enum_yaml_sequence_style_e = !p.at2
      def style_=(value: enum_yaml_sequence_style_e): Unit = (!p)._2 = value
    }
    implicit class struct_mapping_ops(val p: Ptr[struct_mapping_pair])
        extends AnyVal {
      def start: Ptr[yaml_node_pair_t] = !p.at1
      def start_=(value: Ptr[yaml_node_pair_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_node_pair_t] = !p.at2
      def end_=(value: Ptr[yaml_node_pair_t]): Unit = (!p)._2 = value
      def top: Ptr[yaml_node_pair_t] = !p.at3
      def top_=(value: Ptr[yaml_node_pair_t]): Unit = (!p)._3 = value
    }
    implicit class struct_mapping_node_ops(val p: Ptr[struct_mapping_node])
        extends AnyVal {
      def pairs: Ptr[struct_mapping_pair] = p.at1
      def pairs_=(value: Ptr[struct_mapping_pair]): Unit = (!p)._1 = !value
      def style: enum_yaml_mapping_style_e = !p.at2
      def style_=(value: enum_yaml_mapping_style_e): Unit = (!p)._2 = value
    }
    implicit class struct_yaml_node_s_ops(val p: Ptr[struct_yaml_node_s])
        extends AnyVal {
      def `type`: enum_yaml_node_type_e = !p.at1
      def `type_=`(value: enum_yaml_node_type_e): Unit = (!p)._1 = value
      def tag: Ptr[yaml_char_t] = !p.at2
      def tag_=(value: Ptr[yaml_char_t]): Unit = (!p)._2 = value
      def data: Ptr[union_yaml_node] = p.at3
      def data_=(value: Ptr[union_yaml_node]): Unit = (!p)._3 = !value
      def start_mark: Ptr[yaml_mark_t] = p.at4
      def start_mark_=(value: Ptr[yaml_mark_t]): Unit = (!p)._4 = !value
      def end_mark: Ptr[yaml_mark_t] = p.at5
      def end_mark_=(value: Ptr[yaml_mark_t]): Unit = (!p)._5 = !value
    }
    implicit class struct_anonymous_21_ops(val p: Ptr[struct_anonymous_21])
        extends AnyVal {
      def start: Ptr[yaml_node_t] = !p.at1
      def start_=(value: Ptr[yaml_node_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_node_t] = !p.at2
      def end_=(value: Ptr[yaml_node_t]): Unit = (!p)._2 = value
      def top: Ptr[yaml_node_t] = !p.at3
      def top_=(value: Ptr[yaml_node_t]): Unit = (!p)._3 = value
    }
    implicit class struct_anonymous_22_ops(val p: Ptr[struct_anonymous_22])
        extends AnyVal {
      def start: Ptr[yaml_tag_directive_t] = !p.at1
      def start_=(value: Ptr[yaml_tag_directive_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_tag_directive_t] = !p.at2
      def end_=(value: Ptr[yaml_tag_directive_t]): Unit = (!p)._2 = value
    }
    implicit class struct_yaml_document_s_ops(
        val p: Ptr[struct_yaml_document_s]
    ) extends AnyVal {
      def nodes: Ptr[struct_anonymous_21] = p.at1
      def nodes_=(value: Ptr[struct_anonymous_21]): Unit = (!p)._1 = !value
      def version_directive: Ptr[yaml_version_directive_t] = !p.at2
      def version_directive_=(value: Ptr[yaml_version_directive_t]): Unit =
        (!p)._2 = value
      def tag_directives: Ptr[struct_anonymous_22] = p.at3
      def tag_directives_=(value: Ptr[struct_anonymous_22]): Unit = (!p)._3 =
        !value
      def start_implicit: CInt = !p.at4
      def start_implicit_=(value: CInt): Unit = (!p)._4 = value
      def end_implicit: CInt = !p.at5
      def end_implicit_=(value: CInt): Unit = (!p)._5 = value
      def start_mark: Ptr[yaml_mark_t] = p.at6
      def start_mark_=(value: Ptr[yaml_mark_t]): Unit = (!p)._6 = !value
      def end_mark: Ptr[yaml_mark_t] = p.at7
      def end_mark_=(value: Ptr[yaml_mark_t]): Unit = (!p)._7 = !value
    }
    implicit class struct_yaml_simple_key_s_ops(
        val p: Ptr[struct_yaml_simple_key_s]
    ) extends AnyVal {
      def possible: CInt = !p.at1
      def possible_=(value: CInt): Unit = (!p)._1 = value
      def required: CInt = !p.at2
      def required_=(value: CInt): Unit = (!p)._2 = value
      def token_number: CInt = !p.at3
      def token_number_=(value: CInt): Unit = (!p)._3 = value
      def mark: Ptr[yaml_mark_t] = p.at4
      def mark_=(value: Ptr[yaml_mark_t]): Unit = (!p)._4 = !value
    }
    implicit class struct_yaml_alias_data_s_ops(
        val p: Ptr[struct_yaml_alias_data_s]
    ) extends AnyVal {
      def anchor: Ptr[yaml_char_t] = !p.at1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
      def index: CInt = !p.at2
      def index_=(value: CInt): Unit = (!p)._2 = value
      def mark: Ptr[yaml_mark_t] = p.at3
      def mark_=(value: Ptr[yaml_mark_t]): Unit = (!p)._3 = !value
    }
    implicit class struct_anonymous_23_ops(val p: Ptr[struct_anonymous_23])
        extends AnyVal {
      def start: Ptr[CUnsignedChar] = !p.at1
      def start_=(value: Ptr[CUnsignedChar]): Unit = (!p)._1 = value
      def end: Ptr[CUnsignedChar] = !p.at2
      def end_=(value: Ptr[CUnsignedChar]): Unit = (!p)._2 = value
      def current: Ptr[CUnsignedChar] = !p.at3
      def current_=(value: Ptr[CUnsignedChar]): Unit = (!p)._3 = value
    }
    implicit class struct_anonymous_24_ops(val p: Ptr[struct_anonymous_24])
        extends AnyVal {
      def start: Ptr[yaml_char_t] = !p.at1
      def start_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_char_t] = !p.at2
      def end_=(value: Ptr[yaml_char_t]): Unit = (!p)._2 = value
      def pointer: Ptr[yaml_char_t] = !p.at3
      def pointer_=(value: Ptr[yaml_char_t]): Unit = (!p)._3 = value
      def last: Ptr[yaml_char_t] = !p.at4
      def last_=(value: Ptr[yaml_char_t]): Unit = (!p)._4 = value
    }
    implicit class struct_anonymous_25_ops(val p: Ptr[struct_anonymous_25])
        extends AnyVal {
      def start: Ptr[CUnsignedChar] = !p.at1
      def start_=(value: Ptr[CUnsignedChar]): Unit = (!p)._1 = value
      def end: Ptr[CUnsignedChar] = !p.at2
      def end_=(value: Ptr[CUnsignedChar]): Unit = (!p)._2 = value
      def pointer: Ptr[CUnsignedChar] = !p.at3
      def pointer_=(value: Ptr[CUnsignedChar]): Unit = (!p)._3 = value
      def last: Ptr[CUnsignedChar] = !p.at4
      def last_=(value: Ptr[CUnsignedChar]): Unit = (!p)._4 = value
    }
    implicit class struct_anonymous_26_ops(val p: Ptr[struct_anonymous_26])
        extends AnyVal {
      def start: Ptr[yaml_token_t] = !p.at1
      def start_=(value: Ptr[yaml_token_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_token_t] = !p.at2
      def end_=(value: Ptr[yaml_token_t]): Unit = (!p)._2 = value
      def head: Ptr[yaml_token_t] = !p.at3
      def head_=(value: Ptr[yaml_token_t]): Unit = (!p)._3 = value
      def tail: Ptr[yaml_token_t] = !p.at4
      def tail_=(value: Ptr[yaml_token_t]): Unit = (!p)._4 = value
    }

    implicit class struct_anonymous_28_ops(val p: Ptr[struct_anonymous_28])
        extends AnyVal {
      def start: Ptr[yaml_simple_key_t] = !p.at1
      def start_=(value: Ptr[yaml_simple_key_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_simple_key_t] = !p.at2
      def end_=(value: Ptr[yaml_simple_key_t]): Unit = (!p)._2 = value
      def top: Ptr[yaml_simple_key_t] = !p.at3
      def top_=(value: Ptr[yaml_simple_key_t]): Unit = (!p)._3 = value
    }
    implicit class struct_anonymous_29_ops(val p: Ptr[struct_anonymous_29])
        extends AnyVal {
      def start: Ptr[enum_yaml_parser_state_e] = !p.at1
      def start_=(value: Ptr[enum_yaml_parser_state_e]): Unit = (!p)._1 = value
      def end: Ptr[enum_yaml_parser_state_e] = !p.at2
      def end_=(value: Ptr[enum_yaml_parser_state_e]): Unit = (!p)._2 = value
      def top: Ptr[enum_yaml_parser_state_e] = !p.at3
      def top_=(value: Ptr[enum_yaml_parser_state_e]): Unit = (!p)._3 = value
    }
    implicit class struct_anonymous_30_ops(val p: Ptr[struct_anonymous_30])
        extends AnyVal {
      def start: Ptr[yaml_mark_t] = !p.at1
      def start_=(value: Ptr[yaml_mark_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_mark_t] = !p.at2
      def end_=(value: Ptr[yaml_mark_t]): Unit = (!p)._2 = value
      def top: Ptr[yaml_mark_t] = !p.at3
      def top_=(value: Ptr[yaml_mark_t]): Unit = (!p)._3 = value
    }
    implicit class struct_anonymous_31_ops(val p: Ptr[struct_anonymous_31])
        extends AnyVal {
      def start: Ptr[yaml_tag_directive_t] = !p.at1
      def start_=(value: Ptr[yaml_tag_directive_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_tag_directive_t] = !p.at2
      def end_=(value: Ptr[yaml_tag_directive_t]): Unit = (!p)._2 = value
      def top: Ptr[yaml_tag_directive_t] = !p.at3
      def top_=(value: Ptr[yaml_tag_directive_t]): Unit = (!p)._3 = value
    }
    implicit class struct_anonymous_32_ops(val p: Ptr[struct_anonymous_32])
        extends AnyVal {
      def start: Ptr[yaml_alias_data_t] = !p.at1
      def start_=(value: Ptr[yaml_alias_data_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_alias_data_t] = !p.at2
      def end_=(value: Ptr[yaml_alias_data_t]): Unit = (!p)._2 = value
      def top: Ptr[yaml_alias_data_t] = !p.at3
      def top_=(value: Ptr[yaml_alias_data_t]): Unit = (!p)._3 = value
    }
    implicit class struct_yaml_anchors_s_ops(val p: Ptr[struct_yaml_anchors_s])
        extends AnyVal {
      def references: CInt = !p.at1
      def references_=(value: CInt): Unit = (!p)._1 = value
      def anchor: CInt = !p.at2
      def anchor_=(value: CInt): Unit = (!p)._2 = value
      def serialized: CInt = !p.at3
      def serialized_=(value: CInt): Unit = (!p)._3 = value
    }
    implicit class struct_anonymous_33_ops(val p: Ptr[struct_anonymous_33])
        extends AnyVal {
      def buffer: Ptr[CUnsignedChar] = !p.at1
      def buffer_=(value: Ptr[CUnsignedChar]): Unit = (!p)._1 = value
      def size: CInt = !p.at2
      def size_=(value: CInt): Unit = (!p)._2 = value
      def size_written: Ptr[CInt] = !p.at3
      def size_written_=(value: Ptr[CInt]): Unit = (!p)._3 = value
    }
    implicit class struct_anonymous_34_ops(val p: Ptr[struct_anonymous_34])
        extends AnyVal {
      def start: Ptr[yaml_char_t] = !p.at1
      def start_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_char_t] = !p.at2
      def end_=(value: Ptr[yaml_char_t]): Unit = (!p)._2 = value
      def pointer: Ptr[yaml_char_t] = !p.at3
      def pointer_=(value: Ptr[yaml_char_t]): Unit = (!p)._3 = value
      def last: Ptr[yaml_char_t] = !p.at4
      def last_=(value: Ptr[yaml_char_t]): Unit = (!p)._4 = value
    }
    implicit class struct_anonymous_35_ops(val p: Ptr[struct_anonymous_35])
        extends AnyVal {
      def start: Ptr[CUnsignedChar] = !p.at1
      def start_=(value: Ptr[CUnsignedChar]): Unit = (!p)._1 = value
      def end: Ptr[CUnsignedChar] = !p.at2
      def end_=(value: Ptr[CUnsignedChar]): Unit = (!p)._2 = value
      def pointer: Ptr[CUnsignedChar] = !p.at3
      def pointer_=(value: Ptr[CUnsignedChar]): Unit = (!p)._3 = value
      def last: Ptr[CUnsignedChar] = !p.at4
      def last_=(value: Ptr[CUnsignedChar]): Unit = (!p)._4 = value
    }
    implicit class struct_anonymous_36_ops(val p: Ptr[struct_anonymous_36])
        extends AnyVal {
      def start: Ptr[enum_yaml_emitter_state_e] = !p.at1
      def start_=(value: Ptr[enum_yaml_emitter_state_e]): Unit = (!p)._1 = value
      def end: Ptr[enum_yaml_emitter_state_e] = !p.at2
      def end_=(value: Ptr[enum_yaml_emitter_state_e]): Unit = (!p)._2 = value
      def top: Ptr[enum_yaml_emitter_state_e] = !p.at3
      def top_=(value: Ptr[enum_yaml_emitter_state_e]): Unit = (!p)._3 = value
    }
    implicit class struct_anonymous_37_ops(val p: Ptr[struct_anonymous_37])
        extends AnyVal {
      def start: Ptr[yaml_event_t] = !p.at1
      def start_=(value: Ptr[yaml_event_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_event_t] = !p.at2
      def end_=(value: Ptr[yaml_event_t]): Unit = (!p)._2 = value
      def head: Ptr[yaml_event_t] = !p.at3
      def head_=(value: Ptr[yaml_event_t]): Unit = (!p)._3 = value
      def tail: Ptr[yaml_event_t] = !p.at4
      def tail_=(value: Ptr[yaml_event_t]): Unit = (!p)._4 = value
    }

    implicit class struct_anonymous_39_ops(val p: Ptr[struct_anonymous_39])
        extends AnyVal {
      def start: Ptr[yaml_tag_directive_t] = !p.at1
      def start_=(value: Ptr[yaml_tag_directive_t]): Unit = (!p)._1 = value
      def end: Ptr[yaml_tag_directive_t] = !p.at2
      def end_=(value: Ptr[yaml_tag_directive_t]): Unit = (!p)._2 = value
      def top: Ptr[yaml_tag_directive_t] = !p.at3
      def top_=(value: Ptr[yaml_tag_directive_t]): Unit = (!p)._3 = value
    }
    implicit class struct_anonymous_40_ops(val p: Ptr[struct_anonymous_40])
        extends AnyVal {
      def anchor: Ptr[yaml_char_t] = !p.at1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
      def anchor_length: CInt = !p.at2
      def anchor_length_=(value: CInt): Unit = (!p)._2 = value
      def alias: CInt = !p.at3
      def alias_=(value: CInt): Unit = (!p)._3 = value
    }
    implicit class struct_anonymous_41_ops(val p: Ptr[struct_anonymous_41])
        extends AnyVal {
      def handle: Ptr[yaml_char_t] = !p.at1
      def handle_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
      def handle_length: CInt = !p.at2
      def handle_length_=(value: CInt): Unit = (!p)._2 = value
      def suffix: Ptr[yaml_char_t] = !p.at3
      def suffix_=(value: Ptr[yaml_char_t]): Unit = (!p)._3 = value
      def suffix_length: CInt = !p.at4
      def suffix_length_=(value: CInt): Unit = (!p)._4 = value
    }
    implicit class struct_anonymous_42_ops(val p: Ptr[struct_anonymous_42])
        extends AnyVal {
      def value: Ptr[yaml_char_t] = !p.at1
      def value_=(value: Ptr[yaml_char_t]): Unit = (!p)._1 = value
      def length: CInt = !p.at2
      def length_=(value: CInt): Unit = (!p)._2 = value
      def multiline: CInt = !p.at3
      def multiline_=(value: CInt): Unit = (!p)._3 = value
      def flow_plain_allowed: CInt = !p.at4
      def flow_plain_allowed_=(value: CInt): Unit = (!p)._4 = value
      def block_plain_allowed: CInt = !p.at5
      def block_plain_allowed_=(value: CInt): Unit = (!p)._5 = value
      def single_quoted_allowed: CInt = !p.at6
      def single_quoted_allowed_=(value: CInt): Unit = (!p)._6 = value
      def block_allowed: CInt = !p.at7
      def block_allowed_=(value: CInt): Unit = (!p)._7 = value
      def style: enum_yaml_scalar_style_e = !p.at8
      def style_=(value: enum_yaml_scalar_style_e): Unit = (!p)._8 = value
    }

    implicit class union_yaml_node_pos(val p: Ptr[union_yaml_node])
        extends AnyVal {
      def scalar: Ptr[struct_scalar_node] =
        p.asInstanceOf[Ptr[struct_scalar_node]]
      def scalar_=(value: Ptr[struct_scalar_node]): Unit =
        !p.asInstanceOf[Ptr[struct_scalar_node]] = !value
      def sequence: Ptr[struct_sequence_node] =
        p.asInstanceOf[Ptr[struct_sequence_node]]
      def sequence_=(value: Ptr[struct_sequence_node]): Unit =
        !p.asInstanceOf[Ptr[struct_sequence_node]] = !value
      def mapping: Ptr[struct_mapping_node] =
        p.asInstanceOf[Ptr[struct_mapping_node]]
      def mapping_=(value: Ptr[struct_mapping_node]): Unit =
        !p.asInstanceOf[Ptr[struct_mapping_node]] = !value
    }
    implicit class union_anonymous_4_pos(val p: Ptr[union_anonymous_4])
        extends AnyVal {
      def string: Ptr[struct_anonymous_23] =
        p.asInstanceOf[Ptr[struct_anonymous_23]]
      def string_=(value: Ptr[struct_anonymous_23]): Unit =
        !p.asInstanceOf[Ptr[struct_anonymous_23]] = !value
      def file: Ptr[Ptr[FILE]] = p.asInstanceOf[Ptr[Ptr[FILE]]]
      def file_=(value: Ptr[FILE]): Unit = !p.asInstanceOf[Ptr[Ptr[FILE]]] =
        value
    }
    implicit class union_anonymous_5_pos(val p: Ptr[union_anonymous_5])
        extends AnyVal {
      def string: Ptr[struct_anonymous_33] =
        p.asInstanceOf[Ptr[struct_anonymous_33]]
      def string_=(value: Ptr[struct_anonymous_33]): Unit =
        !p.asInstanceOf[Ptr[struct_anonymous_33]] = !value
      def file: Ptr[Ptr[FILE]] = p.asInstanceOf[Ptr[Ptr[FILE]]]
      def file_=(value: Ptr[FILE]): Unit = !p.asInstanceOf[Ptr[Ptr[FILE]]] =
        value
    }
  }

  object struct_yaml_version_directive_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_version_directive_s] =
      alloc[struct_yaml_version_directive_s]()
  }
  object struct_yaml_tag_directive_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_tag_directive_s] =
      alloc[struct_yaml_tag_directive_s]()
  }
  object struct_yaml_mark_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_mark_s] =
      alloc[struct_yaml_mark_s]()
  }
  object struct_yaml_token_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_token_s] =
      alloc[struct_yaml_token_s]()
  }
  object struct_yaml_event_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_event_s] =
      alloc[struct_yaml_event_s]()
  }
  object struct_yaml_node_pair_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_node_pair_s] =
      alloc[struct_yaml_node_pair_s]()
  }
  object struct_yaml_node_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_node_s] =
      alloc[struct_yaml_node_s]()
  }
  object struct_yaml_document_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_document_s] =
      alloc[struct_yaml_document_s]()
  }
  object struct_yaml_simple_key_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_simple_key_s] =
      alloc[struct_yaml_simple_key_s]()
  }
  object struct_yaml_alias_data_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_alias_data_s] =
      alloc[struct_yaml_alias_data_s]()
  }
  object struct_yaml_parser_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_parser_s] =
      alloc[struct_yaml_parser_s]()
  }
  object struct_yaml_anchors_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_anchors_s] =
      alloc[struct_yaml_anchors_s]()
  }
  object struct_yaml_emitter_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_emitter_s] =
      alloc[struct_yaml_emitter_s]()
  }

}

package dev.hnaderi.libyaml_binding

import scala.scalanative._
import scala.scalanative.unsigned._
import scala.scalanative.unsafe._

@link("libyaml")
@extern
object libyaml {
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
  type struct__IO_FILE = CStruct29[
    CInt,
    CString,
    CString,
    CString,
    CString,
    CString,
    CString,
    CString,
    CString,
    CString,
    CString,
    CString,
    Ptr[struct__IO_marker],
    Ptr[Byte],
    CInt,
    CInt,
    __off_t,
    CUnsignedShort,
    CSignedChar,
    CArray[CChar, Nat._1],
    Ptr[Byte],
    __off64_t,
    Ptr[struct__IO_codecvt],
    Ptr[struct__IO_wide_data],
    Ptr[Byte],
    Ptr[Byte],
    CInt,
    CInt,
    CChar
  ]
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
  ], union_anonymous_3, yaml_mark_t, yaml_mark_t]
  type yaml_node_t = struct_yaml_node_s
  type yaml_node_item_t = CInt
  type struct_yaml_node_pair_s = CStruct2[CInt, CInt]
  type yaml_node_pair_t = struct_yaml_node_pair_s
  type struct_anonymous_16 =
    CStruct3[Ptr[yaml_char_t], CInt, enum_yaml_scalar_style_e]
  type struct_anonymous_18 = CStruct3[Ptr[yaml_node_item_t], Ptr[
    yaml_node_item_t
  ], Ptr[yaml_node_item_t]]
  type struct_anonymous_17 =
    CStruct2[struct_anonymous_18, enum_yaml_sequence_style_e]
  type struct_anonymous_20 = CStruct3[Ptr[yaml_node_pair_t], Ptr[
    yaml_node_pair_t
  ], Ptr[yaml_node_pair_t]]
  type struct_anonymous_19 =
    CStruct2[struct_anonymous_20, enum_yaml_mapping_style_e]
  type union_anonymous_3 = CArray[Byte, Nat._1]
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
  type union_anonymous_4 = CArray[Byte, Nat.Digit[Nat._2, Nat._4]]
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
  type struct_yaml_parser_s = CArray[Byte, Nat._1]
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
  type struct_yaml_emitter_s = CArray[Byte, Nat._1]
  type yaml_emitter_t = struct_yaml_emitter_s
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
      handler: CFunctionPtr4[Ptr[Byte], Ptr[CUnsignedChar], CInt, Ptr[
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
      handler: CFunctionPtr3[Ptr[Byte], Ptr[CUnsignedChar], CInt, CInt],
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

  object implicits {
    implicit class struct__IO_FILE_ops(val p: Ptr[struct__IO_FILE])
        extends AnyVal {
      def _flags: CInt = !p._1.cast[Ptr[CInt]]
      def _flags_=(value: CInt): Unit = !p._1.cast[Ptr[CInt]] = value
      def _IO_read_ptr: CString = !(p._1 + 8).cast[Ptr[CString]]
      def _IO_read_ptr_=(value: CString): Unit =
        !(p._1 + 8).cast[Ptr[CString]] = value
      def _IO_read_end: CString = !(p._1 + 16).cast[Ptr[CString]]
      def _IO_read_end_=(value: CString): Unit =
        !(p._1 + 16).cast[Ptr[CString]] = value
      def _IO_read_base: CString = !(p._1 + 24).cast[Ptr[CString]]
      def _IO_read_base_=(value: CString): Unit =
        !(p._1 + 24).cast[Ptr[CString]] = value
      def _IO_write_base: CString = !(p._1 + 32).cast[Ptr[CString]]
      def _IO_write_base_=(value: CString): Unit =
        !(p._1 + 32).cast[Ptr[CString]] = value
      def _IO_write_ptr: CString = !(p._1 + 40).cast[Ptr[CString]]
      def _IO_write_ptr_=(value: CString): Unit =
        !(p._1 + 40).cast[Ptr[CString]] = value
      def _IO_write_end: CString = !(p._1 + 48).cast[Ptr[CString]]
      def _IO_write_end_=(value: CString): Unit =
        !(p._1 + 48).cast[Ptr[CString]] = value
      def _IO_buf_base: CString = !(p._1 + 56).cast[Ptr[CString]]
      def _IO_buf_base_=(value: CString): Unit =
        !(p._1 + 56).cast[Ptr[CString]] = value
      def _IO_buf_end: CString = !(p._1 + 64).cast[Ptr[CString]]
      def _IO_buf_end_=(value: CString): Unit =
        !(p._1 + 64).cast[Ptr[CString]] = value
      def _IO_save_base: CString = !(p._1 + 72).cast[Ptr[CString]]
      def _IO_save_base_=(value: CString): Unit =
        !(p._1 + 72).cast[Ptr[CString]] = value
      def _IO_backup_base: CString = !(p._1 + 80).cast[Ptr[CString]]
      def _IO_backup_base_=(value: CString): Unit =
        !(p._1 + 80).cast[Ptr[CString]] = value
      def _IO_save_end: CString = !(p._1 + 88).cast[Ptr[CString]]
      def _IO_save_end_=(value: CString): Unit =
        !(p._1 + 88).cast[Ptr[CString]] = value
      def _markers: Ptr[struct__IO_marker] =
        !(p._1 + 96).cast[Ptr[Ptr[struct__IO_marker]]]
      def _markers_=(value: Ptr[struct__IO_marker]): Unit =
        !(p._1 + 96).cast[Ptr[Ptr[struct__IO_marker]]] = value
      def _chain: Ptr[struct__IO_FILE] =
        (!(p._1 + 104).cast[Ptr[Ptr[struct__IO_FILE]]])
          .cast[Ptr[struct__IO_FILE]]
      def _chain_=(value: Ptr[struct__IO_FILE]): Unit =
        !(p._1 + 104).cast[Ptr[Ptr[struct__IO_FILE]]] = value.cast[Ptr[Byte]]
      def _fileno: CInt = !(p._1 + 112).cast[Ptr[CInt]]
      def _fileno_=(value: CInt): Unit = !(p._1 + 112).cast[Ptr[CInt]] = value
      def _flags2: CInt = !(p._1 + 116).cast[Ptr[CInt]]
      def _flags2_=(value: CInt): Unit = !(p._1 + 116).cast[Ptr[CInt]] = value
      def _old_offset: __off_t = !(p._1 + 120).cast[Ptr[__off_t]]
      def _old_offset_=(value: __off_t): Unit =
        !(p._1 + 120).cast[Ptr[__off_t]] = value
      def _cur_column: CUnsignedShort = !(p._1 + 128).cast[Ptr[CUnsignedShort]]
      def _cur_column_=(value: CUnsignedShort): Unit =
        !(p._1 + 128).cast[Ptr[CUnsignedShort]] = value
      def _vtable_offset: CSignedChar = !(p._1 + 130).cast[Ptr[CSignedChar]]
      def _vtable_offset_=(value: CSignedChar): Unit =
        !(p._1 + 130).cast[Ptr[CSignedChar]] = value
      def _shortbuf: Ptr[CArray[CChar, Nat._1]] =
        (p._1 + 131).cast[Ptr[CArray[CChar, Nat._1]]]
      def _shortbuf_=(value: Ptr[CArray[CChar, Nat._1]]): Unit =
        !(p._1 + 131).cast[Ptr[CArray[CChar, Nat._1]]] = !value
      def _lock: Ptr[Byte] = !(p._1 + 136).cast[Ptr[Ptr[Byte]]]
      def _lock_=(value: Ptr[Byte]): Unit = !(p._1 + 136).cast[Ptr[Ptr[Byte]]] =
        value
      def _offset: __off64_t = !(p._1 + 144).cast[Ptr[__off64_t]]
      def _offset_=(value: __off64_t): Unit =
        !(p._1 + 144).cast[Ptr[__off64_t]] = value
      def _codecvt: Ptr[struct__IO_codecvt] =
        !(p._1 + 152).cast[Ptr[Ptr[struct__IO_codecvt]]]
      def _codecvt_=(value: Ptr[struct__IO_codecvt]): Unit =
        !(p._1 + 152).cast[Ptr[Ptr[struct__IO_codecvt]]] = value
      def _wide_data: Ptr[struct__IO_wide_data] =
        !(p._1 + 160).cast[Ptr[Ptr[struct__IO_wide_data]]]
      def _wide_data_=(value: Ptr[struct__IO_wide_data]): Unit =
        !(p._1 + 160).cast[Ptr[Ptr[struct__IO_wide_data]]] = value
      def _freeres_list: Ptr[struct__IO_FILE] =
        (!(p._1 + 168).cast[Ptr[Ptr[struct__IO_FILE]]])
          .cast[Ptr[struct__IO_FILE]]
      def _freeres_list_=(value: Ptr[struct__IO_FILE]): Unit =
        !(p._1 + 168).cast[Ptr[Ptr[struct__IO_FILE]]] = value.cast[Ptr[Byte]]
      def _freeres_buf: Ptr[Byte] = !(p._1 + 176).cast[Ptr[Ptr[Byte]]]
      def _freeres_buf_=(value: Ptr[Byte]): Unit =
        !(p._1 + 176).cast[Ptr[Ptr[Byte]]] = value
      def __pad5: CInt = !(p._1 + 184).cast[Ptr[CInt]]
      def __pad5_=(value: CInt): Unit = !(p._1 + 184).cast[Ptr[CInt]] = value
      def _mode: CInt = !(p._1 + 188).cast[Ptr[CInt]]
      def _mode_=(value: CInt): Unit = !(p._1 + 188).cast[Ptr[CInt]] = value
      def _unused2: CChar = !(p._1 + 192).cast[Ptr[CChar]]
      def _unused2_=(value: CChar): Unit = !(p._1 + 192).cast[Ptr[CChar]] =
        value
    }

    implicit class struct_yaml_version_directive_s_ops(
        val p: Ptr[struct_yaml_version_directive_s]
    ) extends AnyVal {
      def major: CInt = !p._1
      def major_=(value: CInt): Unit = !p._1 = value
      def minor: CInt = !p._2
      def minor_=(value: CInt): Unit = !p._2 = value
    }

    implicit class struct_yaml_tag_directive_s_ops(
        val p: Ptr[struct_yaml_tag_directive_s]
    ) extends AnyVal {
      def handle: Ptr[yaml_char_t] = !p._1
      def handle_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def prefix: Ptr[yaml_char_t] = !p._2
      def prefix_=(value: Ptr[yaml_char_t]): Unit = !p._2 = value
    }

    implicit class struct_yaml_mark_s_ops(val p: Ptr[struct_yaml_mark_s])
        extends AnyVal {
      def index: CInt = !p._1
      def index_=(value: CInt): Unit = !p._1 = value
      def line: CInt = !p._2
      def line_=(value: CInt): Unit = !p._2 = value
      def column: CInt = !p._3
      def column_=(value: CInt): Unit = !p._3 = value
    }

    implicit class struct_anonymous_1_ops(val p: Ptr[struct_anonymous_1])
        extends AnyVal {
      def encoding: enum_yaml_encoding_e = !p._1
      def encoding_=(value: enum_yaml_encoding_e): Unit = !p._1 = value
    }

    implicit class struct_anonymous_2_ops(val p: Ptr[struct_anonymous_2])
        extends AnyVal {
      def value: Ptr[yaml_char_t] = !p._1
      def value_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
    }

    implicit class struct_anonymous_3_ops(val p: Ptr[struct_anonymous_3])
        extends AnyVal {
      def value: Ptr[yaml_char_t] = !p._1
      def value_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
    }

    implicit class struct_anonymous_4_ops(val p: Ptr[struct_anonymous_4])
        extends AnyVal {
      def handle: Ptr[yaml_char_t] = !p._1
      def handle_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def suffix: Ptr[yaml_char_t] = !p._2
      def suffix_=(value: Ptr[yaml_char_t]): Unit = !p._2 = value
    }

    implicit class struct_anonymous_5_ops(val p: Ptr[struct_anonymous_5])
        extends AnyVal {
      def value: Ptr[yaml_char_t] = !p._1
      def value_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def length: CInt = !p._2
      def length_=(value: CInt): Unit = !p._2 = value
      def style: enum_yaml_scalar_style_e = !p._3
      def style_=(value: enum_yaml_scalar_style_e): Unit = !p._3 = value
    }

    implicit class struct_anonymous_6_ops(val p: Ptr[struct_anonymous_6])
        extends AnyVal {
      def major: CInt = !p._1
      def major_=(value: CInt): Unit = !p._1 = value
      def minor: CInt = !p._2
      def minor_=(value: CInt): Unit = !p._2 = value
    }

    implicit class struct_anonymous_7_ops(val p: Ptr[struct_anonymous_7])
        extends AnyVal {
      def handle: Ptr[yaml_char_t] = !p._1
      def handle_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def prefix: Ptr[yaml_char_t] = !p._2
      def prefix_=(value: Ptr[yaml_char_t]): Unit = !p._2 = value
    }

    implicit class struct_yaml_token_s_ops(val p: Ptr[struct_yaml_token_s])
        extends AnyVal {
      def `type`: enum_yaml_token_type_e = !p._1
      def `type_=`(value: enum_yaml_token_type_e): Unit = !p._1 = value
      def data: Ptr[union_anonymous_1] = p._2
      def data_=(value: Ptr[union_anonymous_1]): Unit = !p._2 = !value
      def start_mark: Ptr[yaml_mark_t] = p._3
      def start_mark_=(value: Ptr[yaml_mark_t]): Unit = !p._3 = !value
      def end_mark: Ptr[yaml_mark_t] = p._4
      def end_mark_=(value: Ptr[yaml_mark_t]): Unit = !p._4 = !value
    }

    implicit class struct_anonymous_8_ops(val p: Ptr[struct_anonymous_8])
        extends AnyVal {
      def encoding: enum_yaml_encoding_e = !p._1
      def encoding_=(value: enum_yaml_encoding_e): Unit = !p._1 = value
    }

    implicit class struct_anonymous_10_ops(val p: Ptr[struct_anonymous_10])
        extends AnyVal {
      def start: Ptr[yaml_tag_directive_t] = !p._1
      def start_=(value: Ptr[yaml_tag_directive_t]): Unit = !p._1 = value
      def end: Ptr[yaml_tag_directive_t] = !p._2
      def end_=(value: Ptr[yaml_tag_directive_t]): Unit = !p._2 = value
    }

    implicit class struct_anonymous_9_ops(val p: Ptr[struct_anonymous_9])
        extends AnyVal {
      def version_directive: Ptr[yaml_version_directive_t] = !p._1
      def version_directive_=(value: Ptr[yaml_version_directive_t]): Unit =
        !p._1 = value
      def tag_directives: Ptr[struct_anonymous_10] = p._2
      def tag_directives_=(value: Ptr[struct_anonymous_10]): Unit = !p._2 =
        !value
      def `implicit`: CInt = !p._3
      def `implicit_=`(value: CInt): Unit = !p._3 = value
    }

    implicit class struct_anonymous_11_ops(val p: Ptr[struct_anonymous_11])
        extends AnyVal {
      def `implicit`: CInt = !p._1
      def `implicit_=`(value: CInt): Unit = !p._1 = value
    }

    implicit class struct_anonymous_12_ops(val p: Ptr[struct_anonymous_12])
        extends AnyVal {
      def anchor: Ptr[yaml_char_t] = !p._1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
    }

    implicit class struct_anonymous_13_ops(val p: Ptr[struct_anonymous_13])
        extends AnyVal {
      def anchor: Ptr[yaml_char_t] = !p._1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def tag: Ptr[yaml_char_t] = !p._2
      def tag_=(value: Ptr[yaml_char_t]): Unit = !p._2 = value
      def value: Ptr[yaml_char_t] = !p._3
      def value_=(value: Ptr[yaml_char_t]): Unit = !p._3 = value
      def length: CInt = !p._4
      def length_=(value: CInt): Unit = !p._4 = value
      def plain_implicit: CInt = !p._5
      def plain_implicit_=(value: CInt): Unit = !p._5 = value
      def quoted_implicit: CInt = !p._6
      def quoted_implicit_=(value: CInt): Unit = !p._6 = value
      def style: enum_yaml_scalar_style_e = !p._7
      def style_=(value: enum_yaml_scalar_style_e): Unit = !p._7 = value
    }

    implicit class struct_anonymous_14_ops(val p: Ptr[struct_anonymous_14])
        extends AnyVal {
      def anchor: Ptr[yaml_char_t] = !p._1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def tag: Ptr[yaml_char_t] = !p._2
      def tag_=(value: Ptr[yaml_char_t]): Unit = !p._2 = value
      def `implicit`: CInt = !p._3
      def `implicit_=`(value: CInt): Unit = !p._3 = value
      def style: enum_yaml_sequence_style_e = !p._4
      def style_=(value: enum_yaml_sequence_style_e): Unit = !p._4 = value
    }

    implicit class struct_anonymous_15_ops(val p: Ptr[struct_anonymous_15])
        extends AnyVal {
      def anchor: Ptr[yaml_char_t] = !p._1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def tag: Ptr[yaml_char_t] = !p._2
      def tag_=(value: Ptr[yaml_char_t]): Unit = !p._2 = value
      def `implicit`: CInt = !p._3
      def `implicit_=`(value: CInt): Unit = !p._3 = value
      def style: enum_yaml_mapping_style_e = !p._4
      def style_=(value: enum_yaml_mapping_style_e): Unit = !p._4 = value
    }

    implicit class struct_yaml_event_s_ops(val p: Ptr[struct_yaml_event_s])
        extends AnyVal {
      def `type`: enum_yaml_event_type_e = !p._1
      def `type_=`(value: enum_yaml_event_type_e): Unit = !p._1 = value
      def data: Ptr[union_anonymous_2] = p._2
      def data_=(value: Ptr[union_anonymous_2]): Unit = !p._2 = !value
      def start_mark: Ptr[yaml_mark_t] = p._3
      def start_mark_=(value: Ptr[yaml_mark_t]): Unit = !p._3 = !value
      def end_mark: Ptr[yaml_mark_t] = p._4
      def end_mark_=(value: Ptr[yaml_mark_t]): Unit = !p._4 = !value
    }

    implicit class struct_yaml_node_pair_s_ops(
        val p: Ptr[struct_yaml_node_pair_s]
    ) extends AnyVal {
      def key: CInt = !p._1
      def key_=(value: CInt): Unit = !p._1 = value
      def value: CInt = !p._2
      def value_=(value: CInt): Unit = !p._2 = value
    }

    implicit class struct_anonymous_16_ops(val p: Ptr[struct_anonymous_16])
        extends AnyVal {
      def value: Ptr[yaml_char_t] = !p._1
      def value_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def length: CInt = !p._2
      def length_=(value: CInt): Unit = !p._2 = value
      def style: enum_yaml_scalar_style_e = !p._3
      def style_=(value: enum_yaml_scalar_style_e): Unit = !p._3 = value
    }

    implicit class struct_anonymous_18_ops(val p: Ptr[struct_anonymous_18])
        extends AnyVal {
      def start: Ptr[yaml_node_item_t] = !p._1
      def start_=(value: Ptr[yaml_node_item_t]): Unit = !p._1 = value
      def end: Ptr[yaml_node_item_t] = !p._2
      def end_=(value: Ptr[yaml_node_item_t]): Unit = !p._2 = value
      def top: Ptr[yaml_node_item_t] = !p._3
      def top_=(value: Ptr[yaml_node_item_t]): Unit = !p._3 = value
    }

    implicit class struct_anonymous_17_ops(val p: Ptr[struct_anonymous_17])
        extends AnyVal {
      def items: Ptr[struct_anonymous_18] = p._1
      def items_=(value: Ptr[struct_anonymous_18]): Unit = !p._1 = !value
      def style: enum_yaml_sequence_style_e = !p._2
      def style_=(value: enum_yaml_sequence_style_e): Unit = !p._2 = value
    }

    implicit class struct_anonymous_20_ops(val p: Ptr[struct_anonymous_20])
        extends AnyVal {
      def start: Ptr[yaml_node_pair_t] = !p._1
      def start_=(value: Ptr[yaml_node_pair_t]): Unit = !p._1 = value
      def end: Ptr[yaml_node_pair_t] = !p._2
      def end_=(value: Ptr[yaml_node_pair_t]): Unit = !p._2 = value
      def top: Ptr[yaml_node_pair_t] = !p._3
      def top_=(value: Ptr[yaml_node_pair_t]): Unit = !p._3 = value
    }

    implicit class struct_anonymous_19_ops(val p: Ptr[struct_anonymous_19])
        extends AnyVal {
      def pairs: Ptr[struct_anonymous_20] = p._1
      def pairs_=(value: Ptr[struct_anonymous_20]): Unit = !p._1 = !value
      def style: enum_yaml_mapping_style_e = !p._2
      def style_=(value: enum_yaml_mapping_style_e): Unit = !p._2 = value
    }

    implicit class struct_yaml_node_s_ops(val p: Ptr[struct_yaml_node_s])
        extends AnyVal {
      def `type`: enum_yaml_node_type_e = !p._1
      def `type_=`(value: enum_yaml_node_type_e): Unit = !p._1 = value
      def tag: Ptr[yaml_char_t] = !p._2
      def tag_=(value: Ptr[yaml_char_t]): Unit = !p._2 = value
      def data: Ptr[union_anonymous_3] = p._3
      def data_=(value: Ptr[union_anonymous_3]): Unit = !p._3 = !value
      def start_mark: Ptr[yaml_mark_t] = p._4
      def start_mark_=(value: Ptr[yaml_mark_t]): Unit = !p._4 = !value
      def end_mark: Ptr[yaml_mark_t] = p._5
      def end_mark_=(value: Ptr[yaml_mark_t]): Unit = !p._5 = !value
    }

    implicit class struct_anonymous_21_ops(val p: Ptr[struct_anonymous_21])
        extends AnyVal {
      def start: Ptr[yaml_node_t] = !p._1
      def start_=(value: Ptr[yaml_node_t]): Unit = !p._1 = value
      def end: Ptr[yaml_node_t] = !p._2
      def end_=(value: Ptr[yaml_node_t]): Unit = !p._2 = value
      def top: Ptr[yaml_node_t] = !p._3
      def top_=(value: Ptr[yaml_node_t]): Unit = !p._3 = value
    }

    implicit class struct_anonymous_22_ops(val p: Ptr[struct_anonymous_22])
        extends AnyVal {
      def start: Ptr[yaml_tag_directive_t] = !p._1
      def start_=(value: Ptr[yaml_tag_directive_t]): Unit = !p._1 = value
      def end: Ptr[yaml_tag_directive_t] = !p._2
      def end_=(value: Ptr[yaml_tag_directive_t]): Unit = !p._2 = value
    }

    implicit class struct_yaml_document_s_ops(
        val p: Ptr[struct_yaml_document_s]
    ) extends AnyVal {
      def nodes: Ptr[struct_anonymous_21] = p._1
      def nodes_=(value: Ptr[struct_anonymous_21]): Unit = !p._1 = !value
      def version_directive: Ptr[yaml_version_directive_t] = !p._2
      def version_directive_=(value: Ptr[yaml_version_directive_t]): Unit =
        !p._2 = value
      def tag_directives: Ptr[struct_anonymous_22] = p._3
      def tag_directives_=(value: Ptr[struct_anonymous_22]): Unit = !p._3 =
        !value
      def start_implicit: CInt = !p._4
      def start_implicit_=(value: CInt): Unit = !p._4 = value
      def end_implicit: CInt = !p._5
      def end_implicit_=(value: CInt): Unit = !p._5 = value
      def start_mark: Ptr[yaml_mark_t] = p._6
      def start_mark_=(value: Ptr[yaml_mark_t]): Unit = !p._6 = !value
      def end_mark: Ptr[yaml_mark_t] = p._7
      def end_mark_=(value: Ptr[yaml_mark_t]): Unit = !p._7 = !value
    }

    implicit class struct_yaml_simple_key_s_ops(
        val p: Ptr[struct_yaml_simple_key_s]
    ) extends AnyVal {
      def possible: CInt = !p._1
      def possible_=(value: CInt): Unit = !p._1 = value
      def required: CInt = !p._2
      def required_=(value: CInt): Unit = !p._2 = value
      def token_number: CInt = !p._3
      def token_number_=(value: CInt): Unit = !p._3 = value
      def mark: Ptr[yaml_mark_t] = p._4
      def mark_=(value: Ptr[yaml_mark_t]): Unit = !p._4 = !value
    }

    implicit class struct_yaml_alias_data_s_ops(
        val p: Ptr[struct_yaml_alias_data_s]
    ) extends AnyVal {
      def anchor: Ptr[yaml_char_t] = !p._1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def index: CInt = !p._2
      def index_=(value: CInt): Unit = !p._2 = value
      def mark: Ptr[yaml_mark_t] = p._3
      def mark_=(value: Ptr[yaml_mark_t]): Unit = !p._3 = !value
    }

    implicit class struct_anonymous_23_ops(val p: Ptr[struct_anonymous_23])
        extends AnyVal {
      def start: Ptr[CUnsignedChar] = !p._1
      def start_=(value: Ptr[CUnsignedChar]): Unit = !p._1 = value
      def end: Ptr[CUnsignedChar] = !p._2
      def end_=(value: Ptr[CUnsignedChar]): Unit = !p._2 = value
      def current: Ptr[CUnsignedChar] = !p._3
      def current_=(value: Ptr[CUnsignedChar]): Unit = !p._3 = value
    }

    implicit class struct_anonymous_24_ops(val p: Ptr[struct_anonymous_24])
        extends AnyVal {
      def start: Ptr[yaml_char_t] = !p._1
      def start_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def end: Ptr[yaml_char_t] = !p._2
      def end_=(value: Ptr[yaml_char_t]): Unit = !p._2 = value
      def pointer: Ptr[yaml_char_t] = !p._3
      def pointer_=(value: Ptr[yaml_char_t]): Unit = !p._3 = value
      def last: Ptr[yaml_char_t] = !p._4
      def last_=(value: Ptr[yaml_char_t]): Unit = !p._4 = value
    }

    implicit class struct_anonymous_25_ops(val p: Ptr[struct_anonymous_25])
        extends AnyVal {
      def start: Ptr[CUnsignedChar] = !p._1
      def start_=(value: Ptr[CUnsignedChar]): Unit = !p._1 = value
      def end: Ptr[CUnsignedChar] = !p._2
      def end_=(value: Ptr[CUnsignedChar]): Unit = !p._2 = value
      def pointer: Ptr[CUnsignedChar] = !p._3
      def pointer_=(value: Ptr[CUnsignedChar]): Unit = !p._3 = value
      def last: Ptr[CUnsignedChar] = !p._4
      def last_=(value: Ptr[CUnsignedChar]): Unit = !p._4 = value
    }

    implicit class struct_anonymous_26_ops(val p: Ptr[struct_anonymous_26])
        extends AnyVal {
      def start: Ptr[yaml_token_t] = !p._1
      def start_=(value: Ptr[yaml_token_t]): Unit = !p._1 = value
      def end: Ptr[yaml_token_t] = !p._2
      def end_=(value: Ptr[yaml_token_t]): Unit = !p._2 = value
      def head: Ptr[yaml_token_t] = !p._3
      def head_=(value: Ptr[yaml_token_t]): Unit = !p._3 = value
      def tail: Ptr[yaml_token_t] = !p._4
      def tail_=(value: Ptr[yaml_token_t]): Unit = !p._4 = value
    }

    implicit class struct_anonymous_27_ops(val p: Ptr[struct_anonymous_27])
        extends AnyVal {
      def start: Ptr[CInt] = !p._1
      def start_=(value: Ptr[CInt]): Unit = !p._1 = value
      def end: Ptr[CInt] = !p._2
      def end_=(value: Ptr[CInt]): Unit = !p._2 = value
      def top: Ptr[CInt] = !p._3
      def top_=(value: Ptr[CInt]): Unit = !p._3 = value
    }

    implicit class struct_anonymous_28_ops(val p: Ptr[struct_anonymous_28])
        extends AnyVal {
      def start: Ptr[yaml_simple_key_t] = !p._1
      def start_=(value: Ptr[yaml_simple_key_t]): Unit = !p._1 = value
      def end: Ptr[yaml_simple_key_t] = !p._2
      def end_=(value: Ptr[yaml_simple_key_t]): Unit = !p._2 = value
      def top: Ptr[yaml_simple_key_t] = !p._3
      def top_=(value: Ptr[yaml_simple_key_t]): Unit = !p._3 = value
    }

    implicit class struct_anonymous_29_ops(val p: Ptr[struct_anonymous_29])
        extends AnyVal {
      def start: Ptr[enum_yaml_parser_state_e] = !p._1
      def start_=(value: Ptr[enum_yaml_parser_state_e]): Unit = !p._1 = value
      def end: Ptr[enum_yaml_parser_state_e] = !p._2
      def end_=(value: Ptr[enum_yaml_parser_state_e]): Unit = !p._2 = value
      def top: Ptr[enum_yaml_parser_state_e] = !p._3
      def top_=(value: Ptr[enum_yaml_parser_state_e]): Unit = !p._3 = value
    }

    implicit class struct_anonymous_30_ops(val p: Ptr[struct_anonymous_30])
        extends AnyVal {
      def start: Ptr[yaml_mark_t] = !p._1
      def start_=(value: Ptr[yaml_mark_t]): Unit = !p._1 = value
      def end: Ptr[yaml_mark_t] = !p._2
      def end_=(value: Ptr[yaml_mark_t]): Unit = !p._2 = value
      def top: Ptr[yaml_mark_t] = !p._3
      def top_=(value: Ptr[yaml_mark_t]): Unit = !p._3 = value
    }

    implicit class struct_anonymous_31_ops(val p: Ptr[struct_anonymous_31])
        extends AnyVal {
      def start: Ptr[yaml_tag_directive_t] = !p._1
      def start_=(value: Ptr[yaml_tag_directive_t]): Unit = !p._1 = value
      def end: Ptr[yaml_tag_directive_t] = !p._2
      def end_=(value: Ptr[yaml_tag_directive_t]): Unit = !p._2 = value
      def top: Ptr[yaml_tag_directive_t] = !p._3
      def top_=(value: Ptr[yaml_tag_directive_t]): Unit = !p._3 = value
    }

    implicit class struct_anonymous_32_ops(val p: Ptr[struct_anonymous_32])
        extends AnyVal {
      def start: Ptr[yaml_alias_data_t] = !p._1
      def start_=(value: Ptr[yaml_alias_data_t]): Unit = !p._1 = value
      def end: Ptr[yaml_alias_data_t] = !p._2
      def end_=(value: Ptr[yaml_alias_data_t]): Unit = !p._2 = value
      def top: Ptr[yaml_alias_data_t] = !p._3
      def top_=(value: Ptr[yaml_alias_data_t]): Unit = !p._3 = value
    }

    implicit class struct_yaml_parser_s_ops(val p: Ptr[struct_yaml_parser_s])
        extends AnyVal {
      def error: enum_yaml_error_type_e =
        !p._1.cast[Ptr[enum_yaml_error_type_e]]
      def error_=(value: enum_yaml_error_type_e): Unit =
        !p._1.cast[Ptr[enum_yaml_error_type_e]] = value
      def problem: CString = !(p._1 + 8).cast[Ptr[CString]]
      def problem_=(value: CString): Unit = !(p._1 + 8).cast[Ptr[CString]] =
        value
      def problem_offset: CInt = !(p._1 + 16).cast[Ptr[CInt]]
      def problem_offset_=(value: CInt): Unit = !(p._1 + 16).cast[Ptr[CInt]] =
        value
      def problem_value: CInt = !(p._1 + 20).cast[Ptr[CInt]]
      def problem_value_=(value: CInt): Unit = !(p._1 + 20).cast[Ptr[CInt]] =
        value
      def problem_mark: Ptr[yaml_mark_t] = (p._1 + 24).cast[Ptr[yaml_mark_t]]
      def problem_mark_=(value: Ptr[yaml_mark_t]): Unit =
        !(p._1 + 24).cast[Ptr[yaml_mark_t]] = !value
      def context: CString = !(p._1 + 32).cast[Ptr[CString]]
      def context_=(value: CString): Unit = !(p._1 + 32).cast[Ptr[CString]] =
        value
      def context_mark: Ptr[yaml_mark_t] = (p._1 + 40).cast[Ptr[yaml_mark_t]]
      def context_mark_=(value: Ptr[yaml_mark_t]): Unit =
        !(p._1 + 40).cast[Ptr[yaml_mark_t]] = !value
      def read_handler: CFunctionPtr4[Ptr[Byte], Ptr[CUnsignedChar], CInt, Ptr[
        CInt
      ], CInt] = !(p._1 + 48).cast[Ptr[
        CFunctionPtr4[Ptr[Byte], Ptr[CUnsignedChar], CInt, Ptr[CInt], CInt]
      ]]
      def read_handler_=(
          value: CFunctionPtr4[Ptr[Byte], Ptr[CUnsignedChar], CInt, Ptr[
            CInt
          ], CInt]
      ): Unit = !(p._1 + 48).cast[Ptr[
        CFunctionPtr4[Ptr[Byte], Ptr[CUnsignedChar], CInt, Ptr[CInt], CInt]
      ]] = value
      def read_handler_data: Ptr[Byte] = !(p._1 + 56).cast[Ptr[Ptr[Byte]]]
      def read_handler_data_=(value: Ptr[Byte]): Unit =
        !(p._1 + 56).cast[Ptr[Ptr[Byte]]] = value
      def input: Ptr[union_anonymous_4] =
        (p._1 + 64).cast[Ptr[union_anonymous_4]]
      def input_=(value: Ptr[union_anonymous_4]): Unit =
        !(p._1 + 64).cast[Ptr[union_anonymous_4]] = !value
      def eof: CInt = !(p._1 + 88).cast[Ptr[CInt]]
      def eof_=(value: CInt): Unit = !(p._1 + 88).cast[Ptr[CInt]] = value
      def buffer: Ptr[struct_anonymous_24] =
        (p._1 + 96).cast[Ptr[struct_anonymous_24]]
      def buffer_=(value: Ptr[struct_anonymous_24]): Unit =
        !(p._1 + 96).cast[Ptr[struct_anonymous_24]] = !value
      def unread: CInt = !(p._1 + 128).cast[Ptr[CInt]]
      def unread_=(value: CInt): Unit = !(p._1 + 128).cast[Ptr[CInt]] = value
      def raw_buffer: Ptr[struct_anonymous_25] =
        (p._1 + 136).cast[Ptr[struct_anonymous_25]]
      def raw_buffer_=(value: Ptr[struct_anonymous_25]): Unit =
        !(p._1 + 136).cast[Ptr[struct_anonymous_25]] = !value
      def encoding: enum_yaml_encoding_e =
        !(p._1 + 168).cast[Ptr[enum_yaml_encoding_e]]
      def encoding_=(value: enum_yaml_encoding_e): Unit =
        !(p._1 + 168).cast[Ptr[enum_yaml_encoding_e]] = value
      def offset: CInt = !(p._1 + 172).cast[Ptr[CInt]]
      def offset_=(value: CInt): Unit = !(p._1 + 172).cast[Ptr[CInt]] = value
      def mark: Ptr[yaml_mark_t] = (p._1 + 176).cast[Ptr[yaml_mark_t]]
      def mark_=(value: Ptr[yaml_mark_t]): Unit =
        !(p._1 + 176).cast[Ptr[yaml_mark_t]] = !value
      def stream_start_produced: CInt = !(p._1 + 180).cast[Ptr[CInt]]
      def stream_start_produced_=(value: CInt): Unit =
        !(p._1 + 180).cast[Ptr[CInt]] = value
      def stream_end_produced: CInt = !(p._1 + 184).cast[Ptr[CInt]]
      def stream_end_produced_=(value: CInt): Unit =
        !(p._1 + 184).cast[Ptr[CInt]] = value
      def flow_level: CInt = !(p._1 + 188).cast[Ptr[CInt]]
      def flow_level_=(value: CInt): Unit = !(p._1 + 188).cast[Ptr[CInt]] =
        value
      def tokens: Ptr[struct_anonymous_26] =
        (p._1 + 192).cast[Ptr[struct_anonymous_26]]
      def tokens_=(value: Ptr[struct_anonymous_26]): Unit =
        !(p._1 + 192).cast[Ptr[struct_anonymous_26]] = !value
      def tokens_parsed: CInt = !(p._1 + 224).cast[Ptr[CInt]]
      def tokens_parsed_=(value: CInt): Unit = !(p._1 + 224).cast[Ptr[CInt]] =
        value
      def token_available: CInt = !(p._1 + 228).cast[Ptr[CInt]]
      def token_available_=(value: CInt): Unit = !(p._1 + 228).cast[Ptr[CInt]] =
        value
      def indents: Ptr[struct_anonymous_27] =
        (p._1 + 232).cast[Ptr[struct_anonymous_27]]
      def indents_=(value: Ptr[struct_anonymous_27]): Unit =
        !(p._1 + 232).cast[Ptr[struct_anonymous_27]] = !value
      def indent: CInt = !(p._1 + 256).cast[Ptr[CInt]]
      def indent_=(value: CInt): Unit = !(p._1 + 256).cast[Ptr[CInt]] = value
      def simple_key_allowed: CInt = !(p._1 + 260).cast[Ptr[CInt]]
      def simple_key_allowed_=(value: CInt): Unit =
        !(p._1 + 260).cast[Ptr[CInt]] = value
      def simple_keys: Ptr[struct_anonymous_28] =
        (p._1 + 264).cast[Ptr[struct_anonymous_28]]
      def simple_keys_=(value: Ptr[struct_anonymous_28]): Unit =
        !(p._1 + 264).cast[Ptr[struct_anonymous_28]] = !value
      def states: Ptr[struct_anonymous_29] =
        (p._1 + 288).cast[Ptr[struct_anonymous_29]]
      def states_=(value: Ptr[struct_anonymous_29]): Unit =
        !(p._1 + 288).cast[Ptr[struct_anonymous_29]] = !value
      def state: enum_yaml_parser_state_e =
        !(p._1 + 312).cast[Ptr[enum_yaml_parser_state_e]]
      def state_=(value: enum_yaml_parser_state_e): Unit =
        !(p._1 + 312).cast[Ptr[enum_yaml_parser_state_e]] = value
      def marks: Ptr[struct_anonymous_30] =
        (p._1 + 320).cast[Ptr[struct_anonymous_30]]
      def marks_=(value: Ptr[struct_anonymous_30]): Unit =
        !(p._1 + 320).cast[Ptr[struct_anonymous_30]] = !value
      def tag_directives: Ptr[struct_anonymous_31] =
        (p._1 + 344).cast[Ptr[struct_anonymous_31]]
      def tag_directives_=(value: Ptr[struct_anonymous_31]): Unit =
        !(p._1 + 344).cast[Ptr[struct_anonymous_31]] = !value
      def aliases: Ptr[struct_anonymous_32] =
        (p._1 + 368).cast[Ptr[struct_anonymous_32]]
      def aliases_=(value: Ptr[struct_anonymous_32]): Unit =
        !(p._1 + 368).cast[Ptr[struct_anonymous_32]] = !value
      def document: Ptr[yaml_document_t] =
        !(p._1 + 392).cast[Ptr[Ptr[yaml_document_t]]]
      def document_=(value: Ptr[yaml_document_t]): Unit =
        !(p._1 + 392).cast[Ptr[Ptr[yaml_document_t]]] = value
    }

    implicit class struct_yaml_anchors_s_ops(val p: Ptr[struct_yaml_anchors_s])
        extends AnyVal {
      def references: CInt = !p._1
      def references_=(value: CInt): Unit = !p._1 = value
      def anchor: CInt = !p._2
      def anchor_=(value: CInt): Unit = !p._2 = value
      def serialized: CInt = !p._3
      def serialized_=(value: CInt): Unit = !p._3 = value
    }

    implicit class struct_anonymous_33_ops(val p: Ptr[struct_anonymous_33])
        extends AnyVal {
      def buffer: Ptr[CUnsignedChar] = !p._1
      def buffer_=(value: Ptr[CUnsignedChar]): Unit = !p._1 = value
      def size: CInt = !p._2
      def size_=(value: CInt): Unit = !p._2 = value
      def size_written: Ptr[CInt] = !p._3
      def size_written_=(value: Ptr[CInt]): Unit = !p._3 = value
    }

    implicit class struct_anonymous_34_ops(val p: Ptr[struct_anonymous_34])
        extends AnyVal {
      def start: Ptr[yaml_char_t] = !p._1
      def start_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def end: Ptr[yaml_char_t] = !p._2
      def end_=(value: Ptr[yaml_char_t]): Unit = !p._2 = value
      def pointer: Ptr[yaml_char_t] = !p._3
      def pointer_=(value: Ptr[yaml_char_t]): Unit = !p._3 = value
      def last: Ptr[yaml_char_t] = !p._4
      def last_=(value: Ptr[yaml_char_t]): Unit = !p._4 = value
    }

    implicit class struct_anonymous_35_ops(val p: Ptr[struct_anonymous_35])
        extends AnyVal {
      def start: Ptr[CUnsignedChar] = !p._1
      def start_=(value: Ptr[CUnsignedChar]): Unit = !p._1 = value
      def end: Ptr[CUnsignedChar] = !p._2
      def end_=(value: Ptr[CUnsignedChar]): Unit = !p._2 = value
      def pointer: Ptr[CUnsignedChar] = !p._3
      def pointer_=(value: Ptr[CUnsignedChar]): Unit = !p._3 = value
      def last: Ptr[CUnsignedChar] = !p._4
      def last_=(value: Ptr[CUnsignedChar]): Unit = !p._4 = value
    }

    implicit class struct_anonymous_36_ops(val p: Ptr[struct_anonymous_36])
        extends AnyVal {
      def start: Ptr[enum_yaml_emitter_state_e] = !p._1
      def start_=(value: Ptr[enum_yaml_emitter_state_e]): Unit = !p._1 = value
      def end: Ptr[enum_yaml_emitter_state_e] = !p._2
      def end_=(value: Ptr[enum_yaml_emitter_state_e]): Unit = !p._2 = value
      def top: Ptr[enum_yaml_emitter_state_e] = !p._3
      def top_=(value: Ptr[enum_yaml_emitter_state_e]): Unit = !p._3 = value
    }

    implicit class struct_anonymous_37_ops(val p: Ptr[struct_anonymous_37])
        extends AnyVal {
      def start: Ptr[yaml_event_t] = !p._1
      def start_=(value: Ptr[yaml_event_t]): Unit = !p._1 = value
      def end: Ptr[yaml_event_t] = !p._2
      def end_=(value: Ptr[yaml_event_t]): Unit = !p._2 = value
      def head: Ptr[yaml_event_t] = !p._3
      def head_=(value: Ptr[yaml_event_t]): Unit = !p._3 = value
      def tail: Ptr[yaml_event_t] = !p._4
      def tail_=(value: Ptr[yaml_event_t]): Unit = !p._4 = value
    }

    implicit class struct_anonymous_38_ops(val p: Ptr[struct_anonymous_38])
        extends AnyVal {
      def start: Ptr[CInt] = !p._1
      def start_=(value: Ptr[CInt]): Unit = !p._1 = value
      def end: Ptr[CInt] = !p._2
      def end_=(value: Ptr[CInt]): Unit = !p._2 = value
      def top: Ptr[CInt] = !p._3
      def top_=(value: Ptr[CInt]): Unit = !p._3 = value
    }

    implicit class struct_anonymous_39_ops(val p: Ptr[struct_anonymous_39])
        extends AnyVal {
      def start: Ptr[yaml_tag_directive_t] = !p._1
      def start_=(value: Ptr[yaml_tag_directive_t]): Unit = !p._1 = value
      def end: Ptr[yaml_tag_directive_t] = !p._2
      def end_=(value: Ptr[yaml_tag_directive_t]): Unit = !p._2 = value
      def top: Ptr[yaml_tag_directive_t] = !p._3
      def top_=(value: Ptr[yaml_tag_directive_t]): Unit = !p._3 = value
    }

    implicit class struct_anonymous_40_ops(val p: Ptr[struct_anonymous_40])
        extends AnyVal {
      def anchor: Ptr[yaml_char_t] = !p._1
      def anchor_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def anchor_length: CInt = !p._2
      def anchor_length_=(value: CInt): Unit = !p._2 = value
      def alias: CInt = !p._3
      def alias_=(value: CInt): Unit = !p._3 = value
    }

    implicit class struct_anonymous_41_ops(val p: Ptr[struct_anonymous_41])
        extends AnyVal {
      def handle: Ptr[yaml_char_t] = !p._1
      def handle_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def handle_length: CInt = !p._2
      def handle_length_=(value: CInt): Unit = !p._2 = value
      def suffix: Ptr[yaml_char_t] = !p._3
      def suffix_=(value: Ptr[yaml_char_t]): Unit = !p._3 = value
      def suffix_length: CInt = !p._4
      def suffix_length_=(value: CInt): Unit = !p._4 = value
    }

    implicit class struct_anonymous_42_ops(val p: Ptr[struct_anonymous_42])
        extends AnyVal {
      def value: Ptr[yaml_char_t] = !p._1
      def value_=(value: Ptr[yaml_char_t]): Unit = !p._1 = value
      def length: CInt = !p._2
      def length_=(value: CInt): Unit = !p._2 = value
      def multiline: CInt = !p._3
      def multiline_=(value: CInt): Unit = !p._3 = value
      def flow_plain_allowed: CInt = !p._4
      def flow_plain_allowed_=(value: CInt): Unit = !p._4 = value
      def block_plain_allowed: CInt = !p._5
      def block_plain_allowed_=(value: CInt): Unit = !p._5 = value
      def single_quoted_allowed: CInt = !p._6
      def single_quoted_allowed_=(value: CInt): Unit = !p._6 = value
      def block_allowed: CInt = !p._7
      def block_allowed_=(value: CInt): Unit = !p._7 = value
      def style: enum_yaml_scalar_style_e = !p._8
      def style_=(value: enum_yaml_scalar_style_e): Unit = !p._8 = value
    }

    implicit class struct_yaml_emitter_s_ops(val p: Ptr[struct_yaml_emitter_s])
        extends AnyVal {
      def error: enum_yaml_error_type_e =
        !p._1.cast[Ptr[enum_yaml_error_type_e]]
      def error_=(value: enum_yaml_error_type_e): Unit =
        !p._1.cast[Ptr[enum_yaml_error_type_e]] = value
      def problem: CString = !(p._1 + 8).cast[Ptr[CString]]
      def problem_=(value: CString): Unit = !(p._1 + 8).cast[Ptr[CString]] =
        value
      def write_handler
          : CFunctionPtr3[Ptr[Byte], Ptr[CUnsignedChar], CInt, CInt] =
        !(p._1 + 16)
          .cast[Ptr[CFunctionPtr3[Ptr[Byte], Ptr[CUnsignedChar], CInt, CInt]]]
      def write_handler_=(
          value: CFunctionPtr3[Ptr[Byte], Ptr[CUnsignedChar], CInt, CInt]
      ): Unit = !(p._1 + 16)
        .cast[Ptr[CFunctionPtr3[Ptr[Byte], Ptr[CUnsignedChar], CInt, CInt]]] =
        value
      def write_handler_data: Ptr[Byte] = !(p._1 + 24).cast[Ptr[Ptr[Byte]]]
      def write_handler_data_=(value: Ptr[Byte]): Unit =
        !(p._1 + 24).cast[Ptr[Ptr[Byte]]] = value
      def output: Ptr[union_anonymous_5] =
        (p._1 + 32).cast[Ptr[union_anonymous_5]]
      def output_=(value: Ptr[union_anonymous_5]): Unit =
        !(p._1 + 32).cast[Ptr[union_anonymous_5]] = !value
      def buffer: Ptr[struct_anonymous_34] =
        (p._1 + 40).cast[Ptr[struct_anonymous_34]]
      def buffer_=(value: Ptr[struct_anonymous_34]): Unit =
        !(p._1 + 40).cast[Ptr[struct_anonymous_34]] = !value
      def raw_buffer: Ptr[struct_anonymous_35] =
        (p._1 + 72).cast[Ptr[struct_anonymous_35]]
      def raw_buffer_=(value: Ptr[struct_anonymous_35]): Unit =
        !(p._1 + 72).cast[Ptr[struct_anonymous_35]] = !value
      def encoding: enum_yaml_encoding_e =
        !(p._1 + 104).cast[Ptr[enum_yaml_encoding_e]]
      def encoding_=(value: enum_yaml_encoding_e): Unit =
        !(p._1 + 104).cast[Ptr[enum_yaml_encoding_e]] = value
      def canonical: CInt = !(p._1 + 108).cast[Ptr[CInt]]
      def canonical_=(value: CInt): Unit = !(p._1 + 108).cast[Ptr[CInt]] = value
      def best_indent: CInt = !(p._1 + 112).cast[Ptr[CInt]]
      def best_indent_=(value: CInt): Unit = !(p._1 + 112).cast[Ptr[CInt]] =
        value
      def best_width: CInt = !(p._1 + 116).cast[Ptr[CInt]]
      def best_width_=(value: CInt): Unit = !(p._1 + 116).cast[Ptr[CInt]] =
        value
      def unicode: CInt = !(p._1 + 120).cast[Ptr[CInt]]
      def unicode_=(value: CInt): Unit = !(p._1 + 120).cast[Ptr[CInt]] = value
      def line_break: enum_yaml_break_e =
        !(p._1 + 124).cast[Ptr[enum_yaml_break_e]]
      def line_break_=(value: enum_yaml_break_e): Unit =
        !(p._1 + 124).cast[Ptr[enum_yaml_break_e]] = value
      def states: Ptr[struct_anonymous_36] =
        (p._1 + 128).cast[Ptr[struct_anonymous_36]]
      def states_=(value: Ptr[struct_anonymous_36]): Unit =
        !(p._1 + 128).cast[Ptr[struct_anonymous_36]] = !value
      def state: enum_yaml_emitter_state_e =
        !(p._1 + 152).cast[Ptr[enum_yaml_emitter_state_e]]
      def state_=(value: enum_yaml_emitter_state_e): Unit =
        !(p._1 + 152).cast[Ptr[enum_yaml_emitter_state_e]] = value
      def events: Ptr[struct_anonymous_37] =
        (p._1 + 160).cast[Ptr[struct_anonymous_37]]
      def events_=(value: Ptr[struct_anonymous_37]): Unit =
        !(p._1 + 160).cast[Ptr[struct_anonymous_37]] = !value
      def indents: Ptr[struct_anonymous_38] =
        (p._1 + 192).cast[Ptr[struct_anonymous_38]]
      def indents_=(value: Ptr[struct_anonymous_38]): Unit =
        !(p._1 + 192).cast[Ptr[struct_anonymous_38]] = !value
      def tag_directives: Ptr[struct_anonymous_39] =
        (p._1 + 216).cast[Ptr[struct_anonymous_39]]
      def tag_directives_=(value: Ptr[struct_anonymous_39]): Unit =
        !(p._1 + 216).cast[Ptr[struct_anonymous_39]] = !value
      def indent: CInt = !(p._1 + 240).cast[Ptr[CInt]]
      def indent_=(value: CInt): Unit = !(p._1 + 240).cast[Ptr[CInt]] = value
      def flow_level: CInt = !(p._1 + 244).cast[Ptr[CInt]]
      def flow_level_=(value: CInt): Unit = !(p._1 + 244).cast[Ptr[CInt]] =
        value
      def root_context: CInt = !(p._1 + 248).cast[Ptr[CInt]]
      def root_context_=(value: CInt): Unit = !(p._1 + 248).cast[Ptr[CInt]] =
        value
      def sequence_context: CInt = !(p._1 + 252).cast[Ptr[CInt]]
      def sequence_context_=(value: CInt): Unit =
        !(p._1 + 252).cast[Ptr[CInt]] = value
      def mapping_context: CInt = !(p._1 + 256).cast[Ptr[CInt]]
      def mapping_context_=(value: CInt): Unit = !(p._1 + 256).cast[Ptr[CInt]] =
        value
      def simple_key_context: CInt = !(p._1 + 260).cast[Ptr[CInt]]
      def simple_key_context_=(value: CInt): Unit =
        !(p._1 + 260).cast[Ptr[CInt]] = value
      def line: CInt = !(p._1 + 264).cast[Ptr[CInt]]
      def line_=(value: CInt): Unit = !(p._1 + 264).cast[Ptr[CInt]] = value
      def column: CInt = !(p._1 + 268).cast[Ptr[CInt]]
      def column_=(value: CInt): Unit = !(p._1 + 268).cast[Ptr[CInt]] = value
      def whitespace: CInt = !(p._1 + 272).cast[Ptr[CInt]]
      def whitespace_=(value: CInt): Unit = !(p._1 + 272).cast[Ptr[CInt]] =
        value
      def indention: CInt = !(p._1 + 276).cast[Ptr[CInt]]
      def indention_=(value: CInt): Unit = !(p._1 + 276).cast[Ptr[CInt]] = value
      def open_ended: CInt = !(p._1 + 280).cast[Ptr[CInt]]
      def open_ended_=(value: CInt): Unit = !(p._1 + 280).cast[Ptr[CInt]] =
        value
      def anchor_data: Ptr[struct_anonymous_40] =
        (p._1 + 284).cast[Ptr[struct_anonymous_40]]
      def anchor_data_=(value: Ptr[struct_anonymous_40]): Unit =
        !(p._1 + 284).cast[Ptr[struct_anonymous_40]] = !value
      def tag_data: Ptr[struct_anonymous_41] =
        (p._1 + 285).cast[Ptr[struct_anonymous_41]]
      def tag_data_=(value: Ptr[struct_anonymous_41]): Unit =
        !(p._1 + 285).cast[Ptr[struct_anonymous_41]] = !value
      def scalar_data: Ptr[struct_anonymous_42] =
        (p._1 + 286).cast[Ptr[struct_anonymous_42]]
      def scalar_data_=(value: Ptr[struct_anonymous_42]): Unit =
        !(p._1 + 286).cast[Ptr[struct_anonymous_42]] = !value
      def opened: CInt = !(p._1 + 288).cast[Ptr[CInt]]
      def opened_=(value: CInt): Unit = !(p._1 + 288).cast[Ptr[CInt]] = value
      def closed: CInt = !(p._1 + 292).cast[Ptr[CInt]]
      def closed_=(value: CInt): Unit = !(p._1 + 292).cast[Ptr[CInt]] = value
      def anchors: Ptr[yaml_anchors_t] =
        !(p._1 + 296).cast[Ptr[Ptr[yaml_anchors_t]]]
      def anchors_=(value: Ptr[yaml_anchors_t]): Unit =
        !(p._1 + 296).cast[Ptr[Ptr[yaml_anchors_t]]] = value
      def last_anchor_id: CInt = !(p._1 + 304).cast[Ptr[CInt]]
      def last_anchor_id_=(value: CInt): Unit = !(p._1 + 304).cast[Ptr[CInt]] =
        value
      def document: Ptr[yaml_document_t] =
        !(p._1 + 312).cast[Ptr[Ptr[yaml_document_t]]]
      def document_=(value: Ptr[yaml_document_t]): Unit =
        !(p._1 + 312).cast[Ptr[Ptr[yaml_document_t]]] = value
    }

    implicit class union_anonymous_1_pos(val p: Ptr[union_anonymous_1])
        extends AnyVal {
      def stream_start: Ptr[struct_anonymous_1] =
        p.cast[Ptr[struct_anonymous_1]]
      def stream_start_=(value: Ptr[struct_anonymous_1]): Unit =
        !p.cast[Ptr[struct_anonymous_1]] = !value
      def alias: Ptr[struct_anonymous_2] = p.cast[Ptr[struct_anonymous_2]]
      def alias_=(value: Ptr[struct_anonymous_2]): Unit =
        !p.cast[Ptr[struct_anonymous_2]] = !value
      def anchor: Ptr[struct_anonymous_3] = p.cast[Ptr[struct_anonymous_3]]
      def anchor_=(value: Ptr[struct_anonymous_3]): Unit =
        !p.cast[Ptr[struct_anonymous_3]] = !value
      def tag: Ptr[struct_anonymous_4] = p.cast[Ptr[struct_anonymous_4]]
      def tag_=(value: Ptr[struct_anonymous_4]): Unit =
        !p.cast[Ptr[struct_anonymous_4]] = !value
      def scalar: Ptr[struct_anonymous_5] = p.cast[Ptr[struct_anonymous_5]]
      def scalar_=(value: Ptr[struct_anonymous_5]): Unit =
        !p.cast[Ptr[struct_anonymous_5]] = !value
      def version_directive: Ptr[struct_anonymous_6] =
        p.cast[Ptr[struct_anonymous_6]]
      def version_directive_=(value: Ptr[struct_anonymous_6]): Unit =
        !p.cast[Ptr[struct_anonymous_6]] = !value
      def tag_directive: Ptr[struct_anonymous_7] =
        p.cast[Ptr[struct_anonymous_7]]
      def tag_directive_=(value: Ptr[struct_anonymous_7]): Unit =
        !p.cast[Ptr[struct_anonymous_7]] = !value
    }

    implicit class union_anonymous_2_pos(val p: Ptr[union_anonymous_2])
        extends AnyVal {
      def stream_start: Ptr[struct_anonymous_8] =
        p.cast[Ptr[struct_anonymous_8]]
      def stream_start_=(value: Ptr[struct_anonymous_8]): Unit =
        !p.cast[Ptr[struct_anonymous_8]] = !value
      def document_start: Ptr[struct_anonymous_9] =
        p.cast[Ptr[struct_anonymous_9]]
      def document_start_=(value: Ptr[struct_anonymous_9]): Unit =
        !p.cast[Ptr[struct_anonymous_9]] = !value
      def document_end: Ptr[struct_anonymous_11] =
        p.cast[Ptr[struct_anonymous_11]]
      def document_end_=(value: Ptr[struct_anonymous_11]): Unit =
        !p.cast[Ptr[struct_anonymous_11]] = !value
      def alias: Ptr[struct_anonymous_12] = p.cast[Ptr[struct_anonymous_12]]
      def alias_=(value: Ptr[struct_anonymous_12]): Unit =
        !p.cast[Ptr[struct_anonymous_12]] = !value
      def scalar: Ptr[struct_anonymous_13] = p.cast[Ptr[struct_anonymous_13]]
      def scalar_=(value: Ptr[struct_anonymous_13]): Unit =
        !p.cast[Ptr[struct_anonymous_13]] = !value
      def sequence_start: Ptr[struct_anonymous_14] =
        p.cast[Ptr[struct_anonymous_14]]
      def sequence_start_=(value: Ptr[struct_anonymous_14]): Unit =
        !p.cast[Ptr[struct_anonymous_14]] = !value
      def mapping_start: Ptr[struct_anonymous_15] =
        p.cast[Ptr[struct_anonymous_15]]
      def mapping_start_=(value: Ptr[struct_anonymous_15]): Unit =
        !p.cast[Ptr[struct_anonymous_15]] = !value
    }

    implicit class union_anonymous_3_pos(val p: Ptr[union_anonymous_3])
        extends AnyVal {
      def scalar: Ptr[struct_anonymous_16] = p.cast[Ptr[struct_anonymous_16]]
      def scalar_=(value: Ptr[struct_anonymous_16]): Unit =
        !p.cast[Ptr[struct_anonymous_16]] = !value
      def sequence: Ptr[struct_anonymous_17] = p.cast[Ptr[struct_anonymous_17]]
      def sequence_=(value: Ptr[struct_anonymous_17]): Unit =
        !p.cast[Ptr[struct_anonymous_17]] = !value
      def mapping: Ptr[struct_anonymous_19] = p.cast[Ptr[struct_anonymous_19]]
      def mapping_=(value: Ptr[struct_anonymous_19]): Unit =
        !p.cast[Ptr[struct_anonymous_19]] = !value
    }

    implicit class union_anonymous_4_pos(val p: Ptr[union_anonymous_4])
        extends AnyVal {
      def string: Ptr[struct_anonymous_23] = p.cast[Ptr[struct_anonymous_23]]
      def string_=(value: Ptr[struct_anonymous_23]): Unit =
        !p.cast[Ptr[struct_anonymous_23]] = !value
      def file: Ptr[Ptr[FILE]] = p.cast[Ptr[Ptr[FILE]]]
      def file_=(value: Ptr[FILE]): Unit = !p.cast[Ptr[Ptr[FILE]]] = value
    }

    implicit class union_anonymous_5_pos(val p: Ptr[union_anonymous_5])
        extends AnyVal {
      def string: Ptr[struct_anonymous_33] = p.cast[Ptr[struct_anonymous_33]]
      def string_=(value: Ptr[struct_anonymous_33]): Unit =
        !p.cast[Ptr[struct_anonymous_33]] = !value
      def file: Ptr[Ptr[FILE]] = p.cast[Ptr[Ptr[FILE]]]
      def file_=(value: Ptr[FILE]): Unit = !p.cast[Ptr[Ptr[FILE]]] = value
    }
  }

  object struct__IO_FILE {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct__IO_FILE] = alloc[struct__IO_FILE]
    def apply(
        _flags: CInt,
        _IO_read_ptr: CString,
        _IO_read_end: CString,
        _IO_read_base: CString,
        _IO_write_base: CString,
        _IO_write_ptr: CString,
        _IO_write_end: CString,
        _IO_buf_base: CString,
        _IO_buf_end: CString,
        _IO_save_base: CString,
        _IO_backup_base: CString,
        _IO_save_end: CString,
        _markers: Ptr[struct__IO_marker],
        _chain: Ptr[struct__IO_FILE],
        _fileno: CInt,
        _flags2: CInt,
        _old_offset: __off_t,
        _cur_column: CUnsignedShort,
        _vtable_offset: CSignedChar,
        _shortbuf: Ptr[CArray[CChar, Nat._1]],
        _lock: Ptr[Byte],
        _offset: __off64_t,
        _codecvt: Ptr[struct__IO_codecvt],
        _wide_data: Ptr[struct__IO_wide_data],
        _freeres_list: Ptr[struct__IO_FILE],
        _freeres_buf: Ptr[Byte],
        __pad5: CInt,
        _mode: CInt,
        _unused2: CChar
    )(implicit z: Zone): Ptr[struct__IO_FILE] = {
      val ptr = alloc[struct__IO_FILE]
      ptr._flags = _flags
      ptr._IO_read_ptr = _IO_read_ptr
      ptr._IO_read_end = _IO_read_end
      ptr._IO_read_base = _IO_read_base
      ptr._IO_write_base = _IO_write_base
      ptr._IO_write_ptr = _IO_write_ptr
      ptr._IO_write_end = _IO_write_end
      ptr._IO_buf_base = _IO_buf_base
      ptr._IO_buf_end = _IO_buf_end
      ptr._IO_save_base = _IO_save_base
      ptr._IO_backup_base = _IO_backup_base
      ptr._IO_save_end = _IO_save_end
      ptr._markers = _markers
      ptr._chain = _chain
      ptr._fileno = _fileno
      ptr._flags2 = _flags2
      ptr._old_offset = _old_offset
      ptr._cur_column = _cur_column
      ptr._vtable_offset = _vtable_offset
      ptr._shortbuf = _shortbuf
      ptr._lock = _lock
      ptr._offset = _offset
      ptr._codecvt = _codecvt
      ptr._wide_data = _wide_data
      ptr._freeres_list = _freeres_list
      ptr._freeres_buf = _freeres_buf
      ptr.__pad5 = __pad5
      ptr._mode = _mode
      ptr._unused2 = _unused2
      ptr
    }
  }

  object struct_yaml_version_directive_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_version_directive_s] =
      alloc[struct_yaml_version_directive_s]
    def apply(major: CInt, minor: CInt)(implicit
        z: Zone
    ): Ptr[struct_yaml_version_directive_s] = {
      val ptr = alloc[struct_yaml_version_directive_s]
      ptr.major = major
      ptr.minor = minor
      ptr
    }
  }

  object struct_yaml_tag_directive_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_tag_directive_s] =
      alloc[struct_yaml_tag_directive_s]
    def apply(handle: Ptr[yaml_char_t], prefix: Ptr[yaml_char_t])(implicit
        z: Zone
    ): Ptr[struct_yaml_tag_directive_s] = {
      val ptr = alloc[struct_yaml_tag_directive_s]
      ptr.handle = handle
      ptr.prefix = prefix
      ptr
    }
  }

  object struct_yaml_mark_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_mark_s] =
      alloc[struct_yaml_mark_s]
    def apply(index: CInt, line: CInt, column: CInt)(implicit
        z: Zone
    ): Ptr[struct_yaml_mark_s] = {
      val ptr = alloc[struct_yaml_mark_s]
      ptr.index = index
      ptr.line = line
      ptr.column = column
      ptr
    }
  }

  object struct_anonymous_1 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_1] =
      alloc[struct_anonymous_1]
    def apply(
        encoding: enum_yaml_encoding_e
    )(implicit z: Zone): Ptr[struct_anonymous_1] = {
      val ptr = alloc[struct_anonymous_1]
      ptr.encoding = encoding
      ptr
    }
  }

  object struct_anonymous_2 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_2] =
      alloc[struct_anonymous_2]
    def apply(
        value: Ptr[yaml_char_t]
    )(implicit z: Zone): Ptr[struct_anonymous_2] = {
      val ptr = alloc[struct_anonymous_2]
      ptr.value = value
      ptr
    }
  }

  object struct_anonymous_3 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_3] =
      alloc[struct_anonymous_3]
    def apply(
        value: Ptr[yaml_char_t]
    )(implicit z: Zone): Ptr[struct_anonymous_3] = {
      val ptr = alloc[struct_anonymous_3]
      ptr.value = value
      ptr
    }
  }

  object struct_anonymous_4 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_4] =
      alloc[struct_anonymous_4]
    def apply(handle: Ptr[yaml_char_t], suffix: Ptr[yaml_char_t])(implicit
        z: Zone
    ): Ptr[struct_anonymous_4] = {
      val ptr = alloc[struct_anonymous_4]
      ptr.handle = handle
      ptr.suffix = suffix
      ptr
    }
  }

  object struct_anonymous_5 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_5] =
      alloc[struct_anonymous_5]
    def apply(
        value: Ptr[yaml_char_t],
        length: CInt,
        style: enum_yaml_scalar_style_e
    )(implicit z: Zone): Ptr[struct_anonymous_5] = {
      val ptr = alloc[struct_anonymous_5]
      ptr.value = value
      ptr.length = length
      ptr.style = style
      ptr
    }
  }

  object struct_anonymous_6 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_6] =
      alloc[struct_anonymous_6]
    def apply(major: CInt, minor: CInt)(implicit
        z: Zone
    ): Ptr[struct_anonymous_6] = {
      val ptr = alloc[struct_anonymous_6]
      ptr.major = major
      ptr.minor = minor
      ptr
    }
  }

  object struct_anonymous_7 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_7] =
      alloc[struct_anonymous_7]
    def apply(handle: Ptr[yaml_char_t], prefix: Ptr[yaml_char_t])(implicit
        z: Zone
    ): Ptr[struct_anonymous_7] = {
      val ptr = alloc[struct_anonymous_7]
      ptr.handle = handle
      ptr.prefix = prefix
      ptr
    }
  }

  object struct_yaml_token_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_token_s] =
      alloc[struct_yaml_token_s]
    def apply(
        `type`: enum_yaml_token_type_e,
        data: Ptr[union_anonymous_1],
        start_mark: Ptr[yaml_mark_t],
        end_mark: Ptr[yaml_mark_t]
    )(implicit z: Zone): Ptr[struct_yaml_token_s] = {
      val ptr = alloc[struct_yaml_token_s]
      ptr.`type` = `type`
      ptr.data = data
      ptr.start_mark = start_mark
      ptr.end_mark = end_mark
      ptr
    }
  }

  object struct_anonymous_8 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_8] =
      alloc[struct_anonymous_8]
    def apply(
        encoding: enum_yaml_encoding_e
    )(implicit z: Zone): Ptr[struct_anonymous_8] = {
      val ptr = alloc[struct_anonymous_8]
      ptr.encoding = encoding
      ptr
    }
  }

  object struct_anonymous_10 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_10] =
      alloc[struct_anonymous_10]
    def apply(start: Ptr[yaml_tag_directive_t], end: Ptr[yaml_tag_directive_t])(
        implicit z: Zone
    ): Ptr[struct_anonymous_10] = {
      val ptr = alloc[struct_anonymous_10]
      ptr.start = start
      ptr.end = end
      ptr
    }
  }

  object struct_anonymous_9 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_9] =
      alloc[struct_anonymous_9]
    def apply(
        version_directive: Ptr[yaml_version_directive_t],
        tag_directives: Ptr[struct_anonymous_10],
        `implicit`: CInt
    )(implicit z: Zone): Ptr[struct_anonymous_9] = {
      val ptr = alloc[struct_anonymous_9]
      ptr.version_directive = version_directive
      ptr.tag_directives = tag_directives
      ptr.`implicit` = `implicit`
      ptr
    }
  }

  object struct_anonymous_11 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_11] =
      alloc[struct_anonymous_11]
    def apply(`implicit`: CInt)(implicit z: Zone): Ptr[struct_anonymous_11] = {
      val ptr = alloc[struct_anonymous_11]
      ptr.`implicit` = `implicit`
      ptr
    }
  }

  object struct_anonymous_12 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_12] =
      alloc[struct_anonymous_12]
    def apply(
        anchor: Ptr[yaml_char_t]
    )(implicit z: Zone): Ptr[struct_anonymous_12] = {
      val ptr = alloc[struct_anonymous_12]
      ptr.anchor = anchor
      ptr
    }
  }

  object struct_anonymous_13 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_13] =
      alloc[struct_anonymous_13]
    def apply(
        anchor: Ptr[yaml_char_t],
        tag: Ptr[yaml_char_t],
        value: Ptr[yaml_char_t],
        length: CInt,
        plain_implicit: CInt,
        quoted_implicit: CInt,
        style: enum_yaml_scalar_style_e
    )(implicit z: Zone): Ptr[struct_anonymous_13] = {
      val ptr = alloc[struct_anonymous_13]
      ptr.anchor = anchor
      ptr.tag = tag
      ptr.value = value
      ptr.length = length
      ptr.plain_implicit = plain_implicit
      ptr.quoted_implicit = quoted_implicit
      ptr.style = style
      ptr
    }
  }

  object struct_anonymous_14 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_14] =
      alloc[struct_anonymous_14]
    def apply(
        anchor: Ptr[yaml_char_t],
        tag: Ptr[yaml_char_t],
        `implicit`: CInt,
        style: enum_yaml_sequence_style_e
    )(implicit z: Zone): Ptr[struct_anonymous_14] = {
      val ptr = alloc[struct_anonymous_14]
      ptr.anchor = anchor
      ptr.tag = tag
      ptr.`implicit` = `implicit`
      ptr.style = style
      ptr
    }
  }

  object struct_anonymous_15 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_15] =
      alloc[struct_anonymous_15]
    def apply(
        anchor: Ptr[yaml_char_t],
        tag: Ptr[yaml_char_t],
        `implicit`: CInt,
        style: enum_yaml_mapping_style_e
    )(implicit z: Zone): Ptr[struct_anonymous_15] = {
      val ptr = alloc[struct_anonymous_15]
      ptr.anchor = anchor
      ptr.tag = tag
      ptr.`implicit` = `implicit`
      ptr.style = style
      ptr
    }
  }

  object struct_yaml_event_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_event_s] =
      alloc[struct_yaml_event_s]
    def apply(
        `type`: enum_yaml_event_type_e,
        data: Ptr[union_anonymous_2],
        start_mark: Ptr[yaml_mark_t],
        end_mark: Ptr[yaml_mark_t]
    )(implicit z: Zone): Ptr[struct_yaml_event_s] = {
      val ptr = alloc[struct_yaml_event_s]
      ptr.`type` = `type`
      ptr.data = data
      ptr.start_mark = start_mark
      ptr.end_mark = end_mark
      ptr
    }
  }

  object struct_yaml_node_pair_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_node_pair_s] =
      alloc[struct_yaml_node_pair_s]
    def apply(key: CInt, value: CInt)(implicit
        z: Zone
    ): Ptr[struct_yaml_node_pair_s] = {
      val ptr = alloc[struct_yaml_node_pair_s]
      ptr.key = key
      ptr.value = value
      ptr
    }
  }

  object struct_anonymous_16 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_16] =
      alloc[struct_anonymous_16]
    def apply(
        value: Ptr[yaml_char_t],
        length: CInt,
        style: enum_yaml_scalar_style_e
    )(implicit z: Zone): Ptr[struct_anonymous_16] = {
      val ptr = alloc[struct_anonymous_16]
      ptr.value = value
      ptr.length = length
      ptr.style = style
      ptr
    }
  }

  object struct_anonymous_18 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_18] =
      alloc[struct_anonymous_18]
    def apply(
        start: Ptr[yaml_node_item_t],
        end: Ptr[yaml_node_item_t],
        top: Ptr[yaml_node_item_t]
    )(implicit z: Zone): Ptr[struct_anonymous_18] = {
      val ptr = alloc[struct_anonymous_18]
      ptr.start = start
      ptr.end = end
      ptr.top = top
      ptr
    }
  }

  object struct_anonymous_17 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_17] =
      alloc[struct_anonymous_17]
    def apply(
        items: Ptr[struct_anonymous_18],
        style: enum_yaml_sequence_style_e
    )(implicit z: Zone): Ptr[struct_anonymous_17] = {
      val ptr = alloc[struct_anonymous_17]
      ptr.items = items
      ptr.style = style
      ptr
    }
  }

  object struct_anonymous_20 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_20] =
      alloc[struct_anonymous_20]
    def apply(
        start: Ptr[yaml_node_pair_t],
        end: Ptr[yaml_node_pair_t],
        top: Ptr[yaml_node_pair_t]
    )(implicit z: Zone): Ptr[struct_anonymous_20] = {
      val ptr = alloc[struct_anonymous_20]
      ptr.start = start
      ptr.end = end
      ptr.top = top
      ptr
    }
  }

  object struct_anonymous_19 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_19] =
      alloc[struct_anonymous_19]
    def apply(
        pairs: Ptr[struct_anonymous_20],
        style: enum_yaml_mapping_style_e
    )(implicit z: Zone): Ptr[struct_anonymous_19] = {
      val ptr = alloc[struct_anonymous_19]
      ptr.pairs = pairs
      ptr.style = style
      ptr
    }
  }

  object struct_yaml_node_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_node_s] =
      alloc[struct_yaml_node_s]
    def apply(
        `type`: enum_yaml_node_type_e,
        tag: Ptr[yaml_char_t],
        data: Ptr[union_anonymous_3],
        start_mark: Ptr[yaml_mark_t],
        end_mark: Ptr[yaml_mark_t]
    )(implicit z: Zone): Ptr[struct_yaml_node_s] = {
      val ptr = alloc[struct_yaml_node_s]
      ptr.`type` = `type`
      ptr.tag = tag
      ptr.data = data
      ptr.start_mark = start_mark
      ptr.end_mark = end_mark
      ptr
    }
  }

  object struct_anonymous_21 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_21] =
      alloc[struct_anonymous_21]
    def apply(
        start: Ptr[yaml_node_t],
        end: Ptr[yaml_node_t],
        top: Ptr[yaml_node_t]
    )(implicit z: Zone): Ptr[struct_anonymous_21] = {
      val ptr = alloc[struct_anonymous_21]
      ptr.start = start
      ptr.end = end
      ptr.top = top
      ptr
    }
  }

  object struct_anonymous_22 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_22] =
      alloc[struct_anonymous_22]
    def apply(start: Ptr[yaml_tag_directive_t], end: Ptr[yaml_tag_directive_t])(
        implicit z: Zone
    ): Ptr[struct_anonymous_22] = {
      val ptr = alloc[struct_anonymous_22]
      ptr.start = start
      ptr.end = end
      ptr
    }
  }

  object struct_yaml_document_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_document_s] =
      alloc[struct_yaml_document_s]
    def apply(
        nodes: Ptr[struct_anonymous_21],
        version_directive: Ptr[yaml_version_directive_t],
        tag_directives: Ptr[struct_anonymous_22],
        start_implicit: CInt,
        end_implicit: CInt,
        start_mark: Ptr[yaml_mark_t],
        end_mark: Ptr[yaml_mark_t]
    )(implicit z: Zone): Ptr[struct_yaml_document_s] = {
      val ptr = alloc[struct_yaml_document_s]
      ptr.nodes = nodes
      ptr.version_directive = version_directive
      ptr.tag_directives = tag_directives
      ptr.start_implicit = start_implicit
      ptr.end_implicit = end_implicit
      ptr.start_mark = start_mark
      ptr.end_mark = end_mark
      ptr
    }
  }

  object struct_yaml_simple_key_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_simple_key_s] =
      alloc[struct_yaml_simple_key_s]
    def apply(
        possible: CInt,
        required: CInt,
        token_number: CInt,
        mark: Ptr[yaml_mark_t]
    )(implicit z: Zone): Ptr[struct_yaml_simple_key_s] = {
      val ptr = alloc[struct_yaml_simple_key_s]
      ptr.possible = possible
      ptr.required = required
      ptr.token_number = token_number
      ptr.mark = mark
      ptr
    }
  }

  object struct_yaml_alias_data_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_alias_data_s] =
      alloc[struct_yaml_alias_data_s]
    def apply(anchor: Ptr[yaml_char_t], index: CInt, mark: Ptr[yaml_mark_t])(
        implicit z: Zone
    ): Ptr[struct_yaml_alias_data_s] = {
      val ptr = alloc[struct_yaml_alias_data_s]
      ptr.anchor = anchor
      ptr.index = index
      ptr.mark = mark
      ptr
    }
  }

  object struct_anonymous_23 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_23] =
      alloc[struct_anonymous_23]
    def apply(
        start: Ptr[CUnsignedChar],
        end: Ptr[CUnsignedChar],
        current: Ptr[CUnsignedChar]
    )(implicit z: Zone): Ptr[struct_anonymous_23] = {
      val ptr = alloc[struct_anonymous_23]
      ptr.start = start
      ptr.end = end
      ptr.current = current
      ptr
    }
  }

  object struct_anonymous_24 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_24] =
      alloc[struct_anonymous_24]
    def apply(
        start: Ptr[yaml_char_t],
        end: Ptr[yaml_char_t],
        pointer: Ptr[yaml_char_t],
        last: Ptr[yaml_char_t]
    )(implicit z: Zone): Ptr[struct_anonymous_24] = {
      val ptr = alloc[struct_anonymous_24]
      ptr.start = start
      ptr.end = end
      ptr.pointer = pointer
      ptr.last = last
      ptr
    }
  }

  object struct_anonymous_25 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_25] =
      alloc[struct_anonymous_25]
    def apply(
        start: Ptr[CUnsignedChar],
        end: Ptr[CUnsignedChar],
        pointer: Ptr[CUnsignedChar],
        last: Ptr[CUnsignedChar]
    )(implicit z: Zone): Ptr[struct_anonymous_25] = {
      val ptr = alloc[struct_anonymous_25]
      ptr.start = start
      ptr.end = end
      ptr.pointer = pointer
      ptr.last = last
      ptr
    }
  }

  object struct_anonymous_26 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_26] =
      alloc[struct_anonymous_26]
    def apply(
        start: Ptr[yaml_token_t],
        end: Ptr[yaml_token_t],
        head: Ptr[yaml_token_t],
        tail: Ptr[yaml_token_t]
    )(implicit z: Zone): Ptr[struct_anonymous_26] = {
      val ptr = alloc[struct_anonymous_26]
      ptr.start = start
      ptr.end = end
      ptr.head = head
      ptr.tail = tail
      ptr
    }
  }

  object struct_anonymous_27 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_27] =
      alloc[struct_anonymous_27]
    def apply(start: Ptr[CInt], end: Ptr[CInt], top: Ptr[CInt])(implicit
        z: Zone
    ): Ptr[struct_anonymous_27] = {
      val ptr = alloc[struct_anonymous_27]
      ptr.start = start
      ptr.end = end
      ptr.top = top
      ptr
    }
  }

  object struct_anonymous_28 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_28] =
      alloc[struct_anonymous_28]
    def apply(
        start: Ptr[yaml_simple_key_t],
        end: Ptr[yaml_simple_key_t],
        top: Ptr[yaml_simple_key_t]
    )(implicit z: Zone): Ptr[struct_anonymous_28] = {
      val ptr = alloc[struct_anonymous_28]
      ptr.start = start
      ptr.end = end
      ptr.top = top
      ptr
    }
  }

  object struct_anonymous_29 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_29] =
      alloc[struct_anonymous_29]
    def apply(
        start: Ptr[enum_yaml_parser_state_e],
        end: Ptr[enum_yaml_parser_state_e],
        top: Ptr[enum_yaml_parser_state_e]
    )(implicit z: Zone): Ptr[struct_anonymous_29] = {
      val ptr = alloc[struct_anonymous_29]
      ptr.start = start
      ptr.end = end
      ptr.top = top
      ptr
    }
  }

  object struct_anonymous_30 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_30] =
      alloc[struct_anonymous_30]
    def apply(
        start: Ptr[yaml_mark_t],
        end: Ptr[yaml_mark_t],
        top: Ptr[yaml_mark_t]
    )(implicit z: Zone): Ptr[struct_anonymous_30] = {
      val ptr = alloc[struct_anonymous_30]
      ptr.start = start
      ptr.end = end
      ptr.top = top
      ptr
    }
  }

  object struct_anonymous_31 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_31] =
      alloc[struct_anonymous_31]
    def apply(
        start: Ptr[yaml_tag_directive_t],
        end: Ptr[yaml_tag_directive_t],
        top: Ptr[yaml_tag_directive_t]
    )(implicit z: Zone): Ptr[struct_anonymous_31] = {
      val ptr = alloc[struct_anonymous_31]
      ptr.start = start
      ptr.end = end
      ptr.top = top
      ptr
    }
  }

  object struct_anonymous_32 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_32] =
      alloc[struct_anonymous_32]
    def apply(
        start: Ptr[yaml_alias_data_t],
        end: Ptr[yaml_alias_data_t],
        top: Ptr[yaml_alias_data_t]
    )(implicit z: Zone): Ptr[struct_anonymous_32] = {
      val ptr = alloc[struct_anonymous_32]
      ptr.start = start
      ptr.end = end
      ptr.top = top
      ptr
    }
  }

  object struct_yaml_parser_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_parser_s] =
      alloc[struct_yaml_parser_s]
    def apply(
        error: enum_yaml_error_type_e,
        problem: CString,
        problem_offset: CInt,
        problem_value: CInt,
        problem_mark: Ptr[yaml_mark_t],
        context: CString,
        context_mark: Ptr[yaml_mark_t],
        read_handler: CFunctionPtr4[Ptr[Byte], Ptr[CUnsignedChar], CInt, Ptr[
          CInt
        ], CInt],
        read_handler_data: Ptr[Byte],
        input: Ptr[union_anonymous_4],
        eof: CInt,
        buffer: Ptr[struct_anonymous_24],
        unread: CInt,
        raw_buffer: Ptr[struct_anonymous_25],
        encoding: enum_yaml_encoding_e,
        offset: CInt,
        mark: Ptr[yaml_mark_t],
        stream_start_produced: CInt,
        stream_end_produced: CInt,
        flow_level: CInt,
        tokens: Ptr[struct_anonymous_26],
        tokens_parsed: CInt,
        token_available: CInt,
        indents: Ptr[struct_anonymous_27],
        indent: CInt,
        simple_key_allowed: CInt,
        simple_keys: Ptr[struct_anonymous_28],
        states: Ptr[struct_anonymous_29],
        state: enum_yaml_parser_state_e,
        marks: Ptr[struct_anonymous_30],
        tag_directives: Ptr[struct_anonymous_31],
        aliases: Ptr[struct_anonymous_32],
        document: Ptr[yaml_document_t]
    )(implicit z: Zone): Ptr[struct_yaml_parser_s] = {
      val ptr = alloc[struct_yaml_parser_s]
      ptr.error = error
      ptr.problem = problem
      ptr.problem_offset = problem_offset
      ptr.problem_value = problem_value
      ptr.problem_mark = problem_mark
      ptr.context = context
      ptr.context_mark = context_mark
      ptr.read_handler = read_handler
      ptr.read_handler_data = read_handler_data
      ptr.input = input
      ptr.eof = eof
      ptr.buffer = buffer
      ptr.unread = unread
      ptr.raw_buffer = raw_buffer
      ptr.encoding = encoding
      ptr.offset = offset
      ptr.mark = mark
      ptr.stream_start_produced = stream_start_produced
      ptr.stream_end_produced = stream_end_produced
      ptr.flow_level = flow_level
      ptr.tokens = tokens
      ptr.tokens_parsed = tokens_parsed
      ptr.token_available = token_available
      ptr.indents = indents
      ptr.indent = indent
      ptr.simple_key_allowed = simple_key_allowed
      ptr.simple_keys = simple_keys
      ptr.states = states
      ptr.state = state
      ptr.marks = marks
      ptr.tag_directives = tag_directives
      ptr.aliases = aliases
      ptr.document = document
      ptr
    }
  }

  object struct_yaml_anchors_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_anchors_s] =
      alloc[struct_yaml_anchors_s]
    def apply(references: CInt, anchor: CInt, serialized: CInt)(implicit
        z: Zone
    ): Ptr[struct_yaml_anchors_s] = {
      val ptr = alloc[struct_yaml_anchors_s]
      ptr.references = references
      ptr.anchor = anchor
      ptr.serialized = serialized
      ptr
    }
  }

  object struct_anonymous_33 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_33] =
      alloc[struct_anonymous_33]
    def apply(buffer: Ptr[CUnsignedChar], size: CInt, size_written: Ptr[CInt])(
        implicit z: Zone
    ): Ptr[struct_anonymous_33] = {
      val ptr = alloc[struct_anonymous_33]
      ptr.buffer = buffer
      ptr.size = size
      ptr.size_written = size_written
      ptr
    }
  }

  object struct_anonymous_34 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_34] =
      alloc[struct_anonymous_34]
    def apply(
        start: Ptr[yaml_char_t],
        end: Ptr[yaml_char_t],
        pointer: Ptr[yaml_char_t],
        last: Ptr[yaml_char_t]
    )(implicit z: Zone): Ptr[struct_anonymous_34] = {
      val ptr = alloc[struct_anonymous_34]
      ptr.start = start
      ptr.end = end
      ptr.pointer = pointer
      ptr.last = last
      ptr
    }
  }

  object struct_anonymous_35 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_35] =
      alloc[struct_anonymous_35]
    def apply(
        start: Ptr[CUnsignedChar],
        end: Ptr[CUnsignedChar],
        pointer: Ptr[CUnsignedChar],
        last: Ptr[CUnsignedChar]
    )(implicit z: Zone): Ptr[struct_anonymous_35] = {
      val ptr = alloc[struct_anonymous_35]
      ptr.start = start
      ptr.end = end
      ptr.pointer = pointer
      ptr.last = last
      ptr
    }
  }

  object struct_anonymous_36 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_36] =
      alloc[struct_anonymous_36]
    def apply(
        start: Ptr[enum_yaml_emitter_state_e],
        end: Ptr[enum_yaml_emitter_state_e],
        top: Ptr[enum_yaml_emitter_state_e]
    )(implicit z: Zone): Ptr[struct_anonymous_36] = {
      val ptr = alloc[struct_anonymous_36]
      ptr.start = start
      ptr.end = end
      ptr.top = top
      ptr
    }
  }

  object struct_anonymous_37 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_37] =
      alloc[struct_anonymous_37]
    def apply(
        start: Ptr[yaml_event_t],
        end: Ptr[yaml_event_t],
        head: Ptr[yaml_event_t],
        tail: Ptr[yaml_event_t]
    )(implicit z: Zone): Ptr[struct_anonymous_37] = {
      val ptr = alloc[struct_anonymous_37]
      ptr.start = start
      ptr.end = end
      ptr.head = head
      ptr.tail = tail
      ptr
    }
  }

  object struct_anonymous_38 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_38] =
      alloc[struct_anonymous_38]
    def apply(start: Ptr[CInt], end: Ptr[CInt], top: Ptr[CInt])(implicit
        z: Zone
    ): Ptr[struct_anonymous_38] = {
      val ptr = alloc[struct_anonymous_38]
      ptr.start = start
      ptr.end = end
      ptr.top = top
      ptr
    }
  }

  object struct_anonymous_39 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_39] =
      alloc[struct_anonymous_39]
    def apply(
        start: Ptr[yaml_tag_directive_t],
        end: Ptr[yaml_tag_directive_t],
        top: Ptr[yaml_tag_directive_t]
    )(implicit z: Zone): Ptr[struct_anonymous_39] = {
      val ptr = alloc[struct_anonymous_39]
      ptr.start = start
      ptr.end = end
      ptr.top = top
      ptr
    }
  }

  object struct_anonymous_40 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_40] =
      alloc[struct_anonymous_40]
    def apply(anchor: Ptr[yaml_char_t], anchor_length: CInt, alias: CInt)(
        implicit z: Zone
    ): Ptr[struct_anonymous_40] = {
      val ptr = alloc[struct_anonymous_40]
      ptr.anchor = anchor
      ptr.anchor_length = anchor_length
      ptr.alias = alias
      ptr
    }
  }

  object struct_anonymous_41 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_41] =
      alloc[struct_anonymous_41]
    def apply(
        handle: Ptr[yaml_char_t],
        handle_length: CInt,
        suffix: Ptr[yaml_char_t],
        suffix_length: CInt
    )(implicit z: Zone): Ptr[struct_anonymous_41] = {
      val ptr = alloc[struct_anonymous_41]
      ptr.handle = handle
      ptr.handle_length = handle_length
      ptr.suffix = suffix
      ptr.suffix_length = suffix_length
      ptr
    }
  }

  object struct_anonymous_42 {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_anonymous_42] =
      alloc[struct_anonymous_42]
    def apply(
        value: Ptr[yaml_char_t],
        length: CInt,
        multiline: CInt,
        flow_plain_allowed: CInt,
        block_plain_allowed: CInt,
        single_quoted_allowed: CInt,
        block_allowed: CInt,
        style: enum_yaml_scalar_style_e
    )(implicit z: Zone): Ptr[struct_anonymous_42] = {
      val ptr = alloc[struct_anonymous_42]
      ptr.value = value
      ptr.length = length
      ptr.multiline = multiline
      ptr.flow_plain_allowed = flow_plain_allowed
      ptr.block_plain_allowed = block_plain_allowed
      ptr.single_quoted_allowed = single_quoted_allowed
      ptr.block_allowed = block_allowed
      ptr.style = style
      ptr
    }
  }

  object struct_yaml_emitter_s {
    import implicits._
    def apply()(implicit z: Zone): Ptr[struct_yaml_emitter_s] =
      alloc[struct_yaml_emitter_s]
    def apply(
        error: enum_yaml_error_type_e,
        problem: CString,
        write_handler: CFunctionPtr3[Ptr[Byte], Ptr[CUnsignedChar], CInt, CInt],
        write_handler_data: Ptr[Byte],
        output: Ptr[union_anonymous_5],
        buffer: Ptr[struct_anonymous_34],
        raw_buffer: Ptr[struct_anonymous_35],
        encoding: enum_yaml_encoding_e,
        canonical: CInt,
        best_indent: CInt,
        best_width: CInt,
        unicode: CInt,
        line_break: enum_yaml_break_e,
        states: Ptr[struct_anonymous_36],
        state: enum_yaml_emitter_state_e,
        events: Ptr[struct_anonymous_37],
        indents: Ptr[struct_anonymous_38],
        tag_directives: Ptr[struct_anonymous_39],
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
        anchor_data: Ptr[struct_anonymous_40],
        tag_data: Ptr[struct_anonymous_41],
        scalar_data: Ptr[struct_anonymous_42],
        opened: CInt,
        closed: CInt,
        anchors: Ptr[yaml_anchors_t],
        last_anchor_id: CInt,
        document: Ptr[yaml_document_t]
    )(implicit z: Zone): Ptr[struct_yaml_emitter_s] = {
      val ptr = alloc[struct_yaml_emitter_s]
      ptr.error = error
      ptr.problem = problem
      ptr.write_handler = write_handler
      ptr.write_handler_data = write_handler_data
      ptr.output = output
      ptr.buffer = buffer
      ptr.raw_buffer = raw_buffer
      ptr.encoding = encoding
      ptr.canonical = canonical
      ptr.best_indent = best_indent
      ptr.best_width = best_width
      ptr.unicode = unicode
      ptr.line_break = line_break
      ptr.states = states
      ptr.state = state
      ptr.events = events
      ptr.indents = indents
      ptr.tag_directives = tag_directives
      ptr.indent = indent
      ptr.flow_level = flow_level
      ptr.root_context = root_context
      ptr.sequence_context = sequence_context
      ptr.mapping_context = mapping_context
      ptr.simple_key_context = simple_key_context
      ptr.line = line
      ptr.column = column
      ptr.whitespace = whitespace
      ptr.indention = indention
      ptr.open_ended = open_ended
      ptr.anchor_data = anchor_data
      ptr.tag_data = tag_data
      ptr.scalar_data = scalar_data
      ptr.opened = opened
      ptr.closed = closed
      ptr.anchors = anchors
      ptr.last_anchor_id = last_anchor_id
      ptr.document = document
      ptr
    }
  }
}

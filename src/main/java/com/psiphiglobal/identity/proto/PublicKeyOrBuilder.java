// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package com.psiphiglobal.identity.proto;

public interface PublicKeyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:identity.proto.PublicKey)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.identity.proto.PublicKey.Algorithm algorithm = 1;</code>
   */
  int getAlgorithmValue();
  /**
   * <code>.identity.proto.PublicKey.Algorithm algorithm = 1;</code>
   */
  com.psiphiglobal.identity.proto.PublicKey.Algorithm getAlgorithm();

  /**
   * <code>bytes data = 2;</code>
   */
  com.google.protobuf.ByteString getData();
}

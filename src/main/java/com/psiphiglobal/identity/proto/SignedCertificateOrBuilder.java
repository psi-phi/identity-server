// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: organization.proto

package com.psiphiglobal.identity.proto;

public interface SignedCertificateOrBuilder extends
    // @@protoc_insertion_point(interface_extends:identity.proto.SignedCertificate)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>.identity.proto.CertificateStatus status = 2;</code>
   */
  int getStatusValue();
  /**
   * <code>.identity.proto.CertificateStatus status = 2;</code>
   */
  com.psiphiglobal.identity.proto.CertificateStatus getStatus();

  /**
   * <code>uint64 created_at = 3;</code>
   */
  long getCreatedAt();

  /**
   * <code>uint64 expired_at = 4;</code>
   */
  long getExpiredAt();

  /**
   * <code>.identity.proto.AutoValidationMechanism auto_validation = 5;</code>
   */
  int getAutoValidationValue();
  /**
   * <code>.identity.proto.AutoValidationMechanism auto_validation = 5;</code>
   */
  com.psiphiglobal.identity.proto.AutoValidationMechanism getAutoValidation();

  /**
   * <code>.identity.proto.CertificateData data = 6;</code>
   */
  boolean hasData();
  /**
   * <code>.identity.proto.CertificateData data = 6;</code>
   */
  com.psiphiglobal.identity.proto.CertificateData getData();
  /**
   * <code>.identity.proto.CertificateData data = 6;</code>
   */
  com.psiphiglobal.identity.proto.CertificateDataOrBuilder getDataOrBuilder();

  /**
   * <code>.identity.proto.Signature self_sign = 7;</code>
   */
  boolean hasSelfSign();
  /**
   * <code>.identity.proto.Signature self_sign = 7;</code>
   */
  com.psiphiglobal.identity.proto.Signature getSelfSign();
  /**
   * <code>.identity.proto.Signature self_sign = 7;</code>
   */
  com.psiphiglobal.identity.proto.SignatureOrBuilder getSelfSignOrBuilder();

  /**
   * <code>repeated .identity.proto.Signature validations = 8;</code>
   */
  java.util.List<com.psiphiglobal.identity.proto.Signature> 
      getValidationsList();
  /**
   * <code>repeated .identity.proto.Signature validations = 8;</code>
   */
  com.psiphiglobal.identity.proto.Signature getValidations(int index);
  /**
   * <code>repeated .identity.proto.Signature validations = 8;</code>
   */
  int getValidationsCount();
  /**
   * <code>repeated .identity.proto.Signature validations = 8;</code>
   */
  java.util.List<? extends com.psiphiglobal.identity.proto.SignatureOrBuilder> 
      getValidationsOrBuilderList();
  /**
   * <code>repeated .identity.proto.Signature validations = 8;</code>
   */
  com.psiphiglobal.identity.proto.SignatureOrBuilder getValidationsOrBuilder(
      int index);
}

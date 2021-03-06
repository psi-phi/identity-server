// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: organization.proto

package com.psiphiglobal.identity.proto;

public final class OrganizationOuterClass {
  private OrganizationOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_identity_proto_Organization_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_identity_proto_Organization_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_identity_proto_SignedCertificate_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_identity_proto_SignedCertificate_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_identity_proto_CertificateData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_identity_proto_CertificateData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_identity_proto_OrganizationDetails_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_identity_proto_OrganizationDetails_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022organization.proto\022\016identity.proto\032\014co" +
      "mmon.proto\"\351\001\n\014Organization\022\023\n\013domain_na" +
      "me\030\001 \001(\t\022\027\n\017primary_cert_id\030\002 \001(\t\0227\n\014act" +
      "ive_certs\030\003 \003(\0132!.identity.proto.SignedC" +
      "ertificate\0228\n\rexpired_certs\030\004 \003(\0132!.iden" +
      "tity.proto.SignedCertificate\0228\n\rblocked_" +
      "certs\030\005 \003(\0132!.identity.proto.SignedCerti" +
      "ficate\"\311\002\n\021SignedCertificate\022\n\n\002id\030\001 \001(\t" +
      "\0221\n\006status\030\002 \001(\0162!.identity.proto.Certif" +
      "icateStatus\022\022\n\ncreated_at\030\003 \001(\004\022\022\n\nexpir",
      "ed_at\030\004 \001(\004\022@\n\017auto_validation\030\005 \001(\0162\'.i" +
      "dentity.proto.AutoValidationMechanism\022-\n" +
      "\004data\030\006 \001(\0132\037.identity.proto.Certificate" +
      "Data\022,\n\tself_sign\030\007 \001(\0132\031.identity.proto" +
      ".Signature\022.\n\013validations\030\010 \003(\0132\031.identi" +
      "ty.proto.Signature\"\217\001\n\017CertificateData\022\023" +
      "\n\013domain_name\030\001 \001(\t\0228\n\013org_details\030\002 \001(\013" +
      "2#.identity.proto.OrganizationDetails\022-\n" +
      "\npublic_key\030\003 \001(\0132\031.identity.proto.Publi" +
      "cKey\"C\n\023OrganizationDetails\022\014\n\004name\030\001 \001(",
      "\t\022\r\n\005email\030\002 \001(\t\022\017\n\007country\030\003 \001(\t*9\n\021Cer" +
      "tificateStatus\022\n\n\006ACTIVE\020\000\022\013\n\007EXPIRED\020\001\022" +
      "\013\n\007BLOCKED\020\002*9\n\027AutoValidationMechanism\022" +
      "\013\n\007UNKNOWN\020\000\022\010\n\004NONE\020\001\022\007\n\003DNS\020\002B-\n\037com.p" +
      "siphiglobal.identity.protoP\001Z\010identityb\006" +
      "proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.psiphiglobal.identity.proto.Common.getDescriptor(),
        }, assigner);
    internal_static_identity_proto_Organization_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_identity_proto_Organization_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_identity_proto_Organization_descriptor,
        new java.lang.String[] { "DomainName", "PrimaryCertId", "ActiveCerts", "ExpiredCerts", "BlockedCerts", });
    internal_static_identity_proto_SignedCertificate_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_identity_proto_SignedCertificate_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_identity_proto_SignedCertificate_descriptor,
        new java.lang.String[] { "Id", "Status", "CreatedAt", "ExpiredAt", "AutoValidation", "Data", "SelfSign", "Validations", });
    internal_static_identity_proto_CertificateData_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_identity_proto_CertificateData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_identity_proto_CertificateData_descriptor,
        new java.lang.String[] { "DomainName", "OrgDetails", "PublicKey", });
    internal_static_identity_proto_OrganizationDetails_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_identity_proto_OrganizationDetails_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_identity_proto_OrganizationDetails_descriptor,
        new java.lang.String[] { "Name", "Email", "Country", });
    com.psiphiglobal.identity.proto.Common.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

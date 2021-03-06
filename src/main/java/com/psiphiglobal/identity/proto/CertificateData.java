// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: organization.proto

package com.psiphiglobal.identity.proto;

/**
 * Protobuf type {@code identity.proto.CertificateData}
 */
public  final class CertificateData extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:identity.proto.CertificateData)
    CertificateDataOrBuilder {
  // Use CertificateData.newBuilder() to construct.
  private CertificateData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CertificateData() {
    domainName_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private CertificateData(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            domainName_ = s;
            break;
          }
          case 18: {
            com.psiphiglobal.identity.proto.OrganizationDetails.Builder subBuilder = null;
            if (orgDetails_ != null) {
              subBuilder = orgDetails_.toBuilder();
            }
            orgDetails_ = input.readMessage(com.psiphiglobal.identity.proto.OrganizationDetails.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(orgDetails_);
              orgDetails_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            com.psiphiglobal.identity.proto.PublicKey.Builder subBuilder = null;
            if (publicKey_ != null) {
              subBuilder = publicKey_.toBuilder();
            }
            publicKey_ = input.readMessage(com.psiphiglobal.identity.proto.PublicKey.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(publicKey_);
              publicKey_ = subBuilder.buildPartial();
            }

            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.psiphiglobal.identity.proto.OrganizationOuterClass.internal_static_identity_proto_CertificateData_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.psiphiglobal.identity.proto.OrganizationOuterClass.internal_static_identity_proto_CertificateData_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.psiphiglobal.identity.proto.CertificateData.class, com.psiphiglobal.identity.proto.CertificateData.Builder.class);
  }

  public static final int DOMAIN_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object domainName_;
  /**
   * <code>string domain_name = 1;</code>
   */
  public java.lang.String getDomainName() {
    java.lang.Object ref = domainName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      domainName_ = s;
      return s;
    }
  }
  /**
   * <code>string domain_name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getDomainNameBytes() {
    java.lang.Object ref = domainName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      domainName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ORG_DETAILS_FIELD_NUMBER = 2;
  private com.psiphiglobal.identity.proto.OrganizationDetails orgDetails_;
  /**
   * <code>.identity.proto.OrganizationDetails org_details = 2;</code>
   */
  public boolean hasOrgDetails() {
    return orgDetails_ != null;
  }
  /**
   * <code>.identity.proto.OrganizationDetails org_details = 2;</code>
   */
  public com.psiphiglobal.identity.proto.OrganizationDetails getOrgDetails() {
    return orgDetails_ == null ? com.psiphiglobal.identity.proto.OrganizationDetails.getDefaultInstance() : orgDetails_;
  }
  /**
   * <code>.identity.proto.OrganizationDetails org_details = 2;</code>
   */
  public com.psiphiglobal.identity.proto.OrganizationDetailsOrBuilder getOrgDetailsOrBuilder() {
    return getOrgDetails();
  }

  public static final int PUBLIC_KEY_FIELD_NUMBER = 3;
  private com.psiphiglobal.identity.proto.PublicKey publicKey_;
  /**
   * <code>.identity.proto.PublicKey public_key = 3;</code>
   */
  public boolean hasPublicKey() {
    return publicKey_ != null;
  }
  /**
   * <code>.identity.proto.PublicKey public_key = 3;</code>
   */
  public com.psiphiglobal.identity.proto.PublicKey getPublicKey() {
    return publicKey_ == null ? com.psiphiglobal.identity.proto.PublicKey.getDefaultInstance() : publicKey_;
  }
  /**
   * <code>.identity.proto.PublicKey public_key = 3;</code>
   */
  public com.psiphiglobal.identity.proto.PublicKeyOrBuilder getPublicKeyOrBuilder() {
    return getPublicKey();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getDomainNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, domainName_);
    }
    if (orgDetails_ != null) {
      output.writeMessage(2, getOrgDetails());
    }
    if (publicKey_ != null) {
      output.writeMessage(3, getPublicKey());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getDomainNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, domainName_);
    }
    if (orgDetails_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getOrgDetails());
    }
    if (publicKey_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getPublicKey());
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.psiphiglobal.identity.proto.CertificateData)) {
      return super.equals(obj);
    }
    com.psiphiglobal.identity.proto.CertificateData other = (com.psiphiglobal.identity.proto.CertificateData) obj;

    boolean result = true;
    result = result && getDomainName()
        .equals(other.getDomainName());
    result = result && (hasOrgDetails() == other.hasOrgDetails());
    if (hasOrgDetails()) {
      result = result && getOrgDetails()
          .equals(other.getOrgDetails());
    }
    result = result && (hasPublicKey() == other.hasPublicKey());
    if (hasPublicKey()) {
      result = result && getPublicKey()
          .equals(other.getPublicKey());
    }
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DOMAIN_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getDomainName().hashCode();
    if (hasOrgDetails()) {
      hash = (37 * hash) + ORG_DETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getOrgDetails().hashCode();
    }
    if (hasPublicKey()) {
      hash = (37 * hash) + PUBLIC_KEY_FIELD_NUMBER;
      hash = (53 * hash) + getPublicKey().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.psiphiglobal.identity.proto.CertificateData parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.psiphiglobal.identity.proto.CertificateData parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.psiphiglobal.identity.proto.CertificateData parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.psiphiglobal.identity.proto.CertificateData parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.psiphiglobal.identity.proto.CertificateData parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.psiphiglobal.identity.proto.CertificateData parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.psiphiglobal.identity.proto.CertificateData parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.psiphiglobal.identity.proto.CertificateData parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.psiphiglobal.identity.proto.CertificateData parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.psiphiglobal.identity.proto.CertificateData parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.psiphiglobal.identity.proto.CertificateData prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code identity.proto.CertificateData}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:identity.proto.CertificateData)
      com.psiphiglobal.identity.proto.CertificateDataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.psiphiglobal.identity.proto.OrganizationOuterClass.internal_static_identity_proto_CertificateData_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.psiphiglobal.identity.proto.OrganizationOuterClass.internal_static_identity_proto_CertificateData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.psiphiglobal.identity.proto.CertificateData.class, com.psiphiglobal.identity.proto.CertificateData.Builder.class);
    }

    // Construct using com.psiphiglobal.identity.proto.CertificateData.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      domainName_ = "";

      if (orgDetailsBuilder_ == null) {
        orgDetails_ = null;
      } else {
        orgDetails_ = null;
        orgDetailsBuilder_ = null;
      }
      if (publicKeyBuilder_ == null) {
        publicKey_ = null;
      } else {
        publicKey_ = null;
        publicKeyBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.psiphiglobal.identity.proto.OrganizationOuterClass.internal_static_identity_proto_CertificateData_descriptor;
    }

    public com.psiphiglobal.identity.proto.CertificateData getDefaultInstanceForType() {
      return com.psiphiglobal.identity.proto.CertificateData.getDefaultInstance();
    }

    public com.psiphiglobal.identity.proto.CertificateData build() {
      com.psiphiglobal.identity.proto.CertificateData result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.psiphiglobal.identity.proto.CertificateData buildPartial() {
      com.psiphiglobal.identity.proto.CertificateData result = new com.psiphiglobal.identity.proto.CertificateData(this);
      result.domainName_ = domainName_;
      if (orgDetailsBuilder_ == null) {
        result.orgDetails_ = orgDetails_;
      } else {
        result.orgDetails_ = orgDetailsBuilder_.build();
      }
      if (publicKeyBuilder_ == null) {
        result.publicKey_ = publicKey_;
      } else {
        result.publicKey_ = publicKeyBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.psiphiglobal.identity.proto.CertificateData) {
        return mergeFrom((com.psiphiglobal.identity.proto.CertificateData)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.psiphiglobal.identity.proto.CertificateData other) {
      if (other == com.psiphiglobal.identity.proto.CertificateData.getDefaultInstance()) return this;
      if (!other.getDomainName().isEmpty()) {
        domainName_ = other.domainName_;
        onChanged();
      }
      if (other.hasOrgDetails()) {
        mergeOrgDetails(other.getOrgDetails());
      }
      if (other.hasPublicKey()) {
        mergePublicKey(other.getPublicKey());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.psiphiglobal.identity.proto.CertificateData parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.psiphiglobal.identity.proto.CertificateData) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object domainName_ = "";
    /**
     * <code>string domain_name = 1;</code>
     */
    public java.lang.String getDomainName() {
      java.lang.Object ref = domainName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        domainName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string domain_name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getDomainNameBytes() {
      java.lang.Object ref = domainName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        domainName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string domain_name = 1;</code>
     */
    public Builder setDomainName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      domainName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string domain_name = 1;</code>
     */
    public Builder clearDomainName() {
      
      domainName_ = getDefaultInstance().getDomainName();
      onChanged();
      return this;
    }
    /**
     * <code>string domain_name = 1;</code>
     */
    public Builder setDomainNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      domainName_ = value;
      onChanged();
      return this;
    }

    private com.psiphiglobal.identity.proto.OrganizationDetails orgDetails_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.psiphiglobal.identity.proto.OrganizationDetails, com.psiphiglobal.identity.proto.OrganizationDetails.Builder, com.psiphiglobal.identity.proto.OrganizationDetailsOrBuilder> orgDetailsBuilder_;
    /**
     * <code>.identity.proto.OrganizationDetails org_details = 2;</code>
     */
    public boolean hasOrgDetails() {
      return orgDetailsBuilder_ != null || orgDetails_ != null;
    }
    /**
     * <code>.identity.proto.OrganizationDetails org_details = 2;</code>
     */
    public com.psiphiglobal.identity.proto.OrganizationDetails getOrgDetails() {
      if (orgDetailsBuilder_ == null) {
        return orgDetails_ == null ? com.psiphiglobal.identity.proto.OrganizationDetails.getDefaultInstance() : orgDetails_;
      } else {
        return orgDetailsBuilder_.getMessage();
      }
    }
    /**
     * <code>.identity.proto.OrganizationDetails org_details = 2;</code>
     */
    public Builder setOrgDetails(com.psiphiglobal.identity.proto.OrganizationDetails value) {
      if (orgDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        orgDetails_ = value;
        onChanged();
      } else {
        orgDetailsBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.identity.proto.OrganizationDetails org_details = 2;</code>
     */
    public Builder setOrgDetails(
        com.psiphiglobal.identity.proto.OrganizationDetails.Builder builderForValue) {
      if (orgDetailsBuilder_ == null) {
        orgDetails_ = builderForValue.build();
        onChanged();
      } else {
        orgDetailsBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.identity.proto.OrganizationDetails org_details = 2;</code>
     */
    public Builder mergeOrgDetails(com.psiphiglobal.identity.proto.OrganizationDetails value) {
      if (orgDetailsBuilder_ == null) {
        if (orgDetails_ != null) {
          orgDetails_ =
            com.psiphiglobal.identity.proto.OrganizationDetails.newBuilder(orgDetails_).mergeFrom(value).buildPartial();
        } else {
          orgDetails_ = value;
        }
        onChanged();
      } else {
        orgDetailsBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.identity.proto.OrganizationDetails org_details = 2;</code>
     */
    public Builder clearOrgDetails() {
      if (orgDetailsBuilder_ == null) {
        orgDetails_ = null;
        onChanged();
      } else {
        orgDetails_ = null;
        orgDetailsBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.identity.proto.OrganizationDetails org_details = 2;</code>
     */
    public com.psiphiglobal.identity.proto.OrganizationDetails.Builder getOrgDetailsBuilder() {
      
      onChanged();
      return getOrgDetailsFieldBuilder().getBuilder();
    }
    /**
     * <code>.identity.proto.OrganizationDetails org_details = 2;</code>
     */
    public com.psiphiglobal.identity.proto.OrganizationDetailsOrBuilder getOrgDetailsOrBuilder() {
      if (orgDetailsBuilder_ != null) {
        return orgDetailsBuilder_.getMessageOrBuilder();
      } else {
        return orgDetails_ == null ?
            com.psiphiglobal.identity.proto.OrganizationDetails.getDefaultInstance() : orgDetails_;
      }
    }
    /**
     * <code>.identity.proto.OrganizationDetails org_details = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.psiphiglobal.identity.proto.OrganizationDetails, com.psiphiglobal.identity.proto.OrganizationDetails.Builder, com.psiphiglobal.identity.proto.OrganizationDetailsOrBuilder> 
        getOrgDetailsFieldBuilder() {
      if (orgDetailsBuilder_ == null) {
        orgDetailsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.psiphiglobal.identity.proto.OrganizationDetails, com.psiphiglobal.identity.proto.OrganizationDetails.Builder, com.psiphiglobal.identity.proto.OrganizationDetailsOrBuilder>(
                getOrgDetails(),
                getParentForChildren(),
                isClean());
        orgDetails_ = null;
      }
      return orgDetailsBuilder_;
    }

    private com.psiphiglobal.identity.proto.PublicKey publicKey_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.psiphiglobal.identity.proto.PublicKey, com.psiphiglobal.identity.proto.PublicKey.Builder, com.psiphiglobal.identity.proto.PublicKeyOrBuilder> publicKeyBuilder_;
    /**
     * <code>.identity.proto.PublicKey public_key = 3;</code>
     */
    public boolean hasPublicKey() {
      return publicKeyBuilder_ != null || publicKey_ != null;
    }
    /**
     * <code>.identity.proto.PublicKey public_key = 3;</code>
     */
    public com.psiphiglobal.identity.proto.PublicKey getPublicKey() {
      if (publicKeyBuilder_ == null) {
        return publicKey_ == null ? com.psiphiglobal.identity.proto.PublicKey.getDefaultInstance() : publicKey_;
      } else {
        return publicKeyBuilder_.getMessage();
      }
    }
    /**
     * <code>.identity.proto.PublicKey public_key = 3;</code>
     */
    public Builder setPublicKey(com.psiphiglobal.identity.proto.PublicKey value) {
      if (publicKeyBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        publicKey_ = value;
        onChanged();
      } else {
        publicKeyBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.identity.proto.PublicKey public_key = 3;</code>
     */
    public Builder setPublicKey(
        com.psiphiglobal.identity.proto.PublicKey.Builder builderForValue) {
      if (publicKeyBuilder_ == null) {
        publicKey_ = builderForValue.build();
        onChanged();
      } else {
        publicKeyBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.identity.proto.PublicKey public_key = 3;</code>
     */
    public Builder mergePublicKey(com.psiphiglobal.identity.proto.PublicKey value) {
      if (publicKeyBuilder_ == null) {
        if (publicKey_ != null) {
          publicKey_ =
            com.psiphiglobal.identity.proto.PublicKey.newBuilder(publicKey_).mergeFrom(value).buildPartial();
        } else {
          publicKey_ = value;
        }
        onChanged();
      } else {
        publicKeyBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.identity.proto.PublicKey public_key = 3;</code>
     */
    public Builder clearPublicKey() {
      if (publicKeyBuilder_ == null) {
        publicKey_ = null;
        onChanged();
      } else {
        publicKey_ = null;
        publicKeyBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.identity.proto.PublicKey public_key = 3;</code>
     */
    public com.psiphiglobal.identity.proto.PublicKey.Builder getPublicKeyBuilder() {
      
      onChanged();
      return getPublicKeyFieldBuilder().getBuilder();
    }
    /**
     * <code>.identity.proto.PublicKey public_key = 3;</code>
     */
    public com.psiphiglobal.identity.proto.PublicKeyOrBuilder getPublicKeyOrBuilder() {
      if (publicKeyBuilder_ != null) {
        return publicKeyBuilder_.getMessageOrBuilder();
      } else {
        return publicKey_ == null ?
            com.psiphiglobal.identity.proto.PublicKey.getDefaultInstance() : publicKey_;
      }
    }
    /**
     * <code>.identity.proto.PublicKey public_key = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.psiphiglobal.identity.proto.PublicKey, com.psiphiglobal.identity.proto.PublicKey.Builder, com.psiphiglobal.identity.proto.PublicKeyOrBuilder> 
        getPublicKeyFieldBuilder() {
      if (publicKeyBuilder_ == null) {
        publicKeyBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.psiphiglobal.identity.proto.PublicKey, com.psiphiglobal.identity.proto.PublicKey.Builder, com.psiphiglobal.identity.proto.PublicKeyOrBuilder>(
                getPublicKey(),
                getParentForChildren(),
                isClean());
        publicKey_ = null;
      }
      return publicKeyBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:identity.proto.CertificateData)
  }

  // @@protoc_insertion_point(class_scope:identity.proto.CertificateData)
  private static final com.psiphiglobal.identity.proto.CertificateData DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.psiphiglobal.identity.proto.CertificateData();
  }

  public static com.psiphiglobal.identity.proto.CertificateData getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CertificateData>
      PARSER = new com.google.protobuf.AbstractParser<CertificateData>() {
    public CertificateData parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new CertificateData(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CertificateData> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CertificateData> getParserForType() {
    return PARSER;
  }

  public com.psiphiglobal.identity.proto.CertificateData getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


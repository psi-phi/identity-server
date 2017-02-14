package com.psiphiglobal.identity.model;

import com.google.gson.annotations.SerializedName;
import com.psiphiglobal.identity.proto.Common;
import com.psiphiglobal.identity.proto.Organization;
import org.apache.commons.codec.binary.Base64;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public final class Certificate
{
    @SerializedName("cert_id")
    private String certId;

    @SerializedName("status")
    private String statue;

    @SerializedName("created_at")
    private OffsetDateTime createdAt;

    @SerializedName("expired_at")
    private OffsetDateTime expiredAt;

    @SerializedName("auto_validated")
    private boolean isAutoValidated;

    @SerializedName("certificate_data")
    private CertData certData;

    @SerializedName("self_sign")
    private Signature selfSign;

    @SerializedName("validations")
    private List<Signature> validations;

    private Certificate()
    {
    }

    public static Certificate parse(Organization.SignedCertificate cert)
    {
        Certificate certificate = new Certificate();
        certificate.certId = cert.getId();
        certificate.statue = cert.getStatus().toString();
        certificate.createdAt = OffsetDateTime.ofInstant(Instant.ofEpochMilli(cert.getCreatedAt()), ZoneOffset.UTC);

        if (cert.getStatus() == Organization.CertificateStatus.EXPIRED)
            certificate.expiredAt = OffsetDateTime.ofInstant(Instant.ofEpochMilli(cert.getExpiredAt()), ZoneOffset.UTC);

        certificate.isAutoValidated = cert.getAutoValidation() != Organization.AutoValidationMechanism.NONE;

        PublicKey publicKey = new PublicKey();
        publicKey.algorithm = cert.getData().getPublicKey().getAlgorithm().toString();
        publicKey.encodedKey = Base64.encodeBase64String(cert.getData().getPublicKey().getData().toByteArray());

        OrgDetails orgDetails = new OrgDetails();
        orgDetails.name = cert.getData().getOrgDetails().getName();
        orgDetails.email = cert.getData().getOrgDetails().getEmail();
        orgDetails.country = cert.getData().getOrgDetails().getCountry();

        CertData certData = new CertData();
        certData.domainName = cert.getData().getDomainName();
        certData.orgDetails = orgDetails;
        certData.publicKey = publicKey;

        certificate.certData = certData;

        Signature selfSign = new Signature();
        selfSign.algorithm = cert.getSelfSign().getAlgorithm().toString();
        selfSign.signerCertId = cert.getSelfSign().getSignerCertId();
        selfSign.encodedSignature = Base64.encodeBase64String(cert.getSelfSign().getData().toByteArray());
        selfSign.timestamp = OffsetDateTime.ofInstant(Instant.ofEpochMilli(cert.getSelfSign().getTimestamp()), ZoneOffset.UTC);

        certificate.selfSign = selfSign;

        certificate.validations = new ArrayList<>();
        for(Common.Signature signature: cert.getValidationsList())
        {
            Signature validation = new Signature();
            validation.algorithm = signature.getAlgorithm().toString();
            validation.signerCertId = signature.getSignerCertId();
            validation.encodedSignature = Base64.encodeBase64String(signature.getData().toByteArray());
            validation.timestamp = OffsetDateTime.ofInstant(Instant.ofEpochMilli(signature.getTimestamp()), ZoneOffset.UTC);

            certificate.validations.add(validation);
        }

        return certificate;
    }

    private static class CertData
    {
        @SerializedName("domain_name")
        private String domainName;

        @SerializedName("org_details")
        private OrgDetails orgDetails;

        @SerializedName("public_key")
        private PublicKey publicKey;
    }

    private static class OrgDetails
    {
        @SerializedName("name")
        private String name;

        @SerializedName("email")
        private String email;

        @SerializedName("country")
        private String country;
    }

    private static class PublicKey
    {
        @SerializedName("algorithm")
        private String algorithm;

        @SerializedName("encoded_key")
        private String encodedKey;
    }

    private static class Signature
    {
        @SerializedName("signer_cert_id")
        private String signerCertId;

        @SerializedName("algorithm")
        private String algorithm;

        @SerializedName("encoded_signature")
        private String encodedSignature;

        @SerializedName("timestamp")
        private OffsetDateTime timestamp;
    }
}

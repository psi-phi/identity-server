package com.psiphiglobal.identity.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.psiphiglobal.identity.blockchain.BlockchainApiManager;
import com.psiphiglobal.identity.db.KeyValueStoreProvider;
import com.psiphiglobal.identity.model.Certificate;
import com.psiphiglobal.identity.proto.*;
import com.psiphiglobal.identity.service.helper.CertificateHelper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.validator.routines.DomainValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Instant;
import java.util.Arrays;
import java.util.Locale;

public class CertificateService
{
    private static final Logger LOGGER = LogManager.getLogger();

    public Certificate fetchActiveCertificate(String domainName)
    {
        return Certificate.parse(BlockchainApiManager.getInstance().getOrganizationIdentityApi().fetchPrimaryCertificate(domainName));
    }

    public Certificate fetchCertificate(String certId)
    {
        return Certificate.parse(BlockchainApiManager.getInstance().getOrganizationIdentityApi().fetchCertificate(certId));
    }

    public String initiateRegistration(String domainName, String orgName, String orgEmail, String orgCountry,
                                       String publicKeyAlgo, String base64EncodedX509PublicKey)
            throws InvalidDomainException, InvalidOrgNameException, InvalidEmailException, InvalidCountryException, InvalidPublicKeyException
    {
        // Validate Input
        if (!DomainValidator.getInstance().isValid(domainName))
            throw new InvalidDomainException();

        if (orgName == null || orgName.isEmpty())
            throw new InvalidOrgNameException();

        if (!EmailValidator.getInstance().isValid(orgEmail))
            throw new InvalidEmailException();

        if (!Arrays.asList(Locale.getISOCountries()).contains(orgCountry))
            throw new InvalidCountryException();

        PublicKey publicKey = CertificateHelper.parsePublicKey(publicKeyAlgo, base64EncodedX509PublicKey);
        if (publicKey == null)
            throw new InvalidPublicKeyException();

        // Initialize models
        OrganizationDetails orgDetails = OrganizationDetails.newBuilder()
                .setName(orgName)
                .setEmail(orgEmail)
                .setCountry(orgCountry)
                .build();

        CertificateData certData = CertificateData.newBuilder()
                .setDomainName(domainName)
                .setOrgDetails(orgDetails)
                .setPublicKey(publicKey)
                .build();

        // Persist data for validation
        String certId = CertificateHelper.getCertId(certData);
        KeyValueStoreProvider.getInstance().put(certId, certData.toByteArray());

        return certId;
    }

    public String completeRegistration(String domainName, String certId, String signature, String autoValidationMechanismStr)
            throws InvalidCertIdException, InvalidDomainException, InvalidSignatureException, AutoValidationException
    {
        // Validate Input
        byte[] binaryCertData = KeyValueStoreProvider.getInstance().get(certId);
        if (binaryCertData == null)
            throw new InvalidCertIdException();

        CertificateData certData = null;
        try
        {
            certData = CertificateData.parseFrom(binaryCertData);
        }
        catch (InvalidProtocolBufferException ignored)
        {
        }

        if (!certData.getDomainName().equals(domainName))
            throw new InvalidDomainException();

        Signature selfSign = CertificateHelper.processSignature(certData, signature);
        if (selfSign == null)
            throw new InvalidSignatureException();

        AutoValidationMechanism autoValidationMechanism;
        try
        {
            autoValidationMechanism = AutoValidationMechanism.valueOf(autoValidationMechanismStr);
        }
        catch (Exception ignored)
        {
            autoValidationMechanism = AutoValidationMechanism.NONE;
        }

        // Auto Validation
        if (autoValidationMechanism == AutoValidationMechanism.DNS && !CertificateHelper.dnsValidate(domainName, certId))
            throw new AutoValidationException();

        // Initiate Models
        Instant now = Instant.now();
        selfSign = selfSign.toBuilder()
                .setSignerCertId(certId)
                .setTimestamp(now.getEpochSecond())
                .build();

        SignedCertificate signedCertificate = SignedCertificate.newBuilder()
                .setId(certId)
                .setStatus(CertificateStatus.ACTIVE)
                .setCreatedAt(now.getEpochSecond())
                .setAutoValidation(autoValidationMechanism)
                .setData(certData)
                .setSelfSign(selfSign)
                .build();

        // Blockchain API
        String txId = BlockchainApiManager.getInstance().getOrganizationIdentityApi().addCertificate(signedCertificate);
        KeyValueStoreProvider.getInstance().delete(certId);

        LOGGER.debug("[Encoded SignedCertificate Proto] " + Base64.encodeBase64String(signedCertificate.toByteArray()));

        return txId;
    }

    public class InvalidDomainException extends LoggableException
    {
    }

    public class InvalidOrgNameException extends LoggableException
    {
    }

    public class InvalidEmailException extends LoggableException
    {
    }

    public class InvalidCountryException extends LoggableException
    {
    }

    public class InvalidPublicKeyException extends LoggableException
    {
    }

    public class InvalidCertIdException extends LoggableException
    {
    }

    public class InvalidSignatureException extends LoggableException
    {
    }

    public class AutoValidationException extends LoggableException
    {
    }

    public class LoggableException extends Exception
    {
        public LoggableException()
        {
            LOGGER.error(this.getClass().getSimpleName());
        }
    }
}

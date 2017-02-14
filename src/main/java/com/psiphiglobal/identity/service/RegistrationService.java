package com.psiphiglobal.identity.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.psiphiglobal.identity.db.KeyValueStoreProvider;
import com.psiphiglobal.identity.model.Certificate;
import com.psiphiglobal.identity.proto.Common;
import com.psiphiglobal.identity.proto.Organization;
import com.psiphiglobal.identity.service.helper.CertificateHelper;
import org.apache.commons.validator.routines.DomainValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Instant;
import java.util.Arrays;
import java.util.Locale;

public class RegistrationService
{
    private static final Logger LOGGER = LogManager.getLogger();

    public String initiate(String domainName, String orgName, String orgEmail, String orgCountry,
                           String publicKeyAlgo, String base64EncodedX509PublicKey) throws InvalidDomainException,
                                                                                           InvalidOrgNameException,
                                                                                           InvalidEmailException,
                                                                                           InvalidCountryException,
                                                                                           InvalidPublicKeyException
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

        Common.PublicKey publicKey = CertificateHelper.parsePublicKey(publicKeyAlgo, base64EncodedX509PublicKey);
        if (publicKey == null)
            throw new InvalidPublicKeyException();

        // Initialize models
        Organization.OrganizationDetails orgDetails = Organization.OrganizationDetails.newBuilder()
                .setName(orgName)
                .setEmail(orgEmail)
                .setCountry(orgCountry)
                .build();

        Organization.CertificateData certData = Organization.CertificateData.newBuilder()
                .setDomainName(domainName)
                .setOrgDetails(orgDetails)
                .setPublicKey(publicKey)
                .build();

        // Persist data for validation
        String certId = CertificateHelper.getCertId(certData);
        KeyValueStoreProvider.getInstance().put(certId, certData.toByteArray());

        return certId;
    }

    public Certificate complete(String domainName, String certId, String signature, String autoValidationMechanismStr)
            throws InvalidCertIdException, InvalidDomainException, InvalidSignatureException, AutoValidationException
    {
        // Validate Input
        byte[] binaryCertData = KeyValueStoreProvider.getInstance().get(certId);
        if (binaryCertData == null)
            throw new InvalidCertIdException();

        Organization.CertificateData certData = null;
        try
        {
            certData = Organization.CertificateData.parseFrom(binaryCertData);
        }
        catch (InvalidProtocolBufferException ignored)
        {
        }

        if (!certData.getDomainName().equals(domainName))
            throw new InvalidDomainException();

        Common.Signature selfSign = CertificateHelper.processSignature(certData, signature);
        if (selfSign == null)
            throw new InvalidSignatureException();

        Organization.AutoValidationMechanism autoValidationMechanism = Organization.AutoValidationMechanism.NONE;
        try
        {
            autoValidationMechanism = Organization.AutoValidationMechanism.valueOf(autoValidationMechanismStr);
        }
        catch (Exception ignored)
        {
            autoValidationMechanism = Organization.AutoValidationMechanism.NONE;
        }

        // Auto Validation
        if(autoValidationMechanism == Organization.AutoValidationMechanism.DNS && !CertificateHelper.dnsValidate(domainName, certId))
            throw new AutoValidationException();

        // Initiate Models
        Instant now = Instant.now();
        selfSign = selfSign.toBuilder()
                .setSignerCertId(certId)
                .setTimestamp(now.toEpochMilli())
                .build();

        Organization.SignedCertificate signedCertificate = Organization.SignedCertificate.newBuilder()
                .setId(certId)
                .setStatus(Organization.CertificateStatus.ACTIVE)
                .setCreatedAt(now.toEpochMilli())
                .setAutoValidation(autoValidationMechanism)
                .setData(certData)
                .setSelfSign(selfSign)
                .build();

        return Certificate.parse(signedCertificate);
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

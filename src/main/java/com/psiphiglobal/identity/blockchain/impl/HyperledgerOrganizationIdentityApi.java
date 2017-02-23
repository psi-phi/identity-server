package com.psiphiglobal.identity.blockchain.impl;

import com.psiphiglobal.hyperledger_client.ChaincodeExecutionException;
import com.psiphiglobal.hyperledger_client.api.ChaincodeExecutor;
import com.psiphiglobal.identity.blockchain.OrganizationIdentityApi;
import com.psiphiglobal.identity.proto.SignedCertificate;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HyperledgerOrganizationIdentityApi implements OrganizationIdentityApi
{
    private static Logger LOGGER = LogManager.getLogger();

    private static final String FUNC_FETCH_PRIMARY_CERY = "get_primary_cert";
    private static final String FUNC_FETCH_CERT = "get_cert";
    private static final String FUNC_ADD_CERT = "put_cert";

    private ChaincodeExecutor chaincodeExecutor;

    public HyperledgerOrganizationIdentityApi(ChaincodeExecutor chaincodeExecutor)
    {
        this.chaincodeExecutor = chaincodeExecutor;
    }

    @Override
    public SignedCertificate fetchPrimaryCertificate(String domainName)
    {
        try
        {
            String encodedData = chaincodeExecutor.query(FUNC_FETCH_PRIMARY_CERY, domainName);
            byte[] data = Base64.decodeBase64(encodedData);
            return SignedCertificate.parseFrom(data);
        }
        catch (ChaincodeExecutionException e)
        {
            LOGGER.error("[Blockchain] Failed to fetch primary cert", e);
            return null;
        }
        catch (Exception e)
        {
            LOGGER.error("[Blockchain] Error ", e);
            return null;
        }
    }

    @Override
    public SignedCertificate fetchCertificate(String certId)
    {
        try
        {
            String encodedData = chaincodeExecutor.query(FUNC_FETCH_CERT, certId);
            byte[] data = Base64.decodeBase64(encodedData);
            return SignedCertificate.parseFrom(data);
        }
        catch (ChaincodeExecutionException e)
        {
            LOGGER.error("[Blockchain] Failed to fetch cert", e);
            return null;
        }
        catch (Exception e)
        {
            LOGGER.error("[Blockchain] Error ", e);
            return null;
        }
    }

    @Override
    public String addCertificate(SignedCertificate certificate)
    {
        try
        {
            byte[] certData = certificate.toByteArray();
            String encodedCertData = Base64.encodeBase64String(certData);
            return chaincodeExecutor.invoke(FUNC_ADD_CERT, encodedCertData);
        }
        catch (ChaincodeExecutionException e)
        {
            LOGGER.error("[Blockchain] Failed to add cert", e);
            return null;
        }
        catch (Exception e)
        {
            LOGGER.error("[Blockchain] Error ", e);
            return null;
        }
    }
}

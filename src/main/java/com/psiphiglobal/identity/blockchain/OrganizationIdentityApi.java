package com.psiphiglobal.identity.blockchain;


import com.psiphiglobal.identity.proto.SignedCertificate;

public interface OrganizationIdentityApi
{
    SignedCertificate fetchPrimaryCertificate(String domainName);

    SignedCertificate fetchCertificate(String certId);

    String addCertificate(SignedCertificate certificate);
}

package com.psiphiglobal.identity.blockchain;

import com.psiphiglobal.identity.proto.Organization.SignedCertificate;

import java.util.List;

public interface OrganizationIdentityApi
{
    List<SignedCertificate> fetchActiveCertificates(String domainName);

    void addCertificate(SignedCertificate certificate);
}

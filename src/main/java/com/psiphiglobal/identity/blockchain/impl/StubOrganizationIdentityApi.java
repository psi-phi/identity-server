package com.psiphiglobal.identity.blockchain.impl;

import com.psiphiglobal.identity.blockchain.OrganizationIdentityApi;
import com.psiphiglobal.identity.proto.Organization.SignedCertificate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StubOrganizationIdentityApi implements OrganizationIdentityApi
{
    private ConcurrentHashMap<String, Organization> organizations;
    private ConcurrentHashMap<String, SignedCertificate> certs;

    public StubOrganizationIdentityApi()
    {
        organizations = new ConcurrentHashMap<>();
        certs = new ConcurrentHashMap<>();
    }

    @Override
    public List<SignedCertificate> fetchActiveCertificates(String domainName)
    {
        if(organizations.get(domainName) != null)
        {
            List<String> activeCerts = organizations.get(domainName).activeCerts;
            return activeCerts.stream()
                    .map(certId -> certs.get(certId))
                    .collect(Collectors.toList());
        }
        else
            return new ArrayList<>();
    }

    @Override
    public void addCertificate(SignedCertificate certificate)
    {
        String domainName = certificate.getData().getDomainName();
        String certId = certificate.getId();

        if (organizations.get(domainName) == null)
            organizations.put(domainName, new Organization());

        organizations.get(domainName).activeCerts.add(certId);
        certs.put(certId, certificate);
    }

    private static class Organization
    {
        private List<String> activeCerts;
        private List<String> expiredCerts;
        private List<String> blockedCerts;

        public Organization()
        {
            activeCerts = new ArrayList<>();
            expiredCerts = new ArrayList<>();
            blockedCerts = new ArrayList<>();
        }
    }
}

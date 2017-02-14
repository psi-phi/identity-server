package com.psiphiglobal.identity.blockchain;

import com.psiphiglobal.identity.blockchain.impl.StubOrganizationIdentityApi;

public class BlockchainApiManager
{
    private static BlockchainApiManager instance;

    public static BlockchainApiManager getInstance()
    {
        if(instance == null)
            instance = new BlockchainApiManager();
        return instance;
    }

    private BlockchainApiManager(){}

    private OrganizationIdentityApi organizationIdentityApi;

    public OrganizationIdentityApi getOrganizationIdentityApi()
    {
        if(organizationIdentityApi == null)
            organizationIdentityApi = new StubOrganizationIdentityApi();
        return organizationIdentityApi;
    }
}

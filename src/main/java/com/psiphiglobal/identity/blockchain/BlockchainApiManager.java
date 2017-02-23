package com.psiphiglobal.identity.blockchain;

import com.psiphiglobal.hyperledger_client.api.ChaincodeExecutor;
import com.psiphiglobal.hyperledger_client.api.HyperledgerClient;
import com.psiphiglobal.hyperledger_client.api.HyperledgerClientFactory;
import com.psiphiglobal.identity._core.Constants;
import com.psiphiglobal.identity.blockchain.impl.HyperledgerOrganizationIdentityApi;

public class BlockchainApiManager
{
    private static BlockchainApiManager instance;

    public static BlockchainApiManager getInstance()
    {
        if (instance == null)
            instance = new BlockchainApiManager();
        return instance;
    }

    private HyperledgerClient hyperledgerClient;

    private BlockchainApiManager()
    {
        hyperledgerClient = HyperledgerClientFactory.getDefaultClient(Constants.HYPERLEDGER_HOST, Constants.HYPERLEDGER_PORT);
    }

    private OrganizationIdentityApi organizationIdentityApi;

    public OrganizationIdentityApi getOrganizationIdentityApi()
    {
        if (organizationIdentityApi == null)
        {
            ChaincodeExecutor chaincodeExecutor = hyperledgerClient.getChaincodeExecutor(Constants.HYPERLEDGER_CHAINCODE_NAME);
            organizationIdentityApi = new HyperledgerOrganizationIdentityApi(chaincodeExecutor);
        }

        return organizationIdentityApi;
    }
}

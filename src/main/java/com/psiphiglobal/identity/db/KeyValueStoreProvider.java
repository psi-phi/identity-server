package com.psiphiglobal.identity.db;

import com.psiphiglobal.identity.db.impl.InMemoryKeyValueStore;

public class KeyValueStoreProvider
{
    private static KeyValueStore keyValueStore = new InMemoryKeyValueStore();

    public static KeyValueStore getInstance()
    {
        return keyValueStore;
    }
}

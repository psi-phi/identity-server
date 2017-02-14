package com.psiphiglobal.identity.db;

public class KeyValueStoreProvider
{
    private static KeyValueStore keyValueStore = new InMemoryKeyValueStore();

    public static KeyValueStore getInstance()
    {
        return keyValueStore;
    }
}

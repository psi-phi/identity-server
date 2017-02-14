package com.psiphiglobal.identity.db;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryKeyValueStore implements KeyValueStore
{
    private ConcurrentHashMap<String, byte[]> data = new ConcurrentHashMap<>();

    @Override
    public void put(String key, byte[] value)
    {
        data.put(key, value);
    }

    @Override
    public byte[] get(String key)
    {
        return data.get(key);
    }

    @Override
    public void delete(String key)
    {
        data.remove(key);
    }
}

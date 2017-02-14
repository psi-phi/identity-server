package com.psiphiglobal.identity.db;

public interface KeyValueStore
{
    void put(String key, byte[] value);

    byte[] get(String key);

    void delete(String key);
}

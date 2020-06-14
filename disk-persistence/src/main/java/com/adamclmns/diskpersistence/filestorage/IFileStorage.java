package com.adamclmns.diskpersistence.filestorage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IFileStorage<K, V> {
    void save() throws IOException;

    void store(K key, V o) throws IOException;

    void storeAll(Map<K, V> entries) throws IOException;

    V get(K key);

    List<V> getAllAsArrayList();

    Map<K, V> getAll();

    void remove(K key) throws IOException;

    boolean hasKey(K key);

    boolean hasObject(V o);

    int getSize();
}

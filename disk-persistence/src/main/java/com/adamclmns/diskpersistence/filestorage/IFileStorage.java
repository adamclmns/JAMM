package com.adamclmns.diskpersistence.filestorage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IFileStorage<K, V> {
    /**
     * Saves all content to disk.
     * @throws IOException
     */
    void save() throws IOException;

    /**
     * Stores an Object to the FileStore
     * @param key
     * @param o
     * @throws IOException
     */
    void store(K key, V o) throws IOException;

    /**
     * Stores a Map of Objects and Keys to the FileStore
     * @param entries
     * @throws IOException
     */
    void storeAll(Map<K, V> entries) throws IOException;

    /**
     * Returns the Object corresponding the given Key
     * @param key
     * @return
     */
    V get(K key);

    /**
     * Get all objects in the FileStore
     * @return
     */
    List<V> getAllAsArrayList();

    /**
     * Get's all objects and their keys from the FileStore
     * @return
     */
    Map<K, V> getAll();

    /**
     * Remove a value from the FileStore
     * @param key
     * @throws IOException
     */
    void remove(K key) throws IOException;

    /**
     * Returns True if the key is present.
     * @param key
     * @return
     */
    boolean hasKey(K key);

    /**
     * Returns true if the object is present in the FileStore
     * @param o
     * @return
     */
    boolean hasObject(V o);

    /**
     * Returns the number of elements in the FileStore
     * @return
     */
    int getSize();
}

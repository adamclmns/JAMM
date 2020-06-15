package com.adamclmns.diskpersistence.filestorage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The interface File storage.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public interface IFileStorage<K, V> {
    /**
     * Saves all content to disk.
     *
     * @throws IOException the io exception
     */
    void save() throws IOException;

    /**
     * Stores an Object to the FileStore
     *
     * @param key the key
     * @param o   the o
     * @throws IOException the io exception
     */
    void store(K key, V o) throws IOException;

    /**
     * Stores a Map of Objects and Keys to the FileStore
     *
     * @param entries the entries
     * @throws IOException the io exception
     */
    void storeAll(Map<K, V> entries) throws IOException;

    /**
     * Returns the Object corresponding the given Key
     *
     * @param key the key
     * @return v
     */
    V get(K key);

    /**
     * Get all objects in the FileStore
     *
     * @return all as array list
     */
    List<V> getAllAsArrayList();

    /**
     * Get's all objects and their keys from the FileStore
     *
     * @return all
     */
    Map<K, V> getAll();

    /**
     * Remove a value from the FileStore
     *
     * @param key the key
     * @throws IOException the io exception
     */
    void remove(K key) throws IOException;

    /**
     * Returns True if the key is present.
     *
     * @param key the key
     * @return boolean
     */
    boolean hasKey(K key);

    /**
     * Returns true if the object is present in the FileStore
     *
     * @param o the o
     * @return boolean
     */
    boolean hasObject(V o);

    /**
     * Returns the number of elements in the FileStore
     *
     * @return size
     */
    int getSize();
}

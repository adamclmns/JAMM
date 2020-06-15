package com.adamclmns.diskpersistence.filestorage.crypto;

import com.adamclmns.diskpersistence.exception.DecryptionFailedException;
import com.adamclmns.diskpersistence.filestorage.IFileStorage;
import com.adamclmns.diskpersistence.filestorage.simple.GenericFileStorage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Encrypted generic file storage.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class EncryptedGenericFileStorage<K, V> extends GenericFileStorage<K, CryptedObject>
        implements IFileStorage<K, CryptedObject> {
    private Crypter crypter;

    /**
     * Instantiates a new Encrypted generic file storage.
     *
     * @param filepath the filepath
     * @param autosave the autosave
     * @throws IllegalArgumentException the illegal argument exception
     * @throws IOException              the io exception
     */
    public EncryptedGenericFileStorage(final String filepath, final boolean autosave)
            throws IllegalArgumentException, IOException {
        super(filepath, autosave);
        this.crypter = new Crypter<V>();
    }

    /**
     * Instantiates a new Encrypted generic file storage.
     *
     * @param filepath the filepath
     * @throws IOException              the io exception
     * @throws IllegalArgumentException the illegal argument exception
     */
    public EncryptedGenericFileStorage(final String filepath) throws IOException, IllegalArgumentException {
        super(filepath);
    }

    /**
     * Gets all.
     *
     * @param password the password
     * @return the all
     * @throws DecryptionFailedException the decryption failed exception
     */
    public Map<K, V> getAll(String password) throws DecryptionFailedException {
        HashMap<K, V> ret = new HashMap<>();
        for (Map.Entry<K, CryptedObject> entry : super.getAll().entrySet()) {
            K k = entry.getKey();
            CryptedObject v = entry.getValue();
            ret.put(k, (V) this.crypter.decrypt(v, password));
        }
        return ret;
    }

    public void store(K key, CryptedObject o) throws IOException {
        super.store(key, o);
    }

    /**
     * Store.
     *
     * @param key      the key
     * @param o        the o
     * @param password the password
     * @throws IOException the io exception
     */
    public void store(K key, V o, String password) throws IOException {
        store(key, this.crypter.encrypt(o, password));
    }

    /**
     * Get v.
     *
     * @param <V>      the type parameter
     * @param key      the key
     * @param password the password
     * @return the v
     * @throws DecryptionFailedException the decryption failed exception
     */
    public <V> V get(K key, String password) throws DecryptionFailedException {
        return (V) this.crypter.decrypt(super.get(key), password);
    }
}

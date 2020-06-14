package com.adamclmns.diskpersistence.filestorage.crypto;

import com.adamclmns.diskpersistence.filestorage.IFileStorage;
import com.adamclmns.diskpersistence.filestorage.simple.GenericFileStorage;

import java.io.IOException;

public class EncryptedGenericFileStorage<K, V> extends GenericFileStorage<K, CryptedObject>
        implements IFileStorage<K, CryptedObject> {
    private Crypter crypter;

    public EncryptedGenericFileStorage(final String filepath, final boolean autosave)
            throws IllegalArgumentException, IOException {
        super(filepath, autosave);
        this.crypter = new Crypter<V>();
    }

    public EncryptedGenericFileStorage(final String filepath) throws IOException, IllegalArgumentException {
        super(filepath);
    }

    public void store(K key, CryptedObject o) throws IOException {
        super.store(key, o);
    }

    public void store(K key, V o, String password) throws IOException {
        store(key, this.crypter.encrypt(o, password));
    }

    public <V> V get(K key, String password) throws Crypter.DecryptionFailedException {
        return (V) this.crypter.decrypt(super.get(key), password);
    }
}

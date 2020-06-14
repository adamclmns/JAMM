package com.adamclmns.diskpersistence.filestorage;

import com.adamclmns.diskpersistence.filestorage.crypto.CryptedObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractFileStorage<K, V> implements IFileStorage<K, V> {
    private final File storageFile;
    private boolean autosave;
    private HashMap<K, V> storageMap;

    protected AbstractFileStorage(String filepath, boolean autosave) throws IOException {
        this(filepath);
        this.autosave = autosave;
    }

    protected AbstractFileStorage(String filepath) throws IOException {
        this.storageFile = new File(filepath);

        if (storageFile.isDirectory()) {
            throw new IllegalArgumentException("FileStorage file must not be a directory");
        }

        if (storageFile.length() == 0 || storageFile.createNewFile()) {
            storageMap = new HashMap<>();
            save();
        } else {
            load();
        }
    }

    @Override
    public V get(K key) {
        return storageMap.get(key);
    }

    @Override
    public List<V> getAllAsArrayList() {
        return new ArrayList<>(storageMap.values());
    }

    @Override
    public boolean hasObject(Object o) {
        return storageMap.containsValue(o);
    }

    @Override
    public int getSize() {
        return storageMap.size();
    }

    @Override
    public boolean hasKey(K key) {
        return storageMap.containsKey(key);
    }

    @Override
    public HashMap<K, V> getAll() {
        return storageMap;
    }

    @Override
    public void remove(K key) throws IOException {
        storageMap.remove(key);
        if (autosave) {
            save();
        }
    }

    @Override
    public void save() throws IOException {
        ObjectOutputStream oos =
                new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(storageFile)));
        oos.writeObject(storageMap);
        oos.flush();
        oos.close();
    }

    @SuppressWarnings("unchecked")
    void load() {
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new BufferedInputStream(new FileInputStream(storageFile)));
            storageMap = (HashMap<K, V>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeAll(Map<K, V> entries) throws IOException {
        storageMap.putAll(entries);
        if (autosave) {
            save();
        }
    }

    @Override
    public void store(K key, V o) throws IOException {
        storageMap.put(key, o);
        if (autosave) {
            save();
        }
    }

    @Override
    public String toString() {
        StringBuilder result =
                new StringBuilder("FileStorage @ " + storageFile.getAbsolutePath() + "\n");
        for (K cKey : storageMap.keySet()) {
            if (storageMap.get(cKey) instanceof CryptedObject) {
                result.append(cKey).append(" :: (Encrypted)\n");
            } else {
                result.append(cKey).append(" :: ").append(storageMap.get(cKey)).append("\n");
            }
        }
        return result.toString().trim();
    }
}

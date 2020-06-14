package com.adamclmns.diskpersistence.filestorage.simple;

import com.adamclmns.diskpersistence.filestorage.AbstractFileStorage;
import com.adamclmns.diskpersistence.filestorage.IFileStorage;

import java.io.IOException;

public class GenericFileStorage<K, V> extends AbstractFileStorage<K, V>
        implements IFileStorage<K, V> {


    public GenericFileStorage(String filepath, boolean autosave)
            throws IllegalArgumentException, IOException {
        super(filepath, autosave);
    }

    public GenericFileStorage(String filepath) throws IOException, IllegalArgumentException {
        super(filepath);
    }
}

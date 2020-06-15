package com.adamclmns.diskpersistence.filestorage.simple;

import com.adamclmns.diskpersistence.filestorage.AbstractFileStorage;
import com.adamclmns.diskpersistence.filestorage.IFileStorage;

import java.io.IOException;

/**
 * The type Generic file storage.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class GenericFileStorage<K, V> extends AbstractFileStorage<K, V>
        implements IFileStorage<K, V> {


    /**
     * Instantiates a new Generic file storage.
     *
     * @param filepath the filepath
     * @param autosave the autosave
     * @throws IllegalArgumentException the illegal argument exception
     * @throws IOException              the io exception
     */
    public GenericFileStorage(String filepath, boolean autosave)
            throws IllegalArgumentException, IOException {
        super(filepath, autosave);
    }

    /**
     * Instantiates a new Generic file storage.
     *
     * @param filepath the filepath
     * @throws IOException              the io exception
     * @throws IllegalArgumentException the illegal argument exception
     */
    public GenericFileStorage(String filepath) throws IOException, IllegalArgumentException {
        super(filepath);
    }
}

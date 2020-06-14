package com.adamclmns.diskpersistence.datastore;

import com.adamclmns.diskpersistence.exception.FileStorageException;
import com.adamclmns.diskpersistence.filestorage.IFileStorage;
import com.adamclmns.diskpersistence.filestorage.simple.GenericFileStorage;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked") // TODO: Figure out how to fix these for real.
public abstract class AbstractDataStore<K, V extends AbstractStoredObject<K>> {
    protected static final String HOME_DIR = System.getProperty("user.home");

    protected static final String UFU_HOME = ".ufu";
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(AbstractDataStore.class);

    protected final Path storeFilePath;

    private final IFileStorage<K, V> store;
    // todo: add support for Encrypted FileStorage here.
    protected AbstractDataStore() throws IOException {
        this.storeFilePath = getDataStoreFilePath();
        this.store = new GenericFileStorage<K, V>(storeFilePath.toString());
    }

    protected AbstractDataStore(boolean autosave) throws IOException {
        this.storeFilePath = getDataStoreFilePath();
        this.store = new GenericFileStorage<K, V>(storeFilePath.toString(), autosave);
    }

    public void save(V object) throws IOException {
        if (object == null) {
            log.warn("Nothing to save. Doing Nothing");
            return;
        }
        this.store.store(object.getId(), object);
    }

    public V findById(K id) {
        return this.store.get(id);
    }

    public List<V> getAll() {
        return new ArrayList<>(this.store.getAll().values());
    }

    protected Path getDataStoreFilePath() {
        Path thePath = Paths.get(HOME_DIR, UFU_HOME);
        if (!thePath.toFile().exists()) {
            thePath.toFile().mkdirs();
        }
        return Paths.get(HOME_DIR, UFU_HOME, getStoreName());
    }

    public void deleteById(K id) throws FileStorageException {
        try {
            this.store.remove(id);
        } catch (IOException e) {
            throw new FileStorageException("Could not complete the delete operation", e);
        }
    }

    protected abstract String getStoreName();

    protected Map<K, V> getStorageMap() {
        return this.store.getAll();
    }
}

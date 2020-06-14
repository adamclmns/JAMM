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

/**
 * The type Abstract data store.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
@SuppressWarnings("unchecked") // TODO: Figure out how to fix these for real.
public abstract class AbstractDataStore<K, V extends AbstractStoredObject<K>> {

    protected static final String HOME_DIR = System.getProperty("user.home");
    protected static final String UFU_HOME = ".ufu";
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(AbstractDataStore.class);

    protected final Path storeFilePath;

    private final IFileStorage<K, V> store;

    /**
     * Instantiates a new Abstract data store.
     *
     * @throws IOException the io exception
     */
// todo: add support for Encrypted FileStorage here.
    protected AbstractDataStore() throws IOException {
        this.storeFilePath = getDataStoreFilePath();
        this.store = new GenericFileStorage<K, V>(storeFilePath.toString());
    }

    /**
     * Instantiates a new Abstract data store.
     *
     * @param autosave the autosave
     * @throws IOException the io exception
     */
    protected AbstractDataStore(boolean autosave) throws IOException {
        this.storeFilePath = getDataStoreFilePath();
        this.store = new GenericFileStorage<K, V>(storeFilePath.toString(), autosave);
    }

    /**
     * Save.
     *
     * @param object the object
     * @throws IOException the io exception
     */
    public void save(V object) throws IOException {
        if (object == null) {
            log.warn("Nothing to save. Doing Nothing");
            return;
        }
        this.store.store(object.getId(), object);
    }

    /**
     * Find by id v.
     *
     * @param id the id
     * @return the v
     */
    public V findById(K id) {
        return this.store.get(id);
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<V> getAll() {
        return new ArrayList<>(this.store.getAll().values());
    }

    /**
     * Gets data store file path.
     *
     * @return the data store file path
     */
    protected Path getDataStoreFilePath() {
        Path thePath = Paths.get(HOME_DIR, UFU_HOME);
        if (!thePath.toFile().exists()) {
            thePath.toFile().mkdirs();
        }
        return Paths.get(HOME_DIR, UFU_HOME, getStoreName());
    }

    /**
     * Delete by id.
     *
     * @param id the id
     * @throws FileStorageException the file storage exception
     */
    public void deleteById(K id) throws FileStorageException {
        try {
            this.store.remove(id);
        } catch (IOException e) {
            throw new FileStorageException("Could not complete the delete operation", e);
        }
    }

    /**
     * Gets store name.
     *
     * @return the store name
     */
    protected abstract String getStoreName();

    /**
     * Gets storage map.
     *
     * @return the storage map
     */
    protected Map<K, V> getStorageMap() {
        return this.store.getAll();
    }
}

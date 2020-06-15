package com.adamclmns.diskpersistence.datastore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbstractDataStoreTest {
    RandomPojoStore store;
    private MyRandomStoredPojo value0 = new MyRandomStoredPojo("value0", 6, Arrays.asList("One", "Two", "Three"), Map.of(56, "A", 67, "B", 324, "C"));
    private MyRandomStoredPojo value1 = new MyRandomStoredPojo("value1", 3452, Arrays.asList("A", "B", "V"), Map.of(123, "Garlic", 2, "Pepper", 3, "Salt"));
    private MyRandomStoredPojo value2 = new MyRandomStoredPojo("value2", 34, Arrays.asList("Z", "Y", "Z"), Map.of(67, "A", 5, "B", 1, "C"));
    private MyRandomStoredPojo value3 = new MyRandomStoredPojo("value3", 7, Arrays.asList("Little Rock", "Conway", "Maumelle"), Map.of(1, "1", 2, "2", 3, "3"));

    @BeforeEach
    void setUp() throws IOException {
        this.store = new RandomPojoStore();
        store.save(value0);
        store.save(value1);
        store.save(value2);
    }

    /**
     * Tear down.
     *
     * @throws IOException the io exception
     */
    @AfterEach
    void tearDown() throws IOException {
        deleteTestFile();
    }

    private void deleteTestFile() {
        File file = null;
        try {
            file = store.getDataStoreFilePath().toFile();
            file.delete();
        } catch (Exception ignored) {
        }
    }

    @Test
    void save() throws IOException {
        store.save(value3);

    }

    @Test
    void findById() {
        MyRandomStoredPojo pojo1 = store.findById("value0");

        MyRandomStoredPojo pojo2 = store.findById("value2");
    }

    @Test
    void getAll() {
    }

    @Test
    void getDataStoreFilePath() {
        String path = store.getDataStoreFilePath().getFileName().toString();
        assertEquals("com.adamclmns.diskpersistence.datastore.AbstractDataStoreTest$RandomPojoStore", path);

    }

    @Test
    void deleteById() {
    }

    @Test
    void getStoreName() {

    }

    @Test
    void getStorageMap() {
    }

    private static class RandomPojoStore extends AbstractDataStore<String, MyRandomStoredPojo> {

        RandomPojoStore() throws IOException {
            super();
        }

        RandomPojoStore(boolean autosave) throws IOException {
            super(autosave);
        }

        @Override
        protected String getStoreName() {
            return RandomPojoStore.class.getName();
        }
    }
}

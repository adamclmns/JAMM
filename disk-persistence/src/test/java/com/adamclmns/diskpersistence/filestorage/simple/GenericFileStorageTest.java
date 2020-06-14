package com.adamclmns.diskpersistence.filestorage.simple;

import com.adamclmns.diskpersistence.filestorage.IFileStorage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GenericFileStorageTest {
    public static final String TEST_FILE_STORAGE = "testFileStorage";
    private IFileStorage<String, MyRandomPojo> fileStorage;
    private String key0 = "KEY_0";
    private String key1 = "KEY_1";
    private String key2 = "Key_2";
    private String key3 = "Key_3";

    private MyRandomPojo value0 = new MyRandomPojo("value0", 6, Arrays.asList("One", "Two", "Three"), Map.of(56, "A", 67, "B", 324, "C"));
    private MyRandomPojo value1 = new MyRandomPojo("value1", 3452, Arrays.asList("A", "B", "V"), Map.of(123, "Garlic", 2, "Pepper", 3, "Salt"));
    private MyRandomPojo value2 = new MyRandomPojo("value2", 34, Arrays.asList("Z", "Y", "Z"), Map.of(67, "A", 5, "B", 1, "C"));
    private MyRandomPojo value3 = new MyRandomPojo("value3", 7, Arrays.asList("Little Rock", "Conway", "Maumelle"), Map.of(1, "1", 2, "2", 3, "3"));

    @AfterEach
    void tearDown() throws IOException {
        deleteTestFile();
    }

    @BeforeEach
    void setUp() throws IOException {
        deleteTestFile();

        fileStorage = new GenericFileStorage<String, MyRandomPojo>(TEST_FILE_STORAGE, true);
        fileStorage.store(key0, value0);
        fileStorage.store(key1, value1);
        fileStorage.store(key2, value2);
    }

    private void deleteTestFile() {
        File file = null;
        try {
            file = new File(TEST_FILE_STORAGE);
            file.delete();
        } catch (Exception ignored) {
        }
    }

    @Test
    void get() {
        MyRandomPojo m = fileStorage.get(key2);
        assertEquals(m, value2);

    }

    @Test
    void getAllAsArrayList() {
        List<MyRandomPojo> mArr = fileStorage.getAllAsArrayList();
        assertEquals(3, mArr.size());
    }

    @Test
    void hasObject() {
        assertTrue(fileStorage.hasObject(value0));
    }

    @Test
    void getSize() {
        assertEquals(3, fileStorage.getSize());
    }

    @Test
    void hasKey() {
        assertTrue(fileStorage.hasKey(key2));
        assertFalse(fileStorage.hasKey("SOME JUNK"));
    }

    @Test
    void getAll() {
        Map<String, MyRandomPojo> mMap = fileStorage.getAll();
        assertTrue(mMap.containsKey(key0));
        assertTrue(mMap.containsKey(key1));
        assertTrue(mMap.containsKey(key2));
        assertTrue(mMap.containsValue(value0));
        assertTrue(mMap.containsValue(value1));
        assertTrue(mMap.containsValue(value2));
    }

    @Test
    void remove() {

    }

    @Test
    void storeAll() {

    }

    @Test
    void store() {

    }
}

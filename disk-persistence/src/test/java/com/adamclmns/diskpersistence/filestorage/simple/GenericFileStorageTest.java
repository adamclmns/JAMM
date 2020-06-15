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

/**
 * The type Generic file storage test.
 */
class GenericFileStorageTest {
    /**
     * The constant TEST_FILE_STORAGE.
     */
    public static final String TEST_FILE_STORAGE = "GenericFileStorageTest";
    private IFileStorage<String, MyRandomPojo> fileStorage;
    private String key0 = "KEY_0";
    private String key1 = "KEY_1";
    private String key2 = "Key_2";
    private String key3 = "Key_3";

    private MyRandomPojo value0 = new MyRandomPojo("value0", 6, Arrays.asList("One", "Two", "Three"), Map.of(56, "A", 67, "B", 324, "C"));
    private MyRandomPojo value1 = new MyRandomPojo("value1", 3452, Arrays.asList("A", "B", "V"), Map.of(123, "Garlic", 2, "Pepper", 3, "Salt"));
    private MyRandomPojo value2 = new MyRandomPojo("value2", 34, Arrays.asList("Z", "Y", "Z"), Map.of(67, "A", 5, "B", 1, "C"));
    private MyRandomPojo value3 = new MyRandomPojo("value3", 7, Arrays.asList("Little Rock", "Conway", "Maumelle"), Map.of(1, "1", 2, "2", 3, "3"));

    /**
     * Tear down.
     *
     * @throws IOException the io exception
     */
    @AfterEach
    void tearDown() throws IOException {
        deleteTestFile();
    }

    /**
     * Sets up.
     *
     * @throws IOException the io exception
     */
    @BeforeEach
    void setUp() throws IOException {
        deleteTestFile();

        fileStorage = new GenericFileStorage<String, MyRandomPojo>(TEST_FILE_STORAGE, false);
        fileStorage.store(key0, value0);
        fileStorage.store(key1, value1);
        fileStorage.store(key2, value2);
        fileStorage.save();
    }

    private void deleteTestFile() {
        File file = null;
        try {
            file = new File(TEST_FILE_STORAGE);
            file.delete();
        } catch (Exception ignored) {
        }
    }

    /**
     * Get.
     */
    @Test
    void get() {
        MyRandomPojo m = fileStorage.get(key2);
        assertEquals(m, value2);

    }

    /**
     * Load.
     */
    @Test
    void load() throws IOException {
        GenericFileStorage gfs = new GenericFileStorage<String, MyRandomPojo>(TEST_FILE_STORAGE, false);
        Map<String, MyRandomPojo> mMap = gfs.getAll();
        assertTrue(mMap.containsKey(key0));
        assertTrue(mMap.containsKey(key1));
        assertTrue(mMap.containsKey(key2));
        assertTrue(mMap.containsValue(value0));
        assertTrue(mMap.containsValue(value1));
        assertTrue(mMap.containsValue(value2));
    }

    /**
     * Gets all as array list.
     */
    @Test
    void getAllAsArrayList() {
        List<MyRandomPojo> mArr = fileStorage.getAllAsArrayList();
        assertEquals(3, mArr.size());
    }

    /**
     * Has object.
     */
    @Test
    void hasObject() {
        assertTrue(fileStorage.hasObject(value0));
    }

    /**
     * Gets size.
     */
    @Test
    void getSize() {
        assertEquals(3, fileStorage.getSize());
    }

    /**
     * Has key.
     */
    @Test
    void hasKey() {
        assertTrue(fileStorage.hasKey(key2));
        assertFalse(fileStorage.hasKey("SOME JUNK"));
    }

    /**
     * Gets all.
     */
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

    /**
     * Remove.
     *
     * @throws IOException the io exception
     */
    @Test
    void remove() throws IOException {
        fileStorage.remove(key0);
        Map<String, MyRandomPojo> mMap = fileStorage.getAll();
        assertFalse(mMap.containsKey(key0));
        assertTrue(mMap.containsKey(key1));
        assertTrue(mMap.containsKey(key2));
        assertFalse(mMap.containsValue(value0));
        assertTrue(mMap.containsValue(value1));
        assertTrue(mMap.containsValue(value2));
    }

    /**
     * Store all.
     *
     * @throws IOException the io exception
     */
    @Test
    void storeAll() throws IOException {
        fileStorage.remove(key0);
        fileStorage.remove(key1);
        fileStorage.remove(key2);
        Map<String, MyRandomPojo> mMap = fileStorage.getAll();
        assertFalse(mMap.containsKey(key0));
        assertFalse(mMap.containsKey(key1));
        assertFalse(mMap.containsKey(key2));
        assertFalse(mMap.containsValue(value0));
        assertFalse(mMap.containsValue(value1));
        assertFalse(mMap.containsValue(value2));
        fileStorage.storeAll(Map.of(key1, value1, key0, value0, key2, value2));
        mMap = fileStorage.getAll();
        assertTrue(mMap.containsKey(key0));
        assertTrue(mMap.containsKey(key1));
        assertTrue(mMap.containsKey(key2));
        assertTrue(mMap.containsValue(value0));
        assertTrue(mMap.containsValue(value1));
        assertTrue(mMap.containsValue(value2));
    }

    @Test
    public void toStringTest() {
        String actual = fileStorage.toString();
    }
}

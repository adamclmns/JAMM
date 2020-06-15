package com.adamclmns.diskpersistence.filestorage.crypto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Encrypted generic file storage test.
 */
public class EncryptedGenericFileStorageTest {

    /**
     * The constant TEST_FILE_STORAGE.
     */
    public static final String TEST_FILE_STORAGE = "EncryptedGenericFileStorageTest";
    private EncryptedGenericFileStorage<String, MyRandomCryptedPojo> fileStorage;
    private String key0 = "KEY_0";
    private String key1 = "KEY_1";
    private String key2 = "Key_2";
    private String key3 = "Key_3";

    private MyRandomCryptedPojo value0 = new MyRandomCryptedPojo("value0", 6, Arrays.asList("One", "Two", "Three"), Map.of(56, "A", 67, "B", 324, "C"));
    private MyRandomCryptedPojo value1 = new MyRandomCryptedPojo("value1", 3452, Arrays.asList("A", "B", "V"), Map.of(123, "Garlic", 2, "Pepper", 3, "Salt"));
    private MyRandomCryptedPojo value2 = new MyRandomCryptedPojo("value2", 34, Arrays.asList("Z", "Y", "Z"), Map.of(67, "A", 5, "B", 1, "C"));
    private MyRandomCryptedPojo value3 = new MyRandomCryptedPojo("value3", 7, Arrays.asList("Little Rock", "Conway", "Maumelle"), Map.of(1, "1", 2, "2", 3, "3"));

    /**
     * Tear down.
     *
     * @throws IOException the io exception
     */
    @AfterEach
    public void tearDown() throws IOException {
        deleteTestFile();
    }

    /**
     * Sets up.
     *
     * @throws IOException the io exception
     */
    @BeforeEach
    public void setUp() throws IOException {
        deleteTestFile();

        fileStorage = new EncryptedGenericFileStorage<String, MyRandomCryptedPojo>(TEST_FILE_STORAGE, true);
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

    /**
     * Get.
     */
    @Test
    public void get() {
        MyRandomCryptedPojo m = (MyRandomCryptedPojo) fileStorage.get(key2);
        assertEquals(m, value2);

    }

    /**
     * Gets all as array list.
     */
    @Test
    public void getAllAsArrayList() {
        List<CryptedObject> mArr = fileStorage.getAllAsArrayList();
        assertEquals(3, mArr.size());
    }

    /**
     * Has object.
     */
    @Test
    public void hasObject() {
        assertTrue(fileStorage.hasObject(value0));
    }

    /**
     * Gets size.
     */
    @Test
    public void getSize() {
        assertEquals(3, fileStorage.getSize());
    }

    /**
     * Has key.
     */
    @Test
    public void hasKey() {
        assertTrue(fileStorage.hasKey(key2));
        assertFalse(fileStorage.hasKey("SOME JUNK"));
    }

    /**
     * Gets all.
     */
    @Test
    public void getAll() {
        Map<String, CryptedObject> storage = fileStorage.getAll();

        List<Map.Entry<String, MyRandomCryptedPojo>> entries = storage.entrySet().stream().map(e ->
                Map.entry(e.getKey(), (MyRandomCryptedPojo) e.getValue())
        ).collect(Collectors.toList());

        Map<String, MyRandomCryptedPojo> mMap = new HashMap<>();
        entries.forEach(e -> mMap.put(e.getKey(), e.getValue()));
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
    public void remove() throws IOException {
        fileStorage.remove(key0);
        Map<String, CryptedObject> storage = fileStorage.getAll();

        List<Map.Entry<String, MyRandomCryptedPojo>> entries = storage.entrySet().stream().map(e ->
                Map.entry(e.getKey(), (MyRandomCryptedPojo) e.getValue())
        ).collect(Collectors.toList());

        Map<String, MyRandomCryptedPojo> mMap = new HashMap<>();
        entries.forEach(e -> mMap.put(e.getKey(), e.getValue()));


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
    public void storeAll() throws IOException {
        fileStorage.remove(key0);
        fileStorage.remove(key1);
        fileStorage.remove(key2);
        Map<String, CryptedObject> storage = fileStorage.getAll();

        List<Map.Entry<String, MyRandomCryptedPojo>> entries = storage.entrySet().stream().map(e ->
                Map.entry(e.getKey(), (MyRandomCryptedPojo) e.getValue())
        ).collect(Collectors.toList());

        Map<String, MyRandomCryptedPojo> mMap = new HashMap<>();
        entries.forEach(e -> mMap.put(e.getKey(), e.getValue()));
        assertFalse(mMap.containsKey(key0));
        assertFalse(mMap.containsKey(key1));
        assertFalse(mMap.containsKey(key2));
        assertFalse(mMap.containsValue(value0));
        assertFalse(mMap.containsValue(value1));
        assertFalse(mMap.containsValue(value2));
        fileStorage.storeAll(Map.of(key1, value1, key0, value0, key2, value2));
        storage = fileStorage.getAll();

        entries = storage.entrySet().stream().map(e ->
                Map.entry(e.getKey(), (MyRandomCryptedPojo) e.getValue())
        ).collect(Collectors.toList());


        Map<String, MyRandomCryptedPojo> finalMMap = mMap;
        entries.forEach(e -> finalMMap.put(e.getKey(), e.getValue()));
        assertTrue(finalMMap.containsKey(key0));
        assertTrue(finalMMap.containsKey(key1));
        assertTrue(finalMMap.containsKey(key2));
        assertTrue(finalMMap.containsValue(value0));
        assertTrue(finalMMap.containsValue(value1));
        assertTrue(finalMMap.containsValue(value2));
    }

    @Test
    public void toStringTest() {
        fileStorage.toString();
    }
}

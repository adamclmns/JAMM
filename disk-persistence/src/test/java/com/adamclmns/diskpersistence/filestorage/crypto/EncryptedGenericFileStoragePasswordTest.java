package com.adamclmns.diskpersistence.filestorage.crypto;

import com.adamclmns.diskpersistence.exception.DecryptionFailedException;
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
 * The type Encrypted generic file storage password test.
 */
class EncryptedGenericFileStoragePasswordTest {

    /**
     * The constant TEST_FILE_STORAGE.
     */
    public static final String TEST_FILE_STORAGE = "EncryptedGenericFileStoragePasswordTest";
    /**
     * The constant PASSWORD.
     */
    public static final String PASSWORD = "12345PASSWORD@#$!@#!";
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

        fileStorage = new EncryptedGenericFileStorage<String, MyRandomCryptedPojo>(TEST_FILE_STORAGE, true);
        fileStorage.store(key0, value0, PASSWORD);
        fileStorage.store(key1, value1, PASSWORD);
        fileStorage.store(key2, value2, PASSWORD);
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
     *
     * @throws DecryptionFailedException the decryption failed exception
     */
    @Test
    void get() throws DecryptionFailedException {
        MyRandomCryptedPojo m = (MyRandomCryptedPojo) fileStorage.get(key2, PASSWORD);
        assertEquals(m, value2);

    }

    /**
     * Gets all as array list.
     */
    @Test
    void getAllAsArrayList() {
        List<CryptedObject> mArr = fileStorage.getAllAsArrayList();
        assertEquals(3, mArr.size());
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
     *
     * @throws DecryptionFailedException the decryption failed exception
     */
    @Test
    void getAll() throws DecryptionFailedException {
        Map<String, MyRandomCryptedPojo> mMap = fileStorage.getAll(PASSWORD);


        assertTrue(mMap.containsKey(key1));
        assertTrue(mMap.containsKey(key2));
        assertTrue(mMap.containsValue(value0));
        assertTrue(mMap.containsValue(value1));
        assertTrue(mMap.containsValue(value2));
    }

    /**
     * Remove.
     *
     * @throws IOException               the io exception
     * @throws DecryptionFailedException the decryption failed exception
     */
    @Test
    void remove() throws IOException, DecryptionFailedException {
        fileStorage.remove(key0);
        Map<String, MyRandomCryptedPojo> mMap = fileStorage.getAll(PASSWORD);


        assertFalse(mMap.containsKey(key0));
        assertTrue(mMap.containsKey(key1));
        assertTrue(mMap.containsKey(key2));
        assertFalse(mMap.containsValue(value0));
        assertTrue(mMap.containsValue(value1));
        assertTrue(mMap.containsValue(value2));
    }


}

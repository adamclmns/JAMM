package com.adamclmns.diskpersistence.filestorage.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.Key;

public class Crypter<O> {

    private static final String ALGO = "AES";

    public CryptedObject encrypt(O o, String password) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = new ObjectOutputStream(bos);
            out.writeObject(o);
            return new CryptedObject(encrypt(bos.toByteArray(), password));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <O> O decrypt(CryptedObject co, String password) throws DecryptionFailedException {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(decrypt(co.getBytes(), password));
            ObjectInput in = new ObjectInputStream(bis);
            return (O) in.readObject();
        } catch (Exception e) {
            throw new DecryptionFailedException();
        }
    }

    public byte[] encrypt(byte[] data, String rawKey) throws Exception {
        Key key = generateKey(rawKey);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        return c.doFinal(data);
    }

    public byte[] decrypt(byte[] encryptedData, String rawKey) throws Exception {
        Key key = generateKey(rawKey);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        return c.doFinal(encryptedData);
    }

    private Key generateKey(String key) {
        String resultKey = key;
        while (resultKey.length() < 32) {
            resultKey += resultKey;
        }
        resultKey = resultKey.substring(0, 32);

        byte[] keyValue = resultKey.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(keyValue, ALGO);
    }

    public static class DecryptionFailedException extends Exception {

        private static final long serialVersionUID = 5911192741823907010L;

        @Override
        public String getMessage() {
            return "Decryption failed. Is the password correct?";
        }
    }
}

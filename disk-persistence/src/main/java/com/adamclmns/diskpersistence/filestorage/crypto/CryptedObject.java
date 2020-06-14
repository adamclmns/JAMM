package com.adamclmns.diskpersistence.filestorage.crypto;


public class CryptedObject {

    private static final long serialVersionUID = -5575861158027167628L;

    private final byte[] bytes;

    public CryptedObject(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }
}

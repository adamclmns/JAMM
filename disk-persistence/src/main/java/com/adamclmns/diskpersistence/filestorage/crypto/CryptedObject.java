package com.adamclmns.diskpersistence.filestorage.crypto;


import java.io.Serializable;

/**
 * The type Crypted object.
 */
public class CryptedObject implements Serializable {

    private static final long serialVersionUID = -5575861158027167628L;

    private final byte[] bytes;

    /**
     * Instantiates a new Crypted object.
     *
     * @param bytes the bytes
     */
    public CryptedObject(byte[] bytes) {
        this.bytes = bytes;
    }

    /**
     * Get bytes byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] getBytes() {
        return bytes;
    }
}

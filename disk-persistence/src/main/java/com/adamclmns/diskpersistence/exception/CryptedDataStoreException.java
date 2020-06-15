package com.adamclmns.diskpersistence.exception;

/**
 * The type Crypted data store exception.
 */
public class CryptedDataStoreException extends Exception {
    /**
     * Instantiates a new Crypted data store exception.
     *
     * @param msg the msg
     */
    public CryptedDataStoreException(String msg) {
        super(msg);
    }

    /**
     * Instantiates a new Crypted data store exception.
     *
     * @param msg       the msg
     * @param throwable the throwable
     */
    public CryptedDataStoreException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    /**
     * Instantiates a new Crypted data store exception.
     *
     * @param throwable the throwable
     */
    public CryptedDataStoreException(Throwable throwable) {
        super(throwable);
    }
}

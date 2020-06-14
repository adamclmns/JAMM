package com.adamclmns.diskpersistence.exception;

public class CryptedDataStoreException extends Exception{
    public CryptedDataStoreException(String msg) {
        super(msg);
    }

    public CryptedDataStoreException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public CryptedDataStoreException(Throwable throwable) {
        super(throwable);
    }
}

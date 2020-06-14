package com.adamclmns.diskpersistence.exception;

public class DataStoreException extends Exception {
    public DataStoreException(String msg) {
        super(msg);
    }

    public DataStoreException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public DataStoreException(Throwable throwable) {
        super(throwable);
    }
}

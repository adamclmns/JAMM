package com.adamclmns.diskpersistence.exception;

public class FileStorageException extends Exception {

    private static final long serialVersionUID = -6506423940201703664L;

    public FileStorageException(String msg) {
        super(msg);
    }

    public FileStorageException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public FileStorageException(Throwable throwable) {
        super(throwable);
    }
}

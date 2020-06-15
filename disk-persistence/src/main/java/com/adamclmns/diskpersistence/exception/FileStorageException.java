package com.adamclmns.diskpersistence.exception;

/**
 * The type File storage exception.
 */
public class FileStorageException extends Exception {

    private static final long serialVersionUID = -6506423940201703664L;

    /**
     * Instantiates a new File storage exception.
     *
     * @param msg the msg
     */
    public FileStorageException(String msg) {
        super(msg);
    }

    /**
     * Instantiates a new File storage exception.
     *
     * @param msg       the msg
     * @param throwable the throwable
     */
    public FileStorageException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    /**
     * Instantiates a new File storage exception.
     *
     * @param throwable the throwable
     */
    public FileStorageException(Throwable throwable) {
        super(throwable);
    }
}

package com.adamclmns.diskpersistence.exception;

/**
 * The type Data store exception.
 */
public class DataStoreException extends Exception {
    /**
     * Instantiates a new Data store exception.
     *
     * @param msg the msg
     */
    public DataStoreException(String msg) {
        super(msg);
    }

    /**
     * Instantiates a new Data store exception.
     *
     * @param msg       the msg
     * @param throwable the throwable
     */
    public DataStoreException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    /**
     * Instantiates a new Data store exception.
     *
     * @param throwable the throwable
     */
    public DataStoreException(Throwable throwable) {
        super(throwable);
    }
}

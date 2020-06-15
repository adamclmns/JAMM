package com.adamclmns.diskpersistence.exception;

/**
 * The type Decryption failed exception.
 */
public class DecryptionFailedException extends Exception {

    private static final long serialVersionUID = 5911192741823907010L;

    @Override
    public String getMessage() {
        return "Decryption failed. Is the password correct?";
    }
}

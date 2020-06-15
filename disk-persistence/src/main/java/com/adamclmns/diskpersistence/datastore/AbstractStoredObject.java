package com.adamclmns.diskpersistence.datastore;

import java.io.Serializable;


/**
 * The type Abstract stored object.
 *
 * @param <T> the type parameter
 */
public class AbstractStoredObject<T> implements Serializable {

    private static final long serialVersionUID = -2643288903435374162L;
    /**
     * The Id.
     */
    protected T id;

    /**
     * Instantiates a new Abstract stored object.
     *
     * @param id the id
     */
    public AbstractStoredObject(T id) {
        this.id = id;
    }

    /**
     * Instantiates a new Abstract stored object.
     */
    public AbstractStoredObject() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public T getId() {
        return this.id;
    }


    /**
     * The type Abstract stored object builder.
     *
     * @param <T> the type parameter
     */
    public abstract static class AbstractStoredObjectBuilder<T> {
        /**
         * The Id.
         */
        protected T id;

        /**
         * Instantiates a new Abstract stored object builder.
         */
        public AbstractStoredObjectBuilder() {
        }

        /**
         * Id abstract stored object builder.
         *
         * @param id the id
         * @return the abstract stored object builder
         */
        public AbstractStoredObjectBuilder<T> id(T id) {
            this.id = id;
            return this;
        }

        /**
         * Build abstract stored object.
         *
         * @return the abstract stored object
         */
        public abstract AbstractStoredObject<T> build();
    }
}

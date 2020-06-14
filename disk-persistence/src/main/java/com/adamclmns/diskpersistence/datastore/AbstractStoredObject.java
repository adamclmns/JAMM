package com.adamclmns.diskpersistence.datastore;

import java.io.Serializable;
import java.util.UUID;


public class AbstractStoredObject<T> implements Serializable {

    private static final long serialVersionUID = -2643288903435374162L;
    protected T id;

    public AbstractStoredObject(T id) {
        this.id = id;
    }

    public AbstractStoredObject() {
    }

    public T getId() {
        return this.id;
    }


    public abstract static class AbstractStoredObjectBuilder<B> {
        protected UUID id;
        protected String filePath;

        public AbstractStoredObjectBuilder() {
        }

        public AbstractStoredObjectBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public abstract B build();
    }
}

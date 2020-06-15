package com.adamclmns.jamm.impl.persistence;

import com.adamclmns.diskpersistence.datastore.AbstractDataStore;
import com.adamclmns.jamm.models.FileInfo;

import java.io.IOException;
import java.nio.file.Path;

public class FileInfoStore extends AbstractDataStore<Path, FileInfo> {

    protected FileInfoStore() throws IOException {
        super();
    }

    protected FileInfoStore(boolean autosave) throws IOException {
        super(autosave);
    }

    @Override
    protected String getStoreName() {
        return FileInfoStore.class.getCanonicalName();
    }
}

package com.adamclmns.jamm.impl.io;

import com.adamclmns.jamm.api.io.IMetadataService;
import com.adamclmns.jamm.api.io.IMusicInfoService;
import com.adamclmns.jamm.models.FileInfo;

import java.nio.file.Path;
import java.util.UUID;

public class MetadataService implements IMetadataService {
    @Override
    public FileInfo getFileSystemMetadata(Path path) {
        return null;
    }

    @Override
    public IMusicInfoService getMp3Metadata(Path path) {
        return null;
    }

    @Override
    public IMusicInfoService getMp3Metadata(Path path, UUID id) {
        return null;
    }

}

package com.adamclmns.jamm.api.io;

import com.adamclmns.jamm.models.FileInfo;

import java.nio.file.Path;
import java.util.UUID;

// TODO: Define as needed
public interface IMetadataService {
    // Every file will have these.
    public FileInfo getFileSystemMetadata(final Path path);
    // MP3 Metadata if it's an MP3 file
    public IMusicInfoService getMp3Metadata(final Path path);
    public IMusicInfoService getMp3Metadata(final Path path, final UUID id);



}

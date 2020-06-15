package com.adamclmns.jamm.api.io;


public interface IMetadataService {
    // Every file will have these.
    public IFileInfo getFileSystemMetadata();
    // MP3 Metadata if it's an MP3 file
    public IMusicInfo getMp3Metadata();
}

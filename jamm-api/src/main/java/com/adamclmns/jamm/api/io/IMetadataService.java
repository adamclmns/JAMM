package com.adamclmns.jamm.api.io;


/**
 * The interface Metadata service.
 */
public interface IMetadataService {
    /**
     * Gets file system metadata.
     *
     * @return the file system metadata
     */
// Every file will have these.
    public IFileInfo getFileSystemMetadata();

    /**
     * Gets mp 3 metadata.
     *
     * @return the mp 3 metadata
     */
// MP3 Metadata if it's an MP3 file
    public IMusicInfo getMp3Metadata();
}

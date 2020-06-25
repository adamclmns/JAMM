package com.adamclmns.jamm.api.scanning;

import java.nio.file.Path;
import java.util.Collection;

/**
 * The interface Directory scanner service.
 */
public interface IDirectoryScannerService {

    /**
     * Scan directory for files.
     *
     * @param directory the directory
     * @return collection collection
     */
    public Collection<Path> scanDirectory(Path directory);

    /**
     * Scan directory for files by extension extension.
     *
     * @param directory the directory
     * @param extension the extension
     * @return the collection
     */
    public Collection<Path> scanDirectoryForExtension(Path directory, String extension);

    /**
     * Verify directory contains all files, returns true or false.
     *
     * @param directory  the directory
     * @param knownPaths the known paths
     * @return the boolean
     */
    public boolean verifyDirectory(Path directory, Collection<Path> knownPaths);

    /**
     * Import directory recursively collection.
     *
     * @param directory the directory
     * @return the collection
     */
    public Collection<Path> importDirectoryRecursively(Path directory);

    /**
     * Import file path.
     *
     * @param file the file
     * @return the path
     */
    public Path importFile(Path file);

}

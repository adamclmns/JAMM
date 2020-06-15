package com.adamclmns.jamm.impl.io;

import com.adamclmns.jamm.api.scanning.IDirectoryScannerService;

import java.nio.file.Path;
import java.util.Collection;

public class DirectoryScannerService implements IDirectoryScannerService {

    @Override
    public Collection<Path> scanDirectory(Path directory) {
        return null;
    }

    @Override
    public Collection<Path> scanDirectoryForExtension(Path directory, String extension) {
        return null;
    }

    @Override
    public boolean verifyDirectory(Path directory, Collection<Path> knownPaths) {
        return false;
    }

    @Override
    public Collection<Path> importDirectoryRecursively(Path directory) {
        return null;
    }

    @Override
    public Path importFile(Path file) {
        return null;
    }
}

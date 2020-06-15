package com.adamclmns.jamm.impl.io;

import com.adamclmns.jamm.api.io.IDirectoryScannerService;

import java.nio.file.Path;
import java.util.Collection;
import java.util.UUID;

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
    public Collection<UUID> importDirectoryRecursively(Path directory) {
        return null;
    }

    @Override
    public UUID importFile(Path file) {
        return null;
    }
}

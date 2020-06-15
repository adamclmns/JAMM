package com.adamclmns.jamm.api.io;

import java.nio.file.Path;

/**
 * The interface File info.
 */
// TODO: Refactor this to it's own module ("data?" "models?")
public interface IFileInfo {

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName();

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType();

    /**
     * Gets path.
     *
     * @return the path
     */
    public Path getPath();

    /**
     * Gets music info.
     *
     * @return the music info
     */
    public IMusicInfo getMusicInfo();


}

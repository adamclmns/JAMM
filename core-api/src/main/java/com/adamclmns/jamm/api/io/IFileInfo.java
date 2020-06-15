package com.adamclmns.jamm.api.io;

import com.adamclmns.jamm.api.io.IMusicInfo;

import java.nio.file.Path;
// TODO: Refactor this to it's own module ("data?" "models?")
public interface IFileInfo  {

    public String getName();

    public String getType();

    public Path getPath();

    public IMusicInfo getMusicInfo();



}

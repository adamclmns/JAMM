package com.adamclmns.jamm.impl.io;

import com.adamclmns.jamm.api.io.EStarRating;
import com.adamclmns.jamm.api.io.IMusicInfo;
import com.adamclmns.jamm.api.players.IMusicPlayer;

import java.nio.file.Path;

/**
 * The type Music info.
 */
public class MusicInfo implements IMusicInfo {

    private final Object FileInfoStore = null; // TODO: ? Type?
    private final Path path;

    /**
     * Instantiates a new Music info.
     *
     * @param path the path
     */
    MusicInfo(final Path path) {
        this.path = path;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getArtist() {
        return null;
    }

    @Override
    public String getAlbum() {
        return null;
    }

    @Override
    public String getReleaseYear() {
        return null;
    }

    @Override
    public String getGenre() {
        return null;
    }

    @Override
    public byte[] getAlbumArtwork() {
        return new byte[0];
    }

    @Override
    public byte[] getNotes() {
        return new byte[0];
    }

    @Override
    public EStarRating getRating() {
        return null;
    }

    @Override
    public IMusicPlayer getPlayer() {
        return null;
    }


}

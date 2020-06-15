package com.adamclmns.jamm.impl.io;

import com.adamclmns.jamm.models.EStarRating;
import com.adamclmns.jamm.api.io.IMusicInfoService;
import com.adamclmns.jamm.api.players.IMusicPlayerService;

import java.nio.file.Path;

public class MusicInfoService implements IMusicInfoService {

    private final Object FileInfoStore = null; // TODO: ? Type?
    private final Path path;

    MusicInfoService(final Path path){
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
    public IMusicPlayerService getPlayer() {
        return null;
    }
}

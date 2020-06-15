package com.adamclmns.jamm.api.io;

import com.adamclmns.jamm.api.players.IMusicPlayerService;
import com.adamclmns.jamm.models.EStarRating;

public interface IMusicInfoService {
    public String getTitle();
    public String getArtist();
    public String getAlbum();
    public String getReleaseYear();
    public String getGenre();
    public byte[] getAlbumArtwork();
    public byte[] getNotes();
    public EStarRating getRating();

    public IMusicPlayerService getPlayer();
}

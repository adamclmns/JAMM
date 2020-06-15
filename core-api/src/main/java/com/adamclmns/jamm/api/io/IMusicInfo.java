package com.adamclmns.jamm.api.io;

import com.adamclmns.jamm.api.players.IMusicPlayer;

public interface IMusicInfo {
    public String getTitle();
    public String getArtist();
    public String getAlbum();
    public String getReleaseYear();
    public String getGenre();
    public byte[] getAlbumArtwork();
    public byte[] getNotes();
    public EStarRating getRating();

    public IMusicPlayer getPlayer();
}

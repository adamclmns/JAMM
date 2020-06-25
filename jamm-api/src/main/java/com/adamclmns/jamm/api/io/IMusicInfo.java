package com.adamclmns.jamm.api.io;

import com.adamclmns.jamm.api.players.IMusicPlayer;

/**
 * The interface Music info.
 */
public interface IMusicInfo {
    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle();

    /**
     * Gets artist.
     *
     * @return the artist
     */
    public String getArtist();

    /**
     * Gets album.
     *
     * @return the album
     */
    public String getAlbum();

    /**
     * Gets release year.
     *
     * @return the release year
     */
    public String getReleaseYear();

    /**
     * Gets genre.
     *
     * @return the genre
     */
    public String getGenre();

    /**
     * Get album artwork byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] getAlbumArtwork();

    /**
     * Get notes byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] getNotes();

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public EStarRating getRating();

    /**
     * Gets player.
     *
     * @return the player
     */
    public IMusicPlayer getPlayer();
}

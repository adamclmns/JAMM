package com.adamclmns.jamm.models;

public class MusicInfo {
    private final String artist;
    private final String title;
    private final String album;
    private final String albumArtist;
    private final int trackNo;
    private final int releaseYear;
    private final EStarRating userRating;

    MusicInfo(final String artist, final String title, final String album, final String albumArtist, final int trackNo, final int releaseYear, final EStarRating userRating){
        this.artist = artist;
        this.title = title;
        this.album = album;
        this.albumArtist = albumArtist;
        this.trackNo = trackNo;
        this.releaseYear = releaseYear;
        this.userRating = userRating;
    }

    public static MusicInfoBuilder builder(){
        return new MusicInfoBuilder();
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public int getTrackNo() {
        return trackNo;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public EStarRating getUserRating() {
        return userRating;
    }

    public static class MusicInfoBuilder{
        private String artist;
        private String title;
        private String album;
        private String albumArtist;
        private int trackNo;
        private int releaseYear;
        private EStarRating userRating;

        public MusicInfo build(){
            return new MusicInfo(artist,title,album,albumArtist,trackNo,releaseYear,userRating);
        }

        public MusicInfoBuilder withArtist(String artist){
            this.artist = artist;
            return this;
        }
        public MusicInfoBuilder withTitle(String title){
            this.title = title;
            return  this;
        }
        public MusicInfoBuilder withAlbum(String album){
            this.album = album;
            return this;
        }
        public MusicInfoBuilder withAlbumArtist(String albumArtist){
            this.albumArtist = albumArtist;
            return this;
        }
        public MusicInfoBuilder withTrackNo(int trackNo){
            this.trackNo = trackNo;
            return this;
        }
        public MusicInfoBuilder withReleaseYear(int releaseYear){
            this.releaseYear = releaseYear;
            return this;
        }
        public MusicInfoBuilder withUserRating(EStarRating rating){
            this.userRating = rating;
            return this;
        }
    }



}

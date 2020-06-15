package com.adamclmns.jamm.models;

import com.adamclmns.diskpersistence.datastore.AbstractStoredObject;

import java.nio.file.Path;

public class FileInfo extends AbstractStoredObject<Path> {
    private final String name;
    private final String type;
    private final Path path;
    private final MusicInfo musicInfo;

    FileInfo(final String name, final String type, final Path path, final MusicInfo musicInfo){
        this.name = name;
        this.type = type;
        this.path = path;
        this.musicInfo = musicInfo;
    }

    public static FileInfoBuilder builder(){
        return new FileInfoBuilder();
    }
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Path getPath() {
        return path;
    }

    public MusicInfo getMusicInfo() {
        return musicInfo;
    }

    public static class FileInfoBuilder extends AbstractStoredObjectBuilder<Path> {
        private String name;
        private String type;
        private Path path;
        private MusicInfo musicInfo;

        public FileInfoBuilder withName(final String name){
            this.name = name;
            return this;
        }

        public FileInfoBuilder withType(final String type){
            this.type = type;
            return this;
        }

        public FileInfoBuilder withPath(final Path path){
            this.path = path;
            return this;
        }

        public FileInfoBuilder withMusicInfo(final MusicInfo musicInfo){
            this.musicInfo = musicInfo;
            return this;
        }

        @Override
        public FileInfo build() {
            return new FileInfo(name,type,path,musicInfo);
        }
    }


}

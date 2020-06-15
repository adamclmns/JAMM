package com.adamclmns.jamm.api.players;

import com.adamclmns.jamm.api.io.IMusicInfo;

import java.util.Collection;

// TODO: Define as needed
public interface IMusicPlayer extends IMediaPlayerService {
    public void seekTo(long timestamp);
    public Long getCurrentTimeStamp();
    public Collection<IMusicInfo> getCurrentQueue();
    public Collection<IMusicInfo> getPastQueue();
    public void addToQueue(final IMusicInfo musicInfo);
    public void removeFromQueue(final IMusicInfo musicInfo);
    public IMusicInfo getCurrentTrack();


}

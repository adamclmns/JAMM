package com.adamclmns.jamm.api.players;

import com.adamclmns.jamm.api.io.IMusicInfo;

import java.util.Collection;

/**
 * The interface Music player.
 */
// TODO: Define as needed
public interface IMusicPlayer extends IMediaPlayerService {
    /**
     * Seek to.
     *
     * @param timestamp the timestamp
     */
    public void seekTo(long timestamp);

    /**
     * Gets current time stamp.
     *
     * @return the current time stamp
     */
    public Long getCurrentTimeStamp();

    /**
     * Gets current queue.
     *
     * @return the current queue
     */
    public Collection<IMusicInfo> getCurrentQueue();

    /**
     * Gets past queue.
     *
     * @return the past queue
     */
    public Collection<IMusicInfo> getPastQueue();

    /**
     * Add to queue.
     *
     * @param musicInfo the music info
     */
    public void addToQueue(final IMusicInfo musicInfo);

    /**
     * Remove from queue.
     *
     * @param musicInfo the music info
     */
    public void removeFromQueue(final IMusicInfo musicInfo);

    /**
     * Gets current track.
     *
     * @return the current track
     */
    public IMusicInfo getCurrentTrack();


}

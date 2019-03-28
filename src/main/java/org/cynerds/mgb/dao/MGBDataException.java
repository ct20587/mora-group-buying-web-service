package org.cynerds.mgb.dao;

import org.cynerds.mgb.model.Album;
import org.cynerds.mgb.model.Track;

public class MGBDataException extends RuntimeException {

    private Track track;

    private Album album;

    public MGBDataException(String message) {
        super(message);
    }

    public MGBDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public Track getTrack() {
        return track;
    }

    public MGBDataException setTrack(Track track) {
        this.track = track;
        return this;
    }

    public Album getAlbum() {
        return album;
    }

    public MGBDataException setAlbum(Album album) {
        this.album = album;
        return this;
    }
}

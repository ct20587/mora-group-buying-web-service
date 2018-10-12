package org.cynerds.mgb.dao;

import org.cynerds.mgb.model.Track;

public class MGBDataException extends RuntimeException {

    private Track track;

    public MGBDataException(Track track, String message, Throwable cause) {
        super(message, cause);
        this.track = track;
    }

    public Track getTrack() {
        return track;
    }
}

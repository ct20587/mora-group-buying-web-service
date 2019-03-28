package org.cynerds.mgb.dao;

import org.cynerds.mgb.model.Track;

public class MGBDuplicateTrackException extends MGBDataException {

    public MGBDuplicateTrackException(Track track, String message, Throwable cause) {
        super(message, cause);
        this.setTrack(track);
    }

}

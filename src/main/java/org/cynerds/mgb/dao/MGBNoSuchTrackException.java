package org.cynerds.mgb.dao;

import org.cynerds.mgb.model.Track;

public class MGBNoSuchTrackException extends MGBDataException {

    public MGBNoSuchTrackException(String message) {
        super(message);
    }

    public MGBNoSuchTrackException(Track track, String message) {
        super(message);
        this.setTrack(track);
    }
}

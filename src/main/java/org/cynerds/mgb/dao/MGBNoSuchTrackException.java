package org.cynerds.mgb.dao;

import org.cynerds.mgb.model.Track;

public class MGBNoSuchTrackException extends MGBDataException {
    public MGBNoSuchTrackException(Track track, String message) {
        super(message);
        this.setTrack(track);
    }
}

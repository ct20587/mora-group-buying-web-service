package org.cynerds.mgb.controller;

import org.cynerds.mgb.model.Track;

public class MGBErrorResponse {
    private String message;
    private Track track;

    public MGBErrorResponse(String message) {
        this.message = message;
    }

    public MGBErrorResponse(String message, Track track) {
        this.message = message;
        this.track = track;
    }

    public String getMessage() {
        return message;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}

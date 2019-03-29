package org.cynerds.mgb.controller;

import org.cynerds.mgb.model.Album;
import org.cynerds.mgb.model.Track;

public class MGBErrorResponse {
    private String message;
    private Track track;
    private Album album;

    public MGBErrorResponse(String message) {
        this.message = message;
    }

    public MGBErrorResponse(String message, Track track) {
        this.message = message;
        this.track = track;
    }

    public MGBErrorResponse(String message, Album album) {
        this.message = message;
        this.album = album;
    }

    public String getMessage() {
        return message;
    }

    public Track getTrack() {
        return track;
    }

    public Album getAlbum() {
        return album;
    }
}

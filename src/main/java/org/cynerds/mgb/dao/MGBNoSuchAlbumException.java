package org.cynerds.mgb.dao;

import org.cynerds.mgb.model.Album;

public class MGBNoSuchAlbumException extends MGBDataException {

    public MGBNoSuchAlbumException(String message) {
        super(message);
    }

    public MGBNoSuchAlbumException(Album album, String message) {
        super(message);
        this.setAlbum(album);
    }
}

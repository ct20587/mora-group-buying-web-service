package org.cynerds.mgb.model;

import java.util.List;

public class TrackCoBuyerMapping {
    private int trackId;
    private List<String> coBuyers;

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public List<String> getCoBuyers() {
        return coBuyers;
    }

    public void setCoBuyers(List<String> coBuyers) {
        this.coBuyers = coBuyers;
    }

    @Override
    public String toString() {
        return "TrackCoBuyerMapping{" +
                "trackId=" + trackId +
                ", coBuyers=" + coBuyers +
                '}';
    }
}

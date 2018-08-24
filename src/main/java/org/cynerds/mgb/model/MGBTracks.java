package org.cynerds.mgb.model;

import java.util.List;

public class MGBTracks {
    private List<Track> tracks;
    private List<Album> albums;
    private List<User> coBuyers;
    private int total;

    public List<Track> getTracks() {
        return tracks;
    }

    public MGBTracks setTracks(List<Track> tracks) {
        this.tracks = tracks;
        return this;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public MGBTracks setAlbums(List<Album> albums) {
        this.albums = albums;
        return this;
    }

    public List<User> getCoBuyers() {
        return coBuyers;
    }

    public MGBTracks setCoBuyers(List<User> coBuyers) {
        this.coBuyers = coBuyers;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public MGBTracks setTotal(int total) {
        this.total = total;
        return this;
    }

    @Override
    public String toString() {
        return "MGBTracks{" +
                "tracks=" + tracks +
                ", albums=" + albums +
                ", coBuyers=" + coBuyers +
                ", total=" + total +
                '}';
    }
}

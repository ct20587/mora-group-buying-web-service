package org.cynerds.mgb.model;

import java.util.List;

public class MGBTracks {
    private int id;
    private List<Track> tracks;
    private List<Album> albums;
    private List<User> coBuyers;
    private List<TrackCoBuyerMapping> mappings;
    private int totalFoundTracks;
    private int page;
    private int size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<TrackCoBuyerMapping> getMappings() {
        return mappings;
    }

    public void setMappings(List<TrackCoBuyerMapping> mappings) {
        this.mappings = mappings;
    }

    public int getTotalFoundTracks() {
        return totalFoundTracks;
    }

    public MGBTracks setTotalFoundTracks(int totalFoundTracks) {
        this.totalFoundTracks = totalFoundTracks;
        return this;
    }

    public int getPage() {
        return page;
    }

    public MGBTracks setPage(int page) {
        this.page = page;
        return this;
    }

    public int getSize() {
        return size;
    }

    public MGBTracks setSize(int size) {
        this.size = size;
        return this;
    }

    @Override
    public String toString() {
        return "MGBTracks{" +
                "id=" + id +
                ", tracks=" + tracks +
                ", albums=" + albums +
                ", coBuyers=" + coBuyers +
                ", mappings=" + mappings +
                ", totalFoundTracks=" + totalFoundTracks +
                ", page=" + page +
                ", size=" + size +
                '}';
    }
}

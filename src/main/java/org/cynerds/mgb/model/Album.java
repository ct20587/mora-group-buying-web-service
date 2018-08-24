package org.cynerds.mgb.model;

public class Album {
    private String albumId;
    private String albumName;
    private String artist;
    private String coverArt;
    private String url;
    private String creator;
    private String createDate;
    private String updater;
    private String updateDate;

    public String getAlbumId() {
        return albumId;
    }

    public Album setAlbumId(String albumId) {
        this.albumId = albumId;
        return this;
    }

    public String getAlbumName() {
        return albumName;
    }

    public Album setAlbumName(String albumName) {
        this.albumName = albumName;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public Album setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public String getCoverArt() {
        return coverArt;
    }

    public Album setCoverArt(String coverArt) {
        this.coverArt = coverArt;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Album setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public Album setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public String getCreateDate() {
        return createDate;
    }

    public Album setCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }

    public String getUpdater() {
        return updater;
    }

    public Album setUpdater(String updater) {
        this.updater = updater;
        return this;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public Album setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId='" + albumId + '\'' +
                ", albumName='" + albumName + '\'' +
                ", artist='" + artist + '\'' +
                ", coverArt='" + coverArt + '\'' +
                ", url='" + url + '\'' +
                ", creator='" + creator + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updater='" + updater + '\'' +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }
}

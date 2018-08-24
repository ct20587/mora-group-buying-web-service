package org.cynerds.mgb.model;

import java.util.List;
import java.util.Set;

public class Track {
    private int trackId;
    private String albumId;
    private int trackNo;
    private String trackName;
    private String artist;
    private int price;
    private List<String> coBuyers;
    private String purchaseDate;
    private String memo;
    private String creator;
    private String createDate;
    private String updater;
    private String updateDate;

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public int getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(int trackNo) {
        this.trackNo = trackNo;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getCoBuyers() {
        return coBuyers;
    }

    public void setCoBuyers(List<String> coBuyers) {
        this.coBuyers = coBuyers;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", albumId='" + albumId + '\'' +
                ", trackNo=" + trackNo +
                ", trackName='" + trackName + '\'' +
                ", artist='" + artist + '\'' +
                ", price=" + price +
                ", coBuyers=" + coBuyers +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", creator='" + creator + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updater='" + updater + '\'' +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }
}

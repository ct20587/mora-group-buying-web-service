package org.cynerds.mgb.model;

import java.util.List;
import java.util.stream.Collectors;

public class Track {
    private Integer trackId;
    private String albumId;
    private int trackNo;
    private String trackName;
    private String artist;
    private int price;
    private String purchaseDate;
    private String memo;
    private String creator;
    private String createDate;
    private String updater;
    private String updateDate;

    // Used when request to create track
    private List<String> coBuyers;

    public static void validate(Track track) {

        String trackName = track.getTrackName();

        if (trackName == null || trackName.isEmpty()) {
            throw new MGBTrackValidationException("trackName can't be empty");
        }

        if (track.getAlbumId() == null || track.getAlbumId().isEmpty()) {
            throw new MGBTrackValidationException(MGBTrackValidationException.Type.TRACK, "albumId", trackName);
        }

        if (track.getTrackNo() < 1) {
            throw new MGBTrackValidationException(MGBTrackValidationException.Type.TRACK, "trackNo", trackName);
        }

        if (track.getArtist() == null || track.getArtist().isEmpty()) {
            throw new MGBTrackValidationException(MGBTrackValidationException.Type.TRACK, "artist", trackName);
        }

        if (track.getPrice() < 1) {
            throw new MGBTrackValidationException(MGBTrackValidationException.Type.TRACK, "price", trackName);
        }

        if (track.getCoBuyers() == null || track.getCoBuyers().isEmpty()) {
            throw new MGBTrackValidationException(MGBTrackValidationException.Type.TRACK, "coBuyers", trackName);
        } else {
            List<String> emptyCoBuyers = track.getCoBuyers().stream()
                    .filter(coBuyer -> coBuyer == null || coBuyer.isEmpty())
                    .collect(Collectors.toList());
            if (!emptyCoBuyers.isEmpty()) {
                throw new MGBTrackValidationException("coBuyers value can't be empty or null");
            }
        }
    }

    public Integer getTrackId() {
        return trackId;
    }

    public Track setTrackId(Integer trackId) {
        this.trackId = trackId;
        return this;
    }

    public String getAlbumId() {
        return albumId;
    }

    public Track setAlbumId(String albumId) {
        this.albumId = albumId;
        return this;
    }

    public int getTrackNo() {
        return trackNo;
    }

    public Track setTrackNo(int trackNo) {
        this.trackNo = trackNo;
        return this;
    }

    public String getTrackName() {
        return trackName;
    }

    public Track setTrackName(String trackName) {
        this.trackName = trackName;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public Track setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Track setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public Track setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    public String getMemo() {
        return memo;
    }

    public Track setMemo(String memo) {
        this.memo = memo;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public Track setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public String getCreateDate() {
        return createDate;
    }

    public Track setCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }

    public String getUpdater() {
        return updater;
    }

    public Track setUpdater(String updater) {
        this.updater = updater;
        return this;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public Track setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public List<String> getCoBuyers() {
        return coBuyers;
    }

    public Track setCoBuyers(List<String> coBuyers) {
        this.coBuyers = coBuyers;
        return this;
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
                ", purchaseDate='" + purchaseDate + '\'' +
                ", memo='" + memo + '\'' +
                ", creator='" + creator + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updater='" + updater + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", coBuyers=" + coBuyers +
                '}';
    }
}

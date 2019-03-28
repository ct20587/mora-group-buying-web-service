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

    public void setTrackId(Integer trackId) {
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

    public List<String> getCoBuyers() {
        return coBuyers;
    }

    public void setCoBuyers(List<String> coBuyers) {
        this.coBuyers = coBuyers;
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

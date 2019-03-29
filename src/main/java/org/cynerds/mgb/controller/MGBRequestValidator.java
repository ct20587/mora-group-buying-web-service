package org.cynerds.mgb.controller;

import org.cynerds.mgb.model.Album;
import org.cynerds.mgb.model.MGBTrackValidationException;
import org.cynerds.mgb.model.MGBTracks;
import org.cynerds.mgb.model.Track;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class MGBRequestValidator {
    public static void validateMGBTracks(MGBTracks mgbTracks) {
        validateAlbums(mgbTracks.getAlbums());
        validateTracks(mgbTracks.getTracks());
        validateAlbumsAndTracksRelation(mgbTracks);
    }

    private static void validateAlbums(List<Album> albums) {
        if (albums == null || albums.size() < 1) {
            throw new MGBTrackValidationException("Must have at least one album info");
        }

        albums.forEach(Album::validate);

        List<String> duplicateAlbums = albums.stream()
                .collect(Collectors.groupingBy(Album::getAlbumId, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (!duplicateAlbums.isEmpty()) {
            throw new MGBTrackValidationException(
                    String.format("Albums %s have more than one entries in the input", duplicateAlbums.toString())
            );
        }
    }

    private static void validateTracks(List<Track> tracks) {
        if (tracks == null || tracks.size() < 1) {
            throw new MGBTrackValidationException("Must have at least one track info");
        }

        tracks.forEach(Track::validate);

        List<String> duplicateTracks = tracks.stream()
                .collect(Collectors.groupingBy(
                        track -> String.format("Album: %s / TrackNo: %s", track.getAlbumId(), track.getTrackNo()),
                        Collectors.counting()
                        )
                )
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (!duplicateTracks.isEmpty()) {
            throw new MGBTrackValidationException(
                    String.format("Tracks %s have more than one entries in the input", duplicateTracks.toString())
            );
        }
    }

    private static void validateAlbumsAndTracksRelation(MGBTracks mgbTracks) {
        List<Album> albums = mgbTracks.getAlbums();
        List<Track> tracks = mgbTracks.getTracks();

        // would not have duplicate ids in albums if albums were already validated .
        List<String> albumIds = albums.stream().map(Album::getAlbumId).collect(Collectors.toList());
        List<String> trackIds = tracks.stream().map(Track::getAlbumId).distinct().collect(Collectors.toList());

        // not sure would this comparison get speed up if the ids have been sorted first
        if ( !(albumIds.containsAll(trackIds) && trackIds.containsAll(albumIds)) ) {
            throw new MGBTrackValidationException("All tracks need to have corresponding album info and vice versa.");
        }
    }
}

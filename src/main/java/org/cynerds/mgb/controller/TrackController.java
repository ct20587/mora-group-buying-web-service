package org.cynerds.mgb.controller;

import org.cynerds.mgb.dao.TrackDao;
import org.cynerds.mgb.model.Album;
import org.cynerds.mgb.model.MGBTrackValidationException;
import org.cynerds.mgb.model.MGBTracks;
import org.cynerds.mgb.model.Track;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mgb")
public class TrackController {

    private static final Logger LOG = LoggerFactory.getLogger(TrackController.class);


    TrackDao trackDao;

    @Autowired
    public TrackController(TrackDao trackdao) {
        this.trackDao = trackdao;
    }

    @GetMapping("/tracks")
    public MGBTracks getTracks(
            @RequestHeader("FLASH") String passphrase,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "20") Integer size) {
        auth(passphrase);

        // TODO need to set maximum size limit later
        return trackDao.getTracks(page, size);

    }

    @PostMapping("/tracks")
    public ResponseEntity<MGBTracks> createTracks(
            @RequestHeader("FLASH") String passphrase,
            @RequestBody MGBTracks mgbTracks
    ) {
        auth(passphrase);

        // TODO verify the data is complete, e.g. missing album info
        validateMGBTracks(mgbTracks);

        // TODO Get creator id/name from cookie or session maybe
        trackDao.createTracksAndCoBuyerMappings(mgbTracks);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private void validateMGBTracks(MGBTracks mgbTracks) {
        validateAlbums(mgbTracks.getAlbums());
        validateTracks(mgbTracks.getTracks());
        validateAlbumsAndTracksRelation(mgbTracks);
    }

    private void validateAlbums(List<Album> albums) {
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

    private void validateTracks(List<Track> tracks) {
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

    private void validateAlbumsAndTracksRelation(MGBTracks mgbTracks) {
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

    @PatchMapping("/albums")
    public ResponseEntity<List<Album>> updateAlbums(
            @RequestHeader("FLASH") String passphrase,
            @RequestBody List<Album> albums
    ) {
        auth(passphrase);
        
        trackDao.updateAlbums(albums);
        return ResponseEntity.status(HttpStatus.OK).body(albums);
    }

    @PatchMapping("/tracks")
    public ResponseEntity<List<Track>> updateTracks(
            @RequestHeader("FLASH") String passphrase,
            @RequestBody List<Track> tracks
    ) {
        auth(passphrase);
        trackDao.updateTracks(tracks);
        return ResponseEntity.status(HttpStatus.OK).body(tracks);
    }

    @DeleteMapping("/albums")
    public ResponseEntity<String> deleteAlbums(
            @RequestHeader("FLASH") String passphrase,
            @RequestBody List<String> albumIds
    ) {
        auth(passphrase);
        trackDao.deleteAlbums(albumIds);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private void auth(String passphrase) {
        if (!Objects.equals("thunder", passphrase)) {
            throw new RuntimeException("Passphrase incorrect!");
        }
    }
}

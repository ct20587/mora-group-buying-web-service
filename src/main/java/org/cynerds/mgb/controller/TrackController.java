package org.cynerds.mgb.controller;

import org.cynerds.mgb.dao.TrackDao;
import org.cynerds.mgb.model.Album;
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
import java.util.Objects;

@RestController
@RequestMapping("/mgb")
public class TrackController {

    private static final Logger LOG = LoggerFactory.getLogger(TrackController.class);


    TrackDao trackDao;

    @Autowired
    public TrackController(TrackDao trackdao) {
        this.trackDao = trackdao;
    }

    private void auth(String passphrase) {
        if (!Objects.equals("thunder", passphrase)) {
            throw new RuntimeException("Passphrase incorrect!");
        }
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
        MGBRequestValidator.validateMGBTracks(mgbTracks);

        // TODO Get creator id/name from cookie or session maybe
        trackDao.createTracksAndCoBuyerMappings(mgbTracks);

        return ResponseEntity.status(HttpStatus.CREATED).build();
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

    @DeleteMapping("/tracks")
    public ResponseEntity<String> deleteTracks(
            @RequestHeader("FLASH") String passphrase,
            @RequestBody List<Integer> trackIds
    ) {
        auth(passphrase);
        trackDao.deleteTrackAndTrackCoBuyers(trackIds);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

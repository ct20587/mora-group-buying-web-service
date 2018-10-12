package org.cynerds.mgb.controller;

import org.cynerds.mgb.dao.TrackDao;
import org.cynerds.mgb.model.MGBTracks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mgb")
public class TrackController {

    private static final Logger LOG = LoggerFactory.getLogger(TrackController.class);

    @Autowired
    TrackDao trackDao;

    @GetMapping("/tracks")
    public MGBTracks getTracks(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "20") Integer size) {

        // TODO need to set maximum size limit later
        return trackDao.getTracks(page, size);

    }

    @PostMapping("/tracks")
    public ResponseEntity<MGBTracks> createTracks(@RequestBody MGBTracks mgbTracks) {

        // TODO verify the data is complete, e.g. missing album info
        // TODO Get creator id/name from cookie or session maybe

        trackDao.createTracksAndCoBuyerMappings(mgbTracks);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

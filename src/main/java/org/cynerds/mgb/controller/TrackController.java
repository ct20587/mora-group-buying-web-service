package org.cynerds.mgb.controller;

import org.cynerds.mgb.dao.TrackDao;
import org.cynerds.mgb.model.MGBTracks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}

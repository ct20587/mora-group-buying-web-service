package org.cynerds.mgb.controller;

import org.cynerds.mgb.model.Track;
import org.cynerds.mgb.mybatis.MGBMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mgb")
public class TrackController {

    private static final Logger LOG = LoggerFactory.getLogger(TrackController.class);

    @Autowired
    MGBMapper mgbMapper;

    @GetMapping("/tracks")
    public List<Track> getTracks() {
        return mgbMapper.queryTracks();
    }
}

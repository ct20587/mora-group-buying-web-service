package org.cynerds.mgb.dao;

import org.cynerds.mgb.model.MGBTracks;
import org.cynerds.mgb.model.Track;
import org.cynerds.mgb.mybatis.MGBMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrackDao {

    private static final Logger LOG = LoggerFactory.getLogger(TrackDao.class);

    private MGBMapper mgbMapper;

    @Autowired
    TrackDao(MGBMapper mgbMapper) {
        this.mgbMapper = mgbMapper;
    }

    public MGBTracks getTracks(Integer page, Integer size) {

        if (page == null) {
            page = 1;
        }

        if (size == null) {
            size = 20;
        }

        Integer offset = (page - 1) * size;

        MGBTracks result;

        result = mgbMapper.queryTracks(offset, size);

        List<String> albumIds =
                result.getTracks().stream()
                        .map(Track::getAlbumId)
                        .collect(Collectors.toList());

        result.setAlbums(mgbMapper.queryAlbums(albumIds));

        List<Integer> userIds =
                result.getTracks().stream()
                        .map(Track::getTrackId)
                        .collect(Collectors.toList());

        result.setMappings(mgbMapper.queryTrackCoBuyerMappings(userIds));

        return result.setPage(page).setSize(size);
    }
}

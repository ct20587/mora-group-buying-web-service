package org.cynerds.mgb.dao;

import org.cynerds.mgb.model.Album;
import org.cynerds.mgb.model.MGBTracks;
import org.cynerds.mgb.model.Track;
import org.cynerds.mgb.mybatis.MGBMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrackDao {

    private static final Logger LOG = LoggerFactory.getLogger(TrackDao.class);

    // datetime example  2019-03-28 16:59:46
    private static final String datetimeFormat = "yyyy-MM-dd kk:mm:ss";

    private MGBMapper mgbMapper;

    @Autowired
    TrackDao(MGBMapper mgbMapper) {
        this.mgbMapper = mgbMapper;
    }

    /* Response object will include an mysterious id property, it's due to mybatis' limit, the only way to get rid of it is removing
       it by our own hand... */
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

    @Transactional
    public void createTracksAndCoBuyerMappings(MGBTracks mgbTracks) {
        this.createAlbums(mgbTracks.getAlbums());
        this.createTracksAndCoBuyerMappings(mgbTracks.getTracks());
    }

    private void createAlbums(List<Album> albums) {
        try {
            for (Album album : albums) {
                mgbMapper.createAlbum(album);
            }
        } catch (DuplicateKeyException e) {
            LOG.info(e.getMessage());
            LOG.info("Any attempt to create an album that already exists will be ignored.");
            LOG.info("If it's intended to update album info, use PATCH album endpoint instead.");
        }
    }

    private void createTracksAndCoBuyerMappings(List<Track> tracks) {
        for (Track track : tracks) {

            try {
                mgbMapper.createTrack(track);
            } catch (DuplicateKeyException e) {
                String message = String.format(
                        "Track: [%s / %s] already exists.",
                        track.getAlbumId(), track.getTrackName()
                );

                LOG.warn(message);
                throw new MGBDuplicateTrackException(track, message, e);
            }

            mgbMapper.createTrackCoBuyerMappings(track);

        }
    }

    @Transactional
    public void updateAlbums(List<Album> albums) {
        for (Album album : albums) {
            if (mgbMapper.updateAlbum(album) != 1) {
                String message = String.format(
                        "No such album with ID: %s",
                        album.getAlbumId()
                );
                throw new MGBNoSuchAlbumException(album, message);
            };
        }
    }

    @Transactional
    public void updateTracks(List<Track> tracks) {
        for (Track track : tracks) {
            if (mgbMapper.updateTrack(track) != 1) {
                String message = String.format(
                        "No such track with ID: %s",
                        track.getTrackId()
                );
                throw new MGBNoSuchTrackException(track, message);
            };
        }
    }

    @Transactional
    public void deleteAlbums(List<String> albumIds) {
        for (String albumId : albumIds) {
            if (mgbMapper.deleteAlbum(albumId) != 1) {
                String message = String.format("No such album with ID: %s", albumId);
                throw new MGBNoSuchAlbumException(message);
            }
        }
    }

    @Transactional
    public void deleteTrackAndTrackCoBuyers(List<Integer> trackIds) {
        for (Integer trackId : trackIds) {
            if (mgbMapper.deleteTrackAndTrackCoBuyers(trackId) < 1) {
                String message = String.format("No such track with ID: %s", trackId);
                throw new MGBNoSuchTrackException(message);
            }
        }
    }
}

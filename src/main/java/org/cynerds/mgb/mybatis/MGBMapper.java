package org.cynerds.mgb.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.cynerds.mgb.model.Album;
import org.cynerds.mgb.model.MGBTracks;
import org.cynerds.mgb.model.Track;
import org.cynerds.mgb.model.TrackCoBuyerMapping;

import java.util.List;

@Mapper
public interface MGBMapper {

    MGBTracks queryTracks(@Param("offset") Integer offset, @Param("size") Integer size);

    List<Album> queryAlbums(@Param("albumIds") List<String> albumIds);

    List<TrackCoBuyerMapping> queryTrackCoBuyerMappings(@Param("userIds") List<Integer> userIds);

    int createAlbum(@Param("album") Album album);

    int createTrack(@Param("track") Track track);

    int createTrackCoBuyerMappings(@Param("track") Track track);

    int updateAlbum(@Param("album") Album album);

    int updateTrack(@Param("track") Track track);

    int deleteAlbum(@Param("albumId") String albumId);
}

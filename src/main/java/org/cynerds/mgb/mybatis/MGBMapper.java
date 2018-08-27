package org.cynerds.mgb.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.cynerds.mgb.model.Album;
import org.cynerds.mgb.model.MGBTracks;
import org.cynerds.mgb.model.TrackCoBuyerMapping;

import java.util.List;

@Mapper
public interface MGBMapper {
    MGBTracks queryTracks(@Param("offset") Integer offset, @Param("size") Integer size);
    List<Album> queryAlbums(@Param("albumIds") List<String> albumIds);
    List<TrackCoBuyerMapping> queryTrackCoBuyerMappings(@Param("userIds") List<Integer> userIds);
}

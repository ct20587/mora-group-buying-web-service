package org.cynerds.mgb.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.cynerds.mgb.model.Track;

import java.util.List;

@Mapper
public interface MGBMapper {
    List<Track> queryTracks();
}

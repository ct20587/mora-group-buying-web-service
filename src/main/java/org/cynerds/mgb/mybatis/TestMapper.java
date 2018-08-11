package org.cynerds.mgb.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.cynerds.mgb.model.Test;

@Mapper
public interface TestMapper {
    Test queryTestRecord(@Param("id") Integer id);
}

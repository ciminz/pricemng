package com.nngdjt.pricemng.mapper;

import com.nngdjt.pricemng.entity.StationInfo;
import com.nngdjt.pricemng.entity.StationInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StationInfoMapper {
    int countByExample(StationInfoExample example);

    int deleteByExample(StationInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StationInfo record);

    int insertSelective(StationInfo record);

    List<StationInfo> selectByExampleWithRowbounds(StationInfoExample example, RowBounds rowBounds);

    List<StationInfo> selectByExample(StationInfoExample example);

    StationInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StationInfo record, @Param("example") StationInfoExample example);

    int updateByExample(@Param("record") StationInfo record, @Param("example") StationInfoExample example);

    int updateByPrimaryKeySelective(StationInfo record);

    int updateByPrimaryKey(StationInfo record);
}
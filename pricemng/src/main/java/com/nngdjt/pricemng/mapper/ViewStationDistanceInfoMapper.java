package com.nngdjt.pricemng.mapper;

import com.nngdjt.pricemng.entity.ViewStationDistanceInfo;
import com.nngdjt.pricemng.entity.ViewStationDistanceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ViewStationDistanceInfoMapper {
    int countByExample(ViewStationDistanceInfoExample example);

    int deleteByExample(ViewStationDistanceInfoExample example);

    int insert(ViewStationDistanceInfo record);

    int insertSelective(ViewStationDistanceInfo record);

    List<ViewStationDistanceInfo> selectByExampleWithRowbounds(ViewStationDistanceInfoExample example, RowBounds rowBounds);

    List<ViewStationDistanceInfo> selectByExample(ViewStationDistanceInfoExample example);

    int updateByExampleSelective(@Param("record") ViewStationDistanceInfo record, @Param("example") ViewStationDistanceInfoExample example);

    int updateByExample(@Param("record") ViewStationDistanceInfo record, @Param("example") ViewStationDistanceInfoExample example);
}
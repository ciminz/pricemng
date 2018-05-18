package com.nngdjt.pricemng.mapper;

import com.nngdjt.pricemng.entity.DistanceInfo;
import com.nngdjt.pricemng.entity.DistanceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DistanceInfoMapper {
    int countByExample(DistanceInfoExample example);

    int deleteByExample(DistanceInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DistanceInfo record);

    int insertSelective(DistanceInfo record);

    List<DistanceInfo> selectByExampleWithRowbounds(DistanceInfoExample example, RowBounds rowBounds);

    List<DistanceInfo> selectByExample(DistanceInfoExample example);

    DistanceInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DistanceInfo record, @Param("example") DistanceInfoExample example);

    int updateByExample(@Param("record") DistanceInfo record, @Param("example") DistanceInfoExample example);

    int updateByPrimaryKeySelective(DistanceInfo record);

    int updateByPrimaryKey(DistanceInfo record);
}
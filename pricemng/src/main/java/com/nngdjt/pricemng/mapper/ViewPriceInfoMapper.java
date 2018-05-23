package com.nngdjt.pricemng.mapper;

import com.nngdjt.pricemng.entity.ViewPriceInfo;
import com.nngdjt.pricemng.entity.ViewPriceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ViewPriceInfoMapper {
    int countByExample(ViewPriceInfoExample example);

    int deleteByExample(ViewPriceInfoExample example);

    int insert(ViewPriceInfo record);

    int insertSelective(ViewPriceInfo record);

    List<ViewPriceInfo> selectByExampleWithRowbounds(ViewPriceInfoExample example, RowBounds rowBounds);

    List<ViewPriceInfo> selectByExample(ViewPriceInfoExample example);

    int updateByExampleSelective(@Param("record") ViewPriceInfo record, @Param("example") ViewPriceInfoExample example);

    int updateByExample(@Param("record") ViewPriceInfo record, @Param("example") ViewPriceInfoExample example);
}
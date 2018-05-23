package com.nngdjt.pricemng.mapper;

import com.nngdjt.pricemng.entity.PriceInfo;
import com.nngdjt.pricemng.entity.PriceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PriceInfoMapper {
    int countByExample(PriceInfoExample example);

    int deleteByExample(PriceInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PriceInfo record);

    int insertSelective(PriceInfo record);

    List<PriceInfo> selectByExampleWithRowbounds(PriceInfoExample example, RowBounds rowBounds);

    List<PriceInfo> selectByExample(PriceInfoExample example);

    PriceInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PriceInfo record, @Param("example") PriceInfoExample example);

    int updateByExample(@Param("record") PriceInfo record, @Param("example") PriceInfoExample example);

    int updateByPrimaryKeySelective(PriceInfo record);

    int updateByPrimaryKey(PriceInfo record);
}
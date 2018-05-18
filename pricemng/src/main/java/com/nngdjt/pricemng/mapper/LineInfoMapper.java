package com.nngdjt.pricemng.mapper;

import com.nngdjt.pricemng.entity.LineInfo;
import com.nngdjt.pricemng.entity.LineInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LineInfoMapper {
    int countByExample(LineInfoExample example);

    int deleteByExample(LineInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LineInfo record);

    int insertSelective(LineInfo record);

    List<LineInfo> selectByExampleWithRowbounds(LineInfoExample example, RowBounds rowBounds);

    List<LineInfo> selectByExample(LineInfoExample example);

    LineInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LineInfo record, @Param("example") LineInfoExample example);

    int updateByExample(@Param("record") LineInfo record, @Param("example") LineInfoExample example);

    int updateByPrimaryKeySelective(LineInfo record);

    int updateByPrimaryKey(LineInfo record);
}
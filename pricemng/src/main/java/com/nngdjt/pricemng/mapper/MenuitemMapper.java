package com.nngdjt.pricemng.mapper;

import com.nngdjt.pricemng.entity.Menuitem;
import com.nngdjt.pricemng.entity.MenuitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MenuitemMapper {
    int countByExample(MenuitemExample example);

    int deleteByExample(MenuitemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Menuitem record);

    int insertSelective(Menuitem record);

    List<Menuitem> selectByExampleWithRowbounds(MenuitemExample example, RowBounds rowBounds);

    List<Menuitem> selectByExample(MenuitemExample example);

    Menuitem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Menuitem record, @Param("example") MenuitemExample example);

    int updateByExample(@Param("record") Menuitem record, @Param("example") MenuitemExample example);

    int updateByPrimaryKeySelective(Menuitem record);

    int updateByPrimaryKey(Menuitem record);
}
package com.nngdjt.pricemng.mapper;

import com.nngdjt.pricemng.entity.MenuitemRoleExample;
import com.nngdjt.pricemng.entity.MenuitemRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MenuitemRoleMapper {
    int countByExample(MenuitemRoleExample example);

    int deleteByExample(MenuitemRoleExample example);

    int deleteByPrimaryKey(MenuitemRoleKey key);

    int insert(MenuitemRoleKey record);

    int insertSelective(MenuitemRoleKey record);

    List<MenuitemRoleKey> selectByExampleWithRowbounds(MenuitemRoleExample example, RowBounds rowBounds);

    List<MenuitemRoleKey> selectByExample(MenuitemRoleExample example);

    int updateByExampleSelective(@Param("record") MenuitemRoleKey record, @Param("example") MenuitemRoleExample example);

    int updateByExample(@Param("record") MenuitemRoleKey record, @Param("example") MenuitemRoleExample example);
}
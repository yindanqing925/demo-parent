package org.nh.shiro.dict.dao;

import org.apache.ibatis.annotations.Param;
import org.nh.shiro.dict.condition.ShiroDictListCond;
import org.nh.shiro.dict.domian.ShiroDict;

import java.util.List;

public interface ShiroDictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShiroDict record);

    int insertSelective(ShiroDict record);

    ShiroDict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShiroDict record);

    int updateByPrimaryKey(ShiroDict record);

    /**
     * 查询指定类型字典合集
     * @param dictListCond 字典类型
     */
    List<ShiroDict> selectDictList(ShiroDictListCond dictListCond);

}
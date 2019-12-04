package org.nh.shiro.dict.service;

import com.github.pagehelper.PageInfo;
import org.nh.shiro.dict.condition.ShiroDictListCond;
import org.nh.shiro.dict.domian.ShiroDict;

/**
 * @author yindanqing
 * @description 调拨字典服务
 * @date 2019/10/15 17:17
 */
public interface ShiroDictService {

    /**
     * 修改字典属性
     * @param shiroDict
     * @return
     */
    Integer modifyShiroDict(ShiroDict shiroDict);

    /**
     * 新增字典项
     * @param shiroDict
     * @return
     */
    Integer addShiroDict(ShiroDict shiroDict);

    /**
     * 分页查询字典列表
     * @param dictListCond
     * @return
     */
    PageInfo<ShiroDict> findDictList(ShiroDictListCond dictListCond);

    /**
     * 分页查询字典列表
     * @param id
     * @return
     */
    ShiroDict getDictById(Long id);
}

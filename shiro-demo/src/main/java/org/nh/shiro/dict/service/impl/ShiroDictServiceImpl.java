package org.nh.shiro.dict.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.nh.shiro.dict.condition.ShiroDictListCond;
import org.nh.shiro.dict.dao.ShiroDictMapper;
import org.nh.shiro.dict.domian.ShiroDict;
import org.nh.shiro.dict.service.ShiroDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yindanqing
 * @description 调拨字典服务
 * @date 2019/10/15 17:19
 */
@Service
public class ShiroDictServiceImpl implements ShiroDictService {

    @Autowired
    private ShiroDictMapper shiroDictMapper;

    @Override
    public Integer modifyShiroDict(ShiroDict shiroDict) {
        return shiroDictMapper.updateByPrimaryKeySelective(shiroDict);
    }

    @Override
    public Integer addShiroDict(ShiroDict shiroDict) {
        return shiroDictMapper.insertSelective(shiroDict);
    }

    @Override
    public PageInfo<ShiroDict> findDictList(ShiroDictListCond dictListCond) {
        PageHelper.startPage(dictListCond.getPageNum(), dictListCond.getPageSize());
        return new PageInfo<>(shiroDictMapper.selectDictList(dictListCond));
    }

    @Override
    public ShiroDict getDictById(Long id) {
        return shiroDictMapper.selectByPrimaryKey(id);
    }
}

package org.nh.mybatisplus.dict.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import org.nh.mybatisplus.dict.domain.TransferDict;
import org.nh.mybatisplus.dict.mapper.TransferDictMapper;
import org.nh.mybatisplus.dict.service.TransferDictService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author yindanqing
 * @since 2019-12-06
 */
@Service
public class TransferDictServiceImpl extends ServiceImpl<TransferDictMapper, TransferDict> implements TransferDictService {

    @Autowired
    private TransferDictMapper transferDictMapper;

    @Override
    public Page<TransferDict> findDictList(Page<TransferDict> page) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题
        //page.setOptimizeCountSql(true);
        // 不查询总记录数
        page.setSearchCount(false);
        // 注意！！ 分页 total 是经过插件自动 回写 到传入 page 对象
        //System.out.println(PageHelper.getTotal());
        //System.out.println(PageHelper.freeTotal());
        return page.setRecords(transferDictMapper.selectDictList(page));
    }

}

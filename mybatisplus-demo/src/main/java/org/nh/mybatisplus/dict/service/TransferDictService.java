package org.nh.mybatisplus.dict.service;

import com.baomidou.mybatisplus.plugins.Page;
import org.nh.mybatisplus.dict.domain.TransferDict;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author yindanqing
 * @since 2019-12-06
 */
public interface TransferDictService extends IService<TransferDict> {

    /**
     *
     * @param page
     * @return
     */
    Page<TransferDict> findDictList(Page<TransferDict> page);

}

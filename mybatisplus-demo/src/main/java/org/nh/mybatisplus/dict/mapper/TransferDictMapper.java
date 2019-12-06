package org.nh.mybatisplus.dict.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.nh.mybatisplus.dict.domain.TransferDict;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author yindanqing
 * @since 2019-12-06
 */
public interface TransferDictMapper extends BaseMapper<TransferDict> {

    List<TransferDict> selectDictList(Pagination page);

}

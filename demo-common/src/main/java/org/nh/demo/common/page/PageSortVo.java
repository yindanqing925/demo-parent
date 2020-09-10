package org.nh.demo.common.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @program: PageSortVo.java
 * @description: 页面-分页排序使用
 * @author: yindanqing
 * @create: 2019/11/28 16:27
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageSortVo {

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 页大小
     */
    private Integer pageSize;

    /**
     * 排序字段
     */
    private List<SortVo> sortList;

}
package org.nh.demo.common.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: SortVo.java
 * @description:
 * @author: yindanqing
 * @create: 2019/11/28 16:48
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SortVo {

    /**
     * 列名
     */
    private String columnName;

    /**
     * 顺序, 0:升序, 1:降序
     */
    private Integer lift;

    /**
     * 优先级
     */
    private Integer priority;

}

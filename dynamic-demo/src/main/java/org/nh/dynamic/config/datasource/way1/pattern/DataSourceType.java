package org.nh.dynamic.config.datasource.way1.pattern;

/**
 * @author yindanqing
 * @date 2019/11/16 21:40
 * @description 数据源类型
 */
public enum DataSourceType {
    /**
     * 主库
     */
    MASTER(1),

    /**
     * 从库1
     */
    SLAVE1(2);

    /**
     * 标记
     */
    private int mark;

    DataSourceType(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

}

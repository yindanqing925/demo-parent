package org.nh.dynamic.config.datasource.way1.pattern;

/**
 * @author yindanqing
 * @date 2019/11/16 22:05
 * @description 数据源选择模式
 */
public enum DataSourceMode {

    /**
     * 轮询数据源
     */
    POLL(1),
    /**
     * 指定数据源
     */
    ASSIGN(2);

    private int mark;

    DataSourceMode(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

}

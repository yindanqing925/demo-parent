package org.nh.boot.test.equals;

import java.util.Objects;

/**
 * @author yindanqing
 * @date 2019/5/28 21:59
 * @description
 */
public class Bean {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Bean bean = (Bean) o;
        return id == bean.getId() && Objects.equals(name, bean.getName());
    }

    public Bean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

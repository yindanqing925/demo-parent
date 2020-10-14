package org.nh.gome.demo.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: GetRow.java
 * @description: 119. 杨辉三角 II
 * @author: yindanqing
 * @create: 2020/10/14 14:00
 */
public class GetRow {

    public static void main(String[] args) {
        List<Integer> row = new GetRow().getRow2(5);
        System.out.println(row);
    }

    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        if (rowIndex == 0) {
            return new ArrayList<>();
        }
        if (rowIndex == 1) {
            return Collections.singletonList(1);
        }
        if (rowIndex == 2) {
            return Arrays.asList(1, 1);
        }
        List<Integer> former = Arrays.asList(1, 1);
        for (int i = 2; i <= rowIndex - 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < former.size(); j++) {
                list.add(former.get(j - 1) + former.get(j));
            }
            list.add(1);
            former = list;
        }
        return former;
    }

    public static List<Integer> getRow2(int rowIndex) {
        rowIndex++;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            if (i == 0) {
                list.add(1);
            } else {
                long num = (long)list.get(i - 1) * (long)(rowIndex - i) / i;
                list.add((int)num);
            }
        }
        return list;
    }

}

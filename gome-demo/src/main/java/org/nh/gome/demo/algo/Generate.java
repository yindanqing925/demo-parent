package org.nh.gome.demo.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: Generate.java
 * @description: 118. 杨辉三角
 * @author: yindanqing
 * @create: 2020/10/14 11:22
 */
public class Generate {

    public static void main(String[] args) {
        List<List<Integer>> generate = new Generate().generate2(5);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        if (numRows == 1) {
            res.add(Collections.singletonList(1));
            return res;
        }
        if (numRows == 2) {
            res.add(Collections.singletonList(1));
            res.add(Arrays.asList(1, 1));
            return res;
        }
        res.add(Collections.singletonList(1));
        res.add(Arrays.asList(1, 1));
        for (int i = 2; i <= numRows - 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> former = res.get(i - 1);
            for (int j = 0; j < (former.size() - 1); j++) {
                list.add(former.get(j) + former.get(j + 1));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }




    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);
            row.add(1);
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

}

package org.nh.gome.demo.algo;

import java.util.Arrays;

/**
 * @program: SearchRange.java
 * @description:
 * @author: yindanqing
 * @create: 2020/10/23 16:32
 */
public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length / 2;
        while (l < r){

        }
        return new int[]{l, r};
    }

}

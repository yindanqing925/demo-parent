package org.nh.gome.demo.algo;

import java.util.Arrays;

/**
 * @program: SearchRange.java
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * @author: yindanqing
 * @create: 2020/10/23 16:32
 */
public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {2,2};
        int target = 2;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (target > nums[nums.length - 1] || target < nums[0]) {
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = nums.length / 2;
        if (nums[r] <= target) {
            l = nums.length / 2;
            r = nums.length - 1;
        }
        while (l <= r) {
            if (l == r) {
                if (nums[r] == target) {
                    return getRes(nums, target, r);
                }
                if (nums[r] != target) {
                    return new int[]{-1, -1};
                }
            }
            int i = (l + r) / 2;
            if (nums[i] < target) {
                l = l == i ? i + 1 : i;
                continue;
            }
            if (nums[i] > target) {
                r = i;
                continue;
            }
            return getRes(nums, target, i);
        }
        return new int[]{-1, -1};
    }

    private static int[] getRes(int[] nums, int target, int i){
        int res_l = i;
        while (true) {
            res_l--;
            if (res_l < 0) {
                res_l = 0;
                break;
            }
            if (nums[res_l] == target) {
                continue;
            }
            res_l += 1;
            break;
        }
        int res_r = i;
        while (true) {
            res_r++;
            if (res_r > (nums.length - 1)) {
                res_r = nums.length - 1;
                break;
            }
            if (nums[res_r] == target) {
                continue;
            }
            res_r -= 1;
            break;
        }
        return new int[]{res_l, res_r};
    }

}

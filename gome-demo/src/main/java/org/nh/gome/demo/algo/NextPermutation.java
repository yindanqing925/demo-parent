package org.nh.gome.demo.algo;

import java.util.Arrays;

/**
 * @program: NextPermutation.java
 * @description: 31. 下一个排列
 * @author: yindanqing
 * @create: 2020/10/23 14:31
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {3,2,1,4,5};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     *
     * @param nums
     */

    public static void nextPermutation(int[] nums) {
        int start = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if(nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        start = i;
                        break;
                    }
                }
                break;
            }
        }
        for (int i = start; i < (start + nums.length) / 2; i++) {
            swap(nums, i, nums.length - i  + start - 1);
        }
    }

    public static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

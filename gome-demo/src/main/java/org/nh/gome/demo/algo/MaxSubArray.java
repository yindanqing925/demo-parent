package org.nh.gome.demo.algo;

/**
 * @program: MaxSubArray.java
 * @description: 53. 最大子序和
 * @author: yindanqing
 * @create: 2020/9/28 10:55
 */
public class MaxSubArray {

    public static void main(String[] args) {
        /**
         * [-2,1,-3,4,-1,2,1,-5,4]
         * 输出: 6
         */
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSubArray().maxSubArray2(nums));
    }

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum > res) {
                res = sum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum > res) {
                    res = sum;
                }
            }
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
                result = Math.max(result, sum);
            } else {
                sum += nums[i];
                result = Math.max(result, sum);
            }
            System.out.println("------------------------------" + i);
            System.out.println(result);
            System.out.println(sum);
        }
        return result;
    }

}

package org.nh.gome.demo.algo;

import java.util.Arrays;

/**
 * @program: ThreeSumClosest.java
 * @description: 16. 最接近的三数之和
 * @author: yindanqing
 * @create: 2020/9/25 15:01
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {-100,-98,-2,-1};
        int target = -101;
        /**
         * [-100,-98,-2,-1]
         * -101
         */
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        int offset = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int i = 0;
        int idx = nums.length - 1;
        LOOP : while (i < idx) {
            if(i > 0 && nums[i] == nums[i-1]){
                i++;
                continue;
            }
            int l = i+1;
            int r = idx;
            while(l < r) {
                int currentSum = nums[i] + nums[l] + nums[r];
                int tmpOffset = currentSum - target;
                if(Math.abs(tmpOffset) < Math.abs(offset)){
                    offset = currentSum - target;
                }
                if (tmpOffset == 0) {
                    break LOOP;
                }
                else if (tmpOffset < 0) l++;
                else if (tmpOffset > 0) r--;
            }
            i++;
        }
        return target + offset;
    }

}

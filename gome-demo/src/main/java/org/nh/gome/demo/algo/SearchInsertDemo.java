package org.nh.gome.demo.algo;

/**
 * 力扣35
 * @program: SearchInsertDemo.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/18 15:51
 */
public class SearchInsertDemo {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int val = 3;
        System.out.println(new SearchInsertDemo().searchInsert(nums, val));
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsert2(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // 特判
        if (nums[len - 1] < target) {
            return len;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            // 严格小于 target 的元素一定不是解
            if (nums[mid] < target) {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}

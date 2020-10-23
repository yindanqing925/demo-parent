package org.nh.gome.demo.algo;

/**
 * @program: Search.java
 * @description: 33. 搜索旋转排序数组
 * @author: yindanqing
 * @create: 2020/10/23 14:05
 */
public class Search {

    public static void main(String[] args) {
        int[] nums ={1};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if(nums[0] > target && nums[nums.length-1] < target){
            return -1;
        }
        if(nums[nums.length-1] >= target){
            for (int i = nums.length-1; i >= 0 ; i--) {
                if(nums[i] == target){
                    return i;
                }
            }
            return -1;
        }
        if(nums[0] <= target ){
            for (int i = 0 ; i <= nums.length-1; i++) {
                if(nums[i] == target){
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

}

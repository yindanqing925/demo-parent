package org.nh.xyy.demo.algo;

/**
 * RemoveDuplicates
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/6 17:34
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = 1;
        for (int i = 1; i < nums.length; i++){
            if(nums[i] == nums[length-1]){
                continue;
            }
            length++;
            nums[length-1] = nums[i];
        }
        return length;
    }
}

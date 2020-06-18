package org.nh.gome.demo.algo;

import com.alibaba.fastjson.JSON;

/**
 * 力扣27
 * @program: RemoveElementDemo.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/18 13:59
 */
public class RemoveElementDemo {

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(new RemoveElementDemo().removeElement3(nums, val));

    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                if(index == i){
                    index++;
                } else {
                    nums[index] = nums[i];
                    index++;
                }
            }
        }
        return index;
    }

    public int removeElement2(int[] nums, int val) {
        int ans = 0;
        for(int num: nums) {
            if(num != val) {
                nums[ans] = num;
                ans++;
            }
        }
        return ans;
    }

    public int removeElement3(int[] nums, int val) {
        int ans = nums.length;
        for (int i = 0; i < ans; ) {
            if (nums[i] == val) {
                nums[i] = nums[ans - 1];
                ans--;
            } else {
                i++;
            }
        }
        System.out.println(JSON.toJSONString(nums));
        return ans;
    }

}

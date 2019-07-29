package org.nh.xyy.demo.algo;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Sum
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/5 17:45
 */
public class Sum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum2(new int[]{2, 7, 11, 15}, 9)));
    }

}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i + 1; j < nums.length  ; j++) {
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        int index = 0;
        Map<Integer, Integer> collect = Stream.<int[]>of(nums)
                .flatMap(num -> Arrays.stream(num).boxed())
                .collect(Collectors.toMap(a -> a, a -> index, (a, b) -> b));

        /*Map<Integer, Integer> collect = Stream.<int[]>of(nums)
                .flatMap(num -> Arrays.stream(num).boxed())
                .collect(Collectors.toMap(a -> a, a -> index, (a, b) -> b));*/
        return null;
    }
}
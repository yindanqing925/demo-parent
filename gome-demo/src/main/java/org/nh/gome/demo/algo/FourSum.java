package org.nh.gome.demo.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: FourSum.java
 * @description: 18. 四数之和
 * @author: yindanqing
 * @create: 2020/9/27 15:43
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        int target = -11;
        /**
         * [1,-2,-5,-4,-3,3,3,5]
         * -11
         * [[-5,-4,-3,1]]
         */
        System.out.println(new FourSum().fourSum1(nums, target));
    }

    /**
     * 动态三指针
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4){
            return res;
        }
        if(nums.length == 4){
            int tmpSum = nums[0] + nums[1] + nums[2] + nums[3];
            if(tmpSum == target){
                res.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            }
            return res;
        }
        Arrays.sort(nums);
        int idx = nums.length - 1;
        for (int i = 0; i <= idx; i++) {
            if (nums[i] > target) {
                break;
            }
            int l = i + 1;
            int r = idx;
            while (l < r) {
                int tmpSum = nums[i] + nums[l] + nums[r];
                if (tmpSum > target) {
                    int t = l + 1;
                    if (nums[t] < 0) {
                        for (int j = t; j <= idx; j++) {
                            if (nums[t] > 0) {
                                break;
                            }
                            if ((tmpSum + nums[t]) == target) {
                                res.add(Arrays.asList(nums[i], nums[l], nums[t], nums[r]));
                                break;
                            }
                        }
                    }
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                } else if (tmpSum == target) {
                    int t = l + 1;
                    for (int j = t; j <= idx; j++) {
                        if (nums[t] == 0) {
                            res.add(Arrays.asList(nums[i], nums[l], nums[t], nums[r]));
                            break;
                        }
                    }
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (tmpSum < target) {
                    int t = idx-1;
                    if (nums[t] > 0) {
                        for (int j = t; j > i; j--) {
                            if (nums[t] < 0) {
                                break;
                            }
                            if ((tmpSum + nums[t]) == target) {
                                res.add(Arrays.asList(nums[i], nums[l], nums[t], nums[r]));
                                break;
                            }
                        }
                    }
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        if (nums.length == 4) {
            int tmpSum = nums[0] + nums[1] + nums[2] + nums[3];
            if (tmpSum == target) {
                res.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            }
            return res;
        }
        Arrays.sort(nums);
        int idx = nums.length - 1;
        for (int i = 0; i <= idx-1; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j <= idx-1; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = idx;
                while (l < r) {
                    int tmpSum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (tmpSum > target) {
                        while (l < r && nums[r] == nums[--r]);
                    } else if (tmpSum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[++l]);
                        while(l < r && nums[r] == nums[--r]);
                    } else if (tmpSum < target) {
                        while (l < r && nums[l] == nums[++l]);
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        int sum = 0;
        for (int a = 0; a < length - 2; a++) {
            if(a > 0 && nums[a] == nums[a - 1]) continue;
            for(int b = a + 1; b < length - 2; b++) {
                if(b > a + 1 && nums[b] == nums[b - 1]) continue;
                int i = b + 1,j = nums.length - 1;

                while (i < j) {
                    sum = nums[a] + nums[b] + nums[i] + nums[j];
                    if(target < sum) {
                        while (i < j && nums[j] == nums[--j]);
                    } else if(target > sum) {
                        while (i < j && nums[i] == nums[++i]);
                    } else {
                        lists.add(new ArrayList<>(Arrays.asList(nums[a],nums[b],nums[i],nums[j])));
                        while (i < j && nums[i] == nums[++i]);
                        while(i < j && nums[j] == nums[--j]);
                    }
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> fourSum3(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        if(len<4) return res;
        int pre = nums[0];
        for(int i=0;i<len-3;i++) {
            if(i>0 && nums[i] == pre) continue;
            pre = nums[i];

            //获取最小值和最大值，如果不在这两个数内，则无效
            int min1 = nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(target<min1) break;
            int max1 = nums[i]+nums[len-1]+nums[len-2]+nums[len-3];
            if(target>max1) continue;
            int pre2 = nums[i+1];
            for(int j=i+1;j<nums.length-2;j++) {
                if(j>i+1 && nums[j] == pre2) continue;
                pre2 = nums[j];

                int min2 = nums[i]+nums[j]+nums[j+1]+nums[j+2];
                if(target<min2) break;
                int max2 = nums[i]+nums[j]+nums[len-1]+nums[len-2];
                if(target>max2) continue;
                int sum = target - nums[i]-nums[j];
                int a = j+1,b = nums.length-1;
                while(a<b) {
                    int x = nums[a],y=nums[b];
                    if(x + y == sum) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(x);
                        list.add(y);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        res.add(list);
                        while(a<nums.length && nums[a] == x)a++;
                        while(b>j && nums[b] == y)b--;
                    }
                    else if(x+y<sum) a++;
                    else b--;
                }
            }
        }
        return res;
    }
}

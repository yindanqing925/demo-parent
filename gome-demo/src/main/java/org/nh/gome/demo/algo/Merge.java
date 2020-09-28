package org.nh.gome.demo.algo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: Merge.java
 * @description: 88. 合并两个有序数组
 * @author: yindanqing
 * @create: 2020/9/28 14:12
 */
public class Merge {

    public static void main(String[] args) {
        /**
         * [1,2,4,5,6,0]
         * 5
         * [3]
         * 1
         */
        int[] nums1 = {1,2,4,5,6,0}, nums2 = {3};
        int m = 5, n = 1;
        new Merge().merge(nums1, m, nums2, n);
        System.out.println(JSON.toJSONString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while (i < nums1.length && j < n) {
            if (nums1[i] <= nums2[j]) {
                if (i > (m + j - 1)) {
                    break;
                }
                i++;
                continue;
            }
            if (nums1[i] > nums2[j]) {
                for (int k = m - 1 + j; k >= i; k--) {
                    nums1[k + 1] = nums1[k];
                }
                nums1[i] = nums2[j];
                i++;
                j++;
            }
        }
        if (j < n) {
            while (j < n && i < nums1.length) {
                nums1[i] = nums2[j];
                i++;
                j++;
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0) {
            // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }

}

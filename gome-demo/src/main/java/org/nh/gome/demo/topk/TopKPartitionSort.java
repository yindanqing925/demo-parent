package org.nh.gome.demo.topk;

import java.util.Arrays;

/**
 * @program: TopKPartitionSort.java
 * @description:
 * @author: yindanqing
 * @create: 2020/12/7 19:00
 */
public class TopKPartitionSort {

    public static void main(String[] args) {

        int[] num = { 2, 20, 3, 7, 9, 1, 17, 18, 0, 4 };
        partitionSort(num, 0, num.length - 1, 3);
        System.out.println(Arrays.toString(num));
    }

    public static void partitionSort(int[] nums, int low, int high, int K) {
        if (low < high) {
            int pointKey = partitionSortCore(nums, low, high);
            if (K - 1 == pointKey)//TopK问题的核心，就是如果返回的下标为K-1，说明已经排序好了K个最大/最小的数，但是之间的顺序是不确定的
                return;
            partitionSort(nums, low, pointKey - 1, K);
            partitionSort(nums, pointKey + 1, high, K);
        }
    }

    /**
     * 快排的核心
     *
     * @param nums
     * @param low
     * @param high
     * @return 返回排序好以后的位置
     */
    public static int partitionSortCore(int[] nums, int low, int high) {
        // 以第一个座位标志位来比对
        int pivotkey = nums[low];
        while (low < high) {
            // 从pivotkey往最后一个位置比较
            while (low < high && pivotkey <= nums[high]) {
                --high;
            }
            // 开始交换pivotkey和nums[high]
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            // 此时nums[high]对应于pivotkey
            while (low < high && pivotkey >= nums[low]) {
                ++low;
            }
            // 找到比pivotkey大的书了，那就交换
            temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            // 这时，pivotkey对应于nums[low]
        }
        return low;// 返回pivotkey对应的正确位置
    }

}

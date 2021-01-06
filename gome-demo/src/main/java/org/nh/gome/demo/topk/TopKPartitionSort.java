package org.nh.gome.demo.topk;

import java.util.Arrays;

/**
 * @program: TopKPartitionSort.java
 * @description: 快排
 * @author: yindanqing
 * @create: 2020/12/7 19:00
 */
public class TopKPartitionSort {

    public static void main(String[] args) {

        int[] num = { 2, 20, 3, 7, 9, 1, 17, 18, 0, 4 };
        int[] kMinsByHeap = getKMinsByHeap(num, 3);
        System.out.println(Arrays.toString(kMinsByHeap));
    }

    /**
     * 维护一个有k个数的最大堆，代表目前选出的最小的k个数
     *
     * @param read 实际场景中，read提供的数据需要从文件中读取，这里为了方便用数组表示
     * @param k
     * @return
     */
    public static int[] getKMinsByHeap(int[] read, int k) {
        if (k < 1 || k > read.length) {
            return read;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++) {   // 初始时一次性从文件中读取k个数据
            kHeap[i] = read[i];
        }
        buildHeap(kHeap, k);            // 建堆，时间复杂度O(k)
        for (int i = k; i < read.length; i++) { // 从文件中一个一个的读取剩余数据
            if (read[i] < kHeap[0]) {
                kHeap[0] = read[i];
                heapify(kHeap, 0, k);   // 从堆顶开始向下进行调整，时间复杂度O(logk)
            }
        }
        return kHeap;
    }

    /**
     * 建堆函数
     *
     * @param arr
     * @param n
     */
    public static void buildHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    /**
     * 从arr[i]向下进行堆调整
     *
     * @param arr
     * @param i
     * @param heapSize
     */
    public static void heapify(int[] arr, int i, int heapSize) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int max = i;
        if (leftChild < heapSize && arr[leftChild] > arr[max]) {
            max = leftChild;
        }
        if (rightChild < heapSize && arr[rightChild] > arr[max]) {
            max = rightChild;
        }
        if (max != i) {
            swap(arr, i, max);
            heapify(arr, max, heapSize);  // 堆结构发生了变化，继续向下进行堆调整
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

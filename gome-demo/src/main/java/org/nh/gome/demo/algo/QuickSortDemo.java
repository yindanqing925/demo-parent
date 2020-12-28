package org.nh.gome.demo.algo;

import com.alibaba.fastjson.JSON;

/**
 * @program: QuickSortDemo.java
 * @description:
 * @author: yindanqing
 * @create: 2020/12/28 11:17
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        /*int[] num = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        quickSort2(num, 0, num.length - 1);
        System.out.println(JSON.toJSONString(num));*/
        String a = "1";
        int b = 1;
        System.out.println(a.equals(b));
    }

    private static void quickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if (left >= right) {
            return;
        }
        //设置最左边的元素为基准值
        int key = num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，直到遇到比key小的值
            while (num[j] >= key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (num[i] <= key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
        num[left] = num[i];
        num[i] = key;
        quickSort(num, left, i - 1);
        quickSort(num, i + 1, right);
    }

    private static void quickSort2(int[] num, int left, int right) {
        if(left >= right){
            return;
        }
        int index = num[left];
        int i = left;
        int j = right;
        while (i<j){
            while (num[j] >= index && i<j){
                j--;
            }
            while (num[i] <= index && i<j){
                i++;
            }
            if(i<j){
                int t = num[i];
                num[i] = num[j];
                num[j] = t;
            }
        }
        num[left] = num[i];
        num[i] = index;
        quickSort2(num, left, i -1);
        quickSort2(num, i +1, right);
    }

}

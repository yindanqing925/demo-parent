package org.nh.gome.demo.algo;

/**
 * @program: MaxProfit2.java
 * @description: 122. 买卖股票的最佳时机 II
 * @author: yindanqing
 * @create: 2020/10/15 10:30
 */
public class MaxProfit2 {

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        System.out.println(maxProfit2(a));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if(tmp>0){
                maxProfit +=tmp;
            }
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }
}

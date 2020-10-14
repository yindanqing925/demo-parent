package org.nh.gome.demo.algo;

/**
 * @program: MaxProfit.java
 * @description: 121. 买卖股票的最佳时机
 * @author: yindanqing
 * @create: 2020/10/14 14:12
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] k = {7,1,5,3,6,4};
        System.out.println(new MaxProfit().maxProfit2(k));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }
        return profit;
    }

    /**
     * 整体思路, 当前的最小值, 当前的差值和最大差值取最大
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int res = 0;
        // 表示在当前位置之前的最小值，假设修正法（打擂台法）
        int minVal = prices[0];
        // 注意：这里从 1 开始
        for (int i = 1; i < len; i++) {
            res = Math.max(res, prices[i] - minVal);
            minVal = Math.min(minVal, prices[i]);
        }
        return res;
    }


    /**
     * 动态规划 完全看不懂!!!
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：用户手上不持股所能获得的最大利润，特指卖出股票以后的不持股，非指没有进行过任何交易的不持股
        // 1：用户手上持股所能获得的最大利润

        // 注意：因为题目限制只能交易一次，因此状态只可能从 1 到 0，不可能从 0 到 1
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

}

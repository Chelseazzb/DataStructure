//给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
//设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

public class Solution {
    //0 <= k <= 100
    //0 <= prices.length <= 1000
    //0 <= prices[i] <= 1000
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2*k+1];

        //初始化：定义2k+1个状态
        //dp[0]: 没有操作; dp[1]: 第k次买入; dp[2]: 第k次卖出
        //dp[2k+1] = -prices[2k+1]
        for (int i = 1; i < k * 2; i+=2) {
            dp[0][i] = -prices[0];
        }
        //dp[2k] = 0

        for (int i = 1; i < prices.length; i++) {

            for (int j = 1; j <= 2 * k; j++) {
                if ((j & 1) == 1){ //奇数
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] - prices[i]);
                } else { //偶数
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1] + prices[i]);
                }
            }
        }

        return dp[prices.length-1][2*k];
    }

    //空间优化
    public int maxProfit1(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[2*k+1];

        //初始化：定义2k+1个状态
        //dp[0]: 没有操作; dp[1]: 第k次买入; dp[2]: 第k次卖出
        //dp[2k+1] = -prices[2k+1]
        for (int i = 1; i < k * 2; i+=2) {
            dp[i] = -prices[0];
        }
        //dp[2k] = 0

        for (int i = 1; i < prices.length; i++) {

            for (int j = 1; j <= 2 * k; j++) {
                if ((j & 1) == 1){ //奇数
                    dp[j] = Math.max(dp[j], dp[j-1] - prices[i]);
                } else { //偶数
                    dp[j] = Math.max(dp[j],dp[j-1] + prices[i]);
                }
            }
        }

        return dp[2*k];
    }

}

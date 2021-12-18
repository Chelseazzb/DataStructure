//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

public class Solution {

    //1 <= prices.length <= 105
    //0 <= prices[i] <= 105
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];

        /*
         * 定义 5 种状态:
         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
         */

        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0; //还没买入，只能为0
        dp[0][3] = -prices[0];
        dp[0][4] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3] + prices[i]);
        }

        return dp[prices.length-1][4];
    }

    //空间优化
    public int maxProfit1(int[] prices) {
        int[] dp = new int[5];

        /*
         * 定义 5 种状态:
         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
         */

        //初始化
        dp[0] = 0;
        dp[1] = -prices[0];
        dp[2] = 0; //还没买入，只能为0
        dp[3] = -prices[0];
        dp[4] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[1] = Math.max(dp[1],-prices[i]);
            dp[2] = Math.max(dp[2],dp[1] + prices[i]);
            dp[3] = Math.max(dp[3],dp[2] - prices[i]);
            dp[4] = Math.max(dp[4],dp[3] + prices[i]);
        }

        return dp[4];
    }
}

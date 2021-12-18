public class Solution2 {
    //动态规划
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0]; //代表第i天持有股票
        dp[0][1] = 0; //代表第i天不持有股票

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
        }

        return dp[prices.length-1][1];
    }

    //空间优化
    public int maxProfit1(int[] prices) {
        int[] dp = new int[2];
        dp[0] = -prices[0]; //代表第i天持有股票
        dp[1] = 0; //代表第i天不持有股票

        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0],dp[1] - prices[i]);
            dp[1] = Math.max(dp[1],dp[0] + prices[i]);
        }

        return dp[1];
    }
}

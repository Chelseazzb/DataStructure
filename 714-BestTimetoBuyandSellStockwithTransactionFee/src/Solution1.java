public class Solution1 {

    //动态规划
    //1 <= prices.length <= 5 * 10^4
    //1 <= prices[i] < 5 * 10^4
    //0 <= fee < 5 * 10^4
    public int maxProfit(int[] prices, int fee) {
        //判断边界条件
        if (prices.length == 1)
            return 0;

        //可以无限次地完成交易，所以有两种状态：1：持有；2：卖出
        int[][] dp = new int[prices.length][2];
        //初始化
        dp[0][0] = -(prices[0] + fee);
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] - prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
        }

        return dp[prices.length-1][1];
    }

    //空间优化
    public int maxProfit1(int[] prices, int fee) {
        //判断边界条件
        if (prices.length == 1)
            return 0;

        //可以无限次地完成交易，所以有两种状态：1：持有；2：卖出
        int[] dp = new int[2];
        //初始化
        dp[0] = -(prices[0] + fee); //买入时就交手续费
        dp[1] = 0;

        for (int i = 1; i < prices.length; i++) {
            int tmp0 = dp[0]; //因为会变化，所以提前记录
            dp[0] = Math.max(dp[0],dp[1] - prices[i]-fee);
            dp[1] = Math.max(dp[1],tmp0 + prices[i]);
        }

        return dp[1];
    }

}

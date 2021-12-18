//给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
//你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

public class Solution {

    //1 <= prices.length <= 105
    //0 <= prices[i] <= 104
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        //初始化
        dp[0][0] = -prices[0]; //dp[i][0]代表第i天持有股票
        dp[0][1] = 0; //dp[i][1]代表第i天不持有股票
        //两重循环
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]); //之前买入或者当天买入
            dp[i][1] = Math.max(dp[i-1][1],prices[i] + dp[i - 1][0]);
        }

        return dp[prices.length-1][1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }
}

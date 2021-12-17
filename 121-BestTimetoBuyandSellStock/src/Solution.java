//给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
//你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

public class Solution {

    //1 <= prices.length <= 105
    //0 <= prices[i] <= 104
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        //初始化全为0即可
        //两重循环
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                if (i > j && prices[i] > prices[j])
                    dp[i] = Math.max(dp[i-1], prices[i] - prices[j]);
            }
        }

        return dp[prices.length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{7,1,5,3,6,4};
        solution.maxProfit(prices);
    }
}

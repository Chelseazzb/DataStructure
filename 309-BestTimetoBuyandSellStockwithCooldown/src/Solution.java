//给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
//
//设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

public class Solution {

    //具体可以区分出如下四个状态：
    //
    //状态一：买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）
    //**卖出股票状态，这里就有两种卖出股票状态
    //状态二：两天前就卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态
    //状态三：今天卖出了股票
    //状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！

    //j的状态为：
    //0：状态一
    //1：状态二
    //2：状态三
    //3：状态四

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0; //边界条件
        int[][] dp = new int[prices.length][4];

        //初始化
        dp[0][0] = -prices[0]; //代表持有股票
        dp[0][1] = 0; //代表两天前就卖出了股票
        dp[0][2] = 0; //代表今天卖出了股票
        dp[0][3] = 0; //代表冷冻期

        for (int i = 1; i < prices.length; i++) {
            //前一天可以是早就卖出或者冷冻期
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1],dp[i-1][3]) - prices[i]);
            //可以是再早之前就已经卖出或者前一天是冷冻期
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i]; //只可能是之前持有股票
            dp[i][3] = dp[i-1][2]; //只可能前一天买入了股票
        }

        //卖出的情况和冷冻期都可能是最大值
        return Math.max(dp[prices.length-1][3],Math.max(dp[prices.length-1][1],dp[prices.length-1][2]));
    }

    //空间优化
    public int maxProfit1(int[] prices) {
        if (prices.length == 0)
            return 0; //边界条件
        int[] dp = new int[4];

        //初始化
        dp[0] = -prices[0]; //代表持有股票
        dp[1] = 0; //代表两天前就卖出了股票
        dp[2] = 0; //代表今天卖出了股票
        dp[3] = 0; //代表冷冻期

        for (int i = 1; i < prices.length; i++) {
            int tmp0 = dp[0];
            int tmp2 = dp[2]; //0和2会改变，所以提前暂存
            //前一天可以是早就卖出或者冷冻期
            dp[0] = Math.max(dp[0], Math.max(dp[1],dp[3]) - prices[i]);
            //可以是再早之前就已经卖出或者前一天是冷冻期
            dp[1] = Math.max(dp[1], dp[3]);
            dp[2] = tmp0 + prices[i]; //只可能是之前持有股票
            dp[3] = tmp2; //只可能前一天买入了股票
        }

        //卖出的情况和冷冻期都可能是最大值
        return Math.max(dp[3],Math.max(dp[1],dp[2]));
    }
}

public class Solution2 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][2]; //因为只和前一个状态有关所以，可以优化空间
        //初始化
        dp[0][0] = -prices[0]; //dp[i][0]代表第i天持有股票
        dp[0][1] = 0; //dp[i][1]代表第i天不持有股票
        //两重循环
        for (int i = 1; i < prices.length; i++) {
            dp[0][0] = Math.max(dp[0][0],-prices[i]); //之前买入或者当天买入
            dp[1][1] = Math.max(dp[1][1],prices[i] + dp[0][0]);
        }

        return dp[1][1];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }
}

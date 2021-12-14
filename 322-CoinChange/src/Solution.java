//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
//你可以认为每种硬币的数量是无限的。

public class Solution {

    //1 <= coins.length <= 12
    //1 <= coins[i] <= 231 - 1
    //0 <= amount <= 104

    //自己的版本，只能通过部分用例
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        //初始化
        for (int i = 0; i < coins.length && coins[i] <= amount; i++) {
            dp[coins[i]] = 1;
        }

        //本题求钱币最小个数，那么钱币有顺序和没有顺序都可以，都不影响钱币的最小个数。
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    if (dp[i] == 0) {
                        if (dp[i - coins[j]] != 0) //存在这个数字才可以加1
                            dp[i] = dp[i - coins[j]] + 1;
                    } else
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);

                }
            }

            //打印dp数组
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[j] + "  ");
            }
            System.out.println();
        }

        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] coins = new int[]{1};
        solution.coinChange(coins, 0);
        System.out.println(solution.coinChange(coins, 0));
    }
}

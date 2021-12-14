//给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
//
//请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
//
//假设每一种面额的硬币有无限个。
//
//题目数据保证结果符合 32 位带符号整数。

public class Solution {

    //1 <= coins.length <= 300
    //1 <= coins[i] <= 5000
    //coins 中的所有值 互不相同
    //0 <= amount <= 5000

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        //首先dp[0]一定要为1，dp[0] = 1是 递归公式的基础。
        dp[0] = 1;

        //如果求组合数就是外层for循环遍历物品，内层for遍历背包。
        //如果求排列数就是外层for遍历背包，内层for循环遍历物品。
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) { //完全背包可以多次选择，所以正序遍历
                dp[j] += dp[j - coins[i]]; //递推公式
            }
        }

        return dp[amount];
    }
}

public class Solution1 {

    //1 <= coins.length <= 12
    //1 <= coins[i] <= 231 - 1
    //0 <= amount <= 104
    //代码随想录版本，其中我有几点考虑的有问题
    public int coinChange(int[] coins, int amount) {
        //定义dp数组
        int[] dp = new int[amount+1];

        //初始化
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE; // 因为求最小的组合，这样才会覆盖
        }

        dp[0] = 0; //从0开始累加才可以，凑足总金额为0所需钱币的个数一定是0
        //因为本题考不考虑顺序都不影响最小的组合，所以排列和组合都可以，正序遍历，先遍历物品或先遍历背包都可以
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j-coins[i]] != Integer.MAX_VALUE){ //能组合出来才可以比较哪种小
                    dp[j] = Math.min(dp[j],dp[j-coins[i]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

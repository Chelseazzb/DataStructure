public class Solution1 {

    //使用背包实现
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        int[] weight = new int[]{1,2};
        dp[0] = 1; //初始化，否则递推公式只能为0

        //求排列问题，先遍历背包容量
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < weight.length; j++) { //只有两个物品1和2
                if (i >= weight[j])
                    dp[i] += dp[i - weight[j]]; //递推公式
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(2));
    }
}

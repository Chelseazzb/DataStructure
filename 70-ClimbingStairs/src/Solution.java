//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//注意：给定 n 是一个正整数。

public class Solution {

    public int climbStairs(int n) {

        //判断边界条件
        if (n == 1 || n == 2)
            return n;

        int[] dp = new int[3]; //不用讨论dp[0]的初始化
        dp[1] = 1; //代表爬1层有一种方法
        dp[2] = 2; //代表爬2层有两种方法

        for (int i = 2; i < n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }

        return dp[2];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(10));
    }


}

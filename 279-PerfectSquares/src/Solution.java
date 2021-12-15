//给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
//完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

import java.util.LinkedList;
import java.util.List;

public class Solution {

    //1 <= n <= 10^4
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i*i);
        }

        Integer[] nums = new Integer[list.size()];
        list.toArray(nums); //得到全是平方和的数组

        //初始化
        dp[0] = 0;
        //求完全平方数的最少数量，对顺序无所谓
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= n ; j++) {
                if (dp[j-nums[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j],dp[j-nums[i]] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        new Solution().numSquares(5);
    }
}

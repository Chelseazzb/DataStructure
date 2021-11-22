/**
 * @ClassName : Solution2
 * @Author : Zhai Zhibin
 * @Date : 2021/11/19 10:12
 * @Description : 动态规划
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution2 {

    //滑动窗口
    public int fib(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    //不需要额外空间存储weight数组
    //1 <= n <= 10^4
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        //初始化
        dp[0] = 0;
        //求完全平方数的最少数量，对顺序无所谓
        for (int i = 1; i * i <= n; i++) { //每个平方数就是数组的value和weight
            for (int j = i * i; j <= n ; j++) {
                if (dp[j-i*i] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j],dp[j - i * i] + 1);
            }
        }

        return dp[n];
    }
}

public class Solution1 {

    //优化，只需要两个参数
    public int fib(int n) {

        //判断边界条件
        if (n == 0 || n == 1)
            return n;

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }

        return dp[1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().fib(10));
    }

}

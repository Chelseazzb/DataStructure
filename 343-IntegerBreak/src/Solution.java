import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
public class Solution {

    //你可以假设 n 不小于 2 且不大于 58。
    public int integerBreak(int n) {
        //定义dp数组，下标就是n，代表n拆分的最大乘积
        int[] dp = new int[n+1];
        dp[2] = 1; //拆分为1 * 1，dp[0]和dp[1]没有意义

        //遍历
        //递推公式：dp[i] = Math.max(dp[i],Math.max(j * (i-j),j * dp[i-j]))
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) { //要比i小2起码
                //j*(i-j)代表把i拆分为j和i-j两个数相乘
                //j*dp[i-j]代表把i拆分成j和继续把(i-j)这个数拆分，取(i-j)拆分结果中的最大乘积与j相乘
                dp[i] = Math.max(dp[i],Math.max(j * (i-j),j * dp[i-j]));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(8));
    }
}

//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//
//请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
//
//如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

public class Solution {

    //1 <= strs.length <= 600
    //1 <= strs[i].length <= 100
    //strs[i]仅由'0' 和'1' 组成
    //1 <= m, n <= 100

    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < strs.length; i++) {
            int zero = 0;
            int one = 0;
            //找到每个字符的0和1数量
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0')
                    zero ++;
                else
                    one ++;
            }

            //倒叙遍历
            for (int k = m; k >= zero; k--) {
                for (int l = n; l >= one ; l--) {
                    dp[k][l] = Math.max(dp[k][l],dp[k-zero][l-one] + 1);
                }
            }

            }


        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};

        new Solution().findMaxForm(strs,5,3);
    }
}

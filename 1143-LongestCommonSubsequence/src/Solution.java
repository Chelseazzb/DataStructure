//给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在公共子序列 ，返回 0 。
//
//一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
//两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。

public class Solution {

    //1 <= text1.length, text2.length <= 1000
    //text1 和 text2 仅由小写英文字符组成
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]表示text1从0到i-1和text2从0到j-1的最长公共子序列
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    //如果text1[i - 1] 与 text2[j - 1]不相同，
                    // 那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的。
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
                //dp[i][j]有三个方向可以推导出来，都是从左向右，从上到下
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
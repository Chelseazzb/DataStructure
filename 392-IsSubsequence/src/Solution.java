//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//
//字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
// （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

public class Solution {

    //0 <= s.length <= 100
    //0 <= t.length <= 10^4
    //两个字符串都只由小写字符组成。
    public boolean isSubsequence(String s, String t) {
        //判断边界条件
        if (t.length() == 0 && s.length() == 0)
            return true;
        if (t.length() == 0)
            return false;
        if (s.length() == 0)
            return true;

        //dp[i][j]代表了i-1和j-1的最大子序长度
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length() ; i++) {
            for (int j = 1; j <= t.length() ; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = dp[i][j-1];
            }
        }

        return dp[s.length()][t.length()] == s.length();
    }
}

//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
//字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
// （例如，"ACE"是"ABCDE"的一个子序列，而"AEC"不是）
//题目数据保证答案符合 32 位带符号整数范围。

public class Solution {

    //0 <= s.length, t.length <= 1000
    //s 和 t 由英文字母组成
    public int numDistinct(String s, String t) {


        int[][] dp = new int[s.length() + 1][t.length() + 1];

        //初始化
        //从递推公式dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; 和 dp[i][j] = dp[i - 1][j]; 中可以看出dp[i][0] 和dp[0][j]是一定要初始化的。
        //dp[i][0] 表示：以i-1为结尾的s可以随便删除元素，出现空字符串的个数。
        //dp[0][j]：空字符串s可以随便删除元素，出现以j-1为结尾的字符串t的个数。
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }


        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (t.charAt(j-1) == s.charAt(i-1)){
                    //例如： s：bagg 和 t：bag ，s[3] 和 t[2]是相同的，但是字符串s也可以不用s[3]来匹配，即用s[0]s[1]s[2]组成的bag。
                    //当然也可以用s[3]来匹配，即：s[0]s[1]s[3]组成的bag。
                    //所以当s[i - 1] 与 t[j - 1]相等时，dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];

            }
        }


        return dp[s.length()][t.length()];
    }
}

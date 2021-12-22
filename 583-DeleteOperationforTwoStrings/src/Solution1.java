//Carl版本
public class Solution1 {

    public int minDistance(String word1, String word2) {
        //dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //初始化
        for (int i = 0; i < word1.length() + 1; i++) dp[i][0] = i;
        for (int j = 0; j < word2.length() + 1; j++) dp[0][j] = j;

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    //当word1[i - 1] 与 word2[j - 1]不相同的时候，有三种情况：
                    //情况一：删word1[i - 1]，最少操作次数为dp[i - 1][j] + 1
                    //情况二：删word2[j - 1]，最少操作次数为dp[i][j - 1] + 1
                    //情况三：同时删word1[i - 1]和word2[j - 1]，操作的最少次数为dp[i - 1][j - 1] + 2
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2,
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}

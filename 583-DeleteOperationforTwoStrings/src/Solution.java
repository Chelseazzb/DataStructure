//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
public class Solution {

    //给定单词的长度不超过500。
    //给定单词中的字符只含有小写字母。
    public int minDistance(String word1, String word2) {
        //判断边界条件
        if (word1.length() == 0 && word2.length() == 0)
            return 0;
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();

        //dp数组的定义是截止到i-1和j-1，word1和Word2的最长不连续子序列长度
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        //返回需要删除的元素数
        return word1.length() + word2.length() - 2*dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "park";
        String word2 = "spake";

        Solution solution = new Solution();

        System.out.println(solution.minDistance(word1,word2));
    }
}

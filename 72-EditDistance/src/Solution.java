//给你两个单词word1 和word2，请你计算出将word1转换成word2所使用的最少操作数。
//
//你可以对一个单词进行如下三种操作：
//
//插入一个字符
//删除一个字符
//替换一个字符

public class Solution {

    //0 <= word1.length, word2.length <= 500
    //word1 和 word2 由小写英文字母组成
    public int minDistance(String word1, String word2) {
        //判断边界条件
        if (word1.length() == 0 && word2.length() == 0)
            return 0;
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();
        //dp[i][j]表示到i-1，j-1，所需要的最小编辑距离
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        //初始化
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i; //需要操作i个元素才能相等
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i; //需要操作i个元素才能相等
        }

        for (int i = 1; i <= word1.length() ; i++) {
            for (int j = 1; j <= word2.length() ; j++) {
                //当前字符相等
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]; //不需要编辑距离
                else { //字符不相等
                    //删，word1删除一个元素，那么就是以下标i - 2为结尾的word1 与 j-1为结尾的word2的最近编辑距离再加上一个操作。
                    int add = dp[i-1][j] + 1; //word1删除一个元素，相当于word2添加一个元素
                    //增，word2删除一个元素，那么就是以下标i - 1为结尾的word1 与 j-2为结尾的word2的最近编辑距离 再加上一个操作。
                    int delete = dp[i][j-1] + 1;
                    //替换，word1替换word1[i - 1]，使其与word2[j - 1]相同，此时不用增加元素，那么以下标i-2为结尾的word1 与 j-2为结尾的word2的最近编辑距离 加上一个替换元素的操作。
                    int replace = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(Math.min(add,delete),replace);
                }
            }
        }
        return dp[word1.length()][word2.length()];

    }
}

//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//回文字符串 是正着读和倒过来读一样的字符串。
//子字符串 是字符串中的由连续字符组成的一个序列。
//具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

public class Solution {

    //1 <= s.length <= 1000
    //s 由小写英文字母组成
    public int countSubstrings(String s) {
        int result = 0;
        boolean[][] dp = new boolean[s.length()][s.length()]; //dp[i][j]代表i到j（左闭右闭）是否为回文

        for (int i = s.length() - 1; i >= 0; i--) {
            //如果这矩阵是从上到下，从左到右遍历，那么会用到没有计算过的dp[i + 1][j - 1]，也就是根据不确定是不是回文的区间[i+1,j-1]，来判断了[i,j]是不是回文，那结果一定是不对的。
            //所以一定要从下到上，从左到右遍历，这样保证dp[i + 1][j - 1]都是经过计算的。
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i <= 1){
                        dp[i][j] = true;
                        result ++;
                    } else if (dp[i+1][j-1]){
                        dp[i][j] = true;
                        result ++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aaa";

        System.out.println(new Solution().countSubstrings(s));
    }
}

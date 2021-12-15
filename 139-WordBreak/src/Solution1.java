import java.util.List;

public class Solution1 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true; //从0开始找，否则递推公式无法得true

        //先遍历背包
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i >= j && dp[j] && wordDict.contains(s.substring(j,i)))
                    dp[i] = true;
            }
        }

        return dp[s.length()];
    }
}

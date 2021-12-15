//给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定s 是否可以由空格拆分为一个或多个在字典中出现的单词。
//
//说明：拆分时可以重复使用字典中的单词。

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //1 <= s.length <= 300
    //1 <= wordDict.length <= 1000
    //1 <= wordDict[i].length <= 20
    //s 和 wordDict[i] 仅有小写英文字母组成
    //wordDict 中的所有字符串互不相同

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];

        dp[0] = true; //从0开始找，否则递推公式无法得true

        //先遍历物品，再遍历背包
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length() ; j++) {
                if (wordDict.contains(s.substring(i,j)) && dp[i])
                    dp[j] = true;
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(s.substring(0,4));
    }
}

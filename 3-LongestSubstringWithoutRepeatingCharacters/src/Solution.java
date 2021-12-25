import java.util.HashSet;
import java.util.Set;

//给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
public class Solution {

    //0 <= s.length <= 5 * 104
    //s 由英文字母、数字、符号和空格组成
    public int lengthOfLongestSubstring(String s) {
        //判断边界条件
        if (s == null || s.length() == 0)
            return 0;

        int max = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j)))
                    break; //出现重复字符
                else
                    set.add(s.charAt(j));
                if (set.size() > max) max = set.size();
            }
        }

        return max;
    }
}

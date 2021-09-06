import java.util.HashMap;
import java.util.Map;

//使用数组而不是map来实现
public class Solution1 {

    public boolean isAnagram(String s, String t) {
        //判断边界条件，字符长度一致
        if (s.length() != t.length())
            return false;

        //定义数组保存26个字母出现次数（a-0,b-1,...）
        int[] record = new int[26];

        //遍历第一个字符串
        char c;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            record[c - 'a']++;
        }

        //遍历第二个字符串，如果字符存在，value就减一，减到0就删除
        for (int i = 0; i < t.length(); i++) {
            ch = t.charAt(i);
            record[ch - 'a']--;
        }


        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0)
                return false;
        }

        return true;

    }
}

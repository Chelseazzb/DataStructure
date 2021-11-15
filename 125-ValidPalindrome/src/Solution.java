import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/15 15:49
 * @Description : 判断回文串，正着反着一样的字符串
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    public boolean isPalindrome(String s) {
        if ("".equals(s))
            return true;
        List<Character> list = new ArrayList<>();
        //去掉除字母和数字外的所有
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch))
                list.add(ch);
            if (Character.isLetter(ch))
                list.add(Character.toLowerCase(ch));
        }

        for (int start = 0,end = list.size()-1; start < end; start++,end--) {
            if (list.get(start).equals(list.get(end)))
                continue;
            else
                return false;
        }
        return true;
    }
}

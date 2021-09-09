//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' '){
                result.append(c);
            } else {
                result.append('%');
                result.append('2');
                result.append('0');
            }
        }
        return result.toString();
    }
}

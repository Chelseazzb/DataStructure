import java.util.Stack;

//使用StringBuilder实现
public class Solution1 {

    public String removeDuplicates(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count == 0 || c != res.charAt(count-1)) {
                res.append(c);
                count ++;
            } else if (c == res.charAt(count-1)){
                res.deleteCharAt(count-1);
                count--;
            }

        }

        return res.toString();
    }
}

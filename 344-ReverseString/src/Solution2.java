import java.util.Arrays;

//使用双指针
public class Solution2 {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < s.length/2; i++,j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}

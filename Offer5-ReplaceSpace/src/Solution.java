/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/17 10:21
 * @Description : 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    //利用Stringbuilder遍历s的每一个字符
    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                result.append(c);
            } else { //一旦该位置是空字符就填充%20
                result.append('%');
                result.append('2');
                result.append('0');
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "We are young";
        String space = "    ";

        String[] split = space.split(" ");
        System.out.println(split.length);
        System.out.println(new Solution().replaceSpace(str));
        System.out.println(new Solution().replaceSpace(space));
    }
}

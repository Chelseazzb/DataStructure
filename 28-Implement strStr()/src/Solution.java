//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）
// 如果不存在，则返回  -1 。
//
//说明：
//当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。

public class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;

        if (needle.length() > haystack.length())
            return -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)){
                int j = 1; //比较完0从1开始
                for (; j < needle.length(); j++) {
                    if (i+j >= haystack.length())
                        break;
                    if (haystack.charAt(i+j) == needle.charAt(j)) //存在数组越界
                        continue;
                    else
                        break; //跳出循环
                }
                if (j == needle.length()){
                    return i;
                }
            }
        }

        return -1;
    }
}

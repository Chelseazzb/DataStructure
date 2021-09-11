//给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
//
//单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
//
//请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
//
//说明：
//    输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
//    翻转后单词间应当仅用一个空格分隔。
//    翻转后的字符串中不应包含额外的空格。

public class Solution {
    public String reverseWords(String s) {

        StringBuilder res = new StringBuilder();
        String[] strArr = new String[s.length()];
        int count = 0; //记录下标

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue; //空格直接略过
            else {
                res.append(c);
                //判断读取到末尾
                if (i== s.length()-1){
                    strArr[count] = res.toString();
                    count ++;
                    break;
                }

                int index = i;
                if (s.charAt(index+1) == ' ') {
                    strArr[count] = res.toString();
                    count++;
                    i++;
                    res = new StringBuilder(); //每记录一个单词清空
                }
            }
        }

        String str = "";
        for (int j = count - 1; j >= 0; j--) {
            str += strArr[j];
            if (j != 0)
                str+=" ";
        }

        return str;
    }

    public static void main(String[] args) {

        new Solution().reverseWords(" hello world ");
        System.out.println(new Solution().reverseWords(" hello world "));
    }
}

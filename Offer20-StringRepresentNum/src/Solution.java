//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
//
//数值（按顺序）可以分成以下几个部分：
//
//若干空格
//一个 小数 或者 整数
//（可选）一个 'e' 或 'E' ，后面跟着一个 整数
//若干空格
//小数（按顺序）可以分成以下几个部分：
//
//（可选）一个符号字符（'+' 或 '-'）
//下述格式之一：
//至少一位数字，后面跟着一个点 '.'
//至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
//一个点 '.' ，后面跟着至少一位数字
//整数（按顺序）可以分成以下几个部分：
//
//（可选）一个符号字符（'+' 或 '-'）
//至少一位数字
//部分数值列举如下：
//
//["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
//部分非数值列举如下：
//
//["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
//

public class Solution {

    public boolean isNumber(String s) {
        s = s.trim(); //去掉空格
        //判断边界条件
        if (s.length() == 0)
            return false;
        char[] array = s.toCharArray();
        int i = 0;
        if (array[0] == '+' || array[0] =='-')
            i = 1; //有+ -就跳过
        if (i == array.length)
            return false; //边界，只有一个符号

        boolean flag = false; //记录e/E是否出现过
        boolean point = false; //记录小数点是否出现过
        boolean symbol = false;
        for (; i < array.length; i++) {
            char ch = array[i];
            //情况1：是数字
            if (Character.isDigit(ch)){
                continue;
            } else {
                if (ch == 'e' || ch == 'E'){
                    //需要判断前一个是不是数字
                    if (i == 0 || flag || (!Character.isDigit(array[i-1]) && array[i-1] != '.') || i == array.length - 1)
                        return false;
                    flag = true;
                } else if (ch == '.'){
                    if (flag || point)
                        return false; //一个 'e' 或 'E' ，后面跟着一个整数且只能有一个小数点
                    if ( i == 0 || !Character.isDigit(array[i-1])){
                        if (i == array.length - 1 || !Character.isDigit(array[i+1]))
                            return false;
                    }
                    point = true; //出现过小数点了

                } else if (ch == '+' || ch == '-'){
                    if (!flag || i == array.length - 1 || symbol)
                        return false; //没出现e/E的符号已经被跳过了，只能有一个
                    symbol = true; //正负号出现过了
                } else
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println("    .1  ".trim());
        Solution solution = new Solution();

        System.out.println(solution.isNumber("0123")); //整数
        System.out.println(solution.isNumber(".1")); //小数一种
        System.out.println(solution.isNumber("1.")); //小数第二种
        System.out.println(solution.isNumber("1.2")); //小数第三种
        System.out.println(solution.isNumber("2e+60++604"));

    }
}

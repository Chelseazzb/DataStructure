//根据 逆波兰表示法，求表达式的值。
//
//有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
//
//
//说明：
//
//整数除法只保留整数部分。
//给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

//输入：tokens = ["2","1","+","3","*"]
//输出：9
//解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        if (tokens == null)
            return 0;

        if (tokens.length == 1)
            return Integer.parseInt(tokens[0]);

        for (int i = 0; i < tokens.length; i++) {
            if (isNum(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
                continue;
            }

            result = calculate(stack, tokens[i]);
            stack.push(result);

        }
        return result;
    }


    private int calculate(Stack<Integer> stack, String s) {
        int sum = 0;
        if (stack.size() == 1){
            return stack.pop();
        }
        int b = stack.pop();
        int a = stack.pop();


        if (s.equals("+"))
            return a + b;
        else if (s.equals("-"))
            return a - b;
        else if (s.equals("*"))
            return a * b;
        else
            return a / b;
    }

    private boolean isNum(String s) {
        for (int i = 0; i < s.length() ; i++) {
            if ( s.charAt(0) == '-' && s.length() != 1)
                continue;

            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] tokens = {"4","3","-"};
        System.out.println(new Solution().evalRPN(tokens));
//        new Solution().evalRPN(tokens);
    }
}

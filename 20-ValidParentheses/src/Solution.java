//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。


import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char ch;
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()){
                return false;
            } else {
                ch = stack.pop();
            }

            if (c == ')'){
                if (ch != '(')
                    return false;
            } else if (c == ']'){
                if (ch != '[')
                    return false;
            } else {
                if (ch != '{')
                    return false;
            }

        }

        if (stack.isEmpty())
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("}"));
    }
}

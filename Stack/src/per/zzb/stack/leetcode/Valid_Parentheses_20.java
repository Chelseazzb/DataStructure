package per.zzb.stack.leetcode;

import java.util.Stack;

/**
 * @ClassName : Valid_Parentheses_20
 * @Author : Zhai Zhibin
 * @Date : 2020/10/8 16:33
 * @Description : leetcode的第二十题，正确的括号
 * @Modified_by :
 * @Version : 1.0
 **/
public class Valid_Parentheses_20 {

    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();

        for (int i = 0 ; i < s.length() ; i ++){
            Character c = s.charAt(i);

            if (c == '(' || c == '[' || c =='{')
                myStack.push(c);
            else{ //需要考虑到一开始不是左边符号的情况
                if (myStack.isEmpty() == true)
                    return false;
            }


            if (c == ')'){
                if (myStack.peek() != '(')
                    return false;
                else
                    myStack.pop();
            }

            if (c == ']'){
                if (myStack.peek() != '[')
                    return false;
                else
                    myStack.pop();
            }

            if (c == '}'){
                if (myStack.peek() != '{')
                    return false;
                else
                    myStack.pop();
            }
        }


        return myStack.isEmpty(); //最后不能直接返回true，需要检查栈中是否还存在元素
    }

    public static void main(String[] args) {

        System.out.println("(new Valid_Parentheses_20).isValid(\"()[]{}\") = " + (new Valid_Parentheses_20()).isValid("()[]{}"));
    }


}

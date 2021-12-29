//输入一个字符串，打印出该字符串中字符的所有排列。
//你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    /**
     * 自己的解法：超出时间限制
     */


    List<String> path = new LinkedList<>(); //记录所有排列
    Stack<Character> stack = new Stack<>(); //记录每次的路径
    List<Integer> location = new ArrayList<>();

    //1 <= s 的长度 <= 8
    public String[] permutation(String s) {

        backTracking(s);

        String[] result = new String[]{};
        return path.toArray(result);
    }

    private void backTracking(String s) {
        //1、递归终止条件
        if (stack.size() == s.length()) {
            StringBuilder res = new StringBuilder();
            for (char c : stack) {
                res.append(c);
            }
            if (!path.contains(res.toString()))
                path.add(res.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (location.contains(i))
                continue;
            stack.push(s.charAt(i));
            location.add(i);
            backTracking(s);
            stack.pop();
            location.remove(location.size() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        Solution solution = new Solution();

        String[] str = solution.permutation(s);

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}

import java.util.*;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/15 15:45
 * @Description : 给你一个字符串 s，请你将 s分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    private List<List<String>> lists;
    private Stack<String> stack; //生成list

    public List<List<String>> partition(String s) {

        lists = new ArrayList<>();
        stack = new Stack<>();
        int len = s.length();

        backTracking(s, 0, len);
        return lists;
    }

    private void backTracking(String s, int index, int len) {
        //1、回溯终止条件，切割到最后
        if (index >= len) {
            List<String> list = new ArrayList<>(stack);
            lists.add(list);
            return;
        }


        for (int i = index; i < len; i++) {
            if (check(s, index, i)) { //如果找到回文串
                String str = s.substring(index, i + 1);
                stack.push(str);
            } else
                continue;

            backTracking(s, i + 1, len);
            stack.pop();

        }

    }

    //根据切割的位置，判断是否为回文串，左闭右闭
    private boolean check(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().check("aab", 0, 1));
        new Solution().partition("cdd");
    }

}


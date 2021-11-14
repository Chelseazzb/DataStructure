import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/14 13:04
 * @Description : 给定两个整数n和k，返回范围 [1, n] 中所有可能的k个数的组合。
 * 你可以按任何顺序返回答案。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    private List<List<Integer>> lists; //保存最终结果
    private Stack<Integer> path; //保存每个结果
    public List<List<Integer>> combine(int n, int k) {
        lists = new ArrayList<>();
        path = new Stack<>();
        backtracking(1, n, k);
        return lists;
    }

    void backtracking(int start, int end, int count) {

        //回溯终止条件
        if (path.size() == count) { //找到一个结果
            lists.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= end; i++) {
            path.push(i);
            backtracking(i+1,end,count);
            path.pop();
        }
    }

    public static void main(String[] args) {
        new Solution().combine(4,2);
    }
}

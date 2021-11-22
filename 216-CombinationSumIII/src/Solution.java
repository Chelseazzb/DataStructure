import java.util.*;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/14 17:51
 * @Description : 找出所有相加之和为 n的 k个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * @Version : 1.0
 **/
public class Solution {

    List<List<Integer>> lists;
    Stack<Integer> queue;
    public List<List<Integer>> combinationSum3(int k, int n) {
        lists = new ArrayList<>();
        queue = new Stack<>();

        backTracking(k, 1, n);
        return lists;
    }

    private void backTracking(int count, int start, int sum) {
        //1、回溯终止条件
        if (queue.size() == count) {
            for (int i : queue) {
                sum -= i;
            }
            if (sum == 0){
                List<Integer> list = new ArrayList<>(queue);
                if (!lists.contains(list))
                    lists.add(list);
                return;
            }
        }

        //for循环遍历子集，只允许1-9
        for (int i = start; i <= 9; i++) {
            queue.push(i);
            backTracking(count, i + 1, sum );
            queue.pop();
        }
    }
}

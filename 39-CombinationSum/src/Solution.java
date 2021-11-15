import java.util.*;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/14 22:50
 * @Description : 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 * 对于给定的输入，保证和为 target 的唯一组合数少于150个。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    private List<List<Integer>> lists;
    private Stack<Integer> stack;
    private int sum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        lists = new ArrayList<>();
        stack = new Stack<>();
        sum = 0;

        backTracking(candidates, 0, target, sum);
        return lists;
    }

    private void backTracking(int[] candidates, int index, int target, int sum) {

        //1、回溯终止条件
        if (sum > target)
            return; //剪枝

        if (sum == target) {
            List<Integer> list = new ArrayList<>(stack);
            if (!lists.contains(list))
                lists.add(list); //找到一种结果
            return;
        }

        //for循环横向遍历子集
        for (int i = index; i < candidates.length; i++) { //从index开始就不会再往回找出现重复

            sum += candidates[i];
            stack.push(candidates[i]);
            backTracking(candidates, i, target, sum);
            sum -= candidates[i];
            stack.pop();


        }
    }
}

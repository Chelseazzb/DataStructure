import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/15 10:18
 * @Description : 剪枝优化
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    private List<List<Integer>> lists;
    private Stack<Integer> stack;
    private int sum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        lists = new ArrayList<>();
        stack = new Stack<>();
        sum = 0;
        //需要排序
        Arrays.sort(candidates);
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
        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) { //从index开始就不会再往回找出现重复

            sum += candidates[i];
            stack.push(candidates[i]);
            backTracking(candidates, i, target, sum);
            sum -= candidates[i];
            stack.pop();


        }
    }
}

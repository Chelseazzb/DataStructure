import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/15 10:45
 * @Description : 给定一个数组 candidates和一个目标数 target，找出 candidates中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。 
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {


    //跟39题不同的地方是解集不能包含重复的集合，需要额外的数据结构来判断是否使用过
    //重点是区分树枝重复还是树层可以重复，本题是树枝可以重复，树层不行

    List<List<Integer>> lists;
    Stack<Integer> stack;
    boolean[] isUsed;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        lists = new ArrayList<>();
        stack = new Stack<>();
        int len = candidates.length;
        isUsed = new boolean[50];
        for (int i = 0; i < isUsed.length; i++) {
            isUsed[i] = false;
        }
        Arrays.sort(candidates); //将数组排序，一样的全放在一起
        backTracking(candidates,0,target,0,len);
        return lists;
    }

    private void backTracking(int[] candidates, int index, int target,int sum, int len){

        //1、回溯终止条件
        if (sum == target){
            lists.add(new ArrayList<>(stack));
            return;
        }

        for (int i = index; i < len && sum + candidates[i] <= target ; i++) {
            // used[i - 1] == true，说明同一树支candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            if (i>0 &&candidates[i] == candidates[i-1] && isUsed[i-1] == false)
                continue;
            sum += candidates[i];
            stack.push(candidates[i]);
            isUsed[i] = true;
            backTracking(candidates,i+1,target,sum,len);
            sum -= candidates[i];
            stack.pop();
            isUsed[i] = false;
        }
    }
}

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/19 22:07
 * @Description : 给定一个不含重复数字的数组 nums ，返回其所有可能的全排列 。你可以 按任意顺序返回答案。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    List<List<Integer>> lists;
    Stack<Integer> path;
    private boolean[] isUsed; //-10 <= nums[i] <= 10,nums 中的所有整数互不相同
    public List<List<Integer>> permute(int[] nums) {
        lists = new LinkedList<>();
        path = new Stack<>();
        isUsed = new boolean[21]; //初始值为false

        backTracking(nums,nums.length);
        return lists;
    }

    private void backTracking(int[] nums,int len){
        //1、回溯终止条件
        if (path.size() == len){
            lists.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!isUsed[nums[i] + 10]){ //还未使用过
                path.add(nums[i]);
                isUsed[nums[i] + 10] = true; //同一树枝不能使用一样的
            } else
                continue;
            backTracking(nums,len);
            isUsed[nums[i] + 10] = false;
            path.pop();
        }
    }
}

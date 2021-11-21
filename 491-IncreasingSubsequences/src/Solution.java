import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/21 12:02
 * @Description : 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
 * 你可以按任意顺序返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    private List<List<Integer>> lists;
    private Stack<Integer> path;

    public List<List<Integer>> findSubsequences(int[] nums) {

        //判断边界条件
        if (nums.length == 1)
            return lists;

        lists = new LinkedList<>();
        path = new Stack<>();

        backTracking(nums, 0, nums.length);
        return lists;
    }

    private void backTracking(int[] nums, int index, int length) {
        //回溯终止条件
        if (path.size() >= 2) { //递增子序列中至少有两个元素
            lists.add(new LinkedList<>(path));
            //不能加return，因为要记录所有情况
        }

        if (index >= length)
            return;

        //for遍历，树层去重
        boolean[] isUsed = new boolean[201]; //-100 <= nums[i] <= 100
        for (int i = index; i < length; i++) {
            //同层不能选一样的
            if (!path.isEmpty() && nums[i] < path.peek() || isUsed[nums[i] + 100] == true) {
                continue;
            }

            if (path.isEmpty()) { //第一个元素总是加入栈
                path.push(nums[i]);
                isUsed[nums[i] + 100] = true;
                backTracking(nums,i+1,length);
                path.pop();
            }

            if ( !path.isEmpty() && nums[i] >= path.peek()){ //path不为空
                path.push(nums[i]);
                isUsed[nums[i] + 100] = true;
                backTracking(nums,i+1,length);
                path.pop();
            }

        }

    }
}

import java.util.*;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/20 11:21
 * @Description : 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。返回的解集中，子集可以按任意顺序排列。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    private List<List<Integer>> lists;
    private Stack<Integer> path;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        lists = new LinkedList<>();
        path = new Stack<>();
        int len = nums.length;
        Arrays.sort(nums);
        backTracking(nums, 0, len);

        return lists;
    }

    private void backTracking(int[] nums, int index, int len) {
        //加入路径
        if (!lists.contains(new LinkedList<>(path)))
            lists.add(new LinkedList<>(path));

        if (index >= len)
            return;

        //递归回溯
        for (int i = index; i < len; i++) {
            path.push(nums[i]);
            backTracking(nums, i + 1, len);
            path.pop();
        }
    }
}

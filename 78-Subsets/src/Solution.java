import java.util.*;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/18 8:07
 * @Description : 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。你可以按任意顺序返回解集。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    List<List<Integer>> lists;
    Stack<Integer> stack;

    public List<List<Integer>> subsets(int[] nums) {
        lists = new ArrayList<>();
        stack = new Stack<>();
        
        backTracking(nums, 0, nums.length);
        return lists;
    }

    private void backTracking(int[] nums, int index, int len) {
        lists.add(new ArrayList<>(stack)); //加入集合，包括空集
        if (index >= len)
            return; //遍历完最后一个数字

        for (int i = index; i < len; i++) {
            stack.push(nums[i]); //路径添加
            backTracking(nums, i + 1, len);
            stack.pop();
        }
    }
}

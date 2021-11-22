import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/20 22:33
 * @Description : 给定一个可包含重复数字的序列 nums ，按任意顺序返回所有不重复的全排列。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    List<List<Integer>> lists;
    Stack<Integer> path;
    boolean[] indexUsed; // 1 <= nums.length <= 8

    public List<List<Integer>> permuteUnique(int[] nums) {

        lists = new LinkedList<>();
        path = new Stack<>();
        indexUsed = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, nums.length);
        return lists;
    }

    private void backTracking(int[] nums, int length) {

        if (path.size() == length) { //找到一种结果
            lists.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            //同一树层不允许相同
            if (i > 0 && nums[i] == nums[i - 1] && indexUsed[i-1] == false)
                continue;

            if (!indexUsed[i]) {//该位置还没使用过

                path.push(nums[i]);
                indexUsed[i] = true;
                backTracking(nums, length);
                path.pop();
                indexUsed[i] = false;
            }

        }
    }


}

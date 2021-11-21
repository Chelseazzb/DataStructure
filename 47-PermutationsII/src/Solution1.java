import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/21 11:50
 * @Description : 树枝去重，不能树枝树层同时去重
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

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
            //树枝去重，效率会低一点比树层去重
            if (i > 0 && nums[i] == nums[i - 1] && indexUsed[i-1] == true)
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/21 16:22
 * @Description : 空间优化，ArrayList不用LinkedList
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    private List<List<Integer>> lists;
    private Stack<Integer> path;

    public List<List<Integer>> findSubsequences(int[] nums) {

        //判断边界条件
        if (nums.length == 1)
            return lists;

        lists = new ArrayList<>();
        path = new Stack<>();

        backTracking(nums, 0, nums.length);
        return lists;
    }

    private void backTracking(int[] nums, int index, int length) {
        //回溯终止条件
        if (path.size() >= 2) { //递增子序列中至少有两个元素
            lists.add(new ArrayList<>(path));
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

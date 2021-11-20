import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/20 11:32
 * @Description : 剪枝优化
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {
    private List<List<Integer>> lists;
    private Stack<Integer> path;
    private boolean[] isUsed; //-10 <= nums[i] <= 10
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        lists = new LinkedList<>();
        path = new Stack<>();
        isUsed = new boolean[21]; //下标对应 nums[i]+10
        int len = nums.length;
        Arrays.sort(nums);
        backTracking(nums, 0, len);

        return lists;
    }

    private void backTracking(int[] nums, int index, int len) {
        //加入路径
        lists.add(new LinkedList<>(path));

        if (index >= len)
            return;

        //递归回溯
        for (int i = index; i < len; i++) {
            if (i >0 && nums[i] == nums[i-1] && isUsed[nums[i] + 10] == false){
                continue;
            }
            path.push(nums[i]);
            isUsed[nums[i] + 10] = true;
            backTracking(nums, i + 1, len);
            isUsed[nums[i] + 10] = false;
            path.pop();
        }
    }
}

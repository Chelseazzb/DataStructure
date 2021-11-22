import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution2
 * @Author : Zhai Zhibin
 * @Date : 2021/11/20 11:46
 * @Description : 不使用辅助空间进一步优化
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution2 {

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
        lists.add(new LinkedList<>(path));

        if (index >= len)
            return;

        //递归回溯
        for (int i = index; i < len; i++) {
            if (i > index && nums[i] == nums[i-1]){ //同一树层不能选一样的
                continue;
            }
            path.push(nums[i]);
            backTracking(nums, i + 1, len);
            path.pop();
        }
    }
}

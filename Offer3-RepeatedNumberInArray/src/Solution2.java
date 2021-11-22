import java.util.Arrays;

/**
 * @ClassName : Solution2
 * @Author : Zhai Zhibin
 * @Date : 2021/11/16 18:54
 * @Description : 先排序数组
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution2 {

    public int findRepeatNumber(int[] nums) {

        Arrays.sort(nums);
        int i;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                break;
        }
        return nums[i];
    }
}

//使用滑动窗口实现

public class Solution1 {

    public int minSubArrayLen(int target, int[] nums) {
        int result = nums.length + 1 ;
        int slow = 0;
        int sum = 0;
        int subLength = 0; //记录中间结果

        //仅需要一次循环
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];

            //窗口内保持的是满足要求的最小连续数组
            while (sum >= target){
                subLength = fast - slow + 1;
                result = result < subLength ? result : subLength;
                sum -= nums[slow++];
            }
        }

        return result == nums.length + 1 ? 0 : result;
    }
}

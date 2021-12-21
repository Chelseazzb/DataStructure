public class Solution2 {

    //动态规划
    //1 <= nums.length <= 105
    //-104 <= nums[i] <= 104
    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length]; //代表截止到i的最大子数组和
        //初始化
        dp[0] = nums[0];
        int result = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i],dp[i-1] + nums[i]); //dp[i-1]<0的话，dp[i]就是当前元素的值
            if (dp[i] > result) result = dp[i];
        }

        return result;
    }
}

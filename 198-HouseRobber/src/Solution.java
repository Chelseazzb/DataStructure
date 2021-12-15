//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

public class Solution {

    //1 <= nums.length <= 100
    //0 <= nums[i] <= 400
    public int rob(int[] nums) {
        //边界条件
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        //初始化
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        //正向遍历
        for (int i = 2; i < nums.length; i++) {
            //如果不偷第i房间，那么dp[i] = dp[i - 1]，即考虑i-1房（注意这里是考虑，并不是一定要偷i-1房，这是很多同学容易混淆的点）
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]); //递推公式，要么不偷，要么不偷
        }


        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};

        Solution solution = new Solution();
        System.out.println(solution.rob(nums));
    }
}

//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
//
//题目数据保证答案符合 32 位整数范围。

public class Solution {

    //1 <= nums.length <= 200
    //1 <= nums[i] <= 1000
    //nums 中的所有元素 互不相同
    //1 <= target <= 1000

    //如果求组合数就是外层for循环遍历物品，内层for遍历背包。
    //如果求排列数就是外层for遍历背包，内层for循环遍历物品。
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];

        dp[0] = 1; //初始化
        //先遍历背包容量，保证排列的一个结果可以有多个顺序
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i-nums[j]]; //递推公式
            }

            //打印dp数组
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[j] + "  ");
            }
            System.out.println();
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        new Solution().combinationSum4(nums,4);
    }
}

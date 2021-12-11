//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

public class Solution {

    //1 <= nums.length <= 200
    //1 <= nums[i] <= 100

    //只有确定了如下四点，才能把01背包问题套到本题上来。
    //1、背包的体积为sum / 2
    //2、背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
    //3、背包如何正好装满，说明找到了总和为 sum / 2 的子集。
    //4、背包中每一个元素是不可重复放入。
    public boolean canPartition(int[] nums) {

        int sum = 0; //求和数组
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) return false; //奇数不能找两个子集相等

        int[] dp = new int[sum/2 + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = sum/2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-nums[i]] + nums[i]);
            }
        }

        return dp[sum/2] == sum / 2;
    }
}

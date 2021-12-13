/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/12/13 10:12
 * @Description : 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    //1 <= nums.length <= 20
    //0 <= nums[i] <= 1000
    //0 <= sum(nums[i]) <= 1000
    //-1000 <= target <= 1000

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        //判断边界条件
        if (target > sum || (target + sum) %2 != 0)
            return 0;

        //加'+'的总共x个，加'-'的总共sum-x个，总和是一样的sum，x - (sum - x) = target
        int capacity = (sum + target) / 2;
        if(capacity < 0) capacity = -capacity; //可能小于0
        int[] dp = new int[capacity + 1];
        dp[0] = 1; //装容量为0的背包有一种方式，就是啥也不放
        //先遍历数字再倒叙遍历容量
        for (int i = 0; i < nums.length; i++) {
            for (int j = capacity; j >= nums[i] ; j--) {
                //dp[j - nums[i]]的含义是target = j - nums[i]时有多少种可能；
                //如果此时找到一个nums[i]，dp[j] = dp[j] + dp[j - nums[i]]
                dp[j] += dp[j - nums[i]]; //递推公式
            }

            //打印dp
            for (int k = 0; k < capacity + 1; k++) {
                System.out.print(dp[k] + " ");
            }
            System.out.println();
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,1,1,1,1};
        new Solution().findTargetSumWays(nums,3);
    }
}

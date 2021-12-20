//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
// 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

import java.util.Arrays;

public class Solution {

    //1 <= nums.length <= 2500
    //-10^4 <= nums[i] <= 10^4
    public int lengthOfLIS(int[] nums) {

        //判断边界条件
        if (nums.length == 1)
            return 1;

        int[] dp = new int[nums.length]; //代表到i的最长序列
        Arrays.fill(dp, 1); //初始化为1，因为开始的时候只有当前元素就是1
        int res = 0; //dp数组中的最大值

        for (int i = 1; i < nums.length; i++) { //遍历每个元素
            for (int j = 0; j < i; j++) { //从前向后找到i
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1); // 递推公式，是为了比较哪个更大，只要比之前的元素大，就可以+1
                }
            }
        }

        //得到最大值
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }

        return res;

    }
}

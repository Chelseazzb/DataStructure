//在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
//
//现在，可以绘制一些连接两个数字 nums1[i]和 nums2[j]的直线，这些直线需要同时满足满足：
//
//nums1[i] == nums2[j]
//且绘制的直线不与任何其他连线（非水平线）相交。
//请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
//
//以这种方法绘制线条，并返回可以绘制的最大连线数。

public class Solution {

    //1 <= nums1.length, nums2.length <= 500
    //1 <= nums1[i], nums2[j] <= 2000
    //使用暴力方法
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int result = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1]; //dp[i][j]代表截止到i-1和j-1可以画多少条线

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {

                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    //如果text1[i - 1] 与 text2[j - 1]不相同，
                    // 那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的。
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
                //dp[i][j]有三个方向可以推导出来，都是从左向右，从上到下
            }
        }

        return dp[nums1.length][nums2.length];
    }
}

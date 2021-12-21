public class Solution1 {

    //1 <= len(A), len(B) <= 1000
    //0 <= A[i], B[i] < 100
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1]; //dp[i][j]表示nums1到i-1，nums到j-1的最长重复子数组
        int result = 0;

        //初始化都为0即可，所以dp[0][0]没有意义
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1] == nums2[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                result = Math.max(result,dp[i][j]);
            }
        }

        return result;
    }

    //滚动数组，dp[i][j]都是由左上角推过来的，就是由dp[j-1]
    public int findLength1(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int result = 0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--) { //需要倒叙遍历避免重复覆盖
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                result = Math.max(result, dp[j]);
            }
        }
        return result;
    }
}

import java.util.Arrays;

public class Solution1 {

    //1 <= nums.length <= 104
    //-109 <= nums[i] <= 109
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        int res = 1;
        //不连续递增子序列的跟前0-i 个状态有关，连续递增的子序列只跟前一个状态有关
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1; //递推公式
            }
            res = res > dp[i + 1] ? res : dp[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,5,0,3,4};

        System.out.println(new Solution1().findLengthOfLCIS(nums));
    }
}

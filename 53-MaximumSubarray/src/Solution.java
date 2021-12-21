import javax.swing.*;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
public class Solution {

    //暴力解法超出时间限制
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        long max = Integer.MIN_VALUE;
        //暴力解法
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum < 0)
                    break;
                if (sum > max)
                    max = sum;
            }

        }

        return (int)max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4}; //如果数组中有最小值，会超出int边界
        System.out.println(solution.maxSubArray(nums));
    }
}

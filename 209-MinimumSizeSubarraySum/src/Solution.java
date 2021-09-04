//给定一个含有 n 个正整数的数组和一个正整数 target
//找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int result = nums.length + 1;

        //两次循环
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int count = 1;
            sum += nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (sum < target){
                    sum += nums[j];
                    count ++;
                }
            }

            if (sum >= target) //需要判断最终的结果是否满足条件
                if (count < result)
                    result = count;
        }

        return result == nums.length + 1 ? 0 : result;
    }
}

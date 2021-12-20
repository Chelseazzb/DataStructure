//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
//
//连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
// 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。

public class Solution {

    //1 <= nums.length <= 104
    //-109 <= nums[i] <= 109
    public int findLengthOfLCIS(int[] nums) {
        //判断边界
        if (nums.length == 1)
            return 1;

        int length = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            int count = 1;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] > nums[j-1]){
                    count ++;
                }
                else break;
            }
            length = Math.max(length,count);
        }


        return length;

    }
}

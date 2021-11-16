/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/16 18:00
 * @Description : 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数
 * 组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    //使用数组辅助标记
    public int findRepeatNumber(int[] nums) {
        int[] exist = new int[nums.length]; // 0 - n-1

        //exist初始化为0
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (exist[nums[i]] == 1){
                result = nums[i];
                break;
            }

            if (exist[nums[i]] == 0)
                exist[nums[i]] = 1;
        }
        return result;
    }
}

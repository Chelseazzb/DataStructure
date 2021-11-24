/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/24 19:53
 * @Description : 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    //超出时间范围
    private boolean result;
    public boolean canJump(int[] nums) {
        if (nums.length == 1) //判断边界条件
            return true;
        if (nums[0] == 0)
            return false;

        int len = nums.length;

        return canJump(nums,0,len);
    }

    private boolean canJump(int[] nums,int start,int end){
        //1、递归终止条件
        if (start >= end - 1)
            return true;

        //贪心：每次都先跳最远
        for (int i = nums[start]; i > 0; i--) {
            if (canJump(nums,start + i,end))
                return true; //有一种方式能跳到就返回true
        }

        return false; //都跳不到最后一个
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,0};
        Solution solution = new Solution();

        solution.canJump(nums);
        System.out.println(solution.canJump(nums));
    }
}

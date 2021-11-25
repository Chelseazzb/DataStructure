//给你一个非负整数数组nums ，你最初位于数组的第一个位置。
//
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
//假设你总是可以到达数组的最后一个位置。
//

public class Solution {

    int min = Integer.MAX_VALUE;

    //贪心每次先跳最远的，能到达最后就返回
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0; //不需要跳就是最后


        jump(nums, 0, nums[0], nums.length, 1);
        return min;
    }

    private void jump(int[] nums, int index, int coverRange, int len, int count) {

        //1、递归终止条件
        if (coverRange >= len - 1) {
            if (count < min)
                min = count;
            return;
        }
        for (int i = coverRange; i > index; i--) {

            jump(nums, i, i + nums[i], len, count + 1);

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};

        solution.jump(nums);
        System.out.println(solution.jump(nums));
    }
}

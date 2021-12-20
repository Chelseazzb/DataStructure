public class Solution2 {

    //使用贪心法
    //1 <= nums.length <= 104
    //-109 <= nums[i] <= 109
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1)
            return 1;

        int result= 1;
        int count = 1; //自身就算1

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i+1] > nums[i]){
                count ++; //贪心每次大的就加1
            } else {
                count = 1; //遇到小的重新算
            }
            result = Math.max(result,count);
        }

        return result;
    }
}

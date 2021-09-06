public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2]; //返回结果
        int sum = 0;

        //两重循环
        for (int i = 0; i < nums.length - 1; i++) {
            sum = nums[i];


            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                } else {
                    sum -= nums[j];
                }
            }
        }

        return result;
    }
}

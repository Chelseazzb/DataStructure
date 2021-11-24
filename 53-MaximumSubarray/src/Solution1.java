public class Solution1 {

    //使用贪心，每次合为负数就从下一个节点开始，因为负数只会越加越小

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0; //累加计算最大子序和

        //遍历每个位置
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result)
                result = count;
            if (count <= 0)
                count = 0;

        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        int[] nums = new int[]{-2,Integer.MIN_VALUE,1};
        solution1.maxSubArray(nums);
    }
}

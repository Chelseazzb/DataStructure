/**
 * @ClassName : NumArray
 * @Author : Zhai Zhibin
 * @Date : 2021/8/25 7:37
 * @Description : 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * @Modified_by :
 * @Version : 1.0
 **/
class NumArray {

    //利用一个额外的数组
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        // sum[0] = 0 , sum[i] = 前i个数的和
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {

        int leftSum = sum[left];
        int rightSum = sum[right + 1];

        return rightSum - leftSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

import java.util.Arrays;

public class Solution {

    //给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
    //
    //以这种方式修改数组后，返回数组可能的最大和。

    public int largestSumAfterKNegations(int[] nums, int k) {

        int sum = 0;

        //只对最小的元素操作
        Arrays.sort(nums);

        while (k > 0){
            if (nums[0] > 0){ //全是正数
                if (k % 2 == 0)
                    break;
                else {
                    nums[0] = -nums[0];
                    break;
                }
            }
            nums[0] = -nums[0];
            Arrays.sort(nums);
            k --;
        }

        //计算求和
        for(int num : nums)
            sum += num;
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,-3};
        Solution solution = new Solution();

        System.out.println(solution.largestSumAfterKNegations(nums,4));
    }

}

import java.util.Arrays;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
public class Solution {

    //1 <= k <= nums.length <= 104
    //-104 <= nums[i] <= 104
    //调用API
    public int findKthLargest(int[] nums, int k) {

        //数组排序
        Arrays.sort(nums);
        int index = nums.length - 1;
        for (int i = k; i > 1 ; i--) {
            index --;

        }

        return index < 0 ? 0 : nums[index];
    }
}

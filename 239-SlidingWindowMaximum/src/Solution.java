//给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
//
//返回滑动窗口中的最大值。

//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        //Stack<Integer> stack = new Stack<>();
        int[] result; //返回最大值数组

        if (k == 1)
            return nums;

        if (k > nums.length) {
            Arrays.sort(nums);
            result = new int[1];
            result[0] = nums[nums.length - 1];
            return result;
        }

        int count = nums.length - k + 1; //计算最大值数组的元素个数
        result = new int[count];
        int max = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int[] tmp = new int[k];
            int number = 0;
            for (int j = i; j < i + k; j++) {
                tmp[number] = nums[j];
                number++;

            }
            if (number == k){
                Arrays.sort(tmp);
                max = tmp[tmp.length - 1];
        }

        result[i] = max;
    }
        return result;

}

    private String printArr(int[] arr) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                res.append(arr[i]);
                break;
            }
            res.append(arr[i] + ",");
        }
        return res.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = new int[]{1, -1};
        int[] arr2 = new int[]{1};
        int[] arr3 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};

        System.out.println(solution.printArr(solution.maxSlidingWindow(arr1, 2)));
        System.out.println(solution.printArr(solution.maxSlidingWindow(arr2, 1)));
        System.out.println(solution.printArr(solution.maxSlidingWindow(arr3, 3)));
    }
}

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//请必须使用时间复杂度为 O(log n) 的算法。

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int left = 0; //记录左边位置
        int right = nums.length - 1; //记录右边位置
        int mid = left + (right - left) / 2; //求出中间位置

        //判断边界条件，因为是有序数组
        if (target < nums[0])
            return 0;
        else if (target > nums[nums.length - 1])
            return nums.length;

        //进行二分搜索
        while (left <= right) {

            mid = left + (right - left) / 2; //求出中间位置

            //如果小于中间元素
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}

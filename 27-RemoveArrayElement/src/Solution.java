//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//
//不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

class Solution {
    public int removeElement(int[] nums, int val) {


        //删除数组中的所有val元素
        int size = nums.length ;
        for (int i = 0; i < size; i++) {

            if (val == nums[i]){
                //删除元素
                for (int j = i ; j < size - 1; j++) {
                    nums[j ] = nums[j + 1];
                }
                size --;
                i --; // 因为下表i以后的数值都向前移动了一位，所以i也向前移动一位
            }

        }

        return size;
    }
}

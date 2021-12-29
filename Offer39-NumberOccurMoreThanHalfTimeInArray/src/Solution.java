//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。

import java.util.HashMap;
import java.util.Map;

public class Solution {

    //1 <= 数组长度 <= 50000
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int index = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                int value = map.get(nums[i]) + 1;
                if (value > len / 2){
                    index = i;
                    break;
                }
                map.put(nums[i],value);
            } else
                map.put(nums[i],1);
        }

        return nums[index];
    }
}

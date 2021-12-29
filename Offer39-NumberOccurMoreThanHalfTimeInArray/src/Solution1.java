import java.util.Arrays;

public class Solution1 {

    //1 <= 数组长度 <= 50000
    public int majorityElement(int[] nums) {
        int count = 1;
        int len = nums.length;
        //对数组排序
        Arrays.sort(nums);
        int index;
        for (index = 0; index < nums.length - 1; index++) {
            if (nums[index] == nums[index+1]){
                count ++;
                if (count > len / 2)
                    break;
            } else
                count = 1;
        }

        return nums[index];
    }
}

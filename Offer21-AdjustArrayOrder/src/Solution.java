import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
public class Solution {

    //0 <= nums.length <= 50000
    //0 <= nums[i] <= 10000
    public int[] exchange(int[] nums) {
        //使用两个list
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) { //偶数
                queue2.add(nums[i]);
            } else { //奇数
                queue1.add(nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (!queue1.isEmpty()){
                nums[i] = queue1.poll();
                continue;
            }
            if (!queue2.isEmpty()){
                nums[i] = queue2.poll();
            }

        }

        return nums;
    }
}

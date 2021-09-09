import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：
//
//    0 <= a, b, c, d < n
//    a、b、c 和 d 互不相同
//    nums[a] + nums[b] + nums[c] + nums[d] == target
//
//你可以按 任意顺序 返回答案 。

//使用双指针法
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); //先对数组进行排序
        int size = nums.length;

        //判断边界条件
        if ( size < 4 )
            return result;

        for (int head = 0; head < size - 3; head++) {

            //去重
            if (head > 0 && nums[head] == nums[head-1])
                continue;

            for (int tail = size - 1; tail > 2 ; tail-- ) {

                //去重
                if (tail < size - 1 && nums[tail] == nums[tail+1])
                    continue;

                int left = head + 1;
                int right = tail - 1;

                while (right > left){

                    //判断加入条件
                    if (nums[head] + nums[tail] + nums[left] + nums[right] == target){
                        List<Integer> list = new ArrayList<>(4);
                        list.add(nums[head]);
                        list.add(nums[tail]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        if (!result.contains(list))
                            result.add(list);

                        //去重过滤
                        while (right > left && nums[right] == nums[right-1]) right--;
                        while (right > left && nums[left] == nums[left+1]) left++;

                        left ++;
                        right --;
                    } else if(nums[head] + nums[tail] + nums[left] + nums[right] < target){
                        left ++;
                    } else {
                        right --;
                    }

                }
            }


        }

        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1,0,-1,0,-2,2};
//        int[] nums = {2,2,2,2,2};
        int[] nums = {1,-2,-4,-5,-3,3,5,3};
        System.out.println(new Solution().fourSum(nums,-11));
    }
}

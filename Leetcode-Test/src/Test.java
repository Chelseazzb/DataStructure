import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : Test
 * @Author : Zhai Zhibin
 * @Date : 2021/9/20 14:33
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
public class Test {

    //344-反转字符串
    public void reverseString(char[] s) {
        int first = 0;
        int last = s.length - 1;
        while (last > first){
            char tmp = s[first];
            s[first] = s[last];
            s[last] = tmp;
            first ++;
            last --;
        }
    }

    //15-三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3)
            return lists;

        Arrays.sort(nums); //对nums排序
        //head滑动
        for (int head = 0; head < nums.length - 2; head++) {
            if (nums[head] > 0)
                break;
            if (head > 0 && nums[head] == nums[head-1])
                continue; //去重
            int middle = head + 1;
            int tail = nums.length - 1;
            //middle滑动
            while (middle > head && middle < tail){
                if (nums[head] + nums[middle] + nums[tail] < 0) middle++;
                else if (nums[head] + nums[middle] + nums[tail] > 0) tail--;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[head]);
                    list.add(nums[middle]);
                    list.add(nums[tail]);
                    lists.add(list);
                    middle++;
                    tail--;
                    while (middle < tail && nums[middle] == nums[middle - 1]) middle++;
                    while (tail > middle && nums[tail] == nums[tail + 1]) tail--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println(new Test().threeSum(nums));
    }
}

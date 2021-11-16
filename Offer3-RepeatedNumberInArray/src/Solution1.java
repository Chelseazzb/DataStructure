/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/16 18:36
 * @Description : 使用交换法
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    //直接修改数组
    public int findRepeatNumber(int[] nums) {

        int result = findDuplicate(nums);
        return result;
    }

    private int findDuplicate(int[] nums) {
        int result = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (flag == true)
                break;
            while (nums[i] != i){
                int temp = nums[i];
                if (nums[i] == nums[temp]){
                    flag = true;
                    result = nums[i];
                    break;
                } else { //交换
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }
        return result;
    }
}

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/20 21:06
 * @Description : 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    public int minArray(int[] numbers) {
        if (numbers.length == 0) //边界条件
            return 0;
        if (numbers.length == 2) //循环判断不到的
            return numbers[0]<numbers[1] ? numbers[0] : numbers[1];

        int min = numbers[0];
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] <= numbers[i + 1]){
                if (numbers[i + 1] <= numbers[i+2])
                    continue;
                else { //找到转折点
                    min = numbers[i+2];
                    break;
                }
            } else { //不能忘记更新min的值
                min = numbers[i+1];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,1};

        System.out.println(new Solution().minArray(nums));
    }
}

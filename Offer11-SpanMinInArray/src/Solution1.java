/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/21 17:27
 * @Description : 二分查找法
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) //边界条件
            return 0;
        if (numbers.length == 2) //循环判断不到的
            return numbers[0]<numbers[1] ? numbers[0] : numbers[1];

        int head = 0;
        int tail = numbers.length - 1;
        int min = numbers[head];
        if (numbers[tail] > numbers[head]){ //一段递增序列
            min = numbers[head];
        } else if (numbers[tail] < numbers[head]){ //两段递增序列
            while (tail > head){
                if (head + 1 == tail){ //找到前后两个递增序列的交界
                    min = numbers[tail];
                    break;
                }
                //取中间的值
                int middle = (head + tail) / 2;
                if (numbers[middle] >= numbers[head]) //判断middle是否还在前一个递增序列
                    head = middle;
                else
                    tail = middle;
            }
        } else { //首尾元素相等，只能全遍历一遍找最小值
            min = findMin(numbers);
        }
        return min;
    }

    private int findMin(int[] numbers) {
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min)
                min = numbers[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2};

        System.out.println(new Solution().minArray(nums));
    }
}

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//使用dequeue实现
public class Solution1 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        //Stack<Integer> stack = new Stack<>();
        int[] result; //返回最大值数组
        Deque<Integer> deque = new LinkedList<>(); //定义双端队列，队首保持当前最大值，记录最大下标

        if (k == 1) //判断边界条件
            return nums;

        if (k > nums.length) { //判断边界条件
            Arrays.sort(nums);
            result = new int[1];
            result[0] = nums[nums.length - 1];
            return result;
        }

        result = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        result[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length ; i++) {
            //当窗口滑动，新加入的元素和队尾的元素比较，直到队列为空或队尾元素比当前元素大
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k ){ //队首向后移
                deque.pollFirst();
            }
            result[i-k+1] = nums[deque.peekFirst()];
        }
        return result;
    }
}

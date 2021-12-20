//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。
// 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

import java.util.Stack;

public class Solution {

    //0 <= pushed.length == popped.length <= 1000
    //0 <= pushed[i], popped[i] < 1000
    //pushed是popped的排列。
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0)
            return false;
        Stack<Integer> stack = new Stack<>(); //不断向其中加入pushed
        int pushStart = 0;
        int popStart = 0;
        int length = pushed.length;

        //初始化
        stack.push(pushed[pushStart ++]); //放入第一个元素
        while (pushStart <= length && popStart < length){ //push数组可以提前遍历到最后
            if (!stack.isEmpty() && stack.peek() == popped[popStart]){ //需要对栈判空
                stack.pop();
                popStart ++;
            } else {
                if (pushStart == length) //判断边界
                    break;
                stack.push(pushed[pushStart ++]); //放入元素且指针向后移动
            }

        }

        return pushStart == length && popStart == length;
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1,0};
        int[] poped = new int[]{1,0};

        System.out.println(new Solution().validateStackSequences(pushed,poped));
    }
}

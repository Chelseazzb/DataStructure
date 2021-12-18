import java.util.Stack;

public class MinStack1 {

    /** initialize your data structure here. */
    private Stack<Integer> nums;
    private Stack<Integer> min;
    public MinStack1() {
        nums = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        nums.push(x);
        if (min.isEmpty() || x <= min.peek()){
            min.push(x);
        }
    }

    public void pop() {
        int x = nums.pop();
        if (x == min.peek())
            min.pop();
    }

    public int top() {
        return nums.peek();
    }

    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }
}

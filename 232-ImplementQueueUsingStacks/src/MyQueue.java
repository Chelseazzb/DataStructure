import java.util.Stack;

/**
 * @ClassName : MyQueue
 * @Author : Zhai Zhibin
 * @Date : 2021/9/13 16:01
 * @Description : 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）
 * @Modified_by :
 * @Version : 1.0
 **/
class MyQueue {

    private Stack<Integer> stack1; //反向
    private Stack<Integer> stack2; //正向

    /** Initialize your data structure here. */
    public MyQueue() {
        //初始化两个栈
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) { //在插入的时候有两种情况，要考虑周全
        if (!stack1.isEmpty())
            stack1.push(x);
        else {
            while (!stack2.isEmpty()){
                int a = stack2.pop();
                stack1.push(a);
            }
            stack1.push(x);
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack1.isEmpty()){
            int a = stack1.pop();
            stack2.push(a);
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!stack1.isEmpty()){
            int a = stack1.pop();
            stack2.push(a);
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : MyStack
 * @Author : Zhai Zhibin
 * @Date : 2021/9/13 16:55
 * @Description : 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * @Modified_by :
 * @Version : 1.0
 **/
class MyStack {

    //定义队列
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        while (!queue2.isEmpty()){
            int a = queue2.remove();
            queue1.add(a);
        }
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!queue1.isEmpty()){
            int size = queue1.size();//注意，因为队列的长度在不断减小
            for (int i = 1; i < size; i++) {
                int x = queue1.remove();
                queue2.add(x);
            }
            return queue1.remove();
        } else {
            int size = queue2.size(); //注意，因为队列的长度在不断减小
            for (int j = 1; j < size; j++) {
                int x = queue2.remove();
                queue1.add(x);
            }
            return queue2.remove();
        }

    }

    /** Get the top element. */
    public int top() {
        if (!queue1.isEmpty()){
            int size = queue1.size();//注意，因为队列的长度在不断减小
            for (int i = 1; i < size; i++) {
                queue2.add(queue1.remove());
            }
            int x = queue1.remove();
            queue2.add(x);
            return x;
        } else{
            int size = queue2.size();//注意，因为队列的长度在不断减小
            for (int i = 1; i < size; i++) {
                queue1.add(queue2.remove());
            }
            int x = queue2.remove();
            queue1.add(x);
            return x;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.top(); // 返回 3
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        myStack.empty(); // 返回 False
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

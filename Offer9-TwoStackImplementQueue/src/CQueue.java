import java.util.Stack;

/**
 * @ClassName : CQueue
 * @Author : Zhai Zhibin
 * @Date : 2021/11/19 8:16
 * @Description : 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * @Modified_by :
 * @Version : 1.0
 **/
public class CQueue {

    private Stack<Integer> stack;
    private Stack<Integer> reverseStack; //作为Queue

    public CQueue() { //初始化两个栈
        stack = new Stack<>();
        reverseStack = new Stack<>();
    }

    public void appendTail(int value) {
        if (stack.isEmpty()) {
            while (!reverseStack.isEmpty()) {
                stack.push(reverseStack.pop()); //先装回stack
            }
        }
        stack.push(value); //此时保持后进先出
    }

    //懒加载，在删除的时候反转过来
    public int deleteHead() {
        if (reverseStack.isEmpty() && stack.isEmpty()) //全为空
            return -1;

        if (!reverseStack.isEmpty()){
            return reverseStack.pop();
        } else { //还未进行反转
            while (!stack.isEmpty()) {
                reverseStack.push(stack.pop());
            }
            return reverseStack.pop();
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
    }
}

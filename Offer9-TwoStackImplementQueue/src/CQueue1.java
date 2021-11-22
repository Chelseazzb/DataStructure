import java.util.Stack;

/**
 * @ClassName : CQueue1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/19 8:34
 * @Description : 优化添加和删除，保持两边的stack
 * @Modified_by :
 * @Version : 1.0
 **/
public class CQueue1 {
    //两个栈，一个出栈，一个入栈
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue1() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value); //不用考虑是否为空的情况，直接加入就行
    }

    public int deleteHead() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }

    public static void main(String[] args) {
        CQueue1 cQueue1 = new CQueue1();
        System.out.println(cQueue1.deleteHead());
        cQueue1.appendTail(5);
        cQueue1.appendTail(2);
        System.out.println(cQueue1.deleteHead());
    }
}

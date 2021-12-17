import java.util.LinkedList;
import java.util.List;

//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
class MinStack {

    /**
     * initialize your data structure here.
     */
    //各函数的调用总次数不超过 20000 次
    //底层存储使用动态数组
    private List<Integer> list;
    private int min;
    private int size;

    public MinStack() {
        list = new LinkedList<>(); //初始化
        size = 0;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        //维护最小值
        list.add(x);
        size ++;
        if (x < min)
            min = x;
    }

    public void pop() {
        //判断边界条件
        if (size < 1)
            return;
        int remove = list.remove(size - 1);
        size --; //维护数量
        //维护最小值
        if (remove == min){
            if (size == 0)
                min = Integer.MAX_VALUE;
            else {
                min = list.get(0);
                for (int i = 1; i < size; i++) {
                    if (list.get(i) < min)
                        min = list.get(i);
                }
            }

        }
    }

    public int top() {
        return list.get(size-1);
    }

    public int min() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }
}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */


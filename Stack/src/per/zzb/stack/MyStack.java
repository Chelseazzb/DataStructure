package per.zzb.stack;

/**
 * @ClassName : MyStack
 * @Author : Zhai Zhibin
 * @Date : 2020/10/7 8:19
 * @Description : 通过实现stack接口中的方法，完成一个栈的实现
 * @Modified_by :
 * @Version : 1.0
 **/
public class MyStack<E> implements Stack<E> { //两个泛型的E都要注明，否则参数会报错

    private MyArray<E> stack; //直接声明一个数组栈

    //有参构造函数
    public MyStack(int capacity){
        stack = new MyArray<>(capacity);
    }

    //无参构造函数
    public MyStack(){
        this(10);
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public E pop() {
        return stack.removeLast();
    }

    @Override
    public void push(E e) {
        stack.addLast(e);
    }


    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public E peek() {
        return stack.getLast();
    }

    //获取栈的最大容量
    public int getCapacity(){
        return stack.getCapacity();
    }

    //重写toString函数
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Stack size is %d , capacity is %d \n",stack.getSize(), stack.getCapacity()));
        res.append("[");
        for (int i = 0 ; i < stack.getSize() ; i ++){
            res.append(stack.get(i));
            if (i != stack.getSize()-1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}

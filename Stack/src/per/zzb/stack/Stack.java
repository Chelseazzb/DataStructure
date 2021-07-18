package per.zzb.stack;

//做成Stack的接口，一共包括五个接口
public interface Stack<E> {

    int getSize();  //获取数组容量

    E pop(); //弹出栈顶元素

    void push(E e); //向栈中加入元素

    boolean isEmpty(); //检查栈是否为空

    E peek(); //查看栈顶元素
}

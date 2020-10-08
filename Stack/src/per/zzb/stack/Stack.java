package per.zzb.stack;

//做成Stack的接口，一共包括五个接口
public interface Stack<E> {

    int getSize();

    E pop();

    void push(E e);

    boolean isEmpty();

    E peek(); //查看栈顶元素
}

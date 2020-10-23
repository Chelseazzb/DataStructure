package per.zzb.queue;

//队列的接口，包括五个方法
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}

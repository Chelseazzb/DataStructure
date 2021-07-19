package per.zzb.queue;


import java.util.Arrays;

/**
 * @ClassName : LoopQueue
 * @Author : Zhai Zhibin
 * @Date : 2020/10/23 16:22
 * @Description : ToDo
 * @Modified_by :
 * @Description : 循环队列
 * @Modified_by : zzb
 * @Version : 1.0
 **/
public class LoopQueue<E> implements Queue<E> {

    //定义动态队列及相关参数
    private E[] data;
    private int front;
    private int tail;
    private int size; //队列的长度

    //无参构造
    public LoopQueue() {
        data = (E[]) new Object[10];
        front = 0;
        tail = 0;
        size = 0;
    }

    //有参构造
    public LoopQueue(int capacity) {
        //因为浪费一个位置来判断队满
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        // 判断循环队列是否已满
        if ((tail + 1) % data.length == front) {
            //进行扩容操作
            resize(2 * getCapacity() + 1);
        }

        data[tail] = e;
        //队列长度加1
        tail = (tail + 1) % data.length;
        size++;

    }

    //对循环队列进行扩容操作
    private void resize(int newCapacity) {
        //创建一个新的数组
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty! Cannot dequeue!");
        }

        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2 + 1);
        }
        return result;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty! Cannot get the first element!");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue : Size is %d , Capacity is %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    private int getCapacity() {
        return data.length - 1;
    }
}
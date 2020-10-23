package per.zzb.queue;

/**
 * @ClassName : ArrayQueue
 * @Author : Zhai Zhibin
 * @Date : 2020/10/23 16:07
 * @Description : 使用动态数组实现队列接口
 * @Modified_by :
 * @Version : 1.0
 **/
public class ArrayQueue<E> implements Queue<E> {

    //建立私有属性，动态数组
    private MyArray<E> myArray;

    //构造方法
    public ArrayQueue(int capacity){
        myArray = new MyArray<>(capacity);
    }

    //默认构造方法
    public ArrayQueue(){
        myArray = new MyArray<>(10);
    }

    @Override
    public void enqueue(E e) {
        myArray.addLast(e);
    }

    @Override
    public E dequeue() {
        E e = myArray.removeFirst();
        return e;
    }

    @Override
    public E getFront() {
        return myArray.getFirst();
    }

    @Override
    public int getSize() {
        return myArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return myArray.isEmpty();
    }

    public int getCapacity(){
        return myArray.getCapacity();
    }

    //重写toString函数
    @Override
    public String toString(){
        StringBuilder res =new StringBuilder();
        res.append(String.format("Size is %d , Capacity is %d\n", myArray.getSize(),myArray.getCapacity()));
        res.append("head [");
        for (int i = 0 ; i < myArray.getSize() ; i ++){
            res.append(myArray.get(i));
            if (i != myArray.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}

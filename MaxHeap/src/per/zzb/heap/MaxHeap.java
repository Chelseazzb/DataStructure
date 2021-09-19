package per.zzb.heap;

/**
 * @ClassName : MaxHeap
 * @Author : Zhai Zhibin
 * @Date : 2021/8/16 10:18
 * @Description : 最大堆的实现类
 * @Modified_by :
 * @Version : 1.0
 **/
public class MaxHeap<E extends Comparable<E>> {

    //下标是从0开始的
    private MyArray<E> data;

    public MaxHeap() {
        data = new MyArray();
    }

    public MaxHeap(int capacity) {
        data = new MyArray(capacity);
    }

    public MaxHeap(E[] arr) {
        data = new MyArray<>(arr);

        if (arr.length != 1){
            for (int i = parent(arr.length-1) ; i >= 0; i --){
                siftDown(i);
            }
        }

    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int getSize() {
        return data.getSize();
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {

        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(parent(index), index);
            index = parent(index);
        }
    }

    //找到任一节点的父亲节点
    public int parent(int index) {
        if (index == 0) {
            System.out.println("已经到达堆顶，没有父亲节点");
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }

        return (index - 1) / 2;
    }

    //找到任一节点的左孩子节点
    public int leftChild(int index) {
        return index * 2 + 1;
    }

    //找到任一节点的右孩子节点
    public int rightChild(int index) {
        return index * 2 + 2;
    }

    //找到堆中的最大值
    public E findMax() {
        //最大堆，第一个元素是最大的
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    //去取出堆中的最大值，并且将最后一个元素放在第一个元素，并siftDown
    public E extractMax() {
        E ret = findMax();

        //取出第一个元素，并将最后一个元素拿上来
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    //堆中元素下沉操作
    private void siftDown(int index) {

        //比较左右孩子中大的那个交换位置
        while (leftChild(index) <= data.getSize() - 1) {
            int j = leftChild(index);
            //右孩子的值比左边大
            if (j + 1 <= data.getSize() - 1 && data.get(j).compareTo(data.get(j + 1)) < 0) {
                j++;
            }

            if (data.get(index).compareTo(data.get(j)) > 0)
                break;

            //交换位置，继续siftDown
            data.swap(index, j);
            index = j;
        }
    }

    //替换堆顶元素
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);

        return ret;
    }

}

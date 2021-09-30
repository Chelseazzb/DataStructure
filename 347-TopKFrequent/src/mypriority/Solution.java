package mypriority;

import java.util.TreeMap;

/**
 * @ClassName : mypriority.Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/8/19 10:44
 * @Description : 347.前 K 个高频元素
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    public class MyArray<E> {
        private E[] data; //静态数组
        private int size; //数组的长度

        /**
         * @Author Zhai Zhibin
         * @Description 有参构造函数
         * @Date 2020/9/28 22:55
         * @MethodName MyArray
         * @Param [capacity]
         * @Return
         **/
        public MyArray(int capacity) {
            data = (E[]) new Object[capacity];
            size = 0;
        }

        //无参构造函数，默认开辟10的空间
        public MyArray() {
            this(10);
        }

        public MyArray(E[] arr) {
            this(arr.length);
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            size = arr.length;
        }

        //获得数组的当前长度
        public int getSize() {
            return size;
        }

        //判断数组长度是否为空
        public boolean isEmpty() {
            return size == 0;
        }

        //获取数组的容量
        public int getCapacity() {
            return data.length;
        }

        /**
         * @Author Zhai Zhibin
         * @Description 可以使用add函数对addLast进行改造，复用
         * @Date 2020/9/29 8:08
         * @MethodName addLast
         * @Param [e]
         * @Return void
         **/
        public void addLast(E e) {
//        if (size == data.length){
//            throw new IllegalArgumentException("addLast failed, array is full");
//        }
//
//        data[size] = e;
//        size ++;

            add(size, e); //函数复用
        }

        /**
         * @Author Zhai Zhibin
         * @Description 向数组中添加元素
         * @Date 2020/9/29 8:16
         * @MethodName add
         * @Param [index, e]
         * @Return void
         **/
        public void add(int index, E e) {
            if (index < 0 || index > data.length) { //判断索引值大小
                throw new IllegalArgumentException("add failed, argument is not allowed");
            }

            if (size == data.length) { //判断数组是否已满
//            throw new IllegalArgumentException("add failed, array is full");
                resize(2 * data.length);
            }

            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i]; //index之后的每个元素向后移动一位
            }

            data[index] = e; //用新的值覆盖掉原来的值
            size++; //数组的长度加1
        }

        //动态数组扩容
        private void resize(int newCapacity) {
            E[] newData = (E[]) new Object[newCapacity];

            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }


        //向数组中的第一个位置添加元素
        public void addFirst(E e) {
            add(0, e); //函数复用
        }

        //获得数组中指定位置的元素
        public E get(int index) {
            if (index < 0 || index >= data.length)
                throw new IllegalArgumentException("get failed, argument is not allowed");

            return data[index];
        }

        //修改数组中指定位置的元素
        public void set(int index, E e) {
            if (index < 0 || index >= data.length)
                throw new IllegalArgumentException("set failed, argument is not allowed");

            data[index] = e;
        }

        //查看数组中是否存在该元素以及存在的数量
        public int contain(E e) {
            int count = 0;

            for (int i = 0; i < size; i++) {
                if (e == data[i])
                    count++;
            }

            return count; //0代表没有
        }

        //查找元素的第一个位置
        public int find(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return i;
                }
            }
            return -1; //代表没找到该元素
        }

        //查找数组中所有值为e的位置
        public String findAll(E e) {
            String position = ""; //所有位置的字符串

            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    position += i;
                    position += ",";
                }
            }
            //去掉字符串最后的,
            return position.substring(0, position.length() - 1);
        }

        //删除数组中的元素
        public E remove(int index) {
            if (index < 0 || index >= data.length)
                throw new IllegalArgumentException("get failed, argument is not allowed");

            E deleteElement = data[index];
            for (int i = index+1 ; i < size; i++) {
                data[i -1] = data[i];
            }

            size--;
            if (size == getCapacity() / 4 && getCapacity() / 2 != 0) { //注意这里的小bug
                resize(getCapacity() / 2);
            }
            data[size] = null; //
            return deleteElement;
        }

        //删除数组中第一个元素
        public E removeFirst() {
            return remove(0);
        }

        //删除数组中最后一个元素
        public E removeLast() {
            return remove(size - 1);
        }

        //删除数组中指定元素的值第一个位置
        public E removeElement(E e) {
            int index = find(e);
            return remove(index);
        }

        //删除数组中所有值为e的元素
        public void removeAllElement(E e) {
            String position;
            position = findAll(e);

            String[] split = position.split(",");

            //考虑到每次删完一个元素都会向前移动，所以之前的位置也要变化!!!
            for (int i = 0; i < split.length; i++) {
                remove(Integer.parseInt(split[i]) - i);
            }
        }


        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append(String.format("data size is %d, capacity is %d\n", size, data.length));
            res.append("[");
            for (int i = 0; i < size; i++) {

                res.append(data[i]); //向字符串里添加的不是index而是element！！！
                if (i != size - 1) {
                    res.append(", ");
                }
            }
            res.append("]");

            return res.toString();
        }

        //交换i和j两个位置的值
        public void swap(int i, int j) {

            E temp = data[j];
            data[j] = data[i];
            data[i] = temp;
        }
    }

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


    //队列的接口，包括五个方法
    private interface Queue<E> {

        void enqueue(E e);

        E dequeue();

        E getFront();

        int getSize();

        boolean isEmpty();
    }

    public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

        private MaxHeap<E> maxHeap;

        public PriorityQueue(){
            maxHeap = new MaxHeap<>();
        }

        @Override
        public void enqueue(E e) {
            maxHeap.add(e);
        }

        @Override
        public E dequeue() {
            return maxHeap.extractMax();
        }

        @Override
        public E getFront() {
            return maxHeap.findMax();
        }

        @Override
        public int getSize() {
            return maxHeap.getSize();
        }

        @Override
        public boolean isEmpty() {
            return maxHeap.isEmpty();
        }
    }

    private class Freq implements Comparable<Freq> {
        public int v;
        public int f;

        public Freq(){}

        public Freq(int v,int f){
            this.v = v;
            this.f = f;
        }

        @Override
        public int compareTo(Freq another) { //因为使用的是自己实现的最大堆，但是此题需要最小的频率在堆顶，所以比较只需要反过来
            if (this.f < another.f)
                return 1;
            else if(this.f > another.f)
                return -1;
            else
                return 0;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        //第一步，计算nums中元素的频率
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num,1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        //第二步，将频率高的前k个元素放到优先队列中中
        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (int key : map.keySet()){

            //需要判断queue中元素个数是否已经到达k个
            if (queue.getSize() < k){
                queue.enqueue(new Freq(key,map.get(key)));
            } else if (map.get(key) > queue.getFront().f){ //如果后来的key的频率比前k个中最小的大
                //先出队，再入队
                queue.dequeue();
                queue.enqueue(new Freq(key,map.get(key)));
            }

        }


        //第三步，将最大堆中的前k个元素一个个取出
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.dequeue().v;
        }

        return res;
    }
}

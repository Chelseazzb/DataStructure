package per.zzb.array;


/**
 * @ClassName : MyArray
 * @Author : Zhai Zhibin
 * @Date : 2020/9/28 22:52
 * @Description : 自定义数组
 * @Modified_by : zzb，改为泛型数组
 * @Version : 2.0
 **/
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
    public MyArray(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    //无参构造函数，默认开辟10的空间
    public MyArray(){
        this(10);
    }

    //获得数组的长度
    public int getSize(){
        return size;
    }

    //判断数组长度是否为空
    public boolean isEmpty(){
        return size == 0 ;
    }

    //获取数组的容量
    public int getCapacity(){
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
    public void addLast(E e){
//        if (size == data.length){
//            throw new IllegalArgumentException("addLast failed, array is full");
//        }
//
//        data[size] = e;
//        size ++;

        add(size,e); //函数复用
    }

    /**
     * @Author Zhai Zhibin
     * @Description 向数组中添加元素
     * @Date 2020/9/29 8:16
     * @MethodName add
     * @Param [index, e]
     * @Return void
     **/
    public void add(int index, E e){
        if (index < 0 || index >= data.length){ //判断索引值大小
            throw new IllegalArgumentException("add failed, argument is not allowed");
        }

        if (size == data.length){ //判断数组是否已满
//            throw new IllegalArgumentException("add failed, array is full");
            resize(2 * data.length);
        }

        for (int i = size - 1 ; i >= index ; i --){
            data[i + 1] = data[i]; //index之后的每个元素向后移动一位
        }

        data[index] = e; //用新的值覆盖掉原来的值
        size ++; //数组的长度加1
    }

    //动态数组扩容
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];

        for (int i = 0 ; i < size ; i ++){
            newData[i] = data[i];
        }
        data = newData;
    }


    //向数组中的第一个位置添加元素
    public void addFirst(E e){
        add(0,e); //函数复用
    }

    //获得数组中指定位置的元素
    public E get(int index){
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("get failed, argument is not allowed");

        return data[index];
    }

    //修改数组中指定位置的元素
    public void set(int index, E e){
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("set failed, argument is not allowed");

        data[index] = e;
    }

    //查看数组中是否存在该元素以及存在的数量
    public int contain(E e){
        int count = 0;

        for(int i = 0 ; i < size ; i ++){
            if (e == data[i])
                count ++;
        }

        return count; //0代表没有
    }

    //查找元素的位置
    public int find(E e){
        for (int i = 0 ; i < size ; i ++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1; //代表没找到该元素
    }

    //查找数组中所有值为e的位置
    public String findAll(E e){
       String position = ""; //所有位置的字符串

        for (int i = 0 ; i < size ; i ++){
            if (data[i].equals(e)){
                position += i;
                position +=",";
            }
        }
        return position;
    }

    //删除数组中的元素
    public E remove(int index){
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("get failed, argument is not allowed");

        E deleteElement = data[index];
        for (int i = index ; i < size ; i ++){
            data[i] = data[i + 1];
        }

        size --;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) { //注意这里的小bug
            resize(getCapacity() / 2);
        }
        data[size] = null; //
        return deleteElement;
    }

    //删除数组中第一个元素
    public E removeFirst(){
        return remove(0);
    }

    //删除数组中最后一个元素
    public E removeLast(){
        return remove(size - 1);
    }

    //删除数组中指定元素的值第一个位置
    public E removeElement(E e){
        int index = find(e);
        return remove(index);
    }

    //删除数组中所有值为e的元素
    public void removeAllElement(E e){
        String position;
        position = findAll(e);

        String[] split = position.split(",");

        //考虑到每次删完一个元素都会向前移动，所以之前的位置也要变化!!!
        for (int i = 0 ; i < split.length ; i ++) {
            remove(Integer.parseInt(split[i]) - i);
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("data size is %d, capacity is %d\n",size,data.length));
        res.append("[");
        for (int i = 0 ; i < size ; i ++){

            res.append(data[i]); //向字符串里添加的不是index而是element！！！
            if (i != size - 1){
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }
}

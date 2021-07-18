package per.zzb.link;

/**
 * @ClassName : LinkedList
 * @Author : Zhai Zhibin
 * @Date : 2021/7/17 22:53
 * @Description : 链表的实现类
 * @Modified_by :
 * @Version : 1.0
 **/
public class LinkedList<E> {

    // 定义内部类，链表的节点
    private class Node {
        private E e;
        private Node next;

        public Node(){
            this(null,null);
        }

        public Node(E value){
            this.e = value;
            this.next = null;
        }

        public Node(E value,Node next){
            this.e = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    //定义头结点和链表长度
    private Node dummyHead;
    private int size;

    //判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //获得链表的长度
    public int getSize() {
        return size;
    }

    //增加链表中的元素

    //删除链表中的元素

    //修改链表中的元素

    //查询链表中的元素

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        return res.toString();
    }
}

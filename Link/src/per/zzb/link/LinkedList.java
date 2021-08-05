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

        public Node() {
            this(null, null);
        }

        public Node(E value) {
            this.e = value;
            this.next = null;
        }

        public Node(E value, Node next) {
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

    //构造函数
    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //获得链表的长度
    public int getSize() {
        return size;
    }

    //判断链表是否包含元素e
    public boolean contain(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //增加链表中的元素
    public void add(int index, E e) {

        Node prev = dummyHead;

        //判断异常情况
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is out of Link size !");
        }

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node cur = new Node(e);
        cur.next = prev.next;
        prev.next = cur;

        //增加链表长度
        size++;
    }

    //在链表头插入元素
    public void addFirst(E e) {
        add(0, e);
    }

    //在链表最后插入元素
    public void addLast(E e) {
        add(size, e);
    }

    //删除链表中的元素
    public void delete(int index) {
        E oldValue = get(index);
        System.out.printf("链表中第%d个位置的元素是：" + oldValue + "\n", index + 1);

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node cur = prev.next;
        prev.next = cur.next;
        cur = null;

        size--;
    }

    //删除链表的头元素
    public void deleteFirst() {
        delete(0);
    }

    //删除链表的头元素
    public void deleteLast() {
        delete(size - 1);
    }

    //删除链表中的特定元素
    public void remove(E e) {
        if (isEmpty()) {
            System.out.println("链表为空，无法删除！");
            return;
        }

        Node prev = dummyHead; //记录删除的前一个节点
        Node cur = dummyHead.next;
        while (cur != null) {

            if (e.equals(cur.e)) //cur就是要删除的节点
                break;
            else{
                prev = prev.next;
                cur = cur.next;
            }
        }

        //删除cur
        prev.next = cur.next;
        cur.next = null;
        size --;

    }

    //修改链表中的元素
    public void update(int index, E e) {
        E oldValue = get(index);
        System.out.printf("链表中第%d个位置修改前的元素是：" + oldValue + "\n", index + 1);

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    //查询链表中的元素
    public E get(int index) {

        //判断异常情况
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is out of Link size !");
        }

        //判断链表是否为空
        if (isEmpty()) {
            return null;
        }

        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    //查询链表头元素
    public E getFirst() {
        return get(0);
    }

    //查询链表尾部元素
    public E getLast() {
        return get(size - 1);
    }

    //遍历链表
    public void traverse() {

        Node cur = dummyHead.next;
        System.out.print("Head -> ");
        //设置链表为空的输出情况
        if (isEmpty()) {
            System.out.print("null");
        }
        //遍历链表
        while (cur != null) {
            System.out.print(cur + " -> ");
            if (cur.next == null) {
                System.out.print("null\n");
            }
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        //遍历链表
        while (cur != null) {
            res.append(cur + " -> ");
            if (cur.next == null) {
                res.append("null\n");
            }
            cur = cur.next;
        }

        return res.toString();
    }
}

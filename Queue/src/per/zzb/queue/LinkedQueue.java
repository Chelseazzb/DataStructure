package per.zzb.queue;

/**
 * @ClassName : LinkedQueue
 * @Author : Zhai Zhibin
 * @Date : 2021/7/21 18:05
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
public class LinkedQueue<E> implements Queue<E> {

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
    }

    private int size;
    private Node head;
    private Node tail;

    public LinkedQueue() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public void enqueue(E e) {
        //判断队列是否为空
        if (head == null){

            head = new Node(e);
            tail = head;

        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }

        size ++;

    }

    @Override
    public E dequeue() {

        if (isEmpty()){
            throw new IllegalArgumentException("LinkedQueue is empty! Cannot dequeue");
        }

        Node delNode = head;

        head = head.next;
        size --;

        return delNode.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinkedQueue size: %d, Head: ", size));

        Node cur = head;

        //遍历队列
        while (cur != null){

            res.append(cur.e + " -> ");
            cur = cur.next;
        }

        res.append("null");

        return res.toString();
    }
}

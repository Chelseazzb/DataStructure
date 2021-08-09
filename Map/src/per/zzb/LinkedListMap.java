package per.zzb;

//使用链表实现的映射类
public class LinkedListMap<K extends Comparable, V> implements Map<K, V> {

    // 定义内部类，链表的节点
    private class Node {
        private K k; //key
        private V v; //value
        private Node next;

        public Node() {
            this(null, null, null);
        }

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.next = null;
        }

        public Node(K k, V v, Node next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Key:"+k.toString()+"Value:"+v.toString()+" ";
        }
    }

    //定义头结点和链表长度
    private Node dummyHead;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(K k) {
        return get(k) != null ? true : false;
    }

    @Override
    public void add(K k, V v) {
        if (contains(k)){
            System.out.println("Key: "+k.toString()+"在map中已经存在！");
            return;
        }

        dummyHead.next = new Node(k,v,dummyHead.next);
        size ++;
    }

    @Override
    public void set(K k, V v) {

        if (isEmpty()){
            System.out.println("链表为空，无法修改！");
            return;
        }

        Node cur = dummyHead.next;
        //遍历链表
        while (cur != null){
            if (k.equals(cur.k)){
                System.out.println("Key为"+k.toString()+"的值为"+v.toString());
                cur.v = v;
                break;
            }
            cur = cur.next;
        }
    }

    @Override
    public void remove(K k) {
        if (isEmpty()){
            System.out.println("链表为空，无法删除！");
            return;
        }

        Node prev = dummyHead;
        Node cur = dummyHead.next;
        while (cur != null){
            if (k.equals(cur.k)){
                prev.next = cur.next;
                size --;
                cur.next = null;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
    }

    @Override
    public V get(K k) {

        if (isEmpty()){
            return null;
        }

        Node cur = dummyHead.next;
        //遍历链表
        while (cur != null){
            if (k.equals(cur.k)){
                return cur.v;
            }
            cur = cur.next;
        }

        return null;
    }

    @Override
    public String toString() {
        return "LinkedListMap{}";
    }
}

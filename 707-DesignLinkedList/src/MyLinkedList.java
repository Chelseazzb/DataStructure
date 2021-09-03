//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。
// val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
// 假设链表中的所有节点都是 0-index 的。

//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//        linkedList.get(1);            //返回2
//        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//        linkedList.get(1);            //返回3

class MyLinkedList {

    //使用双链表实现
    private class Node {

        private int value;
        private Node prev;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    //定义头结点和size
    private Node head;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new Node(-1); //使用虚拟头结点
        head.next = null;
        head.prev = null;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index > size - 1)
            return -1;

        Node cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;

        Node cur = head;
        Node newNode = new Node(val); //新添加的节点
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        //如果是在最后一个节点添加
        if (index == size) {
            newNode.next = null;
            newNode.prev = cur;
            cur.next = newNode;
        }

        //添加节点
        newNode.prev = cur;
        newNode.next = cur.next;
        cur.next.prev = newNode;
        cur.next = newNode;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size -1 || size == 0)
            return;

        //如果删除的是第一个节点
        if (index == 0){
            head.next = head.next.next;
            head.next.prev = head;
            size --;
            return;
        }


        Node cur = head;
        for (int i = 0; i < index; i++) { //找到删除的节点的prev
            cur = cur.next;
        }

        //如果删除的是最后一个节点
        if (index == size -1){
            cur.next = null;
            size --;
            return;
        }

        //删除节点
        cur.next = cur.next.next;
        cur.next.prev = cur;
        size --;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

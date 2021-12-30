import java.util.HashMap;
import java.util.Map;

//剑指Offer上的思路3：在原链表上拼接
public class Solution1 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //-10000 <= Node.val <= 10000
    //Node.random 为空（null）或指向链表中的节点。
    //节点数目不超过 1000 。
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        buildNewList(head);
        buildRandomNode(head);
        return getClonedList(head);
    }

    //在原链表的基础上原地构建新链表，将新节点一个个接在原节点的后面
    private void buildNewList(Node head){
        Node cur = head;

        //将新节点一个个接在原节点后面
        while (cur != null) {
            Node newNode = new Node(cur.val);
            Node next = cur.next;
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }
    }

    //构建新节点的random节点
    private void buildRandomNode(Node head){
        Node old = head;

        while (old != null){
            Node newNode = old.next;
            if (old.random != null) //本身就为空的话就保持默认值
                newNode.random = old.random.next;
            old = newNode.next;
        }
    }

    //从新链表中提取出克隆的链表，偶数是新链表，需要用next连接起来
    private Node getClonedList(Node head){
        Node oldNode = head;
        Node cloneHead = head.next;
        Node cloneNode = head.next;

        oldNode.next = cloneNode.next; //跳过新节点就是原来的next节点
        oldNode = oldNode.next;

        while (oldNode != null){
            cloneNode.next = oldNode.next;
            cloneNode = cloneNode.next;
            oldNode.next = cloneNode.next;
            oldNode = oldNode.next;
        }

        return cloneHead;
    }
}

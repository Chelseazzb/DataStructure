//使用带头节点的链表来实现删除
public class Solution2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);  //新建虚拟头结点
        dummyHead.next = head;

        //设置两个指针指向dummyhead.next
        ListNode slow = dummyHead;
        ListNode fast = dummyHead.next;

        for (int i = 0; i < n; i++) {
            //让fast往前走n个节点
            fast = fast.next;
        }

        //两个节点同时往前走，当fast为空时，slow的下一个节点就是要删除的节点
        while (fast != null){
          slow = slow.next;
          fast = fast.next;
        }

        slow.next = slow.next.next;


        return dummyHead.next;

    }

}

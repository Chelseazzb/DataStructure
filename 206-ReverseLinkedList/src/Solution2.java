public class Solution2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {

        //判断边界条件
        if (head == null)
            return head;

        return recursionReverse(null,head);

    }

    private ListNode recursionReverse(ListNode prev, ListNode cur) {
        //递归终止条件
        if (cur == null){
            return prev;
        }

        ListNode next = cur.next;
        cur.next = prev;

        return recursionReverse(cur,next);

    }
}

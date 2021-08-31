/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

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

        //记录当前节点
        ListNode cur = head;
        int count = 0;

        while (cur != null) {
            count++;
            cur = cur.next;
        }

        if (n > count)
            throw new IllegalArgumentException("n is too large");

        //判断边界条件
//        if (count == 1 && n == 1){
//            head = null;
//            return head;
//        }

        //计算找到前一个节点的长度
        int index = count - n;

        //判断删除的是头结点
        if (index == 0){
            head = head.next;
            return head;
        }

        ListNode prev = head;
        while (index > 1){
            prev = prev.next;
            index --;
        }

        //删除节点
        cur = prev.next;
        if (cur == null) //判断删除的是最后一个元素
            prev.next = null;
        else {
            prev.next = cur.next;
            cur = null;
        }

        return head;
    }
}

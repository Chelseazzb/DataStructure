//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //0 <= 链表长度 <= 1000
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //1、边界条件
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null && l2 != null)
            return l2;
        if (l2 == null && l1 != null)
            return l1;

        ListNode dummyHead = new ListNode(0); //虚拟头结点
        ListNode cur = dummyHead;
        //遍历两个链表
        while (l1 != null && l2 != null){
          if (l1.val <= l2.val){
            cur.next = l1;
            l1 = l1.next;
          } else {
              cur.next = l2;
              l2 = l2.next;
          }
          cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;

        return dummyHead.next;
    }
}

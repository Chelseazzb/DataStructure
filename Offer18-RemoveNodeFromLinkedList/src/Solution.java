
//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//
//返回删除后的链表的头节点。

import java.util.List;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        //判断边界条件
        if (head == null)
            return null;
        if (head.val == val){
            head = head.next;
            return head;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode cur = head;

        while (cur != null){
            if (cur.val == val)
                break;
            pre = pre.next;
            cur = cur.next;
        }

        pre.next = cur.next;
        cur = null;

        return head;
    }

}

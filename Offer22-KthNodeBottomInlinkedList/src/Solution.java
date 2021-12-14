import java.util.List;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/15 20:20
 * @Description : 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    //链表结点
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //双指针法
    public ListNode getKthFromEnd(ListNode head, int k) {

        //1、判断边界条件
        if (head == null)
            return null;
        if (k <= 0)
            return null;

        ListNode first = head;
        ListNode behind = null;

        for (int i = 0; i < k ; i++) {
            first = first.next; //先走k步
        }

        behind = head;
        while (first != null){ //first走到尾，和behind相差k步
            first = first.next;
            behind = behind.next;
        }

        return behind;
    }
}

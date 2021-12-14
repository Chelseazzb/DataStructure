import java.util.List;

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //0 <= 节点个数 <= 5000
    public ListNode reverseList(ListNode head) {
        //1、判断边界条件
        if (head == null)
            return head;

        //使用双指针法
        ListNode behind = null;
        ListNode fast = head;
        while (fast != null){
            ListNode next = fast.next; //先记录下一个节点，顺序遍历
            fast.next = behind;
            behind = fast;
            fast = next;
        }

        return behind;
    }
}

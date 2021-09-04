//使用快慢指针
public class Solution1 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        int count = 1;

        //设置死循环（制造两次相遇）
        //设环中b个节点,环前a个节点
        // f = 2s , f = s + nb => s = nb, 入口= a + nb
        while (true) {
            if (fast == null || fast.next == null)
                return null; //走出了链表，无环

            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                //第一次相遇
                fast = head;
                //fast回到起点再和slow一起走a步
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }

        }

    }
}

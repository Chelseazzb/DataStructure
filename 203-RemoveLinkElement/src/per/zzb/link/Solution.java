package per.zzb.link;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/7/21 22:40
 * @Description : 力扣203题——移除链表元素
 * @Modified_by :
 * @Version : 1.0
 **/

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

public class Solution {


    public ListNode removeElements(ListNode head, int val) {

        //找到当前元素的前一个元素
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null){
            if (head.val == val){
                head = head.next;
                cur = head;
            } else {
                //遍历下一个元素
                if (cur.next == null){
                    break;
                }else {
                    prev = cur;
                    cur = cur.next;
                    if (cur.val == val){
                        prev.next = cur.next;
                        cur = prev;
                    }
                }
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,6,4,5,6};
        int e = 6;

         ListNode head = new ListNode();
         head.createList(arr);

        System.out.println(head);

        new Solution2().removeRecursion(head,e,0);
        System.out.println(head);
    }

}

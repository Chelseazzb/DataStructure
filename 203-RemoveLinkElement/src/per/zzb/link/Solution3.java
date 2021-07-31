package per.zzb.link;

/**
 * @ClassName : Solution3
 * @Author : Zhai Zhibin
 * @Date : 2021/7/22 22:30
 * @Description : 使用虚拟头结点的解决方案
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }
}

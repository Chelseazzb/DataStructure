package per.zzb.link;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/7/22 22:17
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    public ListNode removeElements(ListNode head, int val) {

        while (head!=null && head.val == val){
                head = head.next;
        }

        if (head == null){
            return null; //判断边界值
        }

        //需要一个元素辅助删除，记录删除的前一个元素
        ListNode prev = head;

        while (prev.next != null){

            if (prev.next.val == val){
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }
}

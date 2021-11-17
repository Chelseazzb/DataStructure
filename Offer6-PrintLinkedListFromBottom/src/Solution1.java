import java.util.Collection;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/17 14:43
 * @Description : 不额外使用存储，两次遍历
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {

        ListNode cur = head;
        int count = 0;

        while (cur != null){
            count ++; //计数一共多少个节点
            cur = cur.next;
        }

        int[] result = new int[count];
        cur = head;
        //再次遍历cur，倒着给数组赋值
        while (cur != null){
            result[--count] = cur.val;
            cur = cur.next;
        }
        return result;
    }
}

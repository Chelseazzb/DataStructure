public class Solution1 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //使用递归方法
    public ListNode reverseList(ListNode head) {
        return reverseList(head,null);
    }

    //递归函数，当前节点和前一个节点
    private ListNode reverseList(ListNode cur, ListNode pre) {
        //1、递归终止条件
        if (cur == null) return pre; //遍历到了最后
        ListNode ret = reverseList(cur.next,cur); //继续递归遍历
        //3、单层递归处理
        cur.next = pre;
        return ret;
    }
}

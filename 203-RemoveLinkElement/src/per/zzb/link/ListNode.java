package per.zzb.link;

/**
 * @ClassName : ListNode
 * @Author : Zhai Zhibin
 * @Date : 2021/7/22 22:13
 * @Description : 链表数据结构定义
 * @Modified_by :
 * @Version : 1.0
 **/

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    //利用数组创建链表
    public ListNode createList(int[] arr){
        ListNode cur = this;
        for (int i = 0 ; i < arr.length ; i ++){
            if (i == 0){
                this.val = arr[i];
//                this.next = cur;
            } else {
                cur.next = new ListNode(arr[i]);
                System.out.println(cur);
                cur = cur.next;

            }
        }

        return this;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("List Head : " + this.val + "->");
        ListNode cur = this;
        while (cur.next != null){
            res.append(cur.next.val + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}

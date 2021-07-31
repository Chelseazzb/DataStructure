package per.zzb.link;

/**
 * @ClassName : Solution2
 * @Author : Zhai Zhibin
 * @Date : 2021/7/24 9:32
 * @Description : 使用递归来解决移除元素问题
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        //设置递归终止条件
        if (head == null ){
            return null;
        }

        ListNode res = removeElements(head.next,val);

        if (head.val == val){
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    //利用递归来研究调用内部机制
    public ListNode removeRecursion(ListNode head, int val, int depth) {
        
        String depthString = recursionDepth(depth);

        System.out.print(depthString);
        System.out.println("Call Remove "+ val + " in : "+ head);

        //设置递归终止条件
        if (head == null ){
            System.out.print(depthString);
            System.out.println("Return : "+ head);
            return null;
        }

        ListNode res = removeRecursion(head.next,val, depth+1);
        System.out.print(depthString);
        System.out.println("After remove " + val +  ": " + res);

        ListNode ret ;
        if (head.val == val){
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("Return : "+ ret);
        return ret;
    }

    private String recursionDepth(int depth) {

        StringBuilder res = new StringBuilder();

        for (int i = 0; i <= depth; i++) {
            res.append("--");
        }

        return res.toString();
    }
}

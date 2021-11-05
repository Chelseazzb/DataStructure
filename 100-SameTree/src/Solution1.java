import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/5 9:02
 * @Description : 使用迭代法
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    //树结点的定义
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //判断边界条件
        if (p == null && q == null)
            return true;
        else if (p == null && q != null)
            return false;
        else if (p != null && q == null)
            return false;

        if (p.val != q.val)
            return false;

        //使用两个队列辅助完成
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(p);
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.size() != queue2.size()) {
                return false;
            } else {
                int size = queue1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode q1 = queue1.poll();
                    TreeNode q2 = queue2.poll();

                    if (q1 == null && q2 == null)
                        continue;
                    else if (q1 == null && q2 != null)
                        return false;
                    else if (q1 != null && q2 == null)
                        return false;

                    if (q1.val != q2.val)
                        return false;
                    else {
                        queue1.add(q1.left);
                        queue2.add(q2.left);
                        queue1.add(q1.right);
                        queue2.add(q2.right);
                    }
                }
            }
        }
        return true;
    }
}

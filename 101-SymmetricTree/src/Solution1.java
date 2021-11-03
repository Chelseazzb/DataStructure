import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/3 11:42
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
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        //定义队列辅助存储
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        //循环判断
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null)
                continue;

            if (left == null && right != null)
                return false;
            else if (left != null && right == null)
                return false;
            else if (left.val != right.val)
                return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }

//    public boolean isSymmetric(TreeNode root) {
//        return check(root, root);
//    }
//
//    public boolean check(TreeNode u, TreeNode v) {
//        Queue<TreeNode> q = new LinkedList<TreeNode>();
//        q.offer(u);
//        q.offer(v);
//        while (!q.isEmpty()) {
//            u = q.poll();
//            v = q.poll();
//            if (u == null && v == null) {
//                continue;
//            }
//            if ((u == null || v == null) || (u.val != v.val)) {
//                return false;
//            }
//
//            q.offer(u.left);
//            q.offer(v.right);
//
//            q.offer(u.right);
//            q.offer(v.left);
//        }
//        return true;
//    }

}

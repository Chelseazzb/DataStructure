//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //0 <= 节点个数 <= 1000
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isSymmetric(root.left,root.right);
    }

    //递归函数，判断两个节点是否对称
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        //1、递归终止条件
        if (left == null && right == null)
            return true;

        if ( (left == null && right != null) ||(right == null && left != null))
            return false;

        if (left.val == right.val)
            return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);

        return false;
    }
}

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/3 10:36
 * @Description : 给定一个二叉树，检查它是否是镜像对称的。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

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

        return isSymmetric(root.left,root.right);

    }

    //递归判断左右子树
    private boolean isSymmetric(TreeNode left,TreeNode right){
        //1、递归终止条件
        if (left == null && right != null)
            return false;
        if (right == null && left != null)
            return false;
        if (left == null && right == null)
            return true;

        //2、递归处理
        if (left.val == right.val){
            return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left); //3、递归调用
        } else {
            return false;
        }

    }
}

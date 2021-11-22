import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/10 22:00
 * @Description : 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    public static class TreeNode {
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

    //使用后序遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //1、递归终止条件
        if (root == null || root == p || root == q)
            return root;

        //单层递归逻辑，左右中
        root.left = lowestCommonAncestor(root.left,p,q);
        root.right = lowestCommonAncestor(root.right,p,q);

        ///中
        if (root.left != null && root.right != null) //找到最近的祖先节点
            return root;

        if (root.left != null && root.right == null)
            return root.left;
        else if (root.left == null && root.right != null)
            return root.right;
        else
            return null;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        new Solution().lowestCommonAncestor(root, left, right);
    }
}

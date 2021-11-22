/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/10 15:51
 * @Description : 给定二叉搜索树（BST）的根节点和一个值。你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。如果节点不存在，则返回NULL。
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

    //递归
    public TreeNode searchBST(TreeNode root, int val) {
        //1、递归终止条件
        if (root == null)
            return null;

        //中
        if (root.val == val) {
            return root;

        } else if (val < root.val) {
            return searchBST(root.left,val);

        } else {
            return searchBST(root.right,val);
        }
    }
}

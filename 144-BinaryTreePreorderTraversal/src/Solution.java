//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public class TreeNode {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalRecursion(root,list);
        return list;

    }

    private void preorderTraversalRecursion(TreeNode node, List<Integer> list) {
        //设置递归终止条件
        if (node == null)
            return;

        //单层处理语句
        list.add(node.val);
        //从左右子树，递归调用
        preorderTraversalRecursion(node.left,list);
        preorderTraversalRecursion(node.right,list);
    }
}

//给定一个二叉树，返回它的 后序 遍历。

import java.util.ArrayList;
import java.util.LinkedList;
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversalRecursion(root,list);
        return list;

    }

    private void postorderTraversalRecursion(TreeNode node, List<Integer> list) {

        //递归终止条件
        if (node == null)
            return;

        postorderTraversalRecursion(node.left,list);
        postorderTraversalRecursion(node.right,list);
        list.add(node.val);
    }
}

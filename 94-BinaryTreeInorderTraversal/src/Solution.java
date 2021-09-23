import java.util.ArrayList;
import java.util.List;

//给定一个二叉树的根节点 root，返回它的中序遍历
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalRecursion(root,list);
        return list;
    }

    private void inorderTraversalRecursion(TreeNode node, List<Integer> list) {
        //递归终止条件
        if (node == null)
            return;

        inorderTraversalRecursion(node.left,list);
        list.add(node.val);
        inorderTraversalRecursion(node.right,list);

    }
}

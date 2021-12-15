//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
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
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        return mirrorTree(root, root.left, root.right);
    }

    private TreeNode mirrorTree(TreeNode root, TreeNode left, TreeNode right) {
        //1、递归终止条件
        if (root.left == null && root.right == null)
            return root;

        //不额外存储会直接改变树的结构
        TreeNode rightChild = null;
        TreeNode leftChild = null;
        if (root.left != null) {
            rightChild = mirrorTree(root.left, root.left.left, root.left.right);
        }
        if (root.right != null) {
            leftChild = mirrorTree(root.right, root.right.left, root.right.right);
        }

        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}

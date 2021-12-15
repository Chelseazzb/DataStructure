public class Solution1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //递归简化版本
    //0 <= 节点个数 <= 1000
    public TreeNode mirrorTree(TreeNode root) {

        //1、递归终止条件
        if (root == null)
            return root;

        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);

        root.left = left;
        root.right = right;
        return root;
    }
}

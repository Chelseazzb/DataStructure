/**
 * @ClassName : Solution2
 * @Author : Zhai Zhibin
 * @Date : 2021/11/7 22:56
 * @Description : 优化递归版
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution2 {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root,targetSum);
    }

    private boolean dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            return (num - root.val) == 0;
        }
        if (root.left != null && dfs(root.left,num - root.val)) {
            return true;
        }
        return root.right != null && dfs(root.right, num - root.val);
    }
}

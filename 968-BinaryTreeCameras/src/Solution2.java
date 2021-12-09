public class Solution2 {

    //精简Solution1
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

    private int count = 0;
    public int minCameraCover(TreeNode root) {
        //情况4：root无覆盖
        if (trval(root) == 0) count++;
        return count;
    }

    private int trval(TreeNode root) {
        if (root == null) return 2;
        int left = trval(root.left);    // 左
        int right = trval(root.right);  // 右
        if (left == 2 && right == 2) return 0;
        else if (left == 0 || right == 0) {
            count++;
            return 1;
        } else return 2;
    }
}

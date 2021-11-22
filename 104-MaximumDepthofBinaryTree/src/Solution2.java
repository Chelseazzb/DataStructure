/**
 * @ClassName : Solution2
 * @Author : Zhai Zhibin
 * @Date : 2021/11/5 8:29
 * @Description : 使用回溯法，正向求深度
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution2 {

    //树结点的定义
    private class TreeNode {
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

    //定义深度
    private int maxDepth;

    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        if (root == null)
            return maxDepth;

        maxDepth(root, 1);
        return maxDepth;
    }

    private void maxDepth(TreeNode node, int depth) {

        //更新maxDepth，中
        maxDepth = maxDepth >= depth ? maxDepth : depth;

        //1、递归终止条件，找到叶子节点
        if (node.left == null && node.right == null)
            return;

        //单层递归逻辑
        if (node.left != null) {
            depth++;
            maxDepth(node.left, depth);
            depth--; //回溯
        }

        //右
        if (node.right != null) {
            depth++;
            maxDepth(node.right, depth);
            depth--;
        }
    }
}

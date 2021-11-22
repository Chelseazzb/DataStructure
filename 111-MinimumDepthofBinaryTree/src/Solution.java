/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/3 18:55
 * @Description : 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * @Modified_by :
 * @Version : 1.0
 **/
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

    public int minDepth(TreeNode root) {

        if(root == null)
            return 0;

        int depth = 1;

        depth = minDepth(root,depth);

        return depth;
    }

    private int minDepth(TreeNode node , int depth){
        //1、递归终止条件
        if (node.left == null && node.right == null)
            return depth;

        //2、单层递归处理逻辑
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        //对左子树求最小
        if (node.left != null){
            left = minDepth(node.left,depth+1);
        }

        //对右子树求最小
        if (node.right != null){
            right = minDepth(node.right,depth+1);
        }

        return Math.min(left,right);

    }
}

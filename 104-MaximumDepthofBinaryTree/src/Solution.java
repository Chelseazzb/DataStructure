import java.util.Map;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/3 15:56
 * @Description : 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    //树结点的定义
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {

        int depth = 0;

        depth = maxDepth(root,depth);
        return depth;
    }

    //递归函数
    private int maxDepth(TreeNode node , int depth){
        //递归终止条件
        if (node == null)
            return depth;

        //单个递归处理逻辑
        int left = maxDepth(node.left,depth + 1);
        int right = maxDepth(node.right,depth + 1);

        return Math.max(left,right);
    }
}

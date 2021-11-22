/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/5 16:55
 * @Description : 计算给定二叉树的所有左叶子之和。
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

    public int sumOfLeftLeaves(TreeNode root) {

        //1、递归终止条件
        if (root == null)
            return 0;

        //单层递归逻辑
        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);

        //中
        int mid = 0;
        //如果该节点的左节点是叶子节点，加上该节点的值
        if (root.left != null && root.left.right == null && root.left.left == null){
            mid = root.left.val;
        }

        return mid + left + right;
    }

}

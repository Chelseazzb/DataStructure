/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/8 16:46
 * @Description : 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        //1、递归终止条件
        if (root1 == null && root2 == null)
            return null;

        TreeNode root; //当前的根节点

        //2、找到当前根节点
        if (root1 != null && root2 == null){
            root = new TreeNode(root1.val);
            //求左右子树
            root.left = mergeTrees(root1.left,null);
            root.right = mergeTrees(root1.right,null);
        } else if (root1 == null && root2 != null) {
            root = new TreeNode(root2.val);
            //求左右子树
            root.left = mergeTrees(null,root2.left);
            root.right = mergeTrees(null,root2.right);
        } else {
            root = new TreeNode(root2.val + root1.val);
            //3、左右子树
            root.left = mergeTrees(root1.left,root2.left);
            root.right = mergeTrees(root1.right, root2.right);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(2);
        TreeNode root1 = new TreeNode(1,left1,right1);
        left1.left = new TreeNode(5);

        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2,left2,right2);
        left2.right = new TreeNode(4);
        right2.right = new TreeNode(7);

        new Solution().mergeTrees(root1,root2);
    }
}

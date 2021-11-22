/**
 * @ClassName : Solution2
 * @Author : Zhai Zhibin
 * @Date : 2021/11/8 19:37
 * @Description : 优化递归版本
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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        //1、递归终止条件
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        TreeNode root; //当前的根节点

        //2、找到当前根节点

        root = new TreeNode(root2.val + root1.val);
        //3、左右子树
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);


        return root;
    }
}

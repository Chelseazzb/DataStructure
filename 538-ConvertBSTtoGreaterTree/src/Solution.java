/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/12 22:03
 * @Description : 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
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

    int pre ; //记录前一个节点的值
    public TreeNode convertBST(TreeNode root) {
        pre = 0; //root没有父节点
        root = build(root);

        return root;
    }

    //遍历的顺序为：右中左，因为求累加
    private TreeNode build(TreeNode root) {
        //1、递归终止条件
        if (root == null)
            return null;

        root.right = build(root.right);
        root.val += pre;
        pre = root.val;
        root.left = build(root.left);

        return root;
    }


}

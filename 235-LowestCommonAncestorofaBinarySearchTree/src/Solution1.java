/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/11 15:24
 * @Description : 递归法
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //迭代法，前序遍历，精简版
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //不知道p和q谁大
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left,p,q);
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right,p,q);
        else
            return root;
    }
}

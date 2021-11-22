/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/5 15:27
 * @Description : 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null)
            return true;
        else if (root == null && subRoot != null)
            return false;
        else if (root != null && subRoot == null)
            return false;

        if (root.val != subRoot.val){
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        } else {
            //有很多种情况，需要考虑全
            return isSameTree(root,subRoot) || ( isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot) ) ||
                    ( isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right) );
        }

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //1、递归终止条件
        if (p == null && q == null)
            return true;
        else if (p == null && q != null)
            return false;
        else if (p != null && q == null)
            return false;

        //2、单层递归逻辑
        if (p.val == q.val){

            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

        } else
            return false;
    }

    public static void main(String[] args) {
        TreeNode p = null;
        TreeNode q = null;
        System.out.println(new Solution().isSubtree(p,q));
    }
}

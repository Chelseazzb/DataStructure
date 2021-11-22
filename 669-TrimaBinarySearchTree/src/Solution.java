/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/11 21:33
 * @Description : 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
 * 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。
 * 可以证明，存在唯一的答案。
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
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

    //递归
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        //前序，中
        if (root.val < low){
            return trimBST(root.right,low,high); //新的根在右子树中
        }

        if (root.val > high)
            return trimBST(root.left,low,high);

        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        new Solution().trimBST(root, 1, 2);
    }
}

import java.util.*;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/7 20:37
 * @Description : 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum
 * 判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和targetSum。
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

    public boolean hasPathSum(TreeNode root, int targetSum) {

        List<Integer> list = new ArrayList<>();

        if (root == null)
            return false;

        inorder(root , root.val, list);

        for (int a : list) {
            if (a == targetSum)
                return true;
        }

        return false;
    }

    //递归，前序遍历
    public void inorder(TreeNode node, int pathLength, List<Integer> list){
        //1、递归结束条件
        if (node == null)
            return;


        //找到一个叶子节点
        if (node.left == null && node.right == null){


            list.add(pathLength); //记录所有路径值

        }

        //左
        if (node.left != null){
            pathLength += node.left.val;
            inorder(node.left,pathLength,list);
            pathLength -= node.left.val; //回溯
        }

        //左
        if (node.right != null){
            pathLength += node.right.val;
            inorder(node.right,pathLength,list);
            pathLength -= node.right.val; //回溯
        }

        return;


    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root= new TreeNode(1,left,right);

        System.out.println(new Solution().hasPathSum(root,3));


    }
}

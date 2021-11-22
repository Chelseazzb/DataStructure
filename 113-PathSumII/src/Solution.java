import java.util.*;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/8 8:29
 * @Description : 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有从根节点到叶子节点路径总和等于给定目标和的路径。
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> lists = new ArrayList<>();

        if (root == null)
            return lists;

        //保存路径和走过的节点
        List<Integer> path = new ArrayList<>();  //路径队列
        int length = root.val; //长度队列

        path.add(root.val);
        preorder(root, path, length, targetSum, lists);


        return lists;

    }

    private void preorder(TreeNode node, List<Integer> path, int length,
                          int targetSum, List<List<Integer>> lists) {

        //1、递归终止条件
        if (node == null)
            return;

        //单层递归逻辑
        //中
        if (node.left == null && node.right == null) { //找到一条路径
            if (targetSum == length) { //找到符合的
                List<Integer> list = new ArrayList<>();
                for (int i: path) {
                    list.add(i);
                }
                lists.add(list);
                //lists.add(path); //path会变化，会影响最终的结果
            }
        }

        //左
        if (node.left != null){
            path.add(node.left.val);
            length += node.left.val;
            preorder(node.left,path,length,targetSum,lists);
            //回溯
            path.remove(path.size() - 1);
            length -= node.left.val;
        }

        //右
        if (node.right != null){
            path.add(node.right.val);
            length += node.right.val;
            preorder(node.right,path,length,targetSum,lists);
            //回溯
            path.remove(path.size() - 1);
            length -= node.right.val;
        }

    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root= new TreeNode(1,left,right);

        System.out.println(new Solution().pathSum(root,3));


    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//给你二叉树的根节点root和一个整数目标和targetSum ，找出所有从根节点到叶子节点路径总和等于给定目标和的路径。
//叶子节点是指没有子节点的节点。

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

    //树中节点总数在范围 [0, 5000] 内
    //-1000 <= Node.val <= 1000
    //-1000 <= targetSum <= 1000

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
}

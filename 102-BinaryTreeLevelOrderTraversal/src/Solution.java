import java.util.*;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/1 22:20
 * @Description : 给你一个二叉树，请你返回其按 层序遍历得到的节点值。 （即逐层地，从左到右访问所有节点）
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    //树结点的定义
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        //1、定义返回值
        List<List<Integer>> result = new ArrayList<>();

        //2、判断边界值
        if (root == null)
            return result;

        //3、开始层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (! queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                list.add(pop.val);
                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
            }
            result.add(list);
        }

        return result;
    }

}



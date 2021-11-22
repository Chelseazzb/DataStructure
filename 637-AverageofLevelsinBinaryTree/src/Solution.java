import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/2 11:13
 * @Description : 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
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

    public List<Double> averageOfLevels(TreeNode root) {

        //1、创建返回list
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null)
            return list;

        //2、遍历树
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                sum += pop.val;

                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
            }
            list.add(sum/size); //3、计算每一层平均值加入list
        }

        return list;

    }
}

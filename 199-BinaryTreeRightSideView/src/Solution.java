import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/2 10:53
 * @Description : 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
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

    public List<Integer> rightSideView(TreeNode root) {
        //1、定义返回值
        List<Integer> result = new ArrayList<>();

        //2、判断边界值
        if (root == null)
            return result;

        //3、开始层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                if (i == size - 1)
                    result.add(pop.val); //每层的最后一个是可以被看见的

                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
            }

        }


        return result;
    }
}

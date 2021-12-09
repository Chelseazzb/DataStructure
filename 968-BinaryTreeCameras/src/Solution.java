//给定一个二叉树，我们在树的节点上安装摄像头。
//节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
//计算监控树的所有节点所需的最小摄像头数量。

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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

    int level = 0;
    Map<Integer, Integer> map = new HashMap<>();
    Queue<TreeNode> queue = new LinkedList<>();

    public int minCameraCover(TreeNode root) {
        queue.add(root);
        levelOrder(root);

        int sum1 = 0;
        int sum2 = 0;
        if (level == 1) //判断边界条件
            return 1;
        for (int i = 1; i < level; i += 2) {
            sum1 += map.get(i);
        }

        for (int i = 2; i < level; i += 2) {
            sum2 += map.get(i);
        }

        return sum1 != 0 && sum2 != 0 ? Math.min(sum1,sum2) : 1;
    }

    private void levelOrder(TreeNode root) {
        while (!queue.isEmpty()) {
            level++;
            map.put(level, queue.size());

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);

        Solution solution = new Solution();
//        solution.queue.add(root);
//        solution.levelOrder(root);
//
//
//        System.out.println("层数是：" + solution.level);
//        for (int i : solution.map.keySet()){
//            System.out.println(i + "-" + solution.map.get(i));
//        }
//        solution.minCameraCover(root);
        System.out.println(solution.minCameraCover(root));
    }
}

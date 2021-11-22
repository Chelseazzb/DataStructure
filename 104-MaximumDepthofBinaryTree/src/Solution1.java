import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/3 16:05
 * @Description : 使用层序遍历
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

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

    public int maxDepth(TreeNode root) {
        //判断边界条件
        if (root == null)
            return 0;

        //利用队列辅助循环遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            depth ++; //每一层加1

            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();

                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
            }

        }


        return depth;
    }
}

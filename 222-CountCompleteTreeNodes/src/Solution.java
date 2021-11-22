import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/3 20:03
 * @Description : 给你一棵 完全二叉树的根节点 root ，求出该树的节点个数。
 * @Modified_by :
 * @Version : 1.0
 **/
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

    public int countNodes(TreeNode root) {

        if(root == null)
            return 0;

        //使用层序遍历获得每一层的节点数进行加和
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            sum += size;

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
        }
        return sum;
    }
}

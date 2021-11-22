import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/2 20:51
 * @Description : 翻转一棵二叉树。
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        //1、使用队列来存储结点
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                //2、变换每个节点的左右子树
                TreeNode left = pop.right;
                pop.right = pop.left;
                pop.left = left;
                //3、将左右子树加入队列
                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
            }
        }

        return root;
    }


}

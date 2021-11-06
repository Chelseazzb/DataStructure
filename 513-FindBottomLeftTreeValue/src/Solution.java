import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/5 18:55
 * @Description : 给定一个二叉树的根节点 root，请找出该二叉树的最底层最左边节点的值。
 * 假设二叉树中至少有一个节点。
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

    //使用迭代法实现
    public int findBottomLeftValue(TreeNode root) {

        //使用层序遍历实现
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //使用栈来存储每层最左边的，top就是要找的节点
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode front = queue.poll();
                if (i == 0)
                    stack.push(front.val);

                if (front.left != null) queue.add(front.left);
                if (front.right != null) queue.add(front.right);
            }
        }

        return stack.pop();
    }


}

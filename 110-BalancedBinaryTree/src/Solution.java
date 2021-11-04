import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/4 12:03
 * @Description : ToDo
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

    public boolean isBalanced(TreeNode root) {
        int depth = getDepth(root);

        if (depth == -1)
            return false;
        else
            return true;

    }

    //递归函数，计算深度,-1
    private int getDepth(TreeNode node){
        //1、递归终止条件
        if (node == null)
            return 0;

        //2、单层递归逻辑
        int left = getDepth(node.left);
        if (left == -1) return -1;
        int right = getDepth(node.right);
        if (right == -1) return -1;

        return Math.abs(left-right) > 1 ? -1 : Math.max(left,right) + 1;

    }
}

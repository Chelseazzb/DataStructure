import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Stack;

public class Solution1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //使用迭代法
    //0 <= 节点个数 <= 1000
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        //利用栈来存储
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root.right);
        stack.add(root.left);


        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop(); //left
            TreeNode node2 = stack.pop(); //right

            if ((node1 != null && node2 == null) || (node2!=null && node1 == null))
                return false;
            if (node1 == null && node2 == null)
                continue;
            if (node1.val == node2.val){
                stack.push(node2.right);
                stack.push(node1.left);
                stack.push(node2.left);
                stack.push(node1.right);
            } else {
                return false;
            }

        }

        return true;
    }
}

import java.util.Stack;

public class Solution2 {

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
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return root;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root); //使用辅助栈存储节点

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
            //交换出栈节点的左右子树
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
        }

        return root;
    }
}

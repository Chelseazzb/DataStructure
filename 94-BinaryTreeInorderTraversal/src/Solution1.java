import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//使用迭代法实现二叉树中序遍历
public class Solution1 {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        stack.push(root);
        while (!stack.isEmpty()){

        }

        return list;
    }
}

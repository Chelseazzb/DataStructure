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
        TreeNode cur = root; //需要遍历整棵树

        while (cur != null || !stack.isEmpty()) {
            //先将左边的
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                list.add(cur.val);
                stack.pop();
                cur = cur.right;
            }
        }
        return list;
    }
}
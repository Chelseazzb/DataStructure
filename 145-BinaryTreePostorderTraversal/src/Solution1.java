import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//使用迭代法实现后序遍历
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

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null)
                list.add(node.val);
            else
                continue;
            stack.push(node.left);
            stack.push(node.right);
        }

        for (int i = 0; i < list.size() / 2; i++) {
            int a = list.get(list.size() - 1 - i);
            list.set(list.size() - 1 - i, list.get(i)) ;
            list.set(i,a);
        }


        return list;

    }
}

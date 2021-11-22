import java.util.Stack;

/**
 * @ClassName : Solution2
 * @Author : Zhai Zhibin
 * @Date : 2021/11/2 21:47
 * @Description : 使用迭代法
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution2 {

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
        //1、边界条件
        if (root == null)
            return null;

        //2、循环
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            TreeNode left = pop.right;
            pop.right = pop.left;
            pop.left = left;

            if (pop.left != null) stack.push(pop.left);
            if (pop.right != null) stack.push(pop.right);
        }


        return root;
    }
}

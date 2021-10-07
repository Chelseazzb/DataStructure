import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution2
 * @Author : Zhai Zhibin
 * @Date : 2021/9/26 21:22
 * @Description : 使用标记法实现后序遍历，统一前中后序的方式
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null)
            stack.push(root);

        while (!stack.isEmpty()){

            TreeNode node = stack.peek();
            if (node != null){
                stack.pop();
                stack.push(node);
                stack.push(null); //加入空节点作为弹出标记

                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);

            } else {
                stack.pop(); //弹出空节点
                list.add(stack.pop().val);
            }

        }
        return list;

    }
}

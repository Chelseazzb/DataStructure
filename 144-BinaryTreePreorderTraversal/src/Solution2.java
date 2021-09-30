import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution2
 * @Author : Zhai Zhibin
 * @Date : 2021/9/26 21:21
 * @Description : 使用标记法实现前序遍历，统一前中后序的方式
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list  = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node != null){
                stack.pop();
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
                stack.push(node);
                stack.push(null);

            }else {
                stack.pop(); //把null节点弹出栈
                list.add(stack.pop().val);
            }
        }
        return list;
    }
}

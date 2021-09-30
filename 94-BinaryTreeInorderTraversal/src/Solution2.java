import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution2
 * @Author : Zhai Zhibin
 * @Date : 2021/9/26 19:11
 * @Description : 使用标记法实现中序遍历，统一前中后序的方式
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null)
            stack.push(root);

        //利用空节点标记，只有遇到空节点后才弹出栈加到list中
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();

            if (node != null){
                stack.pop(); //弹出中间节点
                if (node.right != null){
                    stack.push(node.right);
                }

                stack.push(node);
                stack.push(null);

                if (node.left != null){
                    stack.push(node.left);
                }

            } else {
                stack.pop(); //弹出空节点
                list.add(stack.pop().val);
            }
        }

        return list;
    }
}

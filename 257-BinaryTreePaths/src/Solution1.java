import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/4 21:27
 * @Description : 使用迭代法实现
 * @Modified_by :
 * @Version : 1.0
 **/
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

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> list = new ArrayList<>();
        if (root == null)
            return list;

        //定义访问路径栈和访问节点栈
        Stack<TreeNode> stack = new Stack<>();
        Stack<String> path = new Stack<>();

        stack.push(root);
        path.push(String.valueOf(root.val));

        //遍历所有节点
        while (!stack.isEmpty()){
            //取出中间节点
            TreeNode node = stack.pop();
            String str = path.pop();

            //当走到叶子节点
            if (node.left == null && node.right == null){
                list.add(str); //添加一条新路径
            }

            //右
            if (node.right != null){
                stack.push(node.right);
                path.push(str + "->" + String.valueOf(node.right.val));
            }

            //左
            if (node.left != null){
                stack.push(node.left);
                path.push(str + "->" + String.valueOf(node.left.val));
            }

        }

        return list;
    }
}

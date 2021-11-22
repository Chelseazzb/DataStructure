import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/2 21:32
 * @Description : 使用递归法
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

    public TreeNode invertTree(TreeNode root) {
        //1、设置递归终止条件
        if (root == null)
            return null;

        TreeNode left = root.right;
        root.right = root.left;
        root.left = left;

        //3、递归调用
        invertTree(root.left);
        invertTree(root.right);


        return root;
    }
}

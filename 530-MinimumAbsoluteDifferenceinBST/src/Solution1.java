import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/10 19:33
 * @Description : 利用二分搜索树的有序特性进行递归优化
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    public static class TreeNode {
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

    int min = Integer.MAX_VALUE; //最小值
    TreeNode pre = null; //记录递归遍历中的前一个节点
    public int getMinimumDifference(TreeNode root) {

        inorder(root);

        return min;
    }

    private void inorder(TreeNode node){
        if (node == null)
            return;

        //左
        inorder(node.left);

        //中
        if (pre != null)
            min = Math.min(min, Math.abs(node.val - pre.val));

        //右
        pre = node;
        inorder(node.right);
    }
}

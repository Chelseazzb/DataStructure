/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/4 11:50
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

    public int countNodes(TreeNode root) {

        int count = countRecursion(root);

        return count;
    }

    private int countRecursion(TreeNode node){
        //1、递归终止条件
        if (node == null)
            return 0;

        //3、单层递归逻辑
        int left = countRecursion(node.left);
        int right = countRecursion(node.right);

        //3、返回值
        return left + right + 1;
    }
}

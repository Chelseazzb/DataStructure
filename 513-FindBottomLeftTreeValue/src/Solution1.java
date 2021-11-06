/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/5 19:17
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

    int maxDepth = Integer.MIN_VALUE;
    int leftValue = 0;

    public int findBottomLeftValue(TreeNode root) {

        findBottomLeftValue(root,0);

        return leftValue;

    }

    //递归函数，前序遍历
    private void findBottomLeftValue(TreeNode node , int depth){

        //1、递归终止条件，中
        if (node.left == null && node.right == null){
            if (depth > maxDepth){
                maxDepth = depth;
                leftValue = node.val;
                return;
            }
        }

        //单层递归逻辑，先找左边
        if (node.left != null){
            depth ++;
            findBottomLeftValue(node.left,depth);
            depth --; //回溯
        }

        if (node.right != null){
            depth ++;
            findBottomLeftValue(node.right , depth);
            depth --;
        }

        return;
    }

}

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/11 16:17
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        //1、递归终止条件
        if (root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }

        //2、前序
        if (val < root.val)
            root.left = insertIntoBST(root.left,val);
        else if (val > root.val){
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/10 16:05
 * @Description : 迭代法
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

//    public TreeNode searchBST(TreeNode root, int val) {
//        //1、边界条件
//        if (root == null)
//            return null;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        TreeNode retNode = null;
//        while (!queue.isEmpty()){
//            TreeNode node = queue.poll();
//
//            if (node.val == val){
//                retNode = node;
//                break;
//            } else if (node.val < val){
//                if (node.right != null)
//                    queue.add(node.right);
//            } else {
//                if (node.left != null)
//                    queue.add(node.left);
//            }
//        }
//        return retNode;
//    }

    public TreeNode searchBST(TreeNode root, int val) {


        while (root != null){

            if (root.val == val){
                return root;
            } else if (root.val < val){
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }


}

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/11 19:07
 * @Description :
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

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

    public TreeNode deleteNode(TreeNode root, int key) {
        //1、递归终止条件
        if (root == null)
            return null;

        //使用前序遍历
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else { //找到要删除的节点

            if (root.left == null){
                TreeNode right = root.right;
                root.right = null;
                return right;
            }

            if (root.right == null) {
                TreeNode left = root.left;
                root.left = null;
                return left;
            }

            TreeNode min = minimum(root.right); //找到右子树中的最小节点作为新的root
            min.right = removeMin(root.right);
            min.left = root.left;
            root.left = root.right = null;
            return min;

        }
    }

    //删除最小值
    private TreeNode removeMin(TreeNode root) {

        if (root.left == null) {
            TreeNode right = root.right;
            root.right = null;
            return right;
        }

        root.left = removeMin(root.left);
        return root;
    }

    //找到最小值
    private TreeNode minimum(TreeNode root) {
        if (root.left == null)
            return root;
        return minimum(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(6);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(4);
        TreeNode right2 = new TreeNode(7);

        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = right1;
        right.right = right1;

        new Solution().deleteNode(root, 3);

    }
}

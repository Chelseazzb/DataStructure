/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/12 21:16
 * @Description : 给你一个整数数组nums，其中元素已经按升序排列，请你将其转换为一棵高度平衡 二叉搜索树。
 * 高度平衡二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过1的二叉树。
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

    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root = buildBST(nums, 0, nums.length );
        return root;
    }

    //递归构造二叉树
    private TreeNode buildBST(int[] nums, int left, int right) {
        //1、递归终止条件
        if (left == right)
            return null;

        //只剩一个节点的时候
        if (right - left == 1){
            return new TreeNode(nums[left]);
        }
        //找到根的位置
        int middle = (right - left)/2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = buildBST(nums,left,middle);
        root.right = buildBST(nums,middle + 1,right);

        return root;
    }
}

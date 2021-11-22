/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/8 16:04
 * @Description : 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的最大二叉树定义如下：
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return construct(nums,0,nums.length);
    }

    //递归函数，统一左闭右开
    private TreeNode construct(int[] nums, int begin, int end) {
        //1、递归终止条件
        if (begin == end)
            return null;

        //2、找到最大的节点
        int max = nums[begin];
        int maxIndex = begin; //根节点的位置
        for (int i = begin; i < end; i++) {
            if (nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode node = new TreeNode(max);

        //3、只剩叶子节点
        if (end - begin == 1)
            return node;

        //4、左右两边递归构造
        node.left = construct(nums,begin,maxIndex);
        //跳过根节点
        node.right = construct(nums, maxIndex+1,end);

        return node;
    }
}

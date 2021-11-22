import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/10 19:02
 * @Description : 给你一个二叉搜索树的根节点 root ，返回树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
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

    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE; //最小值
        List<Integer> list = new ArrayList<>();
        inorder(root,list); //将所有节点的值按顺序放在list中

        for (int i = 0; i < list.size() - 1; i++) {

            for (int j = i + 1; j < list.size(); j++) {
                int result = Math.abs(list.get(i) - list.get(j));
                if (result < min)
                    min = result;
            }
        }

        return min;
    }

    private void inorder(TreeNode node , List<Integer> list){
        if (node == null)
            return;

        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }

}

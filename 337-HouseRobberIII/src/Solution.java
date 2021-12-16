//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
// 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
// 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

//计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

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


    //递归函数，后序遍历，超时
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;

        //偷root
        int value1 = root.val;
        if (root.left != null)
            value1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            value1 += rob(root.right.left) + rob(root.right.right);
        //不偷root
        int value2 = rob(root.left) + rob(root.right);

        return Math.max(value1,value2);
    }
}

import java.util.HashMap;
import java.util.Map;

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


    //递归函数，后序遍历，使用map暂存
    Map<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;

        if (map.get(root) != null) return map.get(root);
        //偷root
        int value1 = root.val;
        if (root.left != null)
            value1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            value1 += rob(root.right.left) + rob(root.right.right);
        //不偷root
        int value2 = rob(root.left) + rob(root.right);
        map.put(root,Math.max(value1,value2));
        return Math.max(value1,value2);
    }
}

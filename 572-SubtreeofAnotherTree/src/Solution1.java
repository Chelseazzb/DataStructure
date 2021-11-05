/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/5 16:25
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    //树结点的定义
    private class TreeNode {
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

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode p = null;
        TreeNode q = null;
        System.out.println(new Solution1().isSubtree(p,q));
    }
}

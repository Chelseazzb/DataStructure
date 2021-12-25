import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution2 {

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

    //自己的版本，空间用的多一点
    LinkedList<List<Integer>> res = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    int sum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return res;
    }
    void recur(TreeNode root, int target) {
        if(root == null) return;
        stack.push(root.val);
        sum += root.val;
        if(sum == target && root.left == null && root.right == null)
            res.add(new LinkedList(stack));
        recur(root.left, target);
        recur(root.right, target);
        stack.pop();
        sum -= root.val;
    }
}

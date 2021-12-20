import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//剑指 Offer 32 - II. 从上到下打印二叉树 II
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //节点总数 <= 1000
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new LinkedList<>();
        //判断边界条件
        if (root == null)
            return lists;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            lists.add(list);
        }

        return lists;
    }
}

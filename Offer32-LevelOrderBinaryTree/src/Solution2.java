import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

////剑指 Offer 32 - III. 从上到下打印二叉树
public class Solution2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null)
            return lists;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean left = true; //最开始是从左向右

        while (!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> deque = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (left){
                    deque.offerLast(cur.val);
                } else
                    deque.offerFirst(cur.val);

                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            lists.add(new LinkedList<>(deque));
            left = !left; //转换为从右向左
        }

        return lists;
    }
}

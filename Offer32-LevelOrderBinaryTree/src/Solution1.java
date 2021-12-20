import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//剑指 Offer 32 - I. 从上到下打印二叉树
public class Solution1 {



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //节点总数 <= 1000
    public int[] levelOrder(TreeNode root) {
        if (root == null) //边界条件
            return new int[0];

        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}

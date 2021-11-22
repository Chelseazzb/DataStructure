import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/5 17:24
 * @Description : 使用迭代法实现
 * @Modified_by :
 * @Version : 1.0
 **/
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

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;

        if (root == null)
            return sum;

        //利用queue来辅助存储
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode front = queue.poll();
                if (front.left != null && front.left.right == null && front.left.left == null)
                    sum += front.left.val;

                if (front.left != null)
                    queue.add(front.left);
                if (front.right != null)
                    queue.add(front.right);
            }
        }

        return sum;
    }
}

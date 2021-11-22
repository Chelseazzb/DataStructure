import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/3 19:37
 * @Description : 使用层序遍历，找到最底层
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

    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()){

            Boolean flag = false;
            int size = queue.size();
            depth ++;

            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                if (pop.left == null && pop.right == null){
                    flag = true;
                    break;
                }
                if (pop.left != null)
                    queue.add(pop.left);
                if (pop.right != null)
                    queue.add(pop.right);
            }

            if (flag)
                break; //找到第一个叶子结点

        }

        return depth;

    }
}

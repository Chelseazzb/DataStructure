import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/8 17:18
 * @Description : 迭代法
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

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

    //使用层序遍历
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //判断边界条件
        if (root1 == null && root2 == null)
            return null;
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        //定义队列进行辅助同步
        Queue<TreeNode> queue1 = new LinkedList<>();

        //初始化
        queue1.add(root1);
        queue1.add(root2);

        while (!queue1.isEmpty()){

            TreeNode t1 = queue1.poll();
            TreeNode t2 = queue1.poll();

            t1.val += t2.val;

            if (t1.left != null && t2.left != null){
                queue1.add(t1.left);
                queue1.add(t2.left);
            }

            if (t1.right != null && t2.right != null){
                queue1.add(t1.right);
                queue1.add(t2.right);
            }

            if (t1.left == null && t2.left != null)
                t1.left = t2.left;

            if (t1.right == null && t2.right != null)
                t1.right = t2.right;

        }


        return root1;
    }
}

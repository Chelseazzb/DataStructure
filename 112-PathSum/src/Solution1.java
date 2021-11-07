import java.util.*;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/7 22:16
 * @Description : 使用迭代法实现
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

    public boolean hasPathSum(TreeNode root, int targetSum) {

        List<Integer> list = new ArrayList<>();

        //利用队列存储路径的节点
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sum = new LinkedList<>(); //记录路径值

        if (root == null)
            return false;

        queue.add(root);
        sum.add(root.val);

        while (!queue.isEmpty()){
            //中
            TreeNode front = queue.poll();
            int path = sum.poll();
            //找到叶子结点
            if (front.left == null && front.right == null){
                list.add(path);
            }

            if (front.left != null){
                queue.add(front.left);
                sum.add(front.left.val + path);
            }

            if (front.right != null){
                sum.add(front.right.val + path);
                queue.add(front.right);

            }
        }

        for (int a : list) {
            if (a == targetSum)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root= new TreeNode(1,left,right);

        System.out.println(new Solution1().hasPathSum(root,3));


    }
}

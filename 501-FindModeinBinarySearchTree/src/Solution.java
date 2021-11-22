import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/10 20:04
 * @Description : 给定一个有相同值的二叉搜索树（BST），找出 BST中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {
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

    int count; //记录频率
    int max; //记录最大频率
    TreeNode pre; //记录前一个节点
    Queue<Integer> queue = new LinkedList<>(); //记录最大频率的节点

    public int[] findMode(TreeNode root) {

        count = 0;
        max = 0;
        pre = null;
        queue.clear();

        inorder(root);

        //注意queue的size会变
        int size = queue.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = queue.poll();
        }
        return arr;
    }

    private void inorder(TreeNode node) {

        //1、递归终止条件
        if (node == null)
            return;

        //左
        inorder(node.left);

        //中
        if (pre == null) { //root没有pre
            count = 1;
        } else if (pre.val == node.val) {
            count++;
        } else { //与前一个节点数值不同
            count = 1;
        }

        if (count == max) {
            queue.add(node.val); //找到频率相同的众数
        }

        if (count > max) { //找到新的众数
            queue.clear();  //必须清空
            max = count;
            queue.add(node.val);
        }

        //右
        pre = node;
        inorder(node.right);
    }

    public static void main(String[] args) {
        new Solution().findMode(new TreeNode(1,null,new TreeNode(2)));
    }
}

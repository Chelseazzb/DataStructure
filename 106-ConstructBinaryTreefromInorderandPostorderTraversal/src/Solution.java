import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/8 9:41
 * @Description : 根据一棵树的中序遍历与后序遍历构造二叉树。
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length == 0 || postorder.length == 0)
            return null;

        //方便清除元素，动态变化
        List<Integer> middle = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        for (int i = 0; i < inorder.length; i++) {
            middle.add(inorder[i]);
            post.add(postorder[i]);
        }


        return build(middle,post);

    }

    //递归构造
    private TreeNode build(List<Integer> middle , List<Integer> post){
        //1、递归终止条件，先找post
        if (post.size() == 0)
            return null;

        //2、利用post最后一个节点作为当前的根
        TreeNode node = new TreeNode(post.get(post.size() - 1));

        //如果是叶子结点，直接返回
        if (post.size() == 1)
            return node;

        //3、分割中序数组
        int middleBreak = 0;
        for ( ; middleBreak < middle.size() ; middleBreak++) {
            if (middle.get(middleBreak) == node.val)
                break;
        }
        //左闭右开
        List<Integer> middleLeft = middle.subList(0,middleBreak);
        //需要跳过当前的根节点
        List<Integer> middleRight = middle.subList(middleBreak + 1,middle.size());

        //4、分割后序数组
        //post.remove(post.size()-1); //最后一个元素已经用过了，会出现java.util.ConcurrentModificationException
        post = post.subList(0,post.size()-1);

        //post和middle分割出来的左右两边长度一样
        List<Integer> postLeft = post.subList(0,middleLeft.size());
        List<Integer> postRight = post.subList(middleLeft.size() , post.size());


        //5、递归处理两个区间
        node.left = build(middleLeft,postLeft);
        node.right = build(middleRight,postRight);

        //6、返回当前根节点
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{3,2,1};
        int[] postorder = new int[]{3,2,1};

        new Solution().buildTree(inorder,postorder);
    }
}

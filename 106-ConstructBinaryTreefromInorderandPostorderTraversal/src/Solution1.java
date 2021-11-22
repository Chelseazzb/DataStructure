import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/8 11:27
 * @Description : 优化递归算法
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


        return build(middle,0,middle.size(),post,0,post.size());

    }

    //递归构造
    private TreeNode build(List<Integer> middle , int middleLeft,int middleRight,List<Integer> post, int postLeft, int postRight){
        //1、递归终止条件，先找post
        if (postRight == postLeft)
            return null;

        //2、利用post最后一个节点作为当前的根
        TreeNode node = new TreeNode(post.get(postRight -1));

        //如果是叶子结点，直接返回
        if (postRight - postLeft == 1)
            return node;

        //3、分割中序数组
        int middleBreak = 0;
        for ( ; middleBreak < middle.size() ; middleBreak++) {
            if (middle.get(middleBreak) == node.val)
                break;
        }
        //左闭右开
        int leftInorderBegin = middleLeft;
        int leftInorderEnd = middleBreak;
        //需要跳过当前的根节点
        int rightInorderBegin = middleBreak + 1;
        int rightInorderEnd = middleRight;

        //4、分割后序数组
        //post.remove(post.size()-1); //最后一个元素已经用过了，会出现java.util.ConcurrentModificationException
        //post = post.subList(0,post.size()-1);

        //post和middle分割出来的左右两边长度一样
        int leftPostorderBegin = postLeft;
        int leftPostorderEnd = postLeft + (middleBreak - leftInorderBegin);
        //需要跳过当前的根节点
        int rightPostorderBegin = postLeft + (middleBreak - leftInorderBegin);
        int rightPostorderEnd = postRight - 1; //除去最后一个节点


        //5、递归处理两个区间
        node.left = build(middle,leftInorderBegin,leftInorderEnd,post,leftPostorderBegin,leftPostorderEnd);
        node.right = build(middle,rightInorderBegin,rightInorderEnd,post,rightPostorderBegin,rightPostorderEnd);

        //6、返回当前根节点
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{3,2,1};
        int[] postorder = new int[]{3,2,1};

        new Solution().buildTree(inorder,postorder);
    }
}

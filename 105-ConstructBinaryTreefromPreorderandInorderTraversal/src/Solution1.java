import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/8 15:28
 * @Description : 使用hashmap优化递归
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0)
            return null;

        Map<Integer, Integer> map = new HashMap<>();
        //提前把inorder中的节点值和位置对应起来，优化查找根节点
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    //递归构建
    private TreeNode build(int[] preorder, int preorderBegin, int preorderEnd, int[] inorder, int inorderBegin, int inorderEnd, Map<Integer, Integer> map) {
        //1、递归结束，前序左右边界相等
        if (preorderBegin == preorderEnd)
            return null;

        //2、取前序的第一个作为当前的根节点
        int rootValue = preorder[preorderBegin];
        TreeNode node = new TreeNode(rootValue);

        //如果前序只剩一个叶子节点
        if (preorderEnd - preorderBegin == 1)
            return node;

        //3、切割中序遍历
//        int middleBreak;
//        for (middleBreak = 0; middleBreak < inorder.length; middleBreak++) {
//            if (inorder[middleBreak] == rootValue)
//                break;
//        }

        int middleBreak = map.get(rootValue);

        //左边区间，左闭右开，[0, middleBreak)
        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = middleBreak;
        //跳过根节点，右边区间，左闭右开，[middleBreak + 1, size)
        int rightInorderBegin = middleBreak + 1;
        int rightInorderEnd = inorderEnd;

        //4、切割前序遍历，左边区间，左闭右开，[1, leftInorderEnd - leftInorderBegin)
        //因为切割出来的左右区间长度是一样的
        int leftPreorderBegin = preorderBegin + 1; //跳过根节点，所以加1
        int leftPreorderEnd = preorderBegin + 1 + (leftInorderEnd - leftInorderBegin);
        //右边区间，左闭右开，[leftPreorderEnd, size)
        int rightPreorderBegin = preorderBegin + 1 + (leftInorderEnd - leftInorderBegin);
        int rightPreorderEnd = preorderEnd;

        //5、递归left和right
        node.left = build(preorder, leftPreorderBegin, leftPreorderEnd, inorder, leftInorderBegin, leftInorderEnd, map);
        node.right = build(preorder, rightPreorderBegin, rightPreorderEnd, inorder, rightInorderBegin, rightInorderEnd, map);

        //6、返回值
        return node;
    }
}

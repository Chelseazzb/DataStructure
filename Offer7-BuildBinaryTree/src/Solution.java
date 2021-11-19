/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/18 18:54
 * @Description : 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //判断边界条件
        if(preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length)
            return null;

        //左闭右开原则
        return build(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder,int inStart, int inEnd){
        //1、递归终止条件
        if (preStart >= preEnd || inStart >= inEnd)
            return null;

        //2、前序的第一个元素就是根
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        //3、找到中序遍历中根的下标
        int index;
        for (index = inStart; index < inEnd; index++) {
            if (inorder[index] == rootValue)
                break;
        }

        //4、切割中序遍历
        int leftSize = index - inStart;

        //5、切割前序遍历
        int leftPreEnd = preStart + 1 + leftSize;

        //6、左右子树
        root.left = build(preorder,preStart+1,leftPreEnd,inorder,inStart,index);
        root.right = build(preorder,leftPreEnd,preEnd,inorder,index + 1,inEnd);

        //返回root
        return root;
    }
}

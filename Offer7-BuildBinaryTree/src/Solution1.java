import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/18 19:41
 * @Description : 优化在中序中查找根的位置
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //判断边界条件
        if(preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length)
            return null;

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i); //提前做好位置映射
        }
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
        int index = map.get(rootValue);

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

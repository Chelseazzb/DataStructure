/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/11 17:26
 * @Description : 迭代法实现
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        //1、边界条件
        if (root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }

        //需要记录当前的节点和父亲节点，否则无法插入
        TreeNode cur = root;
        TreeNode parent = root;
        while (cur != null){
            parent = cur;

            if (val > cur.val)
                cur = cur.right;
            else if (val < cur.val)
                cur = cur.left;
        }

        //当前cur为空
        if (val > parent.val)
            parent.right = new TreeNode(val);
        else if (val < parent.val)
            parent.left = new TreeNode(val);

        return root;
    }
}

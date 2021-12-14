//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//
//B是A的子结构， 即 A中有出现和B相同的结构和节点值。
public class Solution {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    //0 <= 节点个数 <= 10000
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        //1、边界条件
        if (A == null || B == null)
            return false;

        return isContain(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);

    }

    private boolean isContain(TreeNode A,TreeNode B){
        //1、递归终止条件
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;

        //2、单层递归处理逻辑
        return isContain(A.left, B.left) && isContain(A.right, B.right);
    }
}

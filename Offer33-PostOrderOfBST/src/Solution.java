//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
public class Solution {

    //数组长度 <= 1000
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    //所有子树都需正确才可判定正确，因此使用与逻辑符 && 连接。
    //p = j ： 判断此树是否正确。
    //recur(i, m - 1)： 判断此树的左子树是否正确。
    //recur(m, j - 1) ： 判断此树的右子树是否正确。

}

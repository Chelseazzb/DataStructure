public class Solution1 {
    //我们只需要利用数组尝试构建一棵BST就可以了，如果构建完成，最终数组为空，说明是合法的BST。若构建结束数组不为空，说明不是合法的BST。
    //实际代码实现不需要真的构建一棵BST，只需要判断是否符合BST结构，符合则移除数组的最后一个元素，不符合直接返回即可。
    // 这样实现的话，不符合规则提前返回，相当于剪枝了。
    //最差情况下需要遍历全部节点，时间复杂度为O(N)。空间上只有2个常量，另外就是递归使用的栈空间，递归的深度和树的深度相关。
    // 常规情况下空间复杂度为O(logN)，极端情况下（拉成一条链）空间复杂度为O(N)。
    //对了，构造顺序是根->右->左，这个点挺关键的，因为是后续遍历序列，而我们是倒序遍历数组的。

    int end;//判断是否完全遍历
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 1) return true;
        end = postorder.length - 1;
        build(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return end < 0;//如果完全遍历，则end < 0;
    }
    private void build(int[] postorder, int min, int max) {
        if (end < 0) return ;//空了，返回
        int rootV = postorder[end];
        if (rootV >= max || rootV <= min) return ;
        end--;
        build(postorder, rootV, max);//右子树
        build(postorder, min, rootV);//左子树
    }
}

package per.zzb;

/**
 * @ClassName : Main
 * @Author : Zhai Zhibin
 * @Date : 2021/7/31 9:55
 * @Description : AVL树的测试类
 * @Modified_by :
 * @Version : 1.0
 **/
public class Main {

    public static void main(String[] args) {
        //初始化一棵树
        AVL<Integer,Integer> bst = new AVL<>();
        int[] arr = {5,3,6,8,4,2};
        int[] ll  = {6,4,7,3,5,2};
        int[] rr  = {6,4,8,7,9,10};
        int[] lr  = {6,3,7,2,5,4};
        int[] rl  = {6,5,10,8,11,9};

        System.out.println("BST树是否为空：" + bst.isEmpty());

        //              5
        //            /   \
        //           3     6
        //          / \     \
        //         2   4     8
        
        System.out.print("向BST中添加元素：" );
        for (int i = 0; i < rl.length; i++) {
            System.out.print(rl[i]);
            bst.add(rl[i],rl[i]);
        }
        System.out.println();
        System.out.println("当前的AVL是否保持了平衡：" + bst.isBalanced());
        System.out.println();
        System.out.println("BST树是否为空：" + bst.isEmpty());
        System.out.println("BST树节点数量：" + bst.getSize());
        System.out.println(bst);
        System.out.println("BST树的最小元素：" + bst.minimum());
        System.out.println("BST树的最大元素：" + bst.maximum());
        bst.nonRecursionPreorder();
        bst.preorder();
        bst.inorder();
        bst.postorder();
        bst.levelorder();

        System.out.println("查找元素1：" + bst.find(1));
        System.out.println("查找元素3：" + bst.find(3));
        System.out.println("查找元素7：" + bst.find(7));


        bst.add(12,12);
        System.out.println("删除元素3");
        bst.remove(5);
        System.out.println(bst);
    }
}

package per.zzb.tree;

/**
 * @ClassName : Main
 * @Author : Zhai Zhibin
 * @Date : 2021/7/31 9:55
 * @Description : 树的测试类
 * @Modified_by :
 * @Version : 1.0
 **/
public class Main {

    public static void main(String[] args) {
        //初始化一棵树
        BST<Integer> bst = new BST<>();
        int[] arr = {5,3,6,8,4,2};

        System.out.println("BST树是否为空：" + bst.isEmpty());

        //              5
        //            /   \
        //           3     6
        //          / \     \
        //         2   4     8
        
        System.out.print("向BST中添加元素：" );
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            bst.add(arr[i]);
        }
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

        System.out.println("删除BST的最小值：" + bst.removeMin());
        System.out.println("删除BST的最小值：" + bst.removeMax());
        System.out.println(bst);

        System.out.println("删除元素3");
        bst.delete(3);
        System.out.println(bst);
    }
}

package per.zzb.set;

/**
 * @ClassName : Main
 * @Author : Zhai Zhibin
 * @Date : 2021/8/4 10:51
 * @Description : 集合的测试类
 * @Modified_by :
 * @Version : 1.0
 **/
public class Main {

    public static void main(String[] args) {
        //BSTSet的测试用例
//        BSTSet<Integer> bstSet = new BSTSet<>();
//        System.out.println("BST树是否为空：" + bstSet.isEmpty());
//
//        for (int i = 0; i < 10; i++) {
//            bstSet.add(i);
//        }
//
//        bstSet.delete(1);
//        System.out.println("BST树节点数量：" + bstSet.getSize());
//        System.out.println(bstSet);

        //LinkedListSet的测试用例
        LinkedListSet<Integer> linkedListSet = new LinkedListSet<>();
        System.out.println("BST树是否为空：" + linkedListSet.isEmpty());

        for (int i = 0; i < 10; i++) {
            linkedListSet.add(i);
        }

        linkedListSet.delete(1);
        System.out.println("BST树节点数量：" + linkedListSet.getSize());
        System.out.println(linkedListSet);
    }
}

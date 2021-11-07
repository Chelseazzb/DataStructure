package per.zzb.set;

import java.util.ArrayList;

/**
 * @ClassName : Main
 * @Author : Zhai Zhibin
 * @Date : 2021/8/4 10:51
 * @Description : 集合的测试类
 * @Modified_by :
 * @Version : 1.0
 **/
public class Main {

    public void getCount(Set<String> set, String filename){

        ArrayList<String> list = new ArrayList<>();

        if (FileOperation.readFile(filename,list)){

            System.out.println("TotalSize of "+ filename + "is "+list.size());

            Long startTime = System.nanoTime();
            for (String str : list){
                set.add(str);
            }

            System.out.println("Non-repeated word size is " + set.getSize());

            for (String str : list){
                set.contains(str);
            }



            Long endTime = System.nanoTime();

            System.out.println("Time："+ (double)(endTime - startTime)/1000000000 + "s");
        }

    }

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
//        LinkedListSet<Integer> linkedListSet = new LinkedListSet<>();
//        System.out.println("BST树是否为空：" + linkedListSet.isEmpty());
//
//        for (int i = 0; i < 10; i++) {
//            linkedListSet.add(i);
//        }
//
//        linkedListSet.delete(1);
//        System.out.println("BST树节点数量：" + linkedListSet.getSize());
//        System.out.println(linkedListSet);

        LinkedListSet<String> set1 = new LinkedListSet<>();
        BSTSet<String> set2 = new BSTSet<>();
        AVLSet<String> set3 = new AVLSet<>();

        new Main().getCount(set1,"pride-and-prejudice.txt");
        new Main().getCount(set2,"pride-and-prejudice.txt");
        new Main().getCount(set3,"pride-and-prejudice.txt");
    }
}

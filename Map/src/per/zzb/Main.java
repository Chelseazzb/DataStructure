package per.zzb;

import java.util.ArrayList;

//映射的测试类
public class Main {

    //读取文件并计算其中某元素的数量
    public int getCount(Map<String, Integer> map, String filename, String word) {
        ArrayList<String> list = new ArrayList<>();
        if (FileOperation.readFile(filename, list)) {
            System.out.println("Total size: " + list.size());

            Long startTime = System.nanoTime();

            for (String str : list) {
                if (map.contains(str)) {
                    map.set(str, map.get(str) + 1);
                } else {
                    map.add(str, 1);
                }
            }
            Long endTime = System.nanoTime();

            System.out.println("花费时间为：" + (double)(endTime-startTime)/1000000000);
            System.out.println("Total Different Words: " + map.getSize());

        }

        return map.get(word);
    }

    public static void main(String[] args) {
        /**
         * 测试LinkedListMap
         */
//        LinkedListMap<Integer,Integer> linkedListMap = new LinkedListMap<>();
//
//        System.out.println("LinkedListMap是否为空："+ linkedListMap.isEmpty());
//        System.out.println("LinkedListMap中添加十个元素");
//        for (int i = 0; i < 10; i++) {
//            linkedListMap.add(i,i);
//        }
//        System.out.println("LinkedListMap中元素个数："+ linkedListMap.getSize());
//        System.out.println("LinkedListMap是否包含key为1的："+ linkedListMap.contains(1));
//        System.out.println("LinkedListMap中key为1的value："+ linkedListMap.get(1));
//        System.out.println("删除LinkedListMap中的key为2的元素");
//        linkedListMap.remove(2);
//        System.out.println(linkedListMap);
//        for (int i = 0; i < 10; i++) {
//            linkedListMap.add(i,i);
//        }
//        System.out.println(linkedListMap);

        /**
         * 测试BSTtMap
         */
//        BSTMap<Integer,Integer> map = new BSTMap<>();
//        int[] arr = {5,3,6,8,4,2};
//
//        System.out.println("BSTMap是否为空："+ map.isEmpty());
//        System.out.println("BSTMap中添加"+arr.length+"个元素");
//        for (int i = 0; i < arr.length; i++) {
//            map.add(arr[i], arr[i]);
//        }
//
//        System.out.println(map);
//        System.out.println("LinkedListMap是否包含key为2的："+ map.contains(2));
//        System.out.println("BSTMap中key为2的value："+ map.get(2));
//        map.set(2,1);
//        System.out.println("BSTMap中key为2的value："+ map.get(2));
//        System.out.println("BSTMap中元素个数："+ map.getSize());
//        System.out.println("删除LinkedListMap中的key为2的元素");
//        map.remove(2);
//        System.out.println(map);
//        System.out.println(map);

        //读取《傲慢与偏见》
        System.out.println("Pride And Prejudice");

        LinkedListMap<String, Integer> map1 = new LinkedListMap<>();
        BSTMap<String,Integer> map2 = new BSTMap<>();
        AVLMap<String,Integer> map3 = new AVLMap<>();

        String filename = "pride-and-prejudice.txt";


//        ArrayList<String> list = new ArrayList<>();
//        if (FileOperation.readFile("D:\\java_workspace\\DataStructure\\Map\\pride-and-prejudice.txt", list)) {
//            System.out.println("Total size: " + list.size());
//
//            LinkedListMap<String, Integer> map = new LinkedListMap<>();
//
//            for (String str : list) {
//                if (map.contains(str)) {
//                    map.set(str, map.get(str) + 1);
//                } else {
//                    map.add(str, 1);
//                }
//            }
//            System.out.println("Total Different Words: " + map.getSize());
//            int count = map.get("pride");
//            System.out.println("pride出现的次数：" + count);
//        }

        System.out.println("Pride出现的次数为：" + new Main().getCount(map1,filename,"prejudice"));
        System.out.println("Prejudice出现的次数为：" + new Main().getCount(map2,filename,"prejudice"));
        System.out.println("Prejudice出现的次数为：" + new Main().getCount(map3,filename,"prejudice"));

    }
}
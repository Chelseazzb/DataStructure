//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//实现 LRUCache 类：
//
//LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
//int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

import java.util.*;

public class LRUCache {

    //Map存储key-value
    private Map<Integer,Integer> map;
    private List<Integer> order; //记录key的顺序，下标越小权值越高
    private int capacity; //容量

    public LRUCache(int capacity) {
        map = new HashMap<>();
        order = new ArrayList<>();
        this.capacity = capacity;
    }

    //1 <= capacity <= 3000
    //0 <= key <= 10000
    //0 <= value <= 105
    //最多调用 2 * 105 次 get 和 put
    public int get(int key) {
         Integer value= map.get(key);
         if (value == null)
             return -1;
         else {
             if (capacity != 1) { //如果容量为1，不需要更新
                 int index = order.indexOf(key);
                 order.remove(index);
                 order.add(0,key);

             }
         }
        return value;
    }

    //key存在就更新，不存在就添加
    public void put(int key, int value) {
        Integer v = map.get(key);
        if (v == null){ //缓存中不存在
            if (map.size() < capacity){ //容量还没满
                map.put(key,value);
                order.add(0,key); //更新顺序
            } else { //容量满了需要清除最久未使用的
                int removeKey = order.get(order.size()-1); //找到该被删除的key
                order.remove(order.size()-1); //下标最大的出列
                map.remove(removeKey); //map中删除该key
                map.put(key,value);
                order.add(0,key);
            }

        } else { //缓存存在该key，更新key，不涉及容量的变化
            int index = order.indexOf(key); //找到key所在的下标
            order.remove(index);
            map.put(key,value); //更新值
            order.add(0,key);
        }

    }

    private void printOrder(){
        System.out.println("打印出列顺序：");
        for (int i = order.size() - 1; i >= 0; i--) {
            System.out.print(order.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        Map<Integer,Integer> map = new HashMap<>();
//        map.put(1,2);
//        map.put(1,1);
//        System.out.println(map.size());

//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        lRUCache.printOrder();
//        System.out.println(lRUCache.get(1));    // 返回 1
//        lRUCache.printOrder();
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        lRUCache.printOrder();
//        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        lRUCache.printOrder();
//        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
//        System.out.println(lRUCache.get(3));    // 返回 3
//        System.out.println(lRUCache.get(4));    // 返回 4

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(2));
        lruCache.put(1,1);
        lruCache.put(4,1);
        System.out.println(lruCache.get(2));

    }
}

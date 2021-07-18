package per.zzb.link;

/**
 * @ClassName : Main
 * @Author : Zhai Zhibin
 * @Date : 2021/7/17 22:53
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("链表是否为空：" + linkedList.isEmpty());
        System.out.println("链表的长度：" + linkedList.getSize());
        System.out.println("获得链表中的第一个元素：" + linkedList.getFirst());
        System.out.println("像链表中添加两个元素++++++++++++++");

        linkedList.add(0, 1);
        linkedList.addLast(2);

//        linkedList.get(12);  //测试异常

        System.out.println("获得链表中的第二个元素：" + linkedList.getLast());
        linkedList.traverse();

        linkedList.update(1, 3);
        System.out.println(linkedList);

        linkedList.deleteLast();
        linkedList.deleteFirst();
        linkedList.traverse();
    }
}

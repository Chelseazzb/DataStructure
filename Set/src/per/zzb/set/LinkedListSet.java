package per.zzb.set;

/**
 * @ClassName : LinkedListSet
 * @Author : Zhai Zhibin
 * @Date : 2021/8/5 22:44
 * @Description : 使用链表实现的集合
 * @Modified_by :
 * @Version : 1.0
 **/
public class LinkedListSet<E extends Comparable> implements Set<E> {

    private LinkedList<E> linkedList;

    public LinkedListSet(){
        linkedList = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public void add(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contain(e);
    }

    @Override
    public void delete(E e) {
        linkedList.remove(e);
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}

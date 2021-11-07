package per.zzb.set;

import java.util.Comparator;

/**
 * @ClassName : AVLSet
 * @Author : Zhai Zhibin
 * @Date : 2021/11/7 16:34
 * @Description : 使用AVL实现Set
 * @Modified_by :
 * @Version : 1.0
 **/
public class AVLSet<E extends Comparable> implements Set<E>{

    AVL<E,Integer> avl;

    public AVLSet(){
        avl = new AVL<>();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public void add(E e) {
        avl.add(e,0);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public void delete(E e) {
        avl.remove(e);
    }
}

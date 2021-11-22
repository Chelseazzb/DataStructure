package per.zzb;

/**
 * @ClassName : AVLMap
 * @Author : Zhai Zhibin
 * @Date : 2021/11/7 18:09
 * @Description : 使用AVL树实现map
 * @Modified_by :
 * @Version : 1.0
 **/
public class AVLMap<K extends Comparable,V> implements Map<K,V> {

    private AVL<K,V> avl;

    public AVLMap(){
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
    public boolean contains(K k) {
        return avl.contains(k);
    }

    @Override
    public void add(K k, V v) {
        avl.add(k,v);
    }

    @Override
    public void set(K k, V v) {
        avl.set(k,v);
    }

    @Override
    public void remove(K k) {
        avl.remove(k);
    }

    @Override
    public V get(K k) {
        return avl.get(k);
    }
}

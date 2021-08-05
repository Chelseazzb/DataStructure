package per.zzb.set;

/**
 * @ClassName : BSTSet
 * @Author : Zhai Zhibin
 * @Date : 2021/8/4 10:52
 * @Description : 利用二分搜索树实现的集合
 * @Modified_by :
 * @Version : 1.0
 **/
public class BSTSet<E extends Comparable> implements Set<E> {

    private BST bst; //定义一个二分搜索树

    public BSTSet() {
        bst = new BST();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void delete(E e) {
        bst.delete(e);
    }

    @Override
    public String toString() {
        String res = bst.toString();
        return res;
    }
}

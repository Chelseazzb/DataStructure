package per.zzb.set;

//集合的接口
public interface Set<E> {

    boolean isEmpty(); //判断集合是否为空
    int getSize();
    void add(E e);
    boolean contains(E e);
    void delete(E e);

}

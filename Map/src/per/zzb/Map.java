package per.zzb;

//集合接口
public interface Map<K,V> {

    boolean isEmpty();
    int getSize();
    boolean contains(K k);
    void add(K k,V v);
    void set(K k, V v);
    void remove(K k);
    V get(K k);
}

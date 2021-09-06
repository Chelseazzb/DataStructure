package per.zzb;

//定义并查集中的三个方法
public interface UF {
    boolean isConnected(int a, int b); //查看是否连接
    int find(int a); //找到根节点
    void unionElements(int p, int q);
}

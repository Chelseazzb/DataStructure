package per.zzb;

//第二版并查集
public class UnionFind2 implements UF {

    //底层存储根节点的数组
    int[] parent;

    //构造函数
    public UnionFind2(int size){
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int getSize(){
        return parent.length;
    }

    @Override
    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }

    @Override
    public int find(int a) {
        while (a != parent[a])
            a = parent[a];

        return a; //直接找到最终根节点
    }

    @Override
    public void unionElements(int a, int b){

        if (isConnected(a,b))
            return;

        int rootA = find(a);
        int rootB = find(b);

        parent[rootA] = rootB; //直接让a的根节点指向b的根节点
    }
}

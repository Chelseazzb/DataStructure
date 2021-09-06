package per.zzb;

//第一版并查集
public class UnionFind1 implements UF{

    //底层存储根节点的数组
    int[] parent;

    //构造函数
    public UnionFind1(int size){
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
        return parent[a];
    }

    @Override
    public void unionElements(int a, int b){

        int rootA = find(a);
        int rootB = find(b);

        if (isConnected(a,b))
            return;

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == rootA)
                parent[i] = rootB; //直接都让指向a的元素指向b
        }
    }
}

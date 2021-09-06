package per.zzb;

public class UnionFind3 implements UF {

    //底层存储根节点的数组
    int[] parent;
    int[] count; //利用size来优化

    //构造函数
    public UnionFind3(int size){
        parent = new int[size];
        count = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            count[i] = 1;
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

        //维护parent和size
        if (count[rootA] <= count[rootB]){
            parent[rootA] = rootB;
            count[rootB] += count[rootA];
            count[rootA] = count[rootB];
        } else {
            parent[rootB] = rootA;
            count[rootA] += count[rootB];
            count[rootB] = count[rootA];
        }


    }
}

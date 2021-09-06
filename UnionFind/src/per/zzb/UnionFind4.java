package per.zzb;

public class UnionFind4 implements UF {

    //底层存储根节点的数组
    int[] parent;
    int[] rank; //利用rank来优化

    //构造函数
    public UnionFind4(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int getSize() {
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
    public void unionElements(int a, int b) {

        if (isConnected(a, b))
            return;

        int rootA = find(a);
        int rootB = find(b);

        //维护parent和rank
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA] += 1;
        }


    }
}

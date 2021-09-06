package per.zzb;

//第六版并查集
public class UnionFind6 implements UF {

    //底层存储根节点的数组
    int[] parent;
    int[] rank; //利用rank来优化

    //构造函数
    public UnionFind6(int size) {
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
        if (a == parent[a])
            return a; //递归终止条件

        return find(parent[a]); //路径压缩，使用递归实现

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

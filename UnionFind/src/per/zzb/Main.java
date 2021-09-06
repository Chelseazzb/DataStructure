package per.zzb;

import java.util.Random;

//并查集的测试类
public class Main {

    private static double UFTest(UF uf , int size){
        long startTime = System.nanoTime();

        Random random = new Random();
        int a , b = 0;

        //union
        for (int i = 0; i < size; i++) {
            a = random.nextInt(size);
            b = random.nextInt(size);
            uf.unionElements(a,b);
        }

        //find
        for (int i = 0; i < size; i++) {
            a = random.nextInt(size);
            b = random.nextInt(size);
            uf.isConnected(a,b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0 ;
    }

    public static void main(String[] args) {

//        UnionFind1 uf1 = new UnionFind1(10);
//        System.out.println("1的根节点是: " + uf1.find(1));
//        System.out.println("1和2是否相连：" + uf1.isConnected(1,2));
//        uf1.unionElements(1,2);
//        System.out.println("1的根节点是: " + uf1.find(1));
//        System.out.println("1和2是否相连：" + uf1.isConnected(1,2));

//        UnionFind2 uf2 = new UnionFind2(10);
//        System.out.println("1的根节点是: " + uf2.find(1));
//        System.out.println("1和2是否相连：" + uf2.isConnected(1,2));
//        uf2.unionElements(1,2);
//        System.out.println("1的根节点是: " + uf2.find(1));
//        System.out.println("1和2是否相连：" + uf2.isConnected(1,2));

//        UnionFind3 uf3 = new UnionFind3(10);
//        System.out.println("1的根节点是: " + uf3.find(1));
//        System.out.println("1和2是否相连：" + uf3.isConnected(1,2));
//        uf3.unionElements(1,2);
//        System.out.println("1的根节点是: " + uf3.find(1));
//        System.out.println("1和2是否相连：" + uf3.isConnected(1,2));

        //比较多个版本UnionFind性能
        int size = 20000000;
        UnionFind1 unionFind1 = new UnionFind1(size);
        UnionFind2 unionFind2 = new UnionFind2(size);
        UnionFind3 unionFind3 = new UnionFind3(size);
        UnionFind4 unionFind4 = new UnionFind4(size);
        UnionFind5 unionFind5 = new UnionFind5(size);
        UnionFind6 unionFind6 = new UnionFind6(size);

//        System.out.println("UnionFind1所花费的时间：" + UFTest(unionFind1,size));
//        System.out.println("UnionFind2所花费的时间：" + UFTest(unionFind2,size));
        System.out.println("UnionFind3所花费的时间：" + UFTest(unionFind3,size));
        System.out.println("UnionFind4所花费的时间：" + UFTest(unionFind4,size));
        System.out.println("UnionFind5所花费的时间：" + UFTest(unionFind5,size));
        System.out.println("UnionFind6所花费的时间：" + UFTest(unionFind6,size));
    }
}

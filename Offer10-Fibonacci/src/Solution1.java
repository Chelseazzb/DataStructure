/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/19 9:49
 * @Description : 利用空间存储值来减少计算
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    static int mod = (int)1e9+7;
    static int N = 101;
    static int[] cache = new int[N];
    public int fib(int n) {
        if (n <= 1) return n;
        if (cache[n] != 0) return cache[n];
        cache[n] = fib(n - 1) + fib(n - 2);
        cache[n] %= mod;
        return cache[n];
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.fib(0));
        System.out.println(solution1.fib(1));
        System.out.println(solution1.fib(6));
    }
}

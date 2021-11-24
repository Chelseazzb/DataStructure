//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。

public class Solution {

    //O(n)超出时间限制
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0 || x == 1)
            return 1;
        if (n == 1)
            return x;

        if (x == -1)
            return n % 2 == 0 ? 1 : -1;

        long b = n; //Java 代码中 int32 变量 n in [-2147483648, 2147483647]n∈[−2147483648,2147483647] ，因此当 n = -2147483648n=−2147483648 时执行 n = -n 会因越界而赋值出错。
        // 解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。
        if (n < 0){
            x = 1/x;
            b = -b;
        }

        double sum = x;
        while (b > 1){
            sum *= x;
            b -= 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(0,5)); // 0
        System.out.println(solution.myPow(2,0)); // 1
        System.out.println(solution.myPow(10,1)); // 10
        System.out.println(solution.myPow(10,2)); // 100
        System.out.println(solution.myPow(2,-2147483648)); //0.25
    }
}

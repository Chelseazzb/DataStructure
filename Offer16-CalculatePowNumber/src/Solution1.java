
//https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
public class Solution1 {

    //向下整除 n // 2 等价于 右移一位 n >> 1 ；
    //取余数 n % 2 等价于 判断二进制最右一位值 n & 1 ；

    public double myPow(double x, int n) { //快速幂（二分法）
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}

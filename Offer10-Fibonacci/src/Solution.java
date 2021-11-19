/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/19 9:07
 * @Description : 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    //超出时间限制
    public int fib(int n) {
        //判断边界条件 , 0 =< n <= 100;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;


        return (fib(n-1) + fib(n-2))  % 1000000007;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(0));
        System.out.println(solution.fib(1));
        System.out.println(solution.fib(50));
    }
}

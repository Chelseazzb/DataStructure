//编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
//输入必须是长度为 32 的 二进制串 。
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1; //向右移，无符号右移需要 >>>
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println( 000000000000000000000000000010 & 1 );

        System.out.println(solution.hammingWeight(00000000000000000000000000001011));
    }

}

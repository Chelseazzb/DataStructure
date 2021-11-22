//巧妙利用 n-1 ，将时间复杂度优化为O(n中1的个数)
public class Solution1 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count ++;
            n &= n-1; //n-1后，n最后边的1会变为0，再进行与n-1操作原来n的最右边的1和后面的元素都会为0
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        System.out.println(solution1.hammingWeight(00000000000000000000000000001011));
    }
}

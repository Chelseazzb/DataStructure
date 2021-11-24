//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
public class Solution {

    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for(int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }

    private void printArr(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            System.out.print (nums[i] + "-");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = solution.printNumbers(1);
        solution.printArr(nums);
    }
}

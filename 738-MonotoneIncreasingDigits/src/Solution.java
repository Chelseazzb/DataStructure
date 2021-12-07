//给定一个非负整数N，找出小于或等于N的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
//当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。

import java.util.LinkedList;
import java.util.List;

public class Solution {

    //局部最优：遇到strNum[i - 1] > strNum[i]的情况，让strNum[i - 1]--，然后strNum[i]给为9，
    // 可以保证这两位变成最大单调递增整数。
    public int monotoneIncreasingDigits(int n) {
        if (n==0)return 0;
        char[] chars= Integer.toString(n).toCharArray();
        int start=Integer.MAX_VALUE;//start初始值设为最大值，这是为了防止当数字本身是单调递增时，没有一位数字需要改成9的情况
        for (int i=chars.length-1;i>0;i--){
            if (chars[i]<chars[i-1]){
                chars[i-1]--;
                start=i;
            }
        }
        StringBuilder res=new StringBuilder();
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='0'&&i==0)continue;//防止出现09这样的情况
            if (i>=start){
                res.append('9');
            }else res.append(chars[i]);
        }
        return Integer.parseInt(res.toString());
    }

    //检查是否单调递增，如果遍历到最后就是递增，返回的是单调递增的位数
    private int check(int[] arr){
        int i;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1])
                break;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{3,3,2};

        System.out.println(solution.check(arr));
        System.out.println(solution.monotoneIncreasingDigits(1000));
    }
}

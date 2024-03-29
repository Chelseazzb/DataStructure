//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
//
//对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j]。如果 s[j]>= g[i]，
// 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

import java.util.Arrays;

public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0)
            return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        //
        int child = 0; //记录孩子的下标
        for (int i = 0; i < s.length; i++) {
            if (child >= g.length)
                break; //遍历完所有孩子

            if (s[i] >= g[child]){
                count ++; //满足了当前的孩子
                child ++;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1,2};
        int[] s = new int[]{1,2,3};
        Solution solution = new Solution();

        System.out.println(solution.findContentChildren(g,s));
    }
}

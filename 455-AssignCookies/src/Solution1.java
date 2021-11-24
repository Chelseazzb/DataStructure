import java.util.Arrays;

//第二种方法：大饼干喂大胃口
public class Solution1 {

    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0)
            return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        //倒着遍历
        int index = s.length - 1; //记录孩子的下标
        for (int i = g.length - 1; i >= 0 ; i --) {
            if (index < 0)
                break; //遍历完所有饼干

            if (s[index] >= g[i]){
                count ++; //满足了当前的孩子
                index --;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        Solution solution = new Solution();

        System.out.println(solution.findContentChildren(g,s));
    }
}

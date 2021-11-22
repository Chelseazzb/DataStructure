/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/22 10:42
 * @Description : 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {
    int count = 0; //记录能走多少步

    public int movingCount(int m, int n, int k) {

        boolean[][] isUsed = new boolean[m][n];

        //不用两层循环了，因为就是从当前节点开始向下和向右
        backTracking(0, m, 0, n, k, isUsed);

        return count;
    }

    private void backTracking(int i, int m, int j, int n, int k, boolean[][] isUsed) {
        //回溯终止条件
        if ( i >= m || j >= n || isUsed[i][j] || (calculate(i) + calculate(j) > k))
            return;

            count++;
            isUsed[i][j] = true;
            backTracking(i + 1, m, j, n, k, isUsed);    //下
            backTracking(i, m, j + 1, n, k, isUsed);    //右
    }

    private int calculate(int number) {
        if (number < 10)
            return number;
        int ret = 0;
        while (number > 0) {
            ret += number % 10;
            number /= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate(109));
        System.out.println(solution.movingCount(16, 8, 4));
    }
}

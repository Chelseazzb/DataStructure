public class Solution1 {

    //空间优化
    public int minCostClimbingStairs(int[] cost) {

        //dp数组初始化
        int dp0 = cost[0];
        int dp1 = cost[1];

        //从前向后遍历
        for (int i = 2; i < cost.length; i++) {
            //递推公式
            int res = Math.min(dp0,dp1) + cost[i];
            dp0 = dp1;
            dp1 = res;
        }

        return Math.min(dp0,dp1); //返回dp数组后两个的最小值

    }
}

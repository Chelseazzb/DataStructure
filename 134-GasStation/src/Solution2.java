//全局最优方法
public class Solution2 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int min = Integer.MAX_VALUE;
        int curSum = 0;

        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i]; //计算从当前节点出发的累加油量

            if (curSum < min){ //更新最小值
                min = curSum;
            }
        }

        //情况一：
        if (curSum < 0) return -1;
        //情况二：
        if (min >= 0) return 0;

        //情况三：从后向前遍历，如果可以让min > 0，说明从当前位置可以跑一圈
        for (int i = gas.length - 1; i >= 0; i--) {
            curSum = gas[i] - cost[i];
            min += curSum;
            if (min >= 0) //找到油量剩余必min大的，就是起点
                return i;
        }

        return -1;

    }
}

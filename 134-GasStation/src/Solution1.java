//局部贪心：只从curSum > 0的位置开始尝试，如果total > 0，说明一定可以走完
public class Solution1 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int curSum = 0;
        int total = 0;

        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i]; //计算从当前节点出发的累加油量
            total += gas[i] - cost[i];

            if (curSum < 0){ //从start出发跑到中间没油了
                start = i + 1; //从下一个节点重新尝试
                curSum = 0; //清零
            }
        }

        if (total < 0) return -1; //油量不够跑完一圈
        return start;
    }

}

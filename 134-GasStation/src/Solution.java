//在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。
//
//你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
//
//如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
//
//说明:
//
//如果题目有解，该答案即为唯一答案。
//输入数组均为非空数组，且长度相同。
//输入数组中的元素均为非负数。


public class Solution {

    //超出时间限制
    public int canCompleteCircuit(int[] gas, int[] cost) {

        if (gas.length == 1)
            return gas[0] - cost[0] > 0 ? 0 : -1; //只有一个加油站，起点就是终点，直接返回

        int start = 0;
        while (gas[start] < cost[start]){ //找到起始加油站的位置，油足以走到下一个加油站
            start ++;
        }

        int len = gas.length;
        while (start <= len - 1){ //对于每一个节点看能不能到最后

            int total = gas[start] - cost[start];
            if (total < 0){
                start ++;
                continue;
            }

            int index = (start + 1) % len; //需要取余，因为需要环绕一周
            while (index != start){ //尝试是否可以环绕一周
                total += gas[index];
                if (total - cost[index] < 0)
                    break;
                else {
                    total -= cost[index];
                    index = (index + 1) % len;
                }
            }
            if (index == start) //可以环绕一周
                return start;
            else
                start ++;


        }

        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{4};
        int[] cost = new int[]{5};
        Solution solution = new Solution();

        System.out.println(solution.canCompleteCircuit(gas,cost));
    }
}

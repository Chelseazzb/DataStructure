/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/12/13 8:08
 * @Description : 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头最小的可能重量 。如果没有石头剩下，就返回 0。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    //转化成01背包
    //1 <= stones.length <= 30
    //1 <= stones[i] <= 100
    public int lastStoneWeightII(int[] stones) {
        if (stones.length == 1)
            return stones[0];

        int sum = 0;
        for (int i : stones){
            sum += i; //求和
        }
        int target = sum / 2; //求背包容量
        int[] dp = new int[target+1]; //无须初始化

        //先遍历物品，再遍历容量
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) { //倒叙遍历容量
                dp[j] = Math.max(dp[j],dp[j-stones[i]] + stones[i]);
            }
        }

        return (sum - dp[target]) - dp[target]; //dp[target]的含义是容量一半的情况下可以装多沉的石头
    }
}

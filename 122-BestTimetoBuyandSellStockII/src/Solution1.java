public class Solution1 {

    //如果想到其实最终利润是可以分解的，那么本题就很容易了！
    //
    //如何分解呢？
    //
    //假如第0天买入，第3天卖出，那么利润为：prices[3] - prices[0]。
    //
    //相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])。
    //
    //此时就是把利润分解为每天为单位的维度，而不是从0天到第3天整体去考虑！
    //收集正利润的区间，就是股票买卖的区间，而我们只需要关注最终利润，不需要记录区间。
    //
    //那么只收集正利润就是贪心所贪的地方！
    //
    //局部最优：收集每天的正利润，全局最优：求得最大利润。
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
}

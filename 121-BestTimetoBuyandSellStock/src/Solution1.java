public class Solution1 {

    //使用贪心法
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE; //不断找到最小的
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low,prices[i]); //贪心找最小的
            result = Math.max(result,prices[i] - low);
        }

        return result;
    }
}

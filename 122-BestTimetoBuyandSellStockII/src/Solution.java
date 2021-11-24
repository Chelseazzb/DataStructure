//给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
//
//设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

public class Solution {

    public int maxProfit(int[] prices) {

        //判断边界条件
        if (prices.length == 1)
            return 0;
        
        int maxValue = 0; //记录最大利润
        boolean isBought = false; // 判断是否进行了买入
        int buyPrice = 0; //记录买入的价格

        int pre = prices[0]; // 记录前一天的价格
        for (int i = 1; i < prices.length; i++) {
            if (i == prices.length - 1 && !isBought && prices[i] > pre){ //只剩两个元素的时候，注意！！！
                maxValue += prices[i] - pre;
            }

            if (pre < prices[i] && !isBought){ //前一天价格低的时候进行买入
                buyPrice = pre;
                isBought = true;
                pre = prices[i];
            } else if (prices[i] > pre && isBought && i != prices.length - 1 || pre > prices[i] && !isBought){ //价格还在上升的时候就不卖，还没到最后一天
                pre = prices[i];
            }  else if (isBought && pre > prices[i]){ //此时进行卖出，最高点卖出
                maxValue += pre - buyPrice;
                buyPrice = 0;
                isBought = false;
                pre = prices[i];
            } else if (i == prices.length - 1 && isBought && prices[i] > buyPrice){ //最后一天还没卖出
                maxValue += prices[i] - buyPrice;
                isBought = false;
            }
        }

        return maxValue;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,4};
        Solution solution = new Solution();

        solution.maxProfit(nums);
        System.out.println(solution.maxProfit(nums));
    }
}

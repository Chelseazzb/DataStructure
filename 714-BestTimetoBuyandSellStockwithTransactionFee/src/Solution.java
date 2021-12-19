//给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；整数fee代表了交易股票的手续费用。
//
//你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
//
//返回获得利润的最大值。

public class Solution {

    //此时无非就是要找到两个点，买入日期，和卖出日期。
    //
    //买入日期：其实很好想，遇到更低点就记录一下。
    //卖出日期：这个就不好算了，但也没有必要算出准确的卖出日期，只要当前价格大于（最低价格+手续费），就可以收获利润，至于准确的卖出日期，就是连续收获利润区间里的最后一天（并不需要计算是具体哪一天）。
    //所以我们在做收获利润操作的时候其实有三种情况：
    //
    //情况一：收获利润的这一天并不是收获利润区间里的最后一天（不是真正的卖出，相当于持有股票），所以后面要继续收获利润。
    //情况二：前一天是收获利润区间里的最后一天（相当于真正的卖出了），今天要重新记录最小价格了。
    //情况三：不作操作，保持原有状态（买入，卖出，不买不卖）
    //上面的贪心思想可以浓缩成一句话，即当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利。在遍历完整个数组 prices 之后之后，我们就得到了最大的总收益。

    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int sum = 0;
        for (int p : prices) {
            if (p + fee < buy) { //真正卖出，重新记录最小值
                buy = p + fee;
            } else if (p > buy){
                sum += p - buy; //计算持续的收益，只减一遍fee
                buy = p; //持续收获利润，如果后面还是在递增
            }
        }
        return sum;
    }


}

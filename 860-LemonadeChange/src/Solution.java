//在柠檬水摊上，每一杯柠檬水的售价为5美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
//
//每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
//注意，一开始你手头没有任何零钱。
//给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回true，否则返回 false。


public class Solution {

    //1 <= bills.length <= 105
    //bills[i] 不是 5 就是 10 或是 20

    public boolean lemonadeChange(int[] bills) {

        //1、判断边界条件
        if (bills[0] != 5)
            return false; //一开始没有零钱，只要不是5块就找不开

        int[] count = new int[2]; //0-5,1-10 代表零钱数量

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5)
                count[0] ++;
            else if (bills[i] == 10){
                if (count[0] < 1)
                    return false;
                else {
                    count[0] --;
                    count[1] ++;
                }
            } else { //收到20
                if ( (count[0] < 3 && count[1] < 1) || (count[0] < 1)) //没有10的就需要3张5，或者1张10、1张5
                    return false;
                else if (count[0] >= 1 && count[1] >= 1){ //优先消耗10美元，因为只能给20找零，贪心策略
                    count[0] --;
                    count[1] --;
                } else if (count[1] < 1 && count[0] >= 3){
                    count[0] -= 3;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] bills = new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        Solution solution = new Solution();

        System.out.println(solution.lemonadeChange(bills));
    }
}

//编写一个算法来判断一个数 n 是不是快乐数。
//
//「快乐数」定义为：
//
//    对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//    然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//    如果 可以变为  1，那么这个数就是快乐数。
//
//如果 n 是快乐数就返回 true ；不是，则返回 false 。

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> sum = new HashSet<>();  //存储当前的所有n的可能
        int count = 1;

        while (true){

            if (count > 32)
                return false;

            List<Integer> list = new ArrayList<>();
            int i = n % 10;
            while (n > 0){ //求出每一位
                list.add(i);
                n = n /10;
                i = n % 10;
            }

            for (int j : list){ //求和
                n += j * j;
            }


            //达到终止条件
            if (n == 1)
                return true;

            if (sum.contains(n)) //又回到出现过的位置
                return false;
            else
                sum.add(n);

            count ++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
    }
}

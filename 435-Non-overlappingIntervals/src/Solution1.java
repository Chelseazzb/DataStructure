import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {

    //难点一：一看题就有感觉需要排序，但究竟怎么排序，按左边界排还是右边界排。
    //难点二：排完序之后如何遍历，如果没有分析好遍历顺序，那么排序就没有意义了。
    //难点三：直接求重复的区间是复杂的，转而求最大非重复区间个数。
    //难点四：求最大非重复区间个数时，需要一个分割点来做标记。


    //我来按照右边界排序，从左向右记录非交叉区间的个数。最后用区间总数减去非交叉区间的个数就是需要移除的区间个数了。
    //此时问题就是要求非交叉区间的最大个数。
    //右边界排序之后，局部最优：优先选右边界小的区间，所以从左向右遍历，留给下一个区间的空间大一些，从而尽量避免交叉。全局最优：选取最多的非交叉区间
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return Integer.compare(o1[1],o2[1]);
                } else {
                    return Integer.compare(o1[0],o2[0]);
                }
            }
        });

        int count = 1;
        int edge = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (edge <= intervals[i][0]){
                count ++; //non overlap + 1
                edge = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}

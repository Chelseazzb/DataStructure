//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//
//注意:
//可以认为区间的终点总是大于它的起点。
//区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。

import java.util.Arrays;

public class Solution {

    //按区间的左边界排序
    public int eraseOverlapIntervals(int[][] intervals) {
        //1、边界条件
        if (intervals.length < 2 )
            return 0;

        Arrays.sort(intervals,(a, b)->{
            return Integer.compare(a[0],b[0]);
        });
        int remove = 0;
        int pre = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(pre>intervals[i][0]) {
                remove++;
                pre = Math.min(pre,intervals[i][1]);
            }
            else pre = intervals[i][1];
        }
        return remove;
    }
}

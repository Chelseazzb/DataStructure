//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
// 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        //判断边界条件
        if (intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); //按照开始区间进行排序
        List<int[]> list = new LinkedList<>();
        int start = intervals[0][0];
        int end = intervals[0][1]; //记录每个区间的右边界
        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][0] > end) {
                int[] arr = new int[]{start, end};
                list.add(arr);
                //更新新区间的开始和结束
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]); //更新右边界
            }

            if (i == intervals.length - 1){
                int[] arr = new int[]{start, end};
                list.add(arr);
                break;
            }
        }

//        int[][] merge = new int[list.size()][2];
//        for (int i = 0; i < list.size(); i++) {
//            merge[i] = list.get(i);
//        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8,10},
                {15,18}
        };
//        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
//        for (int i = 0; i < intervals.length; i++) {
//            System.out.println(intervals[i][0] + "-" + intervals[i][1]);
//        }
        Solution solution = new Solution();

        int[][] merge = solution.merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0] + "-" + merge[i][1]);
        }
    }
}

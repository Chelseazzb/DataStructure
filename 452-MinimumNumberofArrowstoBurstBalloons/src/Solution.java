//在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
//
//一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
// 我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
//
//给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    //1 <= points.length <= 104
    //points[i].length == 2
    //-231 <= xstart < xend <= 231 - 1

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int count = 1;// points 不为空至少需要一支箭
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) { // 气球i和气球i-1不挨着，注意这里不是>=
                count++;
            } else { //i和i-1挨着
                points[i][1] = Math.min(points[i][1],points[i - 1][1]); // 更新重叠气球最小右边界
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,6},{2,8},{7,12},{10,16}
        };

//        Arrays.sort(nums, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a, int[] b) {
//                return Integer.compare(a[0],b[0]);
//            }
//        }); //按照开始位置从小到大排列
//
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i][0] + " " + nums[i][1]);
//        }

        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(nums));
    }
}

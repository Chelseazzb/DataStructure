public class Solution2 {

    //针对于方法一的特殊情况，可以统一处理，即：移动下标只要遇到当前覆盖最远距离的下标，直接步数加一，不考虑是不是终点的情况。
    //
    //想要达到这样的效果，只要让移动下标，最大只能移动到nums.size - 2的地方就可以了。
    //
    //因为当移动下标指向nums.size - 2时：
    //
    //如果移动下标等于当前覆盖最大距离下标， 需要再走一步（即ans++），因为最后一步一定是可以到的终点。（题目假设总是可以到达数组的最后一个位置）
    public int jump(int[] nums) {
        int curDistance = 0;    // 当前覆盖的最远距离下标
        int ans = 0;            // 记录走的最大步数
        int nextDistance = 0;   // 下一步覆盖的最远距离下标
        for (int i = 0; i < nums.length - 1; i++) { // 注意这里是小于nums.size() - 1，这是关键所在
            nextDistance = Math.max(nums[i] + i, nextDistance); // 更新下一步覆盖的最远距离下标
            if (i == curDistance) {                 // 遇到当前覆盖的最远距离下标
                curDistance = nextDistance;         // 更新当前覆盖的最远距离下标
                ans++;
            }
        }
        return ans;
    }
}

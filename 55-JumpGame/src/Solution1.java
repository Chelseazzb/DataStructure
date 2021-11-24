/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/24 20:46
 * @Description : 每次更新覆盖范围
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]); //比较哪个范围更大
            if (coverRange >= nums.length - 1) { //可以覆盖最后一个位置就返回
                return true;
            }
        }
        return false;
    }
}

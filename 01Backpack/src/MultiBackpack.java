import java.util.LinkedList;
import java.util.List;

//多重背包
public class MultiBackpack {

    //多重背包就是01背包的变种，可以多加一重循环
    public static void test_multi_pack() {
        int[] weight = new int[]{1, 3, 4};
        int[] value = new int[]{15, 20, 30};
        int[] nums = new int[]{2, 3, 2};
        int bagWeight = 10;

        int[] dp = new int[bagWeight + 1];

        for (int i = 0; i < weight.length; i++) { //遍历物品
            for (int j = bagWeight; j >= weight[i]; j--) { //倒叙遍历
                for (int k = 1; k <= nums[i]; k++) {
                    if (j >= k * weight[i])
                        dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }

            //打印dp数组
            for (int j = 0; j <= bagWeight; j++) {
                System.out.print(dp[j] + "  ");
            }
            System.out.println();
        }
    }

    //将其转化为01背包
    public static void multi_pack_to01() {
        int[] weight = new int[]{1, 3, 4};
        int[] value = new int[]{15, 20, 30};
        int[] nums = new int[]{2, 3, 2};
        int bagWeight = 10;

        int[] dp = new int[bagWeight + 1];

        //定义list把weight改为动态数组
        List<Integer> weightList = new LinkedList<>();
        List<Integer> valueList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1) {
                weightList.add(weight[i]);
                valueList.add(value[i]);
                nums[i]--;
            }
        }

        for (int i = 0; i < weightList.size(); i++) { //遍历物品
            for (int j = bagWeight; j >= weightList.get(i); j--) { //倒叙遍历
                dp[j] = Math.max(dp[j], dp[j -  weightList.get(i)] +  valueList.get(i));

            }

            //打印dp数组
            for (int j = 0; j <= bagWeight; j++) {
                System.out.print(dp[j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        test_multi_pack();
        multi_pack_to01();
    }
}

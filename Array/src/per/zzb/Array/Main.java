package per.zzb.Array;
/**
 * @Author Zhai Zhibin
 * @Description 数组的基础定义和遍历
 * @Date 2020/9/26 10:31
 * @MethodName
 * @Param
 * @Return
 **/
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hey DataStructure");

        int[] arr = new int[10];
        for (int i = 0 ; i < arr.length ; i ++){
            arr[i] = i; //循环为每个位置初始化
        }

        int[] scores = new int[]{100,85,60};
        for (int score: scores) {
            System.out.println("score = " + score);
        }
    }
}

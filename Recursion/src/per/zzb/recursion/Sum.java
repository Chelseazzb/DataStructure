package per.zzb.recursion;

/**
 * @ClassName : Sum
 * @Author : Zhai Zhibin
 * @Date : 2021/7/24 9:48
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }

        return arr[l] + sum(arr, l + 1);

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(new Sum().sum(arr));
    }
}

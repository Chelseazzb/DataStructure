/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/16 19:46
 * @Description : 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0)
            return false;
        int column = matrix[0].length;
        if (column == 0)
            return false;


        for (int i = 0; i < row; i++) {
            if (matrix[i][0] > target) //后面的每一行最小的元素都比target大
                break;
            if (matrix[i][column - 1] < target) //每一行最大的都比target小
                continue;

            int j = -1;
            while (++j < column){
                if (matrix[i][j] == target)
                    return true;
                else
                    continue;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {}
        };
        System.out.println(new Solution().findNumberIn2DArray(arr,5));
    }
}

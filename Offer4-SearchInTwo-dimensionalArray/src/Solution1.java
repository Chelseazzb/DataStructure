/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/16 20:35
 * @Description : 选取右上角的元素
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //判断边界条件
        int row = matrix.length;
        if (row == 0)
            return false;
        int column = matrix[0].length;
        if (column == 0)
            return false;

        int y = column - 1;
        int x = 0;
        while (y >= 0 && x < row){
            if (matrix[x][y] > target){
                y--;
                continue;
            }
            if (matrix[x][y] == target)
                return true;
            if (matrix[x][y] < target){
                x ++;
                continue;
            }

        }

        return false;
    }
}

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
public class Solution {

    //0 <= matrix.length <= 100
    //0 <= matrix[i].length <= 100
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1; //全部坚持左闭右闭
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) { //右
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) { //下
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) { //判断left < right && top < bottom是为了防止最终只剩下一行或一列的时候重复遍历添加
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }


    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
//        };

        int[][] matrix = new int[][]{
                {7},{9},{6}
        };


        int[] print = new Solution().spiralOrder(matrix);

        for (int i = 0; i < print.length; i++) {
            System.out.print(print[i] + " ");
        }
    }
}

//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix

public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n]; //存储正方形的二维矩阵
        int num = 1; //从1到n
        int row = 0;
        int column = 0;

        //构造顺时针矩阵，主要分为四个步骤，右 - 下 - 左 - 上
        while (num <= n * n){

            //右
            while ( column < n  && matrix[row][column] == 0){
                matrix[row][column++] = num; //左开右闭，每次放n个元素
                num ++;
            }
            column --;
            row ++;

            //下
            while ( row < n && matrix[row][column] == 0){
                matrix[row++][column] = num;
                num ++;
            }
            row --;
            column --;

            //左
            while (column >= 0 && matrix[row][column] == 0){
                matrix[row][column--] = num; //左开右闭，每次只放n-1个元素
                num ++;
            }
            column ++;
            row --;

            //上
            while (row >= 0 && matrix[row][column] == 0){
                matrix[row--][column] = num;
                num ++;
            }
            row ++;
            column ++;

        }

        return matrix;
    }
}

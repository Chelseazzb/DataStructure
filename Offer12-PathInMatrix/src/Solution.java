/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/20 22:08
 * @Description : 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    //不能通过所有用例
    StringBuilder path = new StringBuilder();
    int index = 0; // 判断遍历到word第几个字符
    public boolean exist(char[][] board, String word) {
        //判断边界条件
        if (word == null || word.equals(""))
            return false;
        int rowLen = board.length;
        int columnLen = board[0].length;
        boolean[][] isUsed = new boolean[rowLen][columnLen]; //判断是否使用过
        return backTracking(board,word,0,rowLen,0,columnLen,isUsed,index);
    }

    private boolean backTracking(char[][] board, String word,int rowIndex,int rowLen,int columnIndex,int columnLen,boolean[][] isUsed,int index){

        //for循环横向纵向遍历
        for (int i = rowIndex; i < rowLen; i++) {
            for (int j = columnIndex; j < columnLen; j++) {
                //不匹配或越界则跳过
                if (i < 0 || j < 0 || i >= rowLen || j >= columnLen || board[i][j] != word.charAt(index) || isUsed[i][j] == true)
                    continue;

                //全部搜索完
                if(index == word.length() - 1) {
                    return true;
                }
                //走过的路，赋值 /0
                isUsed[i][j] = true;
                boolean res = backTracking(board, word, i-1,rowLen, columnIndex,columnLen, isUsed,index + 1) //上
                        || backTracking(board, word, i+1,rowLen, columnIndex,columnLen, isUsed,index + 1) //下
                        || backTracking(board, word, i, rowLen,j -1, columnLen,isUsed,index + 1) //左
                        || backTracking(board, word, i , rowLen, j + 1, columnLen,isUsed,index + 1); //右
                //回溯，恢复原来字符
                isUsed[i][j] = false;
                return res;

            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] words = new char[2][2];
        words[0][0] = 'a';
        words[0][1] = 'b';
        words[1][0] = 'c';
        words[1][1] = 'd';

        new Solution().exist(words,"abcd");
    }
}

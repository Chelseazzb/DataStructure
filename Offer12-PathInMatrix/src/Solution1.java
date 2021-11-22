/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/21 21:51
 * @Description : 深度优先搜索（DFS）+ 剪枝
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    /**
     * 参数k为 已经匹配字符的个数
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //越界 or  没找到work[k] 字母
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0
                || board[i][j] != word[k]) {
            return false;
        }
        //全部搜索完
        if(k == word.length - 1) {
            return true;
        }
        //走过的路，赋值 /0
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1)
                || dfs(board, word, i , j - 1, k + 1);
        //回溯，恢复原来字符
        board[i][j] = word[k];
        return res;
    }
}

import java.util.*;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/22 19:36
 * @Description : n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * @Modified_by :
 * @Version : 1.0
 **/
class Solution {

    List<List<String>> res = new ArrayList<>();

    /* 输入棋盘的边长n，返回所有合法的放置 */
    public List<List<String>> solveNQueens(int n) {
        // "." 表示空，"Q"表示皇后，初始化棋盘
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtrack(board, 0);
        return res;
    }

    public void backtrack(char[][] board, int row) {
        // 每一行都成功放置了皇后，记录结果
        if (row == board.length) {
            res.add(charToList(board));
            return;
        }

        int n = board[row].length;
        // 在当前行的每一列都可能放置皇后
        for (int col = 0; col < n; col++) {
            // 排除可以相互攻击的格子
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            board[row][col] = 'Q';
            // 进入下一行放皇后
            backtrack(board, row + 1);
            // 撤销选择
            board[row][col] = '.';
        }
    }

    /* 判断是否可以在 board[row][col] 放置皇后 */
    public boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; i >=0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List charToList(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] c : board) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

}

//解题思路：
//本题也是回溯算法的经典题目。N 皇后问题也是一个暴力穷举的问题。
//其实题目可以改成，在每一行放置一个皇后，让这些皇后不能相互攻击。（因为每一行最多只有一个皇后）
//我们可以先不考虑每一个皇后之间不能相互攻击的条件，如果要求每行只能放一个皇后，我们能否穷举出所有的放置方法？
//考虑皇后之间相互攻击的问题
//对于每一个格子进行计算分析能不能放置皇后，最后的代码实现会跳过这些格子，把皇后放在合法的位置上。
//具体的，在每一个位置放置皇后，然后调用 backtrack 函数，进入下一行进行穷举进行判断
//isValid 函数的逻辑
//按照题意我们需要检查八个方向是否有其他方向，但实际上我们只需要检查三个方向即可。
//因为我们的逻辑是每一行只放一个皇后，所以这个皇后的左边和右边不需要进行检查了。
//因为我们是一行一行从上向下放置皇后，所以下方，左下方和右下方不会有皇后（还没放皇后）。
//最后我们需要检查的只有上方、左上和右上三个方向。
//函数 backtrack 依然像个在决策树上游走的指针，每个节点就表示在 board[row][col] 上放置皇后，通过 isValid 函数可以将不符合条件的情况剪枝。
//  N 皇后的时间复杂度比较高。



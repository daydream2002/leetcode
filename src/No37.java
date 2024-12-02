import java.util.Arrays;
import java.util.HashSet;

/**
 * Author daydream
 * Description
 * Date 2024/11/28 14:16
 */
public class No37 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        new Solution37().solveSudoku(board);

    }
}

class Solution37 {

    public void solveSudoku(char[][] board) {

        dfs(board);
//        System.out.println(Arrays.deepToString(board));
    }

    boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k < 10; k++) {
                        if (isValid(board, i, j, (char) (k + '0'))) {
                            board[i][j] = (char) (k + '0');
                            if (dfs(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int x, int y, char c) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == c)
                return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == c)
                return false;
        }
        for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
                if (board[i][j] == c)
                    return false;
            }
        }
        return true;
    }
}
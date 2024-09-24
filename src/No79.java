/**
 * @author wjh
 * @date 2024/7/21 下午3:00
 */
public class No79 {
    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        solution79.exist(board, "ABCCED");

    }
}

//回溯算法
class Solution79 {
    boolean flag;

    public boolean exist(char[][] board, String word) {
        int i = 0, j = 0, k = 0;
        for (int i1 = 0; i1 < board.length; i1++) {
            for (int i2 = 0; i2 < board[0].length; i2++) {
                dfs(board, word, i1, i2, k);
            }
        }
        dfs(board, word, i, j, k);
        System.out.println(flag);
        return flag;
    }

    void dfs(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            flag = true;
            return;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == ' ')
            return;
        if (board[i][j] == word.charAt(k)) {
            board[i][j] = ' ';
            dfs(board, word, i + 1, j, k + 1);
            dfs(board, word, i - 1, j, k + 1);
            dfs(board, word, i, j - 1, k + 1);
            dfs(board, word, i, j + 1, k + 1);
            board[i][j] = word.charAt(k);
        }

    }

}

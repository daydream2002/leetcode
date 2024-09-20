import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/9/20 09:29
 */
public class No289 {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new Solution289Two().gameOfLife(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}

//使用额外空间
class Solution289One {
    public void gameOfLife(int[][] board) {
        int high = board.length;
        int width = board[0].length;
        int[][] arr = new int[high][width];
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                int count = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int t = -1; t <= 1; t++) {
                        if (!(k == 0 && t == 0))
                            if (i + k >= 0 && j + t >= 0 && i + k < high && j + t < width)
                                if (board[i + k][j + t] == 1)
                                    count++;
                    }
                }
                if (board[i][j] == 1) {
                    {
                        if (count == 2 || count == 3)
                            arr[i][j] = 1;
                    }
                } else {
                    if (count == 3)
                        arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = arr[i][j];
            }
        }
    }
}

//使用o(1)空间
class Solution289Two {
    public void gameOfLife(int[][] board) {
        int high = board.length;
        int width = board[0].length;
        int[][] arr = new int[high][width];
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                int count = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int t = -1; t <= 1; t++) {
                        if (!(k == 0 && t == 0))
                            if (i + k >= 0 && j + t >= 0 && i + k < high && j + t < width)
                                if (board[i + k][j + t] == 1 || board[i + k][j + t] == -1)
                                    count++;
                    }
                }
                if (board[i][j] == 1) {
                    {
                        if (count < 2 || count > 3)
                            board[i][j] = -1;
                    }
                } else {
                    if (count == 3)
                        board[i][j] = 2;
                }

            }
        }
        for (int i1 = 0; i1 < high; i1++) {
            for (int j1 = 0; j1 < width; j1++) {
                if (board[i1][j1] == -1)
                    board[i1][j1] = 0;
                if (board[i1][j1] == 2)
                    board[i1][j1] = 1;
            }
        }
    }
}
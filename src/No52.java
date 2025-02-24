/**
 * Author daydream
 * Description
 * Date 2025/2/23 15:25
 */
public class No52 {
}
class Solution {
    int res = 0;
    boolean[][] visited;

    public int totalNQueens(int n) {
        visited = new boolean[3][2 * n];
        backtrack(visited, 0, n);
        return res;
    }

    void backtrack(boolean[][] visited, int depth, int n) {
        if (depth == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[0][i] && !visited[1][i + depth] && !visited[2][i - depth + n]) {
                visited[0][i] = true;
                visited[1][i + depth] = true;
                visited[2][i - depth + n] = true;
                backtrack(visited, depth + 1, n);
                visited[0][i] = false;
                visited[1][i + depth] = false;
                visited[2][i - depth + n] = false;
            }
        }
    }
}
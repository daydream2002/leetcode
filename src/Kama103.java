import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author daydream
 * Description
 * Date 2025/1/15 10:09
 */
public class Kama103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][m];
        ArrayList<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited1 = new boolean[n][m];
        boolean[][] visited2 = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(graph, visited1, i, 0);
            dfs(graph, visited2, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(graph, visited1, 0, i);
            dfs(graph, visited2, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited1[i][j] && visited2[i][j]) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    static void dfs(int[][] graph, boolean[][] visited, int x, int y) {
        if (!isValid(graph, x, y) || visited[x][y])
            return;
        visited[x][y] = true;
        if (isValid(graph, x + 1, y) && graph[x + 1][y] >= graph[x][y])
            dfs(graph, visited, x + 1, y);
        if (isValid(graph, x, y + 1) && graph[x][y + 1] >= graph[x][y])
            dfs(graph, visited, x, y + 1);
        if (isValid(graph, x - 1, y) && graph[x - 1][y] >= graph[x][y])
            dfs(graph, visited, x - 1, y);
        if (isValid(graph, x, y - 1) && graph[x][y - 1] >= graph[x][y])
            dfs(graph, visited, x, y - 1);
    }

    static boolean isValid(int[][] graph, int x, int y) {
        if (x < 0 || y < 0 || x >= graph.length || y >= graph[0].length)
            return false;
        return true;
    }
}

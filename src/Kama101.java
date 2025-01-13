import java.util.Scanner;

/**
 * Author daydream
 * Description
 * Date 2025/1/13 09:50
 */
public class Kama101 {
    static int res = 0;
    static boolean flag;

    public static void main(String[] args) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    flag = true;
                    dfs(graph, visited, i, j);
                    if (flag) {
                        result = result + res;
                    }
                    res = 0;
                }
            }
        }
        System.out.println(result);
    }

    static void dfs(int[][] graph, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= visited.length || y >= visited[0].length) {
            flag = false;
            return;
        }
        if (visited[x][y] || graph[x][y] == 0)
            return;
        visited[x][y] = true;
        res += 1;
        dfs(graph, visited, x - 1, y);
        dfs(graph, visited, x + 1, y);
        dfs(graph, visited, x, y - 1);
        dfs(graph, visited, x, y + 1);
    }
}

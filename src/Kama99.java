import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2025/1/8 10:00
 */
public class Kama99 {
    /*    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] graph = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }
            int res = 0;
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j]&&graph[i][j] == 1) {
                        res++;
                        dfs(graph, visited, i, j);
                    }
                }
            }
            System.out.println(res);
        }

        static void dfs(int[][] graph, boolean[][] visited, int x, int y) {
            if (x < 0 || y < 0 || x >= graph.length || y >= graph[0].length || visited[x][y])
                return;
            if (graph[x][y] == 1) {
                visited[x][y] = true;
                dfs(graph, visited, x - 1, y);
                dfs(graph, visited, x + 1, y);
                dfs(graph, visited, x, y - 1);
                dfs(graph, visited, x, y + 1);
            }
        }*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        if (isValid(graph, poll[0] + 1, poll[1]) && !visited[poll[0] + 1][poll[1]]) {
                            queue.add(new int[]{poll[0] + 1, poll[1]});
                            visited[poll[0] + 1][poll[1]] = true;
                        }
                        if (isValid(graph, poll[0] - 1, poll[1]) && !visited[poll[0] - 1][poll[1]]) {
                            visited[poll[0] - 1][poll[1]] = true;
                            queue.add(new int[]{poll[0] - 1, poll[1]});
                        }
                        if (isValid(graph, poll[0], poll[1] + 1) && !visited[poll[0]][poll[1] + 1]) {
                            visited[poll[0]][poll[1] + 1] = true;
                            queue.add(new int[]{poll[0], poll[1] + 1});
                        }
                        if (isValid(graph, poll[0], poll[1] - 1) && !visited[poll[0]][poll[1] - 1]) {
                            queue.add(new int[]{poll[0], poll[1] - 1});
                            visited[poll[0]][poll[1] - 1] = true;
                        }
                    }
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    static boolean isValid(int[][] graph, int x, int y) {
        return x >= 0 && x < graph.length && y >= 0 && y < graph[0].length && graph[x][y] == 1;
    }
}

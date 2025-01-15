/**
 * Author daydream
 * Description
 * Date 2025/1/14 10:38
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author daydream
 * Description
 * Date 2025/1/13 09:50
 */
public class Kama102 {

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
        for (int i = 0; i < graph.length; i++) {
            dfs(graph, i, 0);
            dfs(graph, i, graph[0].length - 1);
        }
        for (int i = 0; i < graph[0].length; i++) {
            dfs(graph, 0, i);
            dfs(graph, graph.length - 1, i);
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 2) {
                    graph[i][j] = 1;
                } else if (graph[i][j] == 1) {
                    graph[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int[][] graph, int x, int y) {
        if (x < 0 || y < 0 || x >= graph.length || y >= graph[0].length || graph[x][y] == 0 || graph[x][y] == 2)
            return;
        graph[x][y] = 2;
        dfs(graph, x - 1, y);
        dfs(graph, x + 1, y);
        dfs(graph, x, y - 1);
        dfs(graph, x, y + 1);
    }
}

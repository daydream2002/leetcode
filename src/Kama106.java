import java.util.Scanner;

public class Kama106 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = 0;
        int m = scanner.nextInt();
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    res = res + isBian(graph, i, j);
                }
            }
        }
        System.out.println(res);
    }

    //判断是否为岛屿的边界
    static int isBian(int[][] graph, int x, int y) {
        int[] direction = {0, 1, 0, -1, 1, 0, -1, 0};
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[2 * i];
            int newY = y + direction[2 * i + 1];
            if (newX < 0 || newX >= graph.length || newY < 0 || newY >= graph[0].length || graph[newX][newY] == 0) {
                res++;
            }
        }
        return res;
    }
}

import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2025/1/16 14:46
 */
public class Kama104 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = 2;
        boolean flag = true;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 0) flag = false;
                if (graph[i][j] == 1) {
                    count = 0;
                    dfs(graph, visited, i, j, target);
                    map.put(target, count);
                    target++;
                }
            }
        }
        if (flag) {
            System.out.println(m * n);
            return;
        }
        HashSet<Integer> visitedIsland = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 0) {
                    count = 0;
                    visitedIsland.clear();
                    if (i - 1 >= 0)
                        if (map.containsKey(graph[i - 1][j]) && !visitedIsland.contains(graph[i - 1][j])) {
                            count += map.get(graph[i - 1][j]);
                            visitedIsland.add(graph[i - 1][j]);
                        }
                    if (i + 1 < graph.length)
                        if (map.containsKey(graph[i + 1][j]) && !visitedIsland.contains(graph[i + 1][j])) {
                            count += map.get(graph[i + 1][j]);
                            visitedIsland.add(graph[i + 1][j]);
                        }
                    if (j - 1 >= 0)
                        if (map.containsKey(graph[i][j - 1]) && !visitedIsland.contains(graph[i][j - 1])) {
                            count += map.get(graph[i][j - 1]);
                            visitedIsland.add(graph[i][j - 1]);
                        }
                    if (j + 1 < graph[0].length)
                        if (map.containsKey(graph[i][j + 1]) && !visitedIsland.contains(graph[i][j + 1])) {
                            count += map.get(graph[i][j + 1]);
                            visitedIsland.add(graph[i][j + 1]);
                        }
                    result = Math.max(result, count + 1);
                }
            }
        }
        System.out.println(result);
    }

    static void dfs(int[][] graph, boolean[][] visited, int i, int j, int target) {
        if (i < 0 || i >= graph.length || j < 0 || j >= graph[0].length || graph[i][j] == 0 || visited[i][j]) {
            return;
        }
        count++;
        graph[i][j] = target;
        visited[i][j] = true;
        dfs(graph, visited, i - 1, j, target);
        dfs(graph, visited, i + 1, j, target);
        dfs(graph, visited, i, j - 1, target);
        dfs(graph, visited, i, j + 1, target);
    }
}

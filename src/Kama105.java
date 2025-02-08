/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Author daydream
 * Description
 * Date 2025/2/8 09:25
 *//*

 */
/*
public class Kama105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] graph = new int[n][n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x - 1][y - 1] = 1;
        }
        dfs(graph, visited, 0);
        for (boolean b : visited) {
            if (!b) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(1);
    }

    static void dfs(int[][] graph, boolean[] visited, int x) {
        if (visited[x])
            return;
        visited[x] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[x][i] == 1) {
                dfs(graph, visited, i);
            }
        }
    }
}
*//*

public class Kama105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.get(x - 1).add(y - 1);
        }
        dfs(list, visited, 0);
        for (boolean b : visited) {
            if (!b) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(1);
    }

    static void dfs(ArrayList<ArrayList<Integer>> list, boolean[] visited, int x) {
        if (visited[x])
            return;
        visited[x] = true;
        for (int i = 0; i < list.get(x).size(); i++) {
            dfs(list, visited, list.get(x).get(i));
        }
    }
}
*/
class Kama105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x - 1][y - 1] = 1;
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < n; i++) {
                if (graph[x][i] == 1) {
                    if (!visited[i]){
                        queue.offer(i);
                        visited[i]=true;
                    }
                }
            }
        }
        for (boolean b : visited) {
            if (!b) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(1);
    }
}
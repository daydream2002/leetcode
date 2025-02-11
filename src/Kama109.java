import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kama109 {
    static int[] father;

    static void init(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    static int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    static boolean isSame(int x, int y) {
        return find(x) == find(y);
    }

    static void join(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y)
            father[x] = y;
    }
    static void clear() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    static boolean isTreeAfterRemoveEdge(int[][] edges, int deletedEdge) {
        clear();
        for (int i = 0; i < edges.length; i++) {
            if (i == deletedEdge) {
                continue;
            }
            if (isSame(edges[i][0], edges[i][1])) {
                return false;
            }
            join(edges[i][0], edges[i][1]);
        }
        return true;
    }

    static void getRemoveEdge(int[][] edges) {
        clear();
        for (int i = 0; i < edges.length; i++) {
            if (isSame(edges[i][0], edges[i][1])) {
                System.out.println(edges[i][0] + " " + edges[i][1]);
                return;
            }
            join(edges[i][0], edges[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] edges = new int[n][2];
        int[] inDegree = new int[n + 1];
        init(n + 1);
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            edges[i][0] = x;
            edges[i][1] = y;
            inDegree[y]++;
        }
        List<Integer> vec = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                vec.add(i);
            }
        }
        if (vec.size() > 0) {
            if (isTreeAfterRemoveEdge(edges, vec.get(0))) {
                System.out.println(edges[vec.get(0)][0] + " " + edges[vec.get(0)][1]);
                return;
            } else {
                System.out.println(edges[vec.get(1)][0] + " " + edges[vec.get(1)][1]);
                return;
            }
        }
        getRemoveEdge(edges);
    }
}

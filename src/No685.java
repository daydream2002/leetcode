import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No685 {
    public static void main(String[] args) {
        int[] redundantDirectedConnection = new Solution685().findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
        System.out.println(Arrays.toString(redundantDirectedConnection));
    }
}

class Solution685 {
    int[] father;

    void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    int find(int u) {
        if (u == father[u])
            return u;
        father[u] = find(father[u]);
        return father[u];
    }

    void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v)
            return;
        father[u] = v;
    }

    boolean same(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    boolean isTreeAfterRemoveEdge(int[][] edges, int deleteEdge) {
        init();
        for (int i = 0; i < edges.length; i++) {
            if (i == deleteEdge) continue;
            if (same(edges[i][0], edges[i][1])) {
                return false;
            }
            join(edges[i][0], edges[i][1]);
        }
        return true;
    }

    int[] getRemoveEdge(int[][] edges) {
        init();
        for (int i = 0; i < edges.length; i++) {
            if (same(edges[i][0], edges[i][1])) {
                return edges[i];
            } else
                join(edges[i][0], edges[i][1]);
        }
        return new int[2];
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        father = new int[edges.length + 1];
        init();
        int[] inDegree = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            inDegree[edges[i][1]]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int n = edges.length - 1; n >= 0; n--) {
            if (inDegree[edges[n][1]] == 2)
                list.add(n);
        }
        if (list.size() > 0) {
            if (isTreeAfterRemoveEdge(edges, list.get(0)))
                return edges[list.get(0)];
            else
                return edges[list.get(1)];
        }
        return getRemoveEdge(edges);
    }
}
public class No684 {
}

class Solution684 {
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
        v = find(v);
        u = find(u);
        if (u == v)
            return;
        father[v] = u;
    }

    boolean same(int u, int v) {
        v = find(v);
        u = find(u);
        return u == v;
    }

    public int[] findRedundantConnection(int[][] edges) {
        father = new int[edges.length+1];
        init();
        int[] res;
        for (int[] edge : edges) {
            if (same(edge[0], edge[1]))
                return edge;
            else {
                join(edge[0], edge[1]);
            }
        }
        return edges[0];
    }
}
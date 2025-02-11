import java.util.Scanner;

public class Kama107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        UnionFind unionFind = new UnionFind();
        unionFind.init(n);
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            unionFind.join(x, y);
        }
        int source = scanner.nextInt();
        int destination = scanner.nextInt();
        if (unionFind.isSame(source, destination)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}

class UnionFind {
    int[] father;

    // 并查集初始化
    void init(int n) {
        father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
    }

    int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    boolean isSame(int x, int y) {
        return find(x) == find(y);
    }

    void join(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            father[x] = y;
        }
    }
}

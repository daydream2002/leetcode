import java.util.Scanner;

public class Kama108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        UnionFind unionFind = new UnionFind();
        unionFind.init(n);
        String res = "";
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (unionFind.isSame(x, y)) {
                res = x + " " + y;
            }
            unionFind.join(x, y);
        }
        System.out.println(res);
    }
}

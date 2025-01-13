import java.util.*;


public class Test {
    static List<Integer> list = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][N];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a - 1][b - 1] = 1;
        }
        list.add(0);
        dfs(map);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size() - 1; j++) {
                System.out.print(res.get(i).get(j) + 1 + " ");
            }
            System.out.println(res.get(i).get(res.get(i).size() - 1) + 1);
        }
    }

    static void dfs(int[][] map) {
        int start = list.get(list.size() - 1);
        if (start == map.length - 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[start][i] == 1) {
                list.add(i);
                dfs(map);
                list.removeLast();
            }
        }
    }
}
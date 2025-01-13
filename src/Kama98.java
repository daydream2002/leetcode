/**
 * Author daydream
 * Description
 * Date 2025/1/7 10:38
 */

import java.util.*;


public class Kama98 {
    static List<Integer> list = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<List<Integer>> map = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map.get(a - 1).add(b - 1);
        }
        list.add(0);
        dfs(map, N);
        if (res.size() == 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size() - 1; j++) {
                    System.out.print(res.get(i).get(j) + 1 + " ");
                }
                System.out.println(res.get(i).get(res.get(i).size() - 1) + 1);
            }
        }
    }

    static void dfs(List<List<Integer>> map, int N) {
        if (list.get(list.size() - 1) == N - 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        int start = list.get(list.size() - 1);
        for (int i = 0; i < map.get(start).size(); i++) {
            list.add(map.get(start).get(i));
            dfs(map, N);
            list.remove(list.size() - 1);
        }
    }
}
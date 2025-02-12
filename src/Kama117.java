import java.util.*;

public class Kama117 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] indegree = new int[n];
        List<List<Integer>> map = new ArrayList<>();
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map.get(a).add(b);
            indegree[b]++;
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                result.add(i);
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer i : map.get(poll)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    result.add(i);
                    queue.add(i);
                }
            }
        }
        if (result.size() != n) {
            System.out.print(-1);
            return;
        }
        for (int i = 0; i < result.size()-1; i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println(result.get(result.size()-1));
    }
}

import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
import java.util.*;

class Main {
    static class Node {
        int x, y, time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine();
        char[][] maze = new char[N][N];
        for (int i = 0; i < N; i++) {
            maze[i] = scanner.nextLine().toCharArray();
        }
        int result = bfs(maze, N, K);
        System.out.println(result);
    }

    public static int bfs(char[][] maze, int N, int K) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.offer(new Node(0, 0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.x == N - 1 && current.y == N - 1) {
                return current.time;
            }
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }
                if (maze[nx][ny] == '1') {
                    continue;
                }
                int newTime = current.time;
                if (maze[nx][ny] == '#') {
                    newTime += K + 1;
                } else {
                    newTime += 1;
                }
                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny, newTime));
            }
        }
        return -1;
    }
}

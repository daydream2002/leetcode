import java.util.Scanner;

/**
 * Author daydream
 * Description
 * Date 2024/12/14 15:45
 */
public class KaMa46 {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] map = new int[2][M];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[M][N + 1];
        //初始化dp数组
        for (int i = 0; i < N + 1; i++) {
            if (i >= map[0][0])
                dp[0][i] = map[1][0];
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                if (j >= map[0][i])
                    dp[i][j] = Math.max(dp[i - 1][j - map[0][i]] + map[1][i], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[M - 1][N]);
    }*/
    //空间优化版
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] map = new int[2][M];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int[] dp = new int[N + 1];
        //初始化dp数组
        for (int i = 0; i < N + 1; i++) {
            if (i >= map[0][0])
                dp[i] = map[1][0];
        }
        for (int i = 1; i < M; i++) {
            for (int j = N; j >= 1; j--) {
                if (j >= map[0][i])
                    dp[j] = Math.max(dp[j - map[0][i]] + map[1][i], dp[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
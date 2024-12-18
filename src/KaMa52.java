import java.util.Arrays;
import java.util.Scanner;

/**
 * Author daydream
 * Description
 * Date 2024/12/18 11:53
 */
public class KaMa52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] weights = new int[a];
        int[] values = new int[a];
        for (int i = 0; i < a; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        int[][] dp = new int[a][b + 1];
        for (int i = weights[0]; i <= b; i++) {
            dp[0][i] = dp[0][i - weights[0]] + values[0];
        }
        for (int i = 1; i < a; i++) {
            for (int j = 0; j <= b; j++) {
                if (j >= weights[i])
                    //关键代码,i-1变成i，表示在同一层可以重复选同一件物品
                    dp[i][j] = Math.max(dp[i][j - weights[i]] + values[i], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(Arrays.deepToString(dp));
    }
}

import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/8/19
 */
public class No64 {
    public static void main(String[] args) {
        int res = new Solution64_2().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(res);
    }
}

class Solution64 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        System.out.println(Arrays.deepToString(dp));
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}

class Solution64_2 {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0)
                    dp[j] = dp[j] + grid[i][j];
                else
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[grid[0].length - 1];
    }
}
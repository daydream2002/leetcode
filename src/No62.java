import java.util.Arrays;

/**
 * @author wjh
 * @date 2024/8/18 20:10
 */
public class No62 {
    public static void main(String[] args) {
        int res = new Solution62_2().uniquePaths(3, 7);
        System.out.println(res);
    }
}

//递归算法，会超时
class Solution62_1 {
    int res = 0, m, n;

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        dp(0, 0);
        return res;
    }

    void dp(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            res++;
            return;
        }
        if (x == m || y == n)
            return;
        dp(x + 1, y);
        dp(x, y + 1);
    }
}

class Solution62_2 {
    public int uniquePaths(int m, int n) {
        //dp[i][j]表示起点到i，j的路径数量
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

//矩阵压缩
class Solution62_3 {
    public int uniquePaths(int m, int n) {
        //dp[i][j]表示起点到i，j的路径数量
        int[]dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}

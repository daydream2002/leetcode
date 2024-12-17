import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/12/17 21:55
 */
public class No474 {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int maxForm = new Solution474Two().findMaxForm(strs, 5, 3);
    }
}

class Solution474One {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        int[] fun1 = fun(strs[0]);
        for (int i = fun1[0]; i <= m; i++) {
            for (int j = fun1[1]; j <= n; j++) {
                dp[0][i][j] = 1;
            }
        }
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int[] fun = fun(strs[i]);
                    if (j >= fun[0] && k >= fun[1])
                        dp[i][j][k] = Math.max(dp[i - 1][j - fun[0]][k - fun[1]] + 1, dp[i - 1][j][k]);
                    else
                        dp[i][j][k] = dp[i - 1][j][k];
                }
            }
        }
        return dp[strs.length - 1][m][n];
    }

    int[] fun(String string) {
        int[] res = new int[2];
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '0')
                res[0]++;
            else
                res[1]++;
        }
        return res;
    }
}

//空间优化版
class Solution474Two {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int[] fun1 = fun(strs[0]);
        for (int i = fun1[0]; i <= m; i++) {
            for (int j = fun1[1]; j <= n; j++) {
                dp[i][j] = 1;
            }
        }
        for (int i = 1; i < strs.length; i++) {
            int[] fun = fun(strs[i]);
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j >= fun[0] && k >= fun[1])
                        dp[j][k] = Math.max(dp[j - fun[0]][k - fun[1]] + 1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }

    int[] fun(String string) {
        int[] res = new int[2];
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '0')
                res[0]++;
            else
                res[1]++;
        }
        return res;
    }
}
/**
 * Author daydream
 * Description
 * Date 2024/12/14 15:17
 */
public class No96 {
}

class Solution96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <i; j++) {
                dp[i] = dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
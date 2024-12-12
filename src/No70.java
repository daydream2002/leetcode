/**
 * Author daydream
 * Description
 * Date 2024/12/12 20:57
 */
public class No70 {
}

class Solution702 {
    int[] dp;

    public int climbStairs(int n) {
        if (n < 3)
            return n;
        dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
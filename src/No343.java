/**
 * Author daydream
 * Description
 * Date 2024/12/14 14:54
 */
public class No343 {
    public static void main(String[] args) {
        int i = new Solution343().integerBreak(10);
        System.out.println(i);
    }
}

class Solution343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(Math.max(dp[j], j) * Math.max(dp[i - j], i - j), dp[i]);
            }
        }
        return dp[n];
    }
}
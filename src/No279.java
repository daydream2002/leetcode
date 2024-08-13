/**
 * @Author daydream
 * @Description 力扣完全平方数
 * @Date 2024/8/12
 */
public class No279 {
    public static void main(String[] args) {
        int ans = new Solution279().numSquares(13);
        System.out.println(ans);
    }
}

class Solution279 {
    int[] dp;
    public int numSquares(int n) {
        dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            if (i == 0)
                dp[i] = 0;
            dp[i] = i;
            for (int j = 0; j <= (int) Math.sqrt(i * 1.0); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}


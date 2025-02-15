import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/12/22 21:09
 */
public class No123 {
    public static void main(String[] args) {
        int i = new Solution123().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println(i);
    }
}

class Solution123 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][2] + prices[i], dp[i - 1][3]);
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[prices.length - 1][3];
    }
}
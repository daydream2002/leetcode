/**
 * Author daydream
 * Description
 * Date 2024/12/24 10:12
 */
public class No306 {
}
class Solution306 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[1][0] = Math.max(-prices[0], -prices[1]);
        dp[1][1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/12/23 21:41
 */
public class No188 {
    public static void main(String[] args) {
        int i = new Solution188().maxProfit(2, new int[]{2, 4, 1});
        System.out.println(i);
    }
}

class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][2 * j + 1] = Math.max(dp[i - 1][2 * j + 1], dp[i - 1][2 * j] - prices[i]);
                dp[i][2 * j + 2] = Math.max(dp[i - 1][2 * j + 2], dp[i - 1][2 * j + 1] + prices[i]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[prices.length - 1][2 * k];
    }
}
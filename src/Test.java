import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/12/18 20:25
 */
public class Test {
    public static void main(String[] args) {
        int rob = new SolutionTest().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(rob);
    }
}

class SolutionTest {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        //dp[i][0]持有股票dp[i][1]不持有股票
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);;
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[prices.length - 1][1];
    }
}
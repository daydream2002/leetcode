/**
 * Author daydream
 * Description
 * Date 2024/9/3
 */
public class No122 {
    public static void main(String[] args) {
        int i = new Solution122_2().maxProfit(new int[]{1, 2, 3, 4, 5});
        System.out.println(i);
    }
}

//贪心算法
class Solution122_1 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1])
                profit += prices[i + 1] - prices[i];
        }
        return profit;
    }
}

//dp算法
class Solution122_2 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
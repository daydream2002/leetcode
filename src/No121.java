/**
 * @Author daydream
 * @Description
 * @Date 2024/8/5
 */
public class No121 {
    public static void main(String[] args) {
        Solution121Two solution121 = new Solution121Two();
        int[] ints = {7, 1, 5, 3, 6, 4};
        int i = solution121.maxProfit(ints);
        System.out.println(i);
    }
}

class Solution121One {
    public int maxProfit(int[] prices) {
        int min = prices[0], maxProfits = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfits = Math.max(maxProfits, prices[i] - min);
            if (min > prices[i])
                min = prices[i];
        }
        return maxProfits;
    }
}

class Solution121Two {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        //dp[i][0]持有股票dp[i][1]不持有股票
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
/**
 * Author daydream
 * Description
 * Date 2024/12/12 21:09
 */
public class No746 {
    public static void main(String[] args) {
        new Solution746().minCostClimbingStairs(new int[]{10,15,20});
    }
}

class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
/**
 * Author daydream
 * Description
 * Date 2024/12/16 14:53
 */
public class No1046 {

}

class Solution1046One {
    public int lastStoneWeightII(int[] stones) {
        int count = 0;
        for (int num : stones) {
            count += num;
        }
        int[][] dp = new int[stones.length][count / 2 + 1];
        for (int i = stones[0]; i < dp[0].length; i++) {
            dp[0][i] = stones[0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= stones[i])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return count - 2 * dp[stones.length - 1][count / 2];
    }
}

//空间优化版
class Solution1046Two {
    public int lastStoneWeightII(int[] stones) {
        int count = 0;
        for (int num : stones) {
            count += num;
        }
        int[] dp = new int[count / 2 + 1];
        for (int i = stones[0]; i < dp.length; i++) {
            dp[i] = stones[0];
        }
        for (int i = 1; i < stones.length; i++) {
            for (int j = dp.length; j > 0; j--) {
                if (j >= stones[i])
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return count - 2 * dp[count / 2];
    }
}

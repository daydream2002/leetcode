/**
 * Author daydream
 * Description
 * Date 2024/12/16 11:06
 */
public class No416 {
}

class Solution416 {
    public boolean canPartition(int[] nums) {
        int count = 0;
        for (int num : nums) {
            count += num;
        }
        if (count % 2 == 1)
            return false;
        count = count / 2;
        int[][] dp = new int[nums.length][count + 1];
        for (int i = nums[0]; i < dp[0].length; i++) {
            dp[0][i] = nums[0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j > nums[i])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length - 1][count] == count;
    }
}
import java.util.Arrays;

/**
 * @Author daydream
 * @Description
 * @Date 2024/8/15
 */
public class No300 {
    public static void main(String[] args) {
        int lengthOfLIS = new Solution300().lengthOfLIS(new int[]{7, 7, 7});
    }
}

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res=1;
        Arrays.fill(dp,1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
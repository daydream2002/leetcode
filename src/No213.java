/**
 * Author daydream
 * Description
 * Date 2024/12/19 10:27
 */
public class No213 {
    public static void main(String[] args) {
        int rob = new Solution213().rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);
    }
}

class Solution213 {
    public int rob(int[] nums) {
        if (nums.length < 2)
            return nums[0];
        int[] dp = new int[nums.length];
        int res = 0;
        //0,n-2
        dp[0] = nums[0];
        dp[1] = dp[0];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        res = dp[nums.length - 2];
        //1,n-1
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        res = Math.max(res, dp[nums.length - 1]);
        return res;
    }
}
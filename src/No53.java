/**
 * Author daydream
 * Description
 * Date 2024/11/29 17:30
 */
public class No53 {
}

class Solution53One {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + nums[i];
            if (nums[i] > count)
                count = nums[i];
            max = Math.max(count, max);
        }
        return max;
    }
}

//dp算法
class Solution53Three {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int max = -10000;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
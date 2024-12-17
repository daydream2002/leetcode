import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/12/17 11:10
 */
public class No494 {
    public static void main(String[] args) {
        int targetSumWays = new Solution494Two().findTargetSumWays(new int[]{1}, 1);
        System.out.println(targetSumWays);
    }
}

class Solution494One {
    public int findTargetSumWays(int[] nums, int target) {
        //left+right=sum,left-right=target,left=(sum+target)/2
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1 || sum < target || sum < -target)
            return 0;
        sum = (sum + target) / 2;
        int[][] dp = new int[nums.length][sum + 1]; //背包装的物品，背包容量，目标为有多少种方案能刚好装满背包
        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
            if (dp[0].length > nums[0])
                dp[0][nums[0]] = 1;
        }
        for (int i = 1; i < dp.length; i++) {//遍历物品
            for (int j = 0; j <= sum; j++) {//遍历背包容量
                if (j >= nums[i])
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length - 1][sum];
    }
}

//空间复杂度优化版dp
class Solution494Two {
    public int findTargetSumWays(int[] nums, int target) {
        //left+right=sum,left-right=target,left=(sum+target)/2
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1 || sum < target || sum < -target)
            return 0;
        sum = (sum + target) / 2;
        int[] dp = new int[sum + 1]; //背包装的物品，背包容量，目标为有多少种方案能刚好装满背包
        if (nums[0] == 0) {
            dp[0] = 2;
        } else {
            dp[0] = 1;
            if (dp.length > nums[0])
                dp[nums[0]] = 1;
        }
        for (int i = 1; i < nums.length; i++) {//遍历物品
            for (int j = sum; j >= 0; j--) {//遍历背包容量
                if (j >= nums[i])
                    dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}
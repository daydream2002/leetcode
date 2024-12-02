import java.util.ArrayList;

/**
 * Author daydream
 * Description
 * Date 2024/11/29 10:25
 */
public class No376 {
    public static void main(String[] args) {
        int i = new Solution376Two().wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(i);
    }
}

//贪心策略
class Solution376One {
    public int wiggleMaxLength(int[] nums) {
        int count = 0;
        int pre = 0;
        for (int i = 1; i < nums.length; i++) {
            if (pre > 0 && nums[i] - nums[i - 1] < 0 || pre < 0 && nums[i] - nums[i - 1] > 0) {
                count++;
            }
            if (nums[i] - nums[i - 1] != 0) {
                pre = nums[i] - nums[i - 1];
            }
        }
        if (pre != 0)
            return count + 2;
        else
            return 1;
    }
}

//动态规划
class Solution376Two {
    public int wiggleMaxLength(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][1] = 1;
        dp[0][0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                if (nums[i] < nums[j])
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
            }
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
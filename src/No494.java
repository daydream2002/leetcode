import java.util.ArrayList;
import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2024/12/16 22:06
 */
public class No494 {
    public static void main(String[] args) {
        int targetSumWays = new Solution494Two().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }
}

class Solution494One {
    int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return res;
    }

    void dfs(int[] nums, int target, int index, int count) {
        if (index == nums.length) {
            if (target == count)
                res++;
            return;
        }
        dfs(nums, target, index + 1, count + nums[index]);
        dfs(nums, target, index + 1, count - nums[index]);
    }
}

//dp算法
class Solution494Two {
    public int findTargetSumWays(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            count = count + num;
        }
        count = count - target;
        if (count % 2 == 1)
            return 0;
        count = count / 2;
        int[][] dp = new int[nums.length][count + 1];
        if (nums[0] < count + 1)
            dp[0][nums[0]] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < count; j++) {
                if (j >= nums[i])
                    dp[i][j] = dp[i - 1][j - nums[i]];
            }
        }
        return dp[nums.length - 1][count];
    }
}
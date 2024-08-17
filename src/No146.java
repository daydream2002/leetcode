import java.util.Arrays;

/**
 * @author wjh
 * @date 2024/8/17 21:33
 */
public class No146 {
    public static void main(String[] args) {
        boolean b = new Solution146_2().canPartition(new int[]{1, 5, 11, 5});
        System.out.println(b);
    }
}

//本题为0-1背包问题
class Solution146 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if (sum % 2 == 1)
            return false;
        sum = sum / 2;
        //一维为物品的数量，二维为背包的容量
        boolean[][] dp = new boolean[nums.length][sum + 1];
        //只选第一个物品时，只有背包容量等于第一个物品为真
        if (sum >= nums[0])
            dp[0][nums[0]] = true;
        //i代表物品数量
        for (int i = 1; i < nums.length; i++) {
            //j表示背包容量
            for (int j = 0; j < sum + 1; j++) {
                //当前物品恰好装满背包
                if (nums[i] == j)
                    dp[i][j] = true;
                    //不装物品i时背包可以被前i-1个物品装满
                else if (dp[i - 1][j])
                    dp[i][j] = true;
                    //物品i时背包可以被装满
                else if (j - nums[i] > 0 && dp[i - 1][j - nums[i]])
                    dp[i][j] = true;
            }
        }
        return dp[nums.length - 1][sum];
    }
}

//空间复杂度优化版本
class Solution146_2 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if (sum % 2 == 1)
            return false;
        sum = sum / 2;
        //一维为物品的数量，二维为背包的容量
        boolean[] dp = new boolean[sum + 1];
        //只选第一个物品时，只有背包容量等于第一个物品为真
        if (sum >= nums[0])
            dp[nums[0]] = true;
        //i代表物品数量
        for (int i = 1; i < nums.length; i++) {
            //j表示背包容量
            for (int j = sum; j >= 0; j--) {
                //当前物品恰好装满背包
                if (nums[i] == j)
                    dp[j] = true;
                    //不装物品i时背包可以被前i-1个物品装满
                else if (dp[j])
                    dp[j] = true;
                    //物品i时背包可以被装满
                else if (j - nums[i] > 0 && dp[j - nums[i]])
                    dp[j] = true;
            }
        }
        return dp[sum];
    }
}
import java.util.Arrays;

/**
 * @Author daydream
 * @Description 打家劫舍
 * @Date 2024/8/8
 */
public class No198 {
    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        int rob = solution198.rob(new int[]{2, 7, 9, 3, 1});
        System.out.println(rob);
    }
}

//使用动态规划算法
class Solution198 {
    int[] dpMap;

    public int rob(int[] nums) {
        dpMap = new int[nums.length];
        if (nums.length == 1)
            return nums[0];
        Arrays.fill(dpMap, -1);
        dpMap[0] = nums[0];
        dpMap[1] = Math.max(nums[0], nums[1]);
        return dp2(nums, nums.length - 1);
    }

    int dp(int[] nums, int index) {
        if (index == 0)
            return dpMap[0];
        if (index == 1)
            return dpMap[1];
        if (dpMap[index - 2] < 0) {
            dpMap[index - 2] = dp(nums, index - 2);
        }
        if (dpMap[index - 1] < 0) {
            dpMap[index - 1] = dp(nums, index - 1);
        }
        return Math.max(nums[index] + dpMap[index - 2], dpMap[index - 1]);
    }

    int dp2(int[] nums, int index) {
        for (int i = 2; i <= index; i++) {
            dpMap[i] = Math.max(nums[i] + dpMap[i - 2], dpMap[i - 1]);
        }
        return dpMap[index];
    }

}
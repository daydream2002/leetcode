/**
 * Author daydream
 * Description 1035. 不相交的线
 * Date 2024/12/26 10:32
 */
public class No1035 {
}

class Solution1035 {
    //相当于找出最长的公共子序列
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++)
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        return dp[nums1.length][nums2.length];
    }
}
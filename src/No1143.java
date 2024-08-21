import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/8/21
 */
public class No1143 {
    public static void main(String[] args) {
        int res = new Solution1143_2().longestCommonSubsequence("abcba", "abcbcba");
        new Solution1143().longestCommonSubsequence("abcba", "abcbcba");
        System.out.println(res);
    }
}

//多维动态规划
class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            char a = text1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char b = text2.charAt(j - 1);
                if (a == b)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[len1][len2];
    }
}

//多维动态规划
class Solution1143_2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[] dp_pre = new int[len2 + 1];
        int[] dp = new int[len2 + 1];
        for (int i = 1; i <= len1; i++) {
            char a = text1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char b = text2.charAt(j - 1);
                if (a == b)
                    dp[j] = dp_pre[j - 1] + 1;
                else
                    dp[j] = Math.max(dp[j - 1], dp_pre[j]);
            }
            System.arraycopy(dp, 0, dp_pre, 0, dp_pre.length);
        }
        return dp[len2];
    }
}
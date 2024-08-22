/**
 * Author daydream
 * Description
 * Date 2024/8/22
 */
public class No72 {
    public static void main(String[] args) {
        int ans = new Solution72().minDistance("horse", "ros");
        System.out.println(ans);
    }
}

class Solution72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            char a = word1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char b = word2.charAt(j - 1);
                if (a == b)
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1]));
                else
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1));
            }
        }
        return dp[len1][len2];
    }
}
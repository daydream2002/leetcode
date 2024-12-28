/**
 * Author daydream
 * Description
 * Date 2024/12/28 16:38
 */
public class No516 {
    public static void main(String[] args) {
        int i = new Solution516().longestPalindromeSubseq("bbbab");
    }
}
class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2)
                        dp[i][j] = j - i + 1;
                    else
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

}
import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2025/2/23 21:25
 */
public class No132 {
    public static void main(String[] args) {
        int i = new Solution132().minCut("aab");
        System.out.println(i);
    }
}

class Solution132 {
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] resdp = new int[s.length()];//需要分割的次数
        for (int i = 0; i < resdp.length; i++) {
            resdp[i] = i;
        }
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && j - i >= 2)
                    dp[i][j] = dp[i + 1][j - 1];
                if (s.charAt(i) == s.charAt(j) && j - i == 1)
                    dp[i][j] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (dp[0][i]) {
                resdp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j + 1][i]) {
                    resdp[i] = Math.min(resdp[i], resdp[j] + 1);
                }
            }
        }
        return resdp[resdp.length - 1];
    }
}
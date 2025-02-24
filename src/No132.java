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
        System.out.println(Arrays.deepToString(dp));
        if (dp[0][s.length() - 1])
            return 0;
        int res = 0, index = 0;
        while (index <= s.length() ) {
            for (int i = s.length() - 1; i >= index; i--) {
                if (dp[index][i] == true) {
                    index = i+1;
                    break;
                }
            }
            res++;
        }
        return res;
    }
}
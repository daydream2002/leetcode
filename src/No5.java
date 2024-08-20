import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/8/20
 */
public class No5 {
    public static void main(String[] args) {
        String s = new Solution5().longestPalindrome("aacabdkacaa");
        System.out.println(s);
    }
}

//多维动态规划
class Solution5 {
    public String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        if (s.length() == 2)
            if (s.charAt(0) == s.charAt(1))
                return s;
            else
                return s.substring(0, 1);
        int[][] dp = new int[s.length()][s.length()];
        String res = s.substring(0, 1);
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < dp[0].length; j++) {
                if (j == i + 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2;
                    if (dp[i][j] > res.length())
                        res = s.substring(i, j + 1);
                }
                if (j > i + 1 && dp[i + 1][j - 1] > 0 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (dp[i][j] > res.length())
                        res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}


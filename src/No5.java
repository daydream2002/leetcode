import java.util.Arrays;

public class No5 {
    public static void main(String[] args) {
        String res = new Solution5().longestPalindrome("aacabdkacaa");
        System.out.println(res);
    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        String res = s.substring(0,1);
        boolean[][] dp = new boolean[charArray.length][charArray.length];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i >= 2 && charArray[i] == charArray[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (j - i == 1 && charArray[i] == charArray[j]) {
                    dp[i][j] = true;
                }
                if (j - i + 1 > res.length() && dp[i][j])
                    res = s.substring(i, j + 1);
            }
        }
        return res;
    }
}
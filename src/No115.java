/**
 * Author daydream
 * Description 115. 不同的子序列
 * Date 2024/12/26 14:32
 */
public class No115 {
}

class Solution115 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            //从s[i]中挑出空字符串
            dp[i][0] = 1;
        }
        //从s[i]中挑选出符合的t[j]
        for (int i = 1; i <= s.length(); i++)
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    //从s[i]中挑出t[j]等于从s[i-1]选出t[j-1]加上s[i-1]选出t[j]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    //从s[i]中挑出t[j]等于s[i-1]选出t[j]
                    dp[i][j] = dp[i - 1][j];
            }
        return dp[s.length()][t.length()];
    }
}
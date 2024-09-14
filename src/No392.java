/**
 * Author daydream
 * Description
 * Date 2024/9/14 16:45
 */
public class No392 {
    public static void main(String[] args) {
        boolean subsequence = new Solution392Two().isSubsequence("abc", "ahbgdc");
        System.out.println(subsequence);
    }
}

//解法一、双指针
class Solution392One {
    public boolean isSubsequence(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (sCharArray[i] == tCharArray[j])
                i++;
            j++;
        }
        return i == s.length();
    }
}

//解法二、动态规划
class Solution392Two {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[t.length() + 1][26];
        for (int i = 0; i < 26; i++) {
            dp[t.length()][i] = t.length();
        }
        for (int i = t.length() - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == 'a' + j)
                    dp[i][j] = i;
                else
                    dp[i][j] = dp[i + 1][j];
            }
        }
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dp[index][s.charAt(i) - 'a'] != t.length())
                index = dp[index][s.charAt(i) - 'a'] + 1;
            else
                return false;
        }
        return true;
    }
}
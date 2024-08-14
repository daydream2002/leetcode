import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @Author daydream
 * @Description
 * @Date 2024/8/14
 */
public class No139 {
    public static void main(String[] args) {
        String s = "catsandog";
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "cats", "dog", "sand", "and", "cat");
        boolean b = new Solution139().wordBreak(s,list);
        System.out.println(b);
    }
}
//动态规划算法
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> hashSet = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && hashSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
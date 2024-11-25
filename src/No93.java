import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Author daydream
 * Description
 * Date 2024/11/24 09:53
 */
public class No93 {
    public static void main(String[] args) {
        List<String> strings = new Solution93().restoreIpAddresses("25525511135");
        System.out.println(strings);
    }
}

class Solution93 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, new ArrayList<>(), 0, 0);
        return res;
    }

    void dfs(String s, List<String> list, int count, int start) {
        if (count == 4) {
            if (start == s.length()) {
                String join = String.join(".", list);
                res.add(join);
            }
            return;
        }
        for (int i = start; i < s.length() && i < start + 3; i++) {
            String sb = s.substring(start, i + 1);
            if (Integer.parseInt(sb) == 0 || Integer.parseInt(sb) <= 255) {
                list.add(sb);
                dfs(s, list, count + 1, i + 1);
                list.removeLast();
                if (Integer.parseInt(sb) == 0)
                    break;
            }
        }
    }
}
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wjh
 * @date 2024/10/5 19:24
 */
public class No76 {
    public static void main(String[] args) {
        String s = new Solution76().minWindow("cabwefgewcwaefgcf", "cae");
        System.out.println(s);
    }
}

class Solution76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int l = 0, r = -1;
        boolean flag = false;
        String res = s;
        for (char c : tCharArray) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        while (true) {
            if (!check(map1, map2)) {
                r++;
                if (r == s.length())
                    break;
                map1.put(sCharArray[r], map1.getOrDefault(sCharArray[r], 0) + 1);
            } else {
                flag = true;
                if (r - l + 1 < res.length())
                    res = s.substring(l, r + 1);
                map1.put(sCharArray[l], map1.getOrDefault(sCharArray[l], 0) - 1);
                l++;
            }
        }
        if (!flag) {
            return "";
        }
        return res;
    }

    public boolean check(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            if (entry.getValue() > map1.getOrDefault(entry.getKey(), 0))
                return false;
        }
        return true;
    }
}
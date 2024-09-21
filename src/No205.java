import java.util.HashMap;

/**
 * @author wjh
 * @date 2024/9/21 10:23
 */
public class No205 {
}

class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                if (!(map.get(s.charAt(i)) == t.charAt(i)))
                    return false;
            } else {
                if (map.containsValue(t.charAt(i)))
                    return false;
                else
                    map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
/**
 * @author wjh
 * @date 2024/9/21 10:52
 */
public class No242 {
}

class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int length = s.length();
        int[] map = new int[26];
        for (int i = 0; i < length; i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < length; i++) {
            if (map[t.charAt(i) - 'a'] == 0)
                return false;
            else
                map[t.charAt(i) - 'a']--;
        }
        return true;
    }
}
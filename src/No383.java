import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wjh
 * @date 2024/9/21 10:11
 */
public class No383 {
}

class Solution383One {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (map[index] == 0)
                return false;
            else
                map[index]--;
        }
        return true;
    }
}

class Solution383Two {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (hashMap.getOrDefault(c, 0) > 0)
                hashMap.put(c, hashMap.get(c) - 1);
            else
                return false;
        }
        return true;
    }
}
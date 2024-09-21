/**
 * @author wjh
 * @date 2024/9/21 10:11
 */
public class No383 {
}

class Solution383 {
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
import javax.swing.*;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author wjh
 * @date 2024/9/21 10:33
 */
public class No290 {
}

class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (words.length != chars.length)
            return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(chars[i])) {
                if (!Objects.equals(map.get(chars[i]), words[i]))
                    return false;
            } else if (map.containsValue(words[i]))
                return false;
            else
                map.put(chars[i], words[i]);
        }
        return true;
    }
}
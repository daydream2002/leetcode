/**
 * Author daydream
 * Description
 * Date 2024/10/31 21:30
 */
public class No459 {
}

class Solution459One {
    public boolean repeatedSubstringPattern(String s) {
        char[] array = s.toCharArray();
        for (int i = 1; i <= array.length / 2; i++) {
            if (array.length % i == 0) {
                for (int j = 0; j < array.length; j++) {
                    if (array[j] != array[j % i])
                        break;
                    if (j == array.length - 1)
                        return true;
                }
            }
        }
        return false;
    }
}

class Solution459Two {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
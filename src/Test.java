import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
import java.util.*;

class Test {
    public static void main(String[] args) {
        new Solution().monotoneIncreasingDigits(332);
    }
}

class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] charArray = Integer.toString(n).toCharArray();
        int index = charArray.length;
        for (int i = charArray.length - 1; i >= 1; i--) {
            if (charArray[i - 1] > charArray[i]) {
                charArray[i - 1] = (char) (charArray[i - 1] - 1);
                index = i;
            }
        }
        for (int i = index; i < charArray.length; i++) {
            charArray[i] = '9';
        }
        return Integer.parseInt(new String(charArray));
    }
}
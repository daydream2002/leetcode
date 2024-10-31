import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
public class Test {
    public static void main(String[] args) {
        int i = new Solution().strStr("a", "a");
        System.out.println(i);
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();
        for (int i = 0; i < haystackCharArray.length - needleCharArray.length + 1; i++) {
            for (int j = 0; j < needleCharArray.length; j++) {
                if (haystackCharArray[i + j] != needleCharArray[j])
                    break;
                if (j == needle.length() - 1)
                    return i;
            }
        }
        return -1;
    }
}
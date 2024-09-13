/**
 * Author daydream
 * Description
 * Date 2024/9/13 10:18
 */
public class No28 {
    public static void main(String[] args) {
        int i = new Solution28().strStr("mississippi", "issip");
        System.out.println(i);

    }
}

class Solution28 {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0, index = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1)
                    return i - needle.length() + 1;
                i++;
                j++;
            } else {
                index++;
                i = index;
                j = 0;
            }
        }
        return -1;
    }
}
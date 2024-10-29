/**
 * Author daydream
 * Description
 * Date 2024/10/29 11:08
 */
public class No541 {
    public static void main(String[] args) {
        String s = new Solution541().reverseStr("abcd", 4);
        System.out.println(s);
    }
}

class Solution541 {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            reverse(charArray, i, Math.min(i + k - 1, s.length() - 1));
        }
        return new String(charArray);
    }

    void reverse(char[] s, int i, int j) {
        int index = i + (j - i + 1) / 2;
        for (int k = i; k < index; k++) {
            char temp = s[k];
            s[k] = s[i + j - k];
            s[i + j - k] = temp;
        }
    }
}
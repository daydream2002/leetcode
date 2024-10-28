/**
 * Author daydream
 * Description
 * Date 2024/10/28 15:17
 */
public class No344 {
    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        new Solution344().reverseString(chars);
        System.out.println(chars);
    }
}

class Solution344 {
    public void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            swap(s, i, length - i - 1);
        }

    }

    void swap(char[] s, int i, int j) {
        char temp;
        temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
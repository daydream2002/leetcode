/**
 * Author daydream
 * Description
 * Date 2024/11/13 21:06
 */
public class No738 {
    public static void main(String[] args) {
        int i = new Solution738().monotoneIncreasingDigits(332);
        System.out.println(i);
    }
}

class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        char[] charArray = String.valueOf(n).toCharArray();
        int index = charArray.length;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] - charArray[i - 1] < 0) {
                index = i;
                break;
            }
        }
        while (index > 0 && charArray[index] - charArray[index - 1] < 0) {
            charArray[index - 1] = (char) (charArray[index - 1] - 1);
            index--;
        }
        for (int i = index + 1; i < charArray.length; i++) {
            charArray[i] = '9';
        }
        return Integer.parseInt(new String(charArray));
    }
}
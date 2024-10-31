import java.util.Collections;
import java.util.Scanner;

/**
 * Author daydream
 * Description
 * Date 2024/10/31 17:19
 */
public class Kama55 {
    public static void main(String[] args) {
       /* //解法一
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String string = sc.next();
        StringBuilder sb = new StringBuilder();
        sb.append(string, string.length() - num, string.length());
        sb.append(string, 0, string.length() - num);
        System.out.println(sb);*/

        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String string = sc.nextLine();
        char[] charArray = string.toCharArray();
        reverse(charArray, 0, charArray.length - 1);
        reverse(charArray, 0, num - 1);
        reverse(charArray, num, charArray.length - 1);
        System.out.println(new String(charArray));
    }

    public static void reverse(char[] charArray, int l, int r) {
        while (l < r) {
            char temp = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = temp;
            l++;
            r--;
        }
    }
}

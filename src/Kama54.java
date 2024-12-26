import java.util.Scanner;

/**
 * Author daydream
 * Description
 * Date 2024/10/29 11:44
 */
public class Kama54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        char[] charArray = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if ('0' <= c && c <= '9')
                sb.append("number");
            else
                sb.append(c);
        }
        System.out.println(sb);
    }
}

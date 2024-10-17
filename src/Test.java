import java.util.Scanner;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int count = 0, min = Integer.MAX_VALUE;
        int[] arrA = new int[a];
        int[] arrB = new int[b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                int temp = scanner.nextInt();
                arrA[i] = arrA[i] + temp;
                arrB[j] = arrB[j] + temp;
                count = count + temp;
            }
        }
        int l = 0;
        for (int i = 0; i < arrA.length; i++) {
            l = arrA[i] + l;
            min = Math.min(min, Math.abs(count - 2 * l));
        }
        l = 0;
        for (int i = 0; i < arrB.length; i++) {
            l = arrB[i] + l;
            min = Math.min(min, Math.abs(count - 2 * l));
        }
    }
}


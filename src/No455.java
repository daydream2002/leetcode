import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/11/28 19:40
 */
public class No455 {
    public static void main(String[] args) {
        int contentChildren = new Solution455().findContentChildren(new int[]{1, 2, 3}, new int[]{3});
        System.out.println(contentChildren);
    }
}

class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        int count = 0;
        for (int i = 0; i < g.length; i++) {
            while (index < s.length && s[index] < g[i]) {
                index++;
            }
            if (index < s.length) {
                count++;
                index++;
            }
        }
        return count;
    }
}
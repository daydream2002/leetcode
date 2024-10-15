import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 21:36
 */
public class No59 {
    public static void main(String[] args) {
        int[][] ints = new Solution59().generateMatrix(3);
        System.out.println(Arrays.deepToString(ints));
    }
}

class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0, j = 0, index = 1;
        while (index <= n * n) {
            while (j < n && res[i][j] == 0)
                res[i][j++] = index++;
            j--;
            i++;
            while (i < n && res[i][j] == 0)
                res[i++][j] = index++;
            i--;
            j--;
            while (j > -1 && res[i][j] == 0)
                res[i][j--] = index++;
            j++;
            i--;
            while (i > -1 && res[i][j] == 0)
                res[i--][j] = index++;
            i++;
            j++;
        }
        return res;
    }
}
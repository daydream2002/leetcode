import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/9/26 10:53
 */
public class No452 {
    public static void main(String[] args) {
        int[][] arr = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int minArrowShots = new Solution452().findMinArrowShots(arr);
        System.out.println(minArrowShots);
    }
}

class Solution452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int res = 0;
        for (int[] point : points) {
            int i = point[1];
            if (i != 0) {
                for (int[] ints : points) {
                    if (ints[0] <= i)
                        ints[1] = 0;
                    else break;
                }
                res++;
            }
        }
        return res;
    }
}
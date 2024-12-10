import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
import java.util.*;

class Test {
    public static void main(String[] args) {
        new Solution().findMinArrowShots(new int[][]{new int[]{-2147483646, -2147483645}, new int[]{2147483646, 2147483647}});
    }
}

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return a[1] > b[1] ? 1 : -1;
        });
        int count = 0;
        long index = Long.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > index) {
                index = points[i][1];
                count++;
            }
        }
        return count;
    }
}
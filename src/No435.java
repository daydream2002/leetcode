import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/12/10 17:11
 */
public class No435 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        int i = new Solution435().eraseOverlapIntervals(intervals);
        System.out.println(i);
    }
}

class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
//        System.out.println(Arrays.deepToString(intervals));
        int right = Integer.MIN_VALUE;
        int count = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= right) {
                right = interval[1];
            } else {
                count++;
            }
        }
        return count;
    }
}
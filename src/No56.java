import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/12/11 21:30
 */
public class No56 {
    public static void main(String[] args) {
        int[][] intervals = {
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10}
        };

        int[][] merge = new Solution56().merge(intervals);
    }
}

class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
            right = Math.max(right, intervals[i][1]);
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[0][]);
    }
}
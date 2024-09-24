import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Author daydream
 * Description
 * Date 2024/9/24 15:25
 */
public class No57 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] insert = new Solution57().insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(insert));
    }
}

class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int l = newInterval[0], r = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0])
                list.add(intervals[i]);
            if (intervals[i][0] > newInterval[1])
                list.add(intervals[i]);
            if (intervals[i][0] <= newInterval[0] && newInterval[0] <= intervals[i][1])
                l = intervals[i][0];
            if (intervals[i][0] <= newInterval[1] && newInterval[1] <= intervals[i][1])
                r = intervals[i][1];
        }
        list.add(new int[]{l, r});
        list.sort((o1, o2) -> o1[0] - o2[0]);
        return list.toArray(new int[list.size()][]);
    }
}
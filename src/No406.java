import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Author daydream
 * Description
 * Date 2024/12/10 09:57
 */
public class No406 {
    public static void main(String[] args) {
//        [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]] 转换成Java数组
        int[][] people = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        new Solution406().reconstructQueue(people);
    }
}

class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] > o2[0])
                return -1;
            else if (o1[0] < o2[0])
                return 1;
            else
                return o1[1] - o2[1];
        });
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[0][]);
    }
}
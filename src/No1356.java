import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Function;

public class No1356 {
    public static void main(String[] args) {
        int[] ints = new Solution1356().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(Arrays.toString(ints));
    }
}

class Solution1356 {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted((o1, o2) -> {
            int i = getCount(o1) - getCount(o2);
            if (i != 0) {
                return i;
            } else {
                return o1 - o2;
            }
        }).mapToInt(Integer::intValue).toArray();
    }

    int getCount(int n) {
        int count = 0;
        String binaryString = Integer.toBinaryString(n);
        for (int j = 0; j < binaryString.length(); j++) {
            if (binaryString.charAt(j) == '1')
                count++;
        }
        return count;
    }
}
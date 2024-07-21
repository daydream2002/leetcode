import java.util.Arrays;

/**
 * @author wjh
 * @date 2024/7/21 下午8:27
 */
public class No34 {
    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] ints = {2, 2};
        int[] ints1 = solution34.searchRange(ints, 3);
        System.out.println(Arrays.toString(ints1));
    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        int i = binarySearch(nums, target - 0.5);
        int j = binarySearch(nums, target + 0.5);
        if (i < nums.length && nums[i] == target)
            return new int[]{i, j - 1};
        else return new int[]{-1, -1};
    }

    int binarySearch(int[] matrix, double target) {
        int length = matrix.length;
        int i = 0, j = length - 1, k = length / 2;
        while (i <= j) {
            if (target == matrix[k])
                return k;
            if (target > matrix[k])
                i = k + 1;
            if (target < matrix[k])
                j = k - 1;
            k = (i + j) / 2;
        }
        return i;
    }
}
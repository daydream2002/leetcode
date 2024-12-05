import java.util.Arrays;
import java.util.Comparator;

/**
 * Author daydream
 * Description
 * Date 2024/12/5 21:01
 */
public class No1005 {
    public static void main(String[] args) {
        int i = new Solution1005().largestSumAfterKNegations(new int[]{-2, 5, 0, 2, -2}, 3);
    }
}

class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            } else break;
        }
        for (int num : nums) {
            count = count + num;
        }
        if (k % 2 != 0) {
            count = count - 2 * nums[0];
        }
        return count;
    }
}
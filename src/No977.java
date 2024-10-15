import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:16
 */
public class No977 {
    public static void main(String[] args) {
        int[] ints = new Solution977Two().sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(ints));
    }
}

class Solution977One {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int min = 0, l, r, index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[min]) > Math.abs(nums[i]))
                min = i;
        }
        res[index++] = nums[min] * nums[min];
        l = min - 1;
        r = min + 1;
        while (l >= 0 && r <= nums.length - 1) {
            if (Math.abs(nums[l]) > Math.abs(nums[r]))
                res[index++] = nums[r] * nums[r++];
            else
                res[index++] = nums[l] * nums[l--];
        }
        while (l >= 0) {
            res[index++] = nums[l] * nums[l--];
        }
        while (r <= nums.length - 1) {
            res[index++] = nums[r] * nums[r++];
        }
        return res;
    }
}

class Solution977Two {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0, r = nums.length - 1, index = nums.length - 1;
        while (l < r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r]))
                res[index--] = nums[l] * nums[l++];
            else
                res[index--] = nums[r] * nums[r--];
        }
        return res;
    }
}
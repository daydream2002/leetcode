import java.util.Arrays;

/**
 * @author wjh
 * @date 2024/8/25 10:23
 */
public class No31 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        new Solution31().nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Solution31 {
    public void nextPermutation(int[] nums) {
        int up = nums.length - 1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] <= nums[i - 1])
                up = i - 1;
            else
                break;
        }
        if (up == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int minMax = nums.length - 1;
        for (int i = nums.length - 1; i >= up; i--) {
            if (nums[i] > nums[up - 1]) {
                minMax = i;
                break;
            }
        }
        swap(nums, up - 1, minMax);
        System.out.println(Arrays.toString(nums));
        reverse(nums, up, nums.length - 1);

    }

    void reverse(int[] nums, int i, int j) {
        while (j > i) {
            swap(nums, i++, j--);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
/**
 * Author daydream
 * Description
 * Date 2025/2/15 19:42
 */
public class No189 {
}

class Solution189_1 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[k - i - 1] = nums[nums.length - 1 - i];
        }
        for (int i = nums.length - 1; i > k - 1; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}

class Solution189_2 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    void reverse(int[] nums, int l, int r) {
        while (r > l) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
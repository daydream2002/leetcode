/**
 * Author daydream
 * Description
 * Date 2025/2/15 20:00
 */
public class No724 {
}

class Solution724_1 {
    public int pivotIndex(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (left[i] == right[i])
                return i;
        }
        return -1;
    }
}

class Solution724_2 {
    public int pivotIndex(int[] nums) {
        int count = 0;
        int countLeft = 0;
        for (int num : nums) {
            count += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (countLeft == count - nums[i] - countLeft) {
                return i;
            }
            countLeft = countLeft + nums[i];
        }
        return -1;
    }
}
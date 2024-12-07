/**
 * Author daydream
 * Description
 * Date 2024/11/29 17:30
 */
public class No53 {
}

class Solution53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + nums[i];
            if (nums[i] > count)
                count = nums[i];
            max = Math.max(count, max);
        }
        return max;
    }
}
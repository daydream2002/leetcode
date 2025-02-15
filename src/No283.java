/**
 * Author daydream
 * Description
 * Date 2025/2/15 17:16
 */
public class No283 {
}
class Solution283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
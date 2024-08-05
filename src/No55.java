/**
 * @Author daydream
 * @Description
 * @Date 2024/8/5
 */
public class No55 {
    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        boolean b = solution55.canJump(new int[]{3,2,1,0,4});
        System.out.println(b);
    }
}

class Solution55 {
    public boolean canJump(int[] nums) {
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxDistance < i)
                return false;
            maxDistance = Math.max(maxDistance, nums[i] + i);
        }
        return true;
    }
}